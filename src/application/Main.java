package application;
	


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import application.model.Note;
import application.repository.NoteRepository;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
    
	//Primary Color: 43, 140, 238
	private List<Note> notes;
	private VBox mainNotesList;

    
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
		
		// Click action
		addNoteBtn.setOnAction(e ->
			showNoteModal(stage, "Add", null)	
		);
		
		Text notesTitle = this.CreateHeaderText();
		
		Group SearchGroup = this.CreateSearchBox(stage);
		
//		NoteRepository repo = new NoteRepository();
//		List<Note> notes = repo.getAllNotes();
//		notes = new ArrayList<Note>();
//		notes.add(new Note(1,
//	            "Meeting Notes Q3",
//	            "Key takeaways from the quarterly planning session and next action items.",
//	            "Edited 2 hours ago"
//	    ));
//		
//		 notes.add(new Note(
//		            2,
//		            "Project Phoenix Ideas",
//		            "Initial brainstorming for the new marketing campaign and target audience analysis.",
//		            "Edited yesterday"
//		));
//		 
//		 notes.add(new Note(
//		            3,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 3 days ago"
//		 ));
//		 
//		 notes.add(new Note(
//		            4,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
//		 
//		 notes.add(new Note(
//		            5,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 3 days ago"
//		 ));
//		 
//		 notes.add(new Note(
//		            6,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
//		 
//		 notes.add(new Note(
//		            7,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
//
//		 notes.add(new Note(
//		            8,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
//		 
//		 notes.add(new Note(
//		            9,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
//		 
//		 
//		 notes.add(new Note(
//		            10,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
//		 
//		 
//		 notes.add(new Note(
//		            11,
//		            "Grocery List",
//		            "Milk, Bread, Eggs, Cheese, Apples, Bananas, Coffee.",
//		            "Edited 2 days ago"
//		 ));
		 
		NoteRepository repo = new NoteRepository();
		notes = repo.getAllNotes();

