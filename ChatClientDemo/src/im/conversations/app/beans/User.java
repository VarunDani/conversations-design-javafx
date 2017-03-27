package im.conversations.app.beans;

public class User {

	
	private String userName;
	private String imagePath;
	private String time;
	private String status;
	private String availStatus;
	
	
	
	public User(String userName, String imagePath, String time, String status,  String availStatus) {
		super();
		this.userName = userName;
		this.imagePath = imagePath;
		this.time = time;
		this.status = status;
		this.setAvailStatus(availStatus);
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
	public String getAvailStatus() {
		return availStatus;
	}
	public void setAvailStatus(String availStatus) {
		this.availStatus = availStatus;
	}
	

	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", imagePath=" + imagePath + ", time=" + time + ", status=" + status
				+ "]";
	}
}
