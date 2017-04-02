package im.conversations.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.jfoenix.controls.JFXListView;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

@FXMLController(value = "/resources/fxml/SideMenu.fxml", title = "Conversations.im")
public class SideMenuController {

	@FXMLViewFlowContext
	private ViewFlowContext context;

	@FXML Circle hello;
	
	@FXML
	private JFXListView<Label> sideList;

	
	@FXML
	private ImageView imgViewLst;
	
	@FXML
	private Circle availableLst;
	
	
	@PostConstruct
	public void init() throws FlowException, VetoException {
		
		//Side Panel Effects 
		
		Image image = new Image("/resources/img/user22.jpg");
	      Circle clip = new Circle(100,100,100);
	      
	      imgViewLst.setImage(image);
	      imgViewLst.setFitWidth(200);
	      imgViewLst.setFitHeight(200);
	      imgViewLst.setPreserveRatio(true);
	      imgViewLst.setSmooth(true);
	      imgViewLst.setClip(clip);
	      
	      availableLst.setStroke(Color.web("#67d74c"));;
		  List<Stop> stops = new ArrayList<Stop>();
		  stops.add(new Stop(0.0, Color.web("#408042")));
		  stops.add(new Stop(1.0, Color.web("#27da2a")));
		  LinearGradient lGrad = new LinearGradient(0.6893203883495146, 0.0048543689320388345, 0.7718446601941747, 0.8203883495145631, true, CycleMethod.NO_CYCLE, stops);
		  availableLst.setFill(lGrad);
		
	}

}
