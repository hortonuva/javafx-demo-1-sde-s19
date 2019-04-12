import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonDemo1 extends Application {

    // GUI components defined here so can be accessed by any method in class
    private Button helloButton;

    // state variables for this program
    private int numPresses = 0;

    // -- main() ----------------------------------------
    public static void main(String[] args) {
        launch(args);
    }

    // -- start() ----------------------------------------
    @Override
    public void start(Stage primaryStage) {
        // create Buttons
        Button helloButton = new Button();
        helloButton.setText("Say 'Hello World'");

        // 3 ways shown next that attach an event handler to this button.
        // A button can only have one "onAction" object, so each subsequent call replaces the previous object.
        helloButton.setOnAction(new EventHandler<ActionEvent>() {  // first way: anonymous object
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        helloButton.setOnAction(event -> System.out.println("lambdas work too!")); // second way: lambda
        helloButton.setOnAction(this::handleButtonClick);  // third way:  method reference

        // We can also add event-handlers. This follows the Observer design pattern very closely.
        // MouseEvent API: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MouseEvent.html
        helloButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> System.out.println("Released the mouse after click."));
        helloButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> System.out.println("Mouse moved onto button."));
        helloButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> System.out.println("Mouse moved off of button."));
        helloButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("Message from 'CLICKED' event-handler"));
        helloButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("Message from 2nd'CLICKED' event-handler"));


        // JavaFX code to create a GUI window: modify Stage, create Scene, use VBox layout, add Scene to Stage,...

        VBox vbox = new VBox(helloButton);  // add all Controls to layout-object
        vbox.setSpacing(10);
        primaryStage.setScene(new Scene(vbox, 300, 250));
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }

    // -- event handlers and other methods ----------------------------------------

    private void handleButtonClick(ActionEvent event) {
        ++this.numPresses;
        System.out.println("From our handleButton() method.  Press count=" + this.numPresses);
    }

}
