package osutimemachine;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class OsuTimeMachine {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://osu.ppy.sh/api/get_user_best?k=8ff6b2725309862651a04122dbc6af4c24e3601d&u=jepser&type=string&limit=100");
		ArrayList<Play> list = new ArrayList<Play>();
		ObjectMapper mapper = new ObjectMapper();
		list = mapper.readValue(url, new TypeReference<ArrayList<Play>>() { });
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getBeatmap_id());
		}
	}
}
