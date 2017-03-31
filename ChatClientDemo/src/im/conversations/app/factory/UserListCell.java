package im.conversations.app.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXListCell;

import de.jensd.fx.fontawesome.Icon;
import im.conversations.app.beans.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

/**
 * Customized List Cells for User Panel 
 *
 */
public class UserListCell extends JFXListCell<User>{

	
	@FXML
	private Label timeLabel;
	
	@FXML
	private Label userName;
	
	@FXML
	private Label statusMsg;
	
	@FXML
	private ImageView imgView;
	
	@FXML
	private BorderPane mainPanel;
	
	@FXML
	private Circle available;
	
	@FXML private StackPane unreadMsgPane;
	@FXML private Icon starIcon;
	
	private FXMLLoader mLoader;
	
	
	@Override 
	  public void updateItem(User usr, boolean empty) { 
	    super.updateItem(usr, empty); 
	    if (empty) { 
	      setText(null); 
	      setGraphic(null); 
	    } else { 
	    	
	    	//Setting FXML Loader 
	    	  if (mLoader == null) {
	                mLoader = new FXMLLoader(getClass().getResource("/resources/fxml/cell.fxml"));
	                mLoader.setController(this);

	                try {
	                    mLoader.load();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }

	            }
	    	  
	    	  //Setting Time Label
	    	  timeLabel.setText(usr.getTime());
	    	  
	    	  //Setting User Name 
	    	  userName.setText(usr.getUserName());
	    	  
	    	  //Setting Status Message 
	    	  statusMsg.setText(usr.getStatus());
	    	  
	    	  LinearGradient lGrad = null;
	    	  if(usr.getAvailStatus().equals("available")){
	    		  available.setStroke(Color.web("#67d74c"));;
	    		  List<Stop> stops = new ArrayList<Stop>();
	    		  stops.add(new Stop(0.0, Color.web("#408042")));
	    		  stops.add(new Stop(1.0, Color.web("#27da2a")));
	    		  lGrad = new LinearGradient(0.6893203883495146, 0.0048543689320388345, 0.7718446601941747, 0.8203883495145631, true, CycleMethod.NO_CYCLE, stops);
	    		  
	    	  }
	    	  else if(usr.getAvailStatus().equals("away")){
	    		  available.setStroke(Color.web("#dfe1b6"));;
	    		  List<Stop> stops = new ArrayList<Stop>();
	    		  stops.add(new Stop(0.0, Color.web("#dfe1b6")));
	    		  stops.add(new Stop(1.0, Color.web("#dada5e")));
	    		  lGrad = new LinearGradient(0.6893203883495146, 0.0048543689320388345, 0.7718446601941747, 0.8203883495145631, true, CycleMethod.NO_CYCLE, stops);
	    		  
	    	  }
	    	  else if(usr.getAvailStatus().equals("busy")){
	    		  available.setStroke(Color.web("#ee9c8f"));;
	    		  List<Stop> stops = new ArrayList<Stop>();
	    		  stops.add(new Stop(0.007246376811594203, Color.web("#e1c8c8")));
	    		  stops.add(new Stop(1.0, Color.web("#d03e1d")));
	    		  lGrad = new LinearGradient(0.6893203883495146, 0.0048543689320388345, 0.7718446601941747, 0.8203883495145631, true, CycleMethod.NO_CYCLE, stops);
	    		  
	    	  }
	    	  
	    	  if(lGrad!=null)
	    		  available.setFill(lGrad);
	    	  else
	    		  available.setVisible(false);
	    
	    	  if(usr.isFavourite())starIcon.setVisible(true);
	    	  if(usr.isUnreadMsgs())unreadMsgPane.setVisible(true);
	    	  
	      //setText(msg.getMessage() +" : "+ msg.getRecepient().toString()); 
	      //setText(usr.getUserName()); 
	      
	      Image image = new Image(usr.getImagePath()!=null ? usr.getImagePath() : "/resources/img/user2.png");
	      final Circle clip = new Circle(30,30,30);
	      imgView.setImage(image);
	      imgView.setFitWidth(60);
	      imgView.setFitHeight(60);
	      imgView.setPreserveRatio(true);
	      imgView.setSmooth(true);
	      imgView.setClip(clip);
	      
	      setGraphic(mainPanel); 
	    }
	  } 
	
}
