package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
		
		//Navigation and Main Content Division Line
		Line NavLine = new Line();
		NavLine.setStartX(180);
		NavLine.setStartY(0);
		NavLine.setEndX(180);
		NavLine.setEndY(500);
		NavLine.setStrokeWidth(0.5);
		NavLine.setStroke(Color.rgb(156, 163, 175));
		
		
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
		
		// "Notes" Title (Sidebar Header)
		Text notesTitle = new Text("Notes");

		// Position
		notesTitle.setX(25);
		notesTitle.setY(40);

		// Style using inline CSS
		notesTitle.setStyle(
		    "-fx-fill: white;" +
		    "-fx-font-size: 22px;" +
		    "-fx-font-weight: 700;" +
		    "-fx-font-family: 'Inter', 'Sans-serif';"
		);

		
		root.getChildren().add(text);
		root.getChildren().add(NavLine);
//		root.getChildren().add(SearchBarLine);
		root.getChildren().add(addNoteBtn);
		root.getChildren().add(notesTitle);
		stage.setScene(scene);
		stage.show();
	}
}
