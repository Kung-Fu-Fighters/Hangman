
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Hangman extends Application {

    Input inp = new Input();
    public static void main(String[] args) {
        launch(args);
    }

        public void start (Stage primaryStage){
            primaryStage.setTitle("Awesome Hangman v0.1");

            Button button = new Button();
            button.setText("Start a new game");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                }
            });

            StackPane root = new StackPane();
            root.getChildren().add(button);
            primaryStage.setScene(new Scene(root, 300, 250));
            primaryStage.show();
        }
}