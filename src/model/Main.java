package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Main class.
 *
 * Prepares a stage for the main application window to be displayed on.
 *
 * FUTURE ENHANCEMENT
 *
 * A potential update to the application could include the ability to remove a part from any products it is
 * associated with if the part is removed from inventory. This could be optional, for example in a case
 * where a part still exists within a few products until stock runs out, but would be a good way to add
 * more usability.
 *
 */
public class Main extends Application {

    /**
     * The entry point of the application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Gets the primary stage and loads the Main Screen fxml onto it.
     * @param primaryStage The primary stage for the application.
     * @throws Exception Not used.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScreen.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.show();
    }
}
