import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.layout.Pane;

public class Figure {

    //this is a start on a method for updating the drawings, it uses a switch statement
    // where each case draws one line or part in the figure
    public void updateHangmanFigure(int incorrectGuesses, Pane root) {
        switch (incorrectGuesses) {
            case 1:
                // create the hill
                Arc arc = new Arc();
                arc.setCenterX(50.0f);
                arc.setCenterY(50.0f);
                arc.setRadiusX(25.0f);
                arc.setRadiusY(25.0f);
                arc.setStartAngle(0.0f);
                arc.setLength(180.0f);
                root.getChildren().add(arc);
                break;
            case 2:
                // create the next line
                break;
            case 3:
                // continue the code
                break;
        }
    }
}
