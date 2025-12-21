package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
    
	//Primary Color: 43, 140, 238
	
    
 public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Group root = new Group();
		Scene scene = new Scene(root,750,500,Color.rgb(16, 25, 34));
		
		//Set Jotly's Title
		stage.setTitle("Jotly");
		stage.setResizable(false);
		
		//Set Jotly's Logo
		Image jotlyImage = new Image("Jotly_Logo.png");
		stage.getIcons().add(jotlyImage);
		
		//Sample Text
		Text text = new Text();
		text.setText("Buddongg");
		text.setX(450/2 - 5);
		text.setY(450/2 - 3);
//		text.setFill(Color.WHITE);
//		text.setFont(Font.font("Sans-serif",50));
		text.setStyle(
				"-fx-fill:white;"
				+ "-fx-font-weight:700;"
				+ "-fx-font-size:20px;"
				+ "-fx-font-family: 'Inter';");
		
		Line NavLine = this.CreateLine();
		
		Button addNoteBtn = this.CreateButton();
		
		Text notesTitle = this.CreateHeaderText();
		
		Group SearchGroup = this.CreateSearchBox();
		
		root.getChildren().add(text);
		root.getChildren().add(NavLine);
//		root.getChildren().add(SearchBarLine);
		root.getChildren().add(addNoteBtn);
		root.getChildren().add(notesTitle);
		root.getChildren().add(SearchGroup);
		
		stage.setScene(scene);
		stage.show();
	}
	
	//Creates "Add New Note" Button
	public Button CreateButton() 
	{

		//Add Note Button
		// Add New Note Button
		Button addNoteBtn = new Button("Add New Note");

		// Position (bottom-left, inside navigation)
		addNoteBtn.setLayoutX(20);
		addNoteBtn.setLayoutY(450);

		// Size
		addNoteBtn.setPrefWidth(140);
		addNoteBtn.setPrefHeight(40);

		// Styling
		addNoteBtn.setFont(Font.font("Sans-serif", 13));
		addNoteBtn.setTextFill(Color.WHITE);
		addNoteBtn.setStyle(
		    "-fx-background-color: rgb(43, 140, 238);" +
		    "-fx-background-radius: 10;" +
		    "-fx-font-weight: 700;" +
		    "-fx-cursor: hand;" +
		    "-fx-font-family: 'Inter', 'Sans-serif';"
		);

		// Hover effect
		addNoteBtn.setOnMouseEntered(e ->
		    addNoteBtn.setStyle(
		        "-fx-background-color: rgb(34, 120, 210);" +
		        "-fx-background-radius: 10;" +
		        "-fx-font-weight: 900;" +
		        "-fx-cursor: hand;"
		    )
		);

		addNoteBtn.setOnMouseExited(e ->
		    addNoteBtn.setStyle(
		        "-fx-background-color: rgb(43, 140, 238);" +
		        "-fx-background-radius: 10;" +
		        "-fx-font-weight: 700;" +
		        "-fx-cursor: hand;"
		    )
		);

		// Click action
		addNoteBtn.setOnAction(e ->
		    System.out.println("Add New Note clicked")
		);
		
		return addNoteBtn;
	}
	
	public Text CreateHeaderText() 
	{
		// "Notes" Title (Sidebar Header)
				Text notesTitle = new Text("Notes");

				// Position
				notesTitle.setX(55);
				notesTitle.setY(45);
				notesTitle.setFill(Color.rgb(31, 41, 55));

				// Style using inline CSS
				notesTitle.setStyle(
				    "-fx-fill: white;" +
				    "-fx-font-size: 22px;" +
				    "-fx-font-weight: 700;" +
				    "-fx-font-family: 'Inter', 'Sans-serif';" +
				    "-fx-background-color:transparent;"
				);

		return notesTitle;
	}
	
	public Line CreateLine() 
	{
		//Navigation and Main Content Division Line
				Line NavLine = new Line();
				NavLine.setStartX(180);
				NavLine.setStartY(0);
				NavLine.setEndX(180);
				NavLine.setEndY(500);
				NavLine.setStrokeWidth(0.5);
				NavLine.setStroke(Color.rgb(156, 163, 175));
				
		return NavLine;
	}
	
	public Group CreateSearchBox() {

	    Group searchGroup = new Group();

	    // Background container
	    Rectangle bg = new Rectangle();
	    bg.setX(200);      // start after sidebar (NavLine is at 180)
	    bg.setY(15);
	    bg.setWidth(520);
	    bg.setHeight(40);
	    bg.setArcWidth(12);
	    bg.setArcHeight(12);
	    bg.setFill(Color.rgb(31, 41, 55)); // dark gray background

	    // Search icon (Unicode)
	    Text searchIcon = new Text("🔍");
	    searchIcon.setX(215);
	    searchIcon.setY(41);
	    searchIcon.setStyle(
	        "-fx-fill: rgb(156, 163, 175);" +
	        "-fx-font-size: 14px;"
	    );

	    // TextField
	    TextField searchField = new TextField();
	    searchField.setLayoutX(240);
	    searchField.setLayoutY(18);
	    searchField.setPrefWidth(460);
	    searchField.setPrefHeight(34);
	    searchField.setPromptText("Search notes...");

	    searchField.setStyle(
	        "-fx-background-color: transparent;" +
	        "-fx-text-fill: white;" +
	        "-fx-prompt-text-fill: rgb(156, 163, 175);" +
	        "-fx-font-size: 14px;" +
	        "-fx-font-family: 'Inter', 'Sans-serif';" +
	        "-fx-border-color: transparent;" +
	        "-fx-focus-color: transparent;" +
	        "-fx-faint-focus-color: transparent;"
	    );

	    searchGroup.getChildren().addAll(bg, searchIcon, searchField);
	    return searchGroup;
	}

}


