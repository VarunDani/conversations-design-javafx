package im.conversations.app.beans;

public class Message {

	
	private String userName;
	private String imagePath;
	private String time;
	private String status;
	
	public Message(String userName, String imagePath, String time, String status) {
		super();
		this.userName = userName;
		this.imagePath = imagePath;
		this.time = time;
		this.status = status;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
