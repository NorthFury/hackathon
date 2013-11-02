package hackathon.doit.dto;

public class Reward {
	private String imgSource;
	private String message;
	
	public Reward(String imgSource, String message) {
		this.imgSource = imgSource;
		this.message = message;
	}
	public String getImgSource() {
		return imgSource;
	}
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
