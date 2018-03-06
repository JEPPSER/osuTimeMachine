package osutimemachine;

import java.util.ArrayList;

public class User {
	
	private String user_id;
	private String username;
	private String count300;
	private String count100;
	private String count50;
	private String playcount;
	private String ranked_score;
	private String total_score;
	private String pp_rank;
	private String level;
	private double pp_raw;
	private String accuracy;
	private String count_rank_ss;
	private String count_rank_ssh;
	private String count_rank_s;
	private String count_rank_sh;
	private String count_rank_a;
	private String country;
	private String pp_country_rank;
	private ArrayList<Event> events;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCount300() {
		return count300;
	}
	public void setCount300(String count300) {
		this.count300 = count300;
	}
	public String getCount100() {
		return count100;
	}
	public void setCount100(String count100) {
		this.count100 = count100;
	}
	public String getCount50() {
		return count50;
	}
	public void setCount50(String count50) {
		this.count50 = count50;
	}
	public String getPlaycount() {
		return playcount;
	}
	public void setPlaycount(String playcount) {
		this.playcount = playcount;
	}
	public String getRanked_score() {
		return ranked_score;
	}
	public void setRanked_score(String ranked_score) {
		this.ranked_score = ranked_score;
	}
	public String getTotal_score() {
		return total_score;
	}
	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}
	public String getPp_rank() {
		return pp_rank;
	}
	public void setPp_rank(String pp_rank) {
		this.pp_rank = pp_rank;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getPp_raw() {
		return pp_raw;
	}
	public void setPp_raw(double pp_raw) {
		this.pp_raw = pp_raw;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getCount_rank_ss() {
		return count_rank_ss;
	}
	public void setCount_rank_ss(String count_rank_ss) {
		this.count_rank_ss = count_rank_ss;
	}
	public String getCount_rank_ssh() {
		return count_rank_ssh;
	}
	public void setCount_rank_ssh(String count_rank_ssh) {
		this.count_rank_ssh = count_rank_ssh;
	}
	public String getCount_rank_s() {
		return count_rank_s;
	}
	public void setCount_rank_s(String count_rank_s) {
		this.count_rank_s = count_rank_s;
	}
	public String getCount_rank_sh() {
		return count_rank_sh;
	}
	public void setCount_rank_sh(String count_rank_sh) {
		this.count_rank_sh = count_rank_sh;
	}
	public String getCount_rank_a() {
		return count_rank_a;
	}
	public void setCount_rank_a(String count_rank_a) {
		this.count_rank_a = count_rank_a;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPp_country_rank() {
		return pp_country_rank;
	}
	public void setPp_country_rank(String pp_country_rank) {
		this.pp_country_rank = pp_country_rank;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
}
