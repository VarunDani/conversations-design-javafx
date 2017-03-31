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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

public class MsgListCell extends JFXListCell<Message> {

	
	@FXML
	private Label timeLabel2;
	
	@FXML
	private Label userName2;
	
	@FXML
	private TextFlow statusMsg2;

	@FXML
	private Label iconTime;
	
	
	@FXML
	private ImageView imgView2;
	
	@FXML
	private BorderPane mainPanel2;
	
	@FXML
	private Circle available2;
	
	
	private FXMLLoader mLoader;
	
	static Font fontAwesome;
	static{
		fontAwesome = Font.loadFont(MsgListCell.class.getResource("fontawesome-webfont.ttf").toExternalForm(), 64);
	}
	
	
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
	    	  
	    	  //Setting Message with Text Flow
	    	  
	    	  if(usr.getStatus().contains(":-)") || usr.getStatus().contains(":-D") || usr.getStatus().contains("<3"))
	    	  {
	    	     Label labelText = new Label(usr.getStatus()); 
	    		 labelText.setStyle("-fx-font-size: 15px");
	    		
	  	      Label label = new Label("\uf00c"); 
		      label.setFont(fontAwesome);
		      label.setStyle("-fx-font-family: 'FontAwesome';-fx-font-size: 15px");
		      label.setTextFill(Color.web("#919191"));
		      
		      Label labelLock = new Label("\uf023"); 
		      labelLock.setFont(fontAwesome);
		      labelLock.setStyle("-fx-font-family: 'FontAwesome';-fx-font-size: 20px");
		      labelLock.setTextFill(Color.web("#919191"));
		      
		      Label labelPadd = new Label("   "); 
		      Label labelPadd2 = new Label("   "); 
		      
		      
		      statusMsg2.getChildren().clear();
	  	      statusMsg2.getChildren().add(labelLock);
	  	      statusMsg2.getChildren().add(labelPadd);
	  	      statusMsg2.getChildren().add(label);
	  	      statusMsg2.getChildren().add(labelPadd2);
	  	      statusMsg2.getChildren().add(labelText);
	    	  }
	    	  else
	    	  {
	    		
	    		  
	    		  Label labelText = new Label(usr.getStatus()); 
	    		  labelText.setStyle("-fx-font-size: 15px");
	    		
	  	      Label label = new Label("\uf00c"); 
		      label.setFont(fontAwesome);
		      label.setStyle("-fx-font-family: 'FontAwesome';-fx-font-size: 15px");
		      label.setTextFill(Color.web("#919191"));
		      
		      Label labelLock = new Label("\uf023"); 
		      labelLock.setFont(fontAwesome);
		      labelLock.setStyle("-fx-font-family: 'FontAwesome';-fx-font-size: 20px");
		      labelLock.setTextFill(Color.web("#919191"));
		      
		      Label labelPadd = new Label("   "); 
		      Label labelPadd2 = new Label("   "); 
		      
		      
		      
		      statusMsg2.getChildren().clear();
	  	      statusMsg2.getChildren().add(labelLock);
	  	      statusMsg2.getChildren().add(labelPadd);
	  	      statusMsg2.getChildren().add(label);
	  	      statusMsg2.getChildren().add(labelPadd2);
	  	      
	  	      constructMessagewithEmoji(statusMsg2,usr.getStatus());
	  	    
	  	      //statusMsg2.getChildren().add(labelText);
	  	      
	    	  }
	    	  
	    	  
	    	  //statusMsg2.setText(usr.getStatus());
	    	  
	    	  iconTime.setText("\uf017");
	    	  iconTime.setFont(fontAwesome);
	    	  iconTime.setStyle("-fx-font-family: 'FontAwesome';-fx-font-size: 17px");
	    	  
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


	private void constructMessagewithEmoji(TextFlow statusMsg22, String status) {
		
		
		char[] ch = status.toCharArray();
		
		int j = -1;
		for(int i = 0; i<ch.length;i++){
			
			if(ch[i]== '~'){
				
				 statusMsg2.getChildren().add(getTextLabel(status.substring(j+1,i)));
				j = i+1;
				while(ch[j]!='~' && j<ch.length-1)
				{
					++j;
				}
				if(status.substring(i+1,j)!=null && !"".equals(status.substring(i+1,j)))
					statusMsg2.getChildren().add(getEmoji(status.substring(i+1,j)));
				i=j;
			}
		}
		 statusMsg2.getChildren().add(getTextLabel(status.substring(j+1)));
		
		
		
	}
	
	
	private Label getTextLabel(String text){
		  Label labelText = new Label(text); 
		  labelText.setStyle("-fx-font-size: 18px");
		  return labelText;
	}
	
	private ImageView getEmoji(String emojiName)
	{

		 ImageView imgView2 = new ImageView();
		 Image image = null;
		 
		 if("smile".equalsIgnoreCase(emojiName))
		 {
			 image = new Image("/resources/img/smile2.png");
		 }
		 else if("heart".equalsIgnoreCase(emojiName))
		 {
			 image = new Image("/resources/img/heart.png");
		 }
		 else if("laugh".equalsIgnoreCase(emojiName))
		 {
			 image = new Image("/resources/img/laugh.png");
		 }
			 
	 	imgView2.setImage(image);
	 	imgView2.setFitWidth(23);
	 	imgView2.setFitHeight(23);
	 	imgView2.setPreserveRatio(true);
	 	imgView2.setSmooth(true);
	      
	      
      return imgView2;
	}
}