//		refreshMainNotes(notes, stage);

		
		
		//Add Scrollable effect on SideBar
		ScrollPane sidebarScroll = new ScrollPane();
		sidebarScroll.setLayoutX(0);
		sidebarScroll.setLayoutY(60);
		sidebarScroll.setPrefWidth(180);
		sidebarScroll.setPrefHeight(390);

		sidebarScroll.setFitToWidth(true);
		sidebarScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sidebarScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		sidebarScroll.setStyle(
		    "-fx-background: transparent;" +
		    "-fx-background-color: transparent;"
		);

		
		//Vbox for Notes
		VBox notesList = new VBox();
		notesList.setSpacing(4);
		notesList.setPadding(new Insets(5));

		notesList.setStyle(
		    "-fx-background-color: transparent;"
		);
		
		//SideBar Notes
		for (Note note : notes) {
		    notesList.getChildren().add(CreateSidebarNote(note,stage));
		}
		
		//Connect Vbox to ScrollPane
		sidebarScroll.setContent(notesList);
		root.getChildren().add(sidebarScroll);
		
		
		//Main Scroll 
		ScrollPane mainScroll = new ScrollPane();
		mainScroll.setLayoutX(180);
		mainScroll.setLayoutY(60);
		mainScroll.setPrefWidth(570);
		mainScroll.setPrefHeight(440);

		mainScroll.setFitToWidth(true);
		mainScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		mainScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		mainScroll.setStyle(
		    "-fx-background: transparent;" +
		    "-fx-background-color: transparent;"
		);
		
		
		//Main Notes Vbox
		mainNotesList = new VBox();
		mainNotesList.setSpacing(10);
		mainNotesList.setPadding(new Insets(10));
		
		for (Note note : notes) {
		    mainNotesList.getChildren().add(CreateMainNoteItem(note,stage));
		}
		
		refreshMainNotes(notes,stage);

		mainScroll.setContent(mainNotesList);
		root.getChildren().add(mainScroll);

		

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
	
	public Group CreateSearchBox(Stage stage) {

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
	    
	    searchField.textProperty().addListener((obs, oldVal, newVal) -> {
	        String query = newVal.toLowerCase().trim();

	        List<Note> filtered = notes.stream()
	            .filter(note ->
	                note.getTitle().toLowerCase().contains(query) ||
	                note.getContent().toLowerCase().contains(query)
	            )
	            .collect(Collectors.toList());

	        refreshMainNotes(filtered,stage);
	    });


	    searchGroup.getChildren().addAll(bg, searchIcon, searchField);
	    return searchGroup;
	}
	
	public VBox CreateMainNoteItem(Note note, Stage stage) {

	    VBox card = new VBox(6);
	    card.setPadding(new Insets(12));
	    card.setStyle(
	        "-fx-background-color: rgb(16,25,34);" +
	        "-fx-background-radius: 12;"
	    );


	    // Header Row
	    HBox header = new HBox();
	    header.setAlignment(Pos.CENTER_LEFT);

	    Text title = new Text(note.getTitle());
	    title.setStyle(
	        "-fx-fill: white;" +
	        "-fx-font-size: 15px;" +
	        "-fx-font-weight: 700;"
	    );

	    Region spacer = new Region();
	    HBox.setHgrow(spacer, Priority.ALWAYS);

	    HBox actions = new HBox(8);
	    actions.setOpacity(0);

	    Button view = createActionBtn("View", "rgb(59,130,246)");
	    view.setOnAction(e ->
	    	showNoteModal(stage, "View", note)
	    );
	    
	    Button edit = createActionBtn("Edit", "rgb(34,197,94)");
	    edit.setOnAction(e ->
	    	showNoteModal(stage, "Edit", note)
	    );

	    
	    Button del  = createActionBtn("Delete", "rgb(239,68,68)");

	    actions.getChildren().addAll(view, edit, del);

	    // Hover buttons
	    card.setOnMouseEntered(e -> {
	    	 card.setStyle(
	 	            "-fx-background-color: rgb(16,25,34);" +
	 	            "-fx-background-radius: 12;" +
	 	            "-fx-border-color: rgb(43,140,238);" +
	 	            "-fx-border-radius: 12;"
	 	        );
	    	actions.setOpacity(1);
	    });
	    card.setOnMouseExited(e -> {
	    	card.setStyle(
	            "-fx-background-color: rgb(16,25,34);" +
	            "-fx-background-radius: 12;"
	        );
	    	actions.setOpacity(0);
	    });

	    header.getChildren().addAll(title, spacer, actions);

	    // Content
	    Text preview = new Text(note.getContent());
	    preview.setWrappingWidth(520);
	    preview.setStyle(
	        "-fx-fill: rgb(156,163,175);" +
	        "-fx-font-size: 12px;"
	    );

	    Text edited = new Text(note.getLastEdited());
	    edited.setStyle(
	        "-fx-fill: rgb(107,114,128);" +
	        "-fx-font-size: 10px;"
	    );

	    card.getChildren().addAll(header, preview, edited);
	    return card;
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
	
	public HBox CreateSidebarNote(Note note,Stage stage) {

	    HBox item = new HBox();
	    item.setPrefHeight(40);
	    item.setAlignment(Pos.CENTER_LEFT);
	    item.setSpacing(10);
	    item.setPadding(new Insets(0, 8, 0, 10));

	    Text title = new Text(note.getTitle());
	    title.setWrappingWidth(90);   // ✅ prevents overflow
	    title.setStyle(
	        "-fx-fill: white;" +
	        "-fx-font-size: 13px;" +
	        "-fx-font-weight: 700;"
	    );

	    Region spacer = new Region();
	    HBox.setHgrow(spacer, Priority.ALWAYS);

	    Button viewBtn = new Button("View");
	    viewBtn.setOpacity(0);
	    
	    viewBtn.setOnAction(e ->
    		showNoteModal(stage, "View", note)
	    );

	    viewBtn.setStyle(
	        "-fx-background-color: rgb(43,140,238);" +
	        "-fx-text-fill: white;" +
	        "-fx-font-size: 11px;" +
	        "-fx-background-radius: 6;"
	    );

	    // Hover effects
	    item.setOnMouseEntered(e -> {
	        item.setStyle("-fx-background-color: rgba(43,140,238,0.15);");
	        viewBtn.setOpacity(1);
	    });

	    item.setOnMouseExited(e -> {
	        item.setStyle("-fx-background-color: transparent;");
	        viewBtn.setOpacity(0);
	    });

	    item.getChildren().addAll(title, spacer, viewBtn);
	    return item;
	}

	private void showNoteModal(Stage owner, String mode, Note note) {

	    Stage modal = new Stage();
	    modal.initOwner(owner);
	    modal.initModality(Modality.APPLICATION_MODAL);
	    modal.initStyle(StageStyle.TRANSPARENT);

	    StackPane overlay = new StackPane();
	    overlay.setStyle(
	        "-fx-background-color: rgba(0,0,0,0.65);"
	    );

	    VBox card = new VBox(14);
	    card.setPadding(new Insets(20));
	    card.setPrefWidth(480);
	    card.setStyle(
	        "-fx-background-color: linear-gradient(to bottom right, rgb(17,24,39), rgb(15,23,42));" +
	        "-fx-background-radius: 14;"
	    );

	    // ---------- HEADER ----------
	    Text title = new Text(mode + " Note");
	    title.setStyle(
	        "-fx-fill: white;" +
	        "-fx-font-size: 20px;" +
	        "-fx-font-weight: 800;"
	    );

	    // ---------- TITLE FIELD ----------
	    Label titleLabel = new Label("Title");
	    titleLabel.setStyle("-fx-text-fill: rgb(156,163,175);");

	    TextField titleField = new TextField();
	    titleField.setText(note != null ? note.getTitle() : "");
	    styleInput(titleField);

	    // ---------- CONTENT ----------
	    Label contentLabel = new Label("Content");
	    contentLabel.setStyle("-fx-text-fill: rgb(156,163,175);");

	    TextArea contentArea = new TextArea();
	    contentArea.setText(note != null ? note.getContent() : "");
	    contentArea.setPrefHeight(180);
	    contentArea.setWrapText(true);
	    contentArea.setPrefRowCount(6);
	    contentArea.setMinHeight(120);
	    contentArea.setMaxHeight(300); // optional limit	    
	    styleInput(contentArea);

	    // ---------- BUTTONS ----------
	    HBox actions = new HBox(10);
	    actions.setAlignment(Pos.CENTER_RIGHT);

	    Button cancel = new Button("Cancel");
	    cancel.setStyle(
	        "-fx-background-color: transparent;" +
	        "-fx-border-color: rgb(75,85,99);" +
	        "-fx-text-fill: white;" +
	        "-fx-background-radius: 8;" +
	        "-fx-border-radius: 8;" +
	        "-fx-padding: 6 16;"
	    );

	    Button save = new Button("Save");
	    save.setStyle(
	        "-fx-background-color: rgb(59,130,246);" +
	        "-fx-text-fill: white;" +
	        "-fx-background-radius: 8;" +
	        "-fx-padding: 6 16;"
	    );

	    cancel.setOnAction(e -> modal.close());
	    save.setOnAction(e -> {

	        NoteRepository repo = new NoteRepository();

	        if (mode.equals("Add")) {
	            repo.insert(
	                new Note(
	                    0,
	                    titleField.getText(),
	                    contentArea.getText(),
	                    "Just now"
	                )
	            );
	        }

	        notes = repo.getAllNotes();
	        refreshMainNotes(notes, owner);

	        modal.close();
	    });


	    actions.getChildren().addAll(cancel, save);

	    card.getChildren().addAll(
	        title,
	        titleLabel, titleField,
	        contentLabel, contentArea,
	        actions
	    );

	    overlay.getChildren().add(card);

	    Scene scene = new Scene(overlay);
	    scene.setFill(Color.TRANSPARENT);

	    modal.setScene(scene);
	    modal.showAndWait();
	}

	private void styleInput(Control input) {
	    input.setStyle(
	        "-fx-control-inner-background: rgb(30,41,59);" +  // 👈 IMPORTANT
	        "-fx-background-color: rgb(30,41,59);" +
	        "-fx-text-fill: white;" +
	        "-fx-prompt-text-fill: rgb(107,114,128);" +
	        "-fx-background-radius: 8;" +
	        "-fx-border-color: rgb(55,65,81);" +
	        "-fx-border-radius: 8;" +
	        "-fx-padding: 8;"
	    );
	}

	private void refreshMainNotes(List<Note> notes, Stage stage) {
	    mainNotesList.getChildren().clear();

	    for (Note note : notes) {
	        mainNotesList.getChildren().add(CreateMainNoteItem(note, stage));
	    }
	}


}


