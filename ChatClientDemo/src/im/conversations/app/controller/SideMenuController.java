package im.conversations.app.controller;

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

@FXMLController(value = "/resources/fxml/SideMenu.fxml", title = "Conversations.im")
public class SideMenuController {

	@FXMLViewFlowContext
	private ViewFlowContext context;

	
	@FXML
	private JFXListView<Label> sideList;

	@PostConstruct
	public void init() throws FlowException, VetoException {
		/*FlowHandler contentFlowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
		sideList.propagateMouseEventsToParent();
		sideList.getSelectionModel().selectedItemProperty().addListener((o,oldVal,newVal)->{
			if(newVal!=null){
				try {
					contentFlowHandler.handle(newVal.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
		});
		Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
		bindNodeToController(button, ButtonController.class, contentFlow, contentFlowHandler);
		bindNodeToController(checkbox, CheckboxController.class, contentFlow, contentFlowHandler);*/
		
	}

	private void bindNodeToController(Node node, Class<?> controllerClass, Flow flow, FlowHandler flowHandler) {
		flow.withGlobalLink(node.getId(), controllerClass);
	}

}
