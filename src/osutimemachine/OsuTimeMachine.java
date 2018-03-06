package osutimemachine;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OsuTimeMachine extends Application{
		
	private String userName = "cookiezi";
	private String key = "8ff6b2725309862651a04122dbc6af4c24e3601d";
	private String dateString = "01.03.2018";
	private Text ppText;

	public static void main(String[] args) throws IOException {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(5);
		TextField nameField = new TextField();
		nameField.setPrefWidth(300);
		TextField dateField = new TextField();
		dateField.setPrefWidth(300);
		TextField keyField = new TextField();
		keyField.setPrefWidth(300);
		vbox.getChildren().addAll(new Text("User Name:"), nameField, new Text("Date (dd.mm.yyyy):"), dateField, new Text("API Key:"), keyField);
		
		HBox hbox = new HBox();
		hbox.setSpacing(5);
		Button button = new Button("Calculate pp");
		button.setMaxWidth(90);
		ppText = new Text("New pp value: ");
		hbox.getChildren().addAll(button, ppText);
		vbox.getChildren().add(hbox);
		
		button.setOnAction(e -> {
			userName = nameField.getText();
			dateString = dateField.getText();
			key = keyField.getText();
			try {
				calculatePP();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		Scene scene = new Scene(vbox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void calculatePP() throws IOException{
		// Read in plays from json.
		URL url = new URL("https://osu.ppy.sh/api/get_user_best?k=" + key + "&u=" + userName + "&type=string&limit=100");
		ArrayList<Play> list = new ArrayList<Play>();
		ObjectMapper mapper = new ObjectMapper();
		list = mapper.readValue(url, new TypeReference<ArrayList<Play>>() { });
		
		// Date
		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
	    LocalDate date = LocalDate.parse(dateString, germanFormatter);
		
	    int counter = 0;
	    double totalNewPP = 0;
	    double totalActualPP = 0;
	    
		for(int i = 0; i < list.size(); i++){
			int id = list.get(i).getBeatmap_id(); // Beatmap id.
			
			// Getting the approval date of the beatmap.
			URL beatUrl = new URL("https://osu.ppy.sh/api/get_beatmaps?k=" + key + "&b=" + id);
			Beatmap b = mapper.readValue(beatUrl, Beatmap[].class)[0];
			String[] parts = b.getApproved_date().split(" ")[0].split("-");
			String dateStr = parts[2] + "." + parts[1] + "." + parts[0];
		    LocalDate beatDate = LocalDate.parse(dateStr, germanFormatter);
		    
		    // If Beatmap approval date is before selected date, then add play pp value to totalPP.
		    if(beatDate.isBefore(date)){
		    	totalNewPP += list.get(i).getPp() * Math.pow(0.95, counter);
		    	counter++;
		    }
		    
		    totalActualPP += list.get(i).getPp() * Math.pow(0.95, i);
		}
		
		// Get user in order to calculate bonus pp. We assume that the bonus pp would have been the same in the earlier date.
		URL userUrl = new URL("https://osu.ppy.sh/api/get_user?k=" + key + "&u=" + userName + "&type=string&limit=100");
		User user = mapper.readValue(userUrl, User[].class)[0];
		double bonusPP = user.getPp_raw() - totalActualPP;
		double newPP = totalNewPP + bonusPP;
		ppText.setText("New pp value: " + Math.round(newPP));
	}
}
