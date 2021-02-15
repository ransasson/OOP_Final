package view;

import model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	
	private Scene theScene;
	private BorderPane bp;
	private Text storeName;
	private Button saveASC;
	private Button saveDESC;
	private Button saveByOrder;
	private Button printProducts;
	private Button saveChanges;
	private Button undo;
	private VBox saveBox;
	private TextField productName;
	private TextField productSerial;
	private TextField priceForStore;
	private TextField priceForCustomer;
	private TextField customerName;
	private TextField customerPhone;
	private Text productNameText;
	private Text productSerialText;
	private Text priceForStoreText;
	private Text priceForCustomerText;
	private Text customerNameText;
	private Text customerPhoneText;
	private Text customerSalesText;
	private CheckBox customerSales;
	private HBox texts;
	private HBox textFields;
	private HBox saveUndo;
	private VBox textsAndFields;

	//////////
	private Button showView;
	private Button clearView;
	/////////
	
	public View(Stage theStage) {

		storeName=new Text("Our Store");
		
		saveASC=new Button("Save Products ASC Order");
		saveDESC=new Button("Save Products DESC Order");
		saveByOrder=new Button("Save Products By Insert Order");
		printProducts=new Button("Print Products");
		saveChanges=new Button("Save Changes");
		undo=new Button("Undo");
		undo.setDisable(true);
		
		////////////
		showView=new Button("show view");
		clearView=new Button("clear view");
		////////////
		saveBox=new VBox();
		saveBox.getChildren().addAll(saveASC,saveDESC,saveByOrder,printProducts,showView,clearView);
		saveBox.setSpacing(20);
		
		productName=new TextField();
		productSerial=new TextField();
		priceForStore=new TextField();
		priceForCustomer=new TextField();
		customerName=new TextField();
		customerPhone=new TextField();
		customerSales=new CheckBox();
		
		textFields=new HBox();
		textFields.getChildren().addAll(productSerial,productName,priceForStore,priceForCustomer,customerName,customerPhone,customerSales);
		textFields.setSpacing(60);

		productNameText=new Text("Product Name");
		productSerialText=new Text("Product Serial Number");
		priceForStoreText=new Text("Produc Price For Store");
		priceForCustomerText=new Text("Produc Price For Customer");
		customerNameText=new Text("Customer Name");
		customerPhoneText=new Text("Customer Phone");
		customerSalesText=new Text("Customer Want Sales?");
		
		texts=new HBox();
		texts.getChildren().addAll(productSerialText,productNameText,priceForStoreText,priceForCustomerText,customerNameText,customerPhoneText,customerSalesText);
		//texts.setSpacing(20);
		texts.setMargin(productNameText, new Insets(0,0,0,110));
		texts.setMargin(productSerialText, new Insets(0,0,0,20));
		texts.setMargin(priceForStoreText, new Insets(0,0,0,100));
		texts.setMargin(priceForCustomerText, new Insets(0,0,0,85));
		texts.setMargin(customerNameText, new Insets(0,0,0,95));
		texts.setMargin(customerPhoneText, new Insets(0,0,0,120));
		texts.setMargin(customerSalesText, new Insets(0,0,0,50));

		textsAndFields=new VBox();
		textsAndFields.getChildren().addAll(texts,textFields);
		textsAndFields.setSpacing(20);
		
		saveUndo=new HBox();
		saveUndo.getChildren().addAll(saveChanges,undo);
		saveUndo.setSpacing(50);

		bp=new BorderPane();
		bp.setCenter(saveBox);
		bp.setRight(textsAndFields);
		bp.setTop(storeName);
		bp.setBottom(saveUndo);
		
		bp.setMargin(storeName, new Insets(20,0,0,950));
		bp.setMargin(saveBox, new Insets(20,0,0,20));
		bp.setMargin(textsAndFields, new Insets(300,250,0,0));
		bp.setMargin(saveUndo, new Insets(0,0,200,900));

		clearView();
		
		theScene = new Scene(bp,2000,1000);
		theStage.setScene(theScene);
		theStage.show();
	}
	
	public void addEventTosaveASC(EventHandler<ActionEvent> saveASCPressed) {
		saveASC.setOnAction(saveASCPressed);
	}
	
	public void saveASC(Model theModel) {
		lockSave();
		showView();
		theModel.setSort(1);
	}
	
	public void addEventTosaveDESC(EventHandler<ActionEvent> saveDESCPressed) {
		saveDESC.setOnAction(saveDESCPressed);
	}
	
	public void saveDESC(Model theModel) {
		lockSave();
		showView();
		theModel.setSort(2);
	}
	
	public void addEventTosaveByOrder(EventHandler<ActionEvent> saveByOrderPressed) {
		saveByOrder.setOnAction(saveByOrderPressed);
	}
	
	public void saveByOrder(Model theModel) {
		lockSave();
		showView();
		theModel.setSort(3);
	}
	
	public void addEventTosaveChanges(EventHandler<ActionEvent> saveChangesPressed) {
		saveChanges.setOnAction(saveChangesPressed);
	}
	
	public void saveChanges(Model theModel) {
		if(productSerial.getText().isEmpty())
		{
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Must fill Product Serial Number!");
			msg.show();
			return;
		}
		try {
			if(Integer.parseInt(priceForStore.getText())<0)
				{
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill Positive Price!");
				msg.show();
				return;
				}
			if(Integer.parseInt(priceForCustomer.getText())<0)
			{
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Must fill Positive Price!");
			msg.show();
			return;
			}
		} catch (Exception e) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Price Must Be Integer!");
			msg.show();
			return;
		}
		String catalog=productSerial.getText();
		int storePrice=Integer.parseInt(priceForStore.getText());
		int customerPrice=Integer.parseInt(priceForCustomer.getText());
		String pName=productName.getText();
		String cName=customerName.getText();
		String cPhone=customerPhone.getText();
		boolean sales;
		if(!customerSales.isPressed())
			 sales=false;
		else
			sales=true;
		theModel.UpdateCatalogNum(catalog, pName, storePrice, customerPrice, cName, cPhone, sales);
		clearInsert();
		undo.setDisable(false);
	}
	
	public void addEventToUndo(EventHandler<ActionEvent> undoPressed) {
		undo.setOnAction(undoPressed);
	}
	
	public void undo(Model theModel) {
		theModel.setMemento();
		undo.setDisable(true);
	}
	
	private void clearInsert() {
		productSerial.clear();
		priceForStore.clear();
		priceForCustomer.clear();
		productName.clear();
		customerName.clear();
		customerPhone.clear();
		customerSales.setSelected(false);
	}

	public void lockSave() {
		saveASC.setDisable(true);
		saveDESC.setDisable(true);
		saveByOrder.setDisable(true);
	}
	
	public void clearView() {
		saveChanges.setVisible(false);
		undo.setVisible(false);
		textsAndFields.setVisible(false);
	}
	
	public void showView() {
		undo.setVisible(true);
		saveChanges.setVisible(true);
		textsAndFields.setVisible(true);
	}
	
//	public void update(model.Model data) {
//		root.getChildren().clear(); // clean current root
//		data.draw(root);
//	}
}
