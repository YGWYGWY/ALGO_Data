package PROJECT.GUI2;

import PROJECT.DB2.DBContactPerson;
import PROJECT.LOGIC2.ContactPerson;
import PROJECT.LOGIC2.Locations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddLocationPersonsController {
    public Button addLocationbttn;
    public TextField txtLastName;
    public static TextField txtPhoneNumber;
    public TextField txtFirstName;
    @FXML
    private AnchorPane dataPane;
    private ArrayList<Locations> locations;

    public void AddLocation(ActionEvent event) {

        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AddLocation.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static TextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }
}
