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
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
    
    
 public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Group root = new Group();
		Scene scene = new Scene(root,750,500,Color.BLACK);
		
		//Set Jotly's Title
		stage.setTitle("Jotly");
		stage.setResizable(false);
		
		//Set Jotly's Logo
		Image jotlyImage = new Image("Jotly_Logo.png");
		stage.getIcons().add(jotlyImage);
		
		//Sample Text
		Text text = new Text();
		text.setText("Hello Buddy");
		text.setX(450/2 - 5);
		text.setY(450/2 - 3);
		text.setFill(Color.WHITE);
		text.setFont(Font.font("Sans-serif",50));
		
		
		root.getChildren().add(text);
		stage.setScene(scene);
		stage.show();
	}
}
