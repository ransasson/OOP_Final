package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrintOne {
	private BorderPane bp;


	public PrintOne(Stage primaryStage) {
		
		
		bp=new BorderPane();

		
		Scene theScene = new Scene(bp,2000,1000);
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
}
