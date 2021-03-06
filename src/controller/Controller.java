package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.PrintOne;

public class Controller {
	private model.Model theModel;
	private view.View theView;
	private view.PrintOne printOne;
	
	public Controller(model.Model m, view.View v) {
		theModel = m;
		theView = v;
		
		
		EventHandler<ActionEvent> saveASCPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.saveASC(theModel);

			}
		};
		theView.addEventTosaveASC(saveASCPressed);
		
		EventHandler<ActionEvent> saveDESCPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.saveDESC(theModel);

			}
		};
		theView.addEventTosaveDESC(saveDESCPressed);
		
		EventHandler<ActionEvent> saveByOrderPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.saveByOrder(theModel);

			}
		};
		theView.addEventTosaveByOrder(saveByOrderPressed);
		
		EventHandler<ActionEvent> saveChangesPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.saveChanges(theModel);

			}
		};
		
		theView.addEventTosaveChanges(saveChangesPressed);
		
		EventHandler<ActionEvent> PrintOnePressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.PrintOne(theModel);
				Stage secondStage = new Stage();
				printOne=new PrintOne(secondStage);
			}
		};
		
		theView.addEventToPrintOne(PrintOnePressed);
		
		EventHandler<ActionEvent> undoPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.undo(theModel);

			}
		};
		theView.addEventToUndo(undoPressed);
	}
}
