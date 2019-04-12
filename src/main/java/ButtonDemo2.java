import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonDemo2 extends Application {

    // GUI components defined here so can be accessed by any method in class
    private Button helloButton;
    private Button calcButton;
    private Label calcResult; // methods other than start() need to update this result

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

        // Event handlers for this button.  (Removed all but one from ButtonDemo1.)
        helloButton.setOnAction(this::handleButtonClick);

        // We can also add event-handlers. This follows the Observer design pattern very closely.
        // (REMOVED: mouse-event handlers from ButtonDemo1.)

        // 2nd Button to do some calculation, plus Label to show text of result
        Button calcButton = new Button();
        calcButton.setText("Calculate!");
        calcResult = new Label("<initial text>");
        calcButton.setOnAction(this::handleCalcButtonClick);

        // JavaFX code to create a GUI window: modify Stage, create Scene, use VBox layout, add Scene to Stage,...

        VBox vbox = new VBox(helloButton, calcButton, calcResult);  // add all Controls to layout-object
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

    private void handleCalcButtonClick(ActionEvent event) {
        ++this.numPresses;
        System.out.println("Calculate button pressed.");
        String answer = this.doBigCalculation();
        this.calcResult.setText(answer);
    }

    private String doBigCalculation() {
        return "result of calculation. " + this.numPresses;
    }

}
