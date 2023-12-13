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
    public void updateHangmanFigure(int incorrectGuesses, int positionX, int positionY, Pane root) {

        switch (incorrectGuesses) {
            case 1:
                // create the hill
                Arc arc = new Arc();
                arc.setCenterX(positionX);
                arc.setCenterY(positionY);
                arc.setRadiusX(25.0f);
                arc.setRadiusY(25.0f);
                arc.setStartAngle(0.0f);
                arc.setLength(180.0f);
                root.getChildren().add(arc);
                break;
            case 2:
                // Draw the stick that goes up from the hill
                Line verticalLine = new Line(positionX, positionY - 25, positionX, positionY - 75);
                root.getChildren().add(verticalLine);
                break;
            case 3:
                // Draw the stick that goes horizontally from the first stick
               Line horizontalLine = new Line(positionX, positionY - 75, positionX + 30, positionY - 75);
                root.getChildren().add(horizontalLine);
                break;
            case 4:
                // Case 4: Draw the diagonal stick between 2 & 3 as a "support stick"
               Line diagonalLine = new Line(positionX, positionY - 50, positionX + 20, positionY - 75);
                root.getChildren().add(diagonalLine);
                break;
            case 5:
                // Case 5: Draw the head
                Circle head = new Circle(positionX + 30, positionY - 60, 15);
                root.getChildren().add(head);
                break;
            case 6:
                // Case 6: Draw the body
                Line body = new Line(positionX + 30, positionY - 45, positionX + 30, positionY - 15);
                root.getChildren().add(body);
                break;
            case 7:
                // Case 7: Draw the left arm
                Line leftArm = new Line(positionX + 30, positionY - 45, positionX + 20, positionY - 30);
                root.getChildren().add(leftArm);
                break;
            case 8:
                // Case 8: Draw the right arm
                Line rightArm = new Line(positionX + 30, positionY - 45, positionX + 40, positionY - 30);
                root.getChildren().add(rightArm);
                break;
            case 9:
                // Case 9: Draw the left leg
                Line leftLeg = new Line(positionX + 30, positionY - 15, positionX + 20, positionY);
                root.getChildren().add(leftLeg);
                break;
            case 10:
                // Case 10: Draw the right leg
                Line rightLeg = new Line(positionX + 30, positionY - 15, positionX + 40, positionY);
                root.getChildren().add(rightLeg);
                break;
            case 11:
                // Case 11: Show that the player has won(for example with a text)
                Text winText = new Text(positionX, positionY - 100, "Grattis, du har vunnit!");
                root.getChildren().add(winText);
                break;
        }
    }
}
