package application;
	


import java.util.ArrayList;
import java.util.List;

import application.model.Note;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
		
		Line NavLine = this.CreateLine();
		
		Button addNoteBtn = this.CreateButton();
		
		Text notesTitle = this.CreateHeaderText();
		
		Group SearchGroup = this.CreateSearchBox();
		
//		NoteRepository repo = new NoteRepository();
//		List<Note> notes = repo.getAllNotes();
		List<Note> notes = new ArrayList<Note>();
		notes.add(new Note(1,
	            "Meeting Notes Q3",
	            "Key takeaways from the quarterly planning session and next action items.",
	            "Edited 2 hours ago"
	    ));
		
		 notes.add(new Note(
		            2,
		            "Project Phoenix Ideas",
		            "Initial brainstorming for the new marketing campaign and target audience analysis.",
		            "Edited yesterday"
		));
		 
		 notes.add(new Note(
		            3,
		            "Grocery List",
		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
		            "Edited 3 days ago"
		 ));

		double startY = 70;

		for (Note note : notes) {
		    Group noteUI = CreateNoteItem(note, startY);
		    root.getChildren().add(noteUI);
		    startY += 80;
		}

		
		//Mock Notes (SideBar)
		double y = 70;

		for (Note note : notes) {
		    root.getChildren().add(CreateSidebarNote(note, y));
		    y += 45;
		}

		
		root.getChildren().add(NavLine);
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
	
	public Group CreateNoteItem(Note note, double y) {

	    Group item = new Group();

	    // Background
	    Rectangle bg = new Rectangle(200, y, 520, 72);
	    bg.setArcWidth(12);
	    bg.setArcHeight(12);
	    bg.setFill(Color.rgb(16, 25, 34));
	    bg.setStroke(Color.rgb(43, 140, 238));
	    bg.setStrokeWidth(0);

	    Text title = new Text(note.getTitle());
	    title.setX(215);
	    title.setY(y + 28);
	    title.setStyle(
	        "-fx-fill: white;" +
	        "-fx-font-size: 15px;" +
	        "-fx-font-weight: 700;"
	    );

	    Text preview = new Text(note.getContent());
	    preview.setX(215);
	    preview.setY(y + 48);
	    preview.setStyle(
	        "-fx-fill: rgb(156,163,175);" +
	        "-fx-font-size: 12px;"
	    );
	    
	    // Edited
	    Text edited = new Text(note.getLastEdited());
	    edited.setX(215);
	    edited.setY(y + 64);
	    edited.setStyle(
	        "-fx-fill: rgb(107,114,128);" +
	        "-fx-font-size: 10px;"
	    );
	    
	    // Hover Buttons Container
	    HBox actions = new HBox(8);
	    actions.setLayoutX(550);
	    actions.setLayoutY(y + 22);
	    actions.setOpacity(0); // hidden by default

	    Button viewBtn = createActionBtn("View", "rgb(59,130,246)");
	    Button editBtn = createActionBtn("Edit", "rgb(34,197,94)");
	    Button deleteBtn = createActionBtn("Delete", "rgb(239,68,68)");

	    // Placeholder actions
	    viewBtn.setOnAction(e -> System.out.println("View " + note.getId()));
	    editBtn.setOnAction(e -> System.out.println("Edit " + note.getId()));
	    deleteBtn.setOnAction(e -> System.out.println("Delete " + note.getId()));

	    actions.getChildren().addAll(viewBtn, editBtn, deleteBtn);

	    // Hover Effects
	    item.setOnMouseEntered(e -> {
	        actions.setOpacity(1);
	        bg.setStrokeWidth(1);
	        item.setCursor(Cursor.HAND);
	    });

	    item.setOnMouseExited(e -> {
	        actions.setOpacity(0);
	        bg.setStrokeWidth(0);
	        item.setCursor(Cursor.DEFAULT);
	    });

	    item.getChildren().addAll(bg, title, preview, edited, actions);
	    return item;
	}


	private Button createActionBtn(String text, String color) {

	    Button btn = new Button(text);

	    btn.setPrefHeight(28);
	    btn.setStyle(
	        "-fx-background-color: " + color + ";" +
	        "-fx-text-fill: white;" +
	        "-fx-font-size: 11px;" +
	        "-fx-font-weight: 600;" +
	        "-fx-background-radius: 6;" +
	        "-fx-cursor: hand;"
	    );

	    btn.setOnMouseEntered(e ->
	        btn.setStyle(
	            "-fx-background-color: derive(" + color + ", -15%);" +
	            "-fx-text-fill: white;" +
	            "-fx-font-size: 11px;" +
	            "-fx-font-weight: 700;" +
	            "-fx-background-radius: 6;"
	        )
	    );

	    btn.setOnMouseExited(e ->
	        btn.setStyle(
	            "-fx-background-color: " + color + ";" +
	            "-fx-text-fill: white;" +
	            "-fx-font-size: 11px;" +
	            "-fx-font-weight: 600;" +
	            "-fx-background-radius: 6;"
	        )
	    );

	    return btn;
	}
	
	public Group CreateSidebarNote(Note note, double y) {

	    Group item = new Group();

	    Rectangle bg = new Rectangle(0, y, 180, 40);
	    bg.setFill(Color.TRANSPARENT);

	    Text title = new Text(note.getTitle());
	    title.setX(15);
	    title.setY(y + 25);
	    title.setStyle(
	        "-fx-fill: white;" +
	        "-fx-font-size: 13px;" +
	        "-fx-font-weight: 500;"
	    );

	    Button viewBtn = new Button("View");
	    viewBtn.setLayoutX(120);
	    viewBtn.setLayoutY(y + 8);
	    viewBtn.setOpacity(0);

	    viewBtn.setStyle(
	        "-fx-background-color: rgb(43,140,238);" +
	        "-fx-text-fill: white;" +
	        "-fx-font-size: 11px;" +
	        "-fx-background-radius: 6;" +
	        "-fx-cursor: hand;"
	    );

	    // Hover behavior
	    item.setOnMouseEntered(e -> {
	        bg.setFill(Color.rgb(43, 140, 238, 0.15));
	        viewBtn.setOpacity(1);
	    });

	    item.setOnMouseExited(e -> {
	        bg.setFill(Color.TRANSPARENT);
	        viewBtn.setOpacity(0);
	    });

	    // Placeholder click
	    viewBtn.setOnAction(e ->
	        System.out.println("Viewing note: " + note.getTitle())
	    );

	    item.getChildren().addAll(bg, title, viewBtn);
	    return item;
	}


}


