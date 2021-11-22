package PROJECT.GUI2;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.LOGIC2.ContactPerson;
import PROJECT.LOGIC2.Systeem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

/**
 * FXML Controller class
 *
 * @author fgailly
 */
public class AddPersonController implements Initializable {

    @FXML
    public TextField txtFirstName;
    @FXML
    public TextField txtLastName;
    @FXML
    public TextField txtEmail;
    @FXML
    public TextField txtPhoneNumber;

    private Systeem model;

    @FXML
    private Button addPersonBtn;
    @FXML
    private Label testLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //model = Systeem.getInstance();
    }
    @FXML
    private void addPerson(ActionEvent event) {

        try {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String phoneNumber = txtPhoneNumber.getText();

            ContactPerson person= new ContactPerson(phoneNumber,email,lastName,firstName);
            Systeem.addContactPerson(person);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonListGUI.fxml"));
            loader.load();
            PersonListViewController controller =
                    (PersonListViewController) loader.getController();
            controller.addContactPerson(person);

            //studentListView.getItems().add(student);
            //model.addContactPerson(person);
            //
        } catch (IOException ex) {
            Logger.getLogger(AddPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void testMethode(ContextMenuEvent event) {
    }


}