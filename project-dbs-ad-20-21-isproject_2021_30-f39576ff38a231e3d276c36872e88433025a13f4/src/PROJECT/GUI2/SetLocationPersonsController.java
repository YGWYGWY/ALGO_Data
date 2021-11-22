package PROJECT.GUI2;

import PROJECT.LOGIC2.Locations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetLocationPersonsController {


    public Button nextBttn;
    public TextField txtFirstName;
    public TextField txtLastName;
    public static TextField txtPhoneNumber;
    private static ArrayList<Locations> locations;
    @FXML
    private AnchorPane dataPane;

    public void setLocation(ActionEvent actionEvent) {

        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/SetLocation.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static TextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }
}
