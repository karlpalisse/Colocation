package masini.colocation.model;

public class AchievedService {

	private int from;
	private int to_;
	private String date;
	private String picture;
	private Boolean valid;
	
	public AchievedService(int _from, int _to_, String _date, String _picture, Boolean _valid) {
		this.from = _from;
		this.to_ = _to_;
		this.date = _date;
		this.picture = _picture;
		this.valid = _valid;
	}
	
	public int getFrom() {
		return from;
	}
	
	public void setFrom(int from) {
		this.from = from;
	}
	
	public int getTo_() {
		return to_;
	}
	
	public void setTo_(int to_) {
		this.to_ = to_;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public Boolean getValid() {
		return valid;
	}
	
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	
}

