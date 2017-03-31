package im.conversations.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import im.conversations.app.beans.Message;
import im.conversations.app.beans.User;
import im.conversations.app.factory.MsgListCell;
import im.conversations.app.factory.UserListCell;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.util.VetoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@FXMLController(value = "/resources/fxml/mainPanel.fxml" , title = "Menu Design  ")
public class ChatPanelController {

	
	
	
	@FXML private JFXListView<User> sideList2;
	@FXML private JFXListView<Message> sideList3;
	@FXML private JFXTextField msgBox;
	
	
	static ObservableList<User> items =FXCollections.observableArrayList ();
	static ObservableList<Message> messages =FXCollections.observableArrayList ();
	
	/*@FXML
	private JFXTextField enterMsg;*/
	
	@PostConstruct
	public void init() throws FlowException, VetoException {
		sideList2.depthProperty().set(1);
		sideList3.depthProperty().set(1);
		/*enterMsg.setLabelFloat(true);
		enterMsg.setPromptText("Type Something");*/
		items.add(new User("Varun Dani","/resources/img/user11.png","12:30","# Status of Varun Dani","available",true,false));
		items.add(new User("User 2","/resources/img/user22.jpg","11:11","# status of second User","away",false,true));
		items.add(new User("User 3","/resources/img/user33.jpg","10:11","# status of third User","busy",true,true));
		
		sideList2.setItems(items);
		sideList2.setCellFactory((ListView<User> l) -> new UserListCell());
		
		messages.add(new Message("Varun Dani","/resources/img/user11.png","12:30","Hello !! How are you ~smile~ !!"));
		messages.add(new Message("User","/resources/img/user22.jpg","12:35","I am Fine Thak you ~laugh~ .. "));
		messages.add(new Message("Varun Dani","/resources/img/user11.png","12:36","What about your project ?"));
		messages.add(new Message("User","/resources/img/user22.jpg","12:37","Project is in Good Situation and meeting deadlines "));
		//messages.add(new Message("Varun Dani","/resources/img/user11.png","12:50","That's Great !! "));
		
		sideList3.setItems(messages);
		sideList3.setCellFactory((ListView<Message> l) -> new MsgListCell());
		
		
		
		msgBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent keyEvent) {
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		        	
		        	String msgText = msgBox.getText();
		        	
		        	if(msgText!=null && !"".equals(msgText))
		        	{
		        		
		        		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		        		Calendar cal = Calendar.getInstance();
		        		
		        		messages.add(new Message("User","/resources/img/user22.jpg",dateFormat.format(cal.getTime()),msgText));
		        		msgBox.setText("");
		        	}
		        }
		    }
		});
	}
}
