package im.conversations.app.factory;

import java.io.IOException;

import com.jfoenix.controls.JFXListCell;

import im.conversations.app.beans.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class MsgListCell extends JFXListCell<Message> {

	
	@FXML
	private Label timeLabel2;
	
	@FXML
	private Label userName2;
	
	@FXML
	private Label statusMsg2;
	
	@FXML
	private ImageView imgView2;
	
	@FXML
	private BorderPane mainPanel2;
	
	@FXML
	private Circle available2;
	
	
	private FXMLLoader mLoader;
	
	
	@Override 
	  public void updateItem(Message usr, boolean empty) { 
	    super.updateItem(usr, empty); 
	    if (empty) { 
	      setText(null); 
	      setGraphic(null); 
	    } else { 
	    	
	    	//Setting FXML Loader 
	    	  if (mLoader == null) {
	                mLoader = new FXMLLoader(getClass().getResource("/resources/fxml/Msgcell.fxml"));
	                mLoader.setController(this);

	                try {
	                    mLoader.load();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }

	            }
	    	  
	    	  //Setting Time Label
	    	  timeLabel2.setText(usr.getTime());
	    	  
	    	  //Setting User Name 
	    	  userName2.setText(usr.getUserName());
	    	  
	    	  //Setting Status Message 
	    	  statusMsg2.setText(usr.getStatus());
	    	  
	    	 
	      //setText(msg.getMessage() +" : "+ msg.getRecepient().toString()); 
	      //setText(usr.getUserName()); 
	      
	      Image image = new Image(usr.getImagePath()!=null ? usr.getImagePath() : "/resources/img/user2.png");
	      final Circle clip = new Circle(35,35,35);
	      imgView2.setImage(image);
	      imgView2.setFitWidth(80);
	      imgView2.setFitHeight(70);
	      imgView2.setPreserveRatio(true);
	      imgView2.setSmooth(true);
	      imgView2.setClip(clip);
	      
	      setGraphic(mainPanel2); 
	    }
	  } 
}
