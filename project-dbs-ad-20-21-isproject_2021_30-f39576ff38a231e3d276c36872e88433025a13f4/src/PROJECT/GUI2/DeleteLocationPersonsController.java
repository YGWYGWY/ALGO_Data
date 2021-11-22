package PROJECT.GUI2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteLocationPersonsController {

    public Button nextBttn;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtPhoneNumber;
    @FXML
    private AnchorPane dataPane;

    public void showLocations(ActionEvent event) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/DeleteLocation.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
