package PROJECT.GUI2;

import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.LOGIC2.ContactPerson;
import PROJECT.LOGIC2.Systeem;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeletePersonController {

    public Button deletePersonbttn;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtPhoneNumber;
    public TextField txtEmail;

    public void deletePerson(MouseEvent mouseEvent) throws DBException, IOException {
        Systeem.deleteContactPerson(txtPhoneNumber.getText());
        DBContactPerson.deletePerson(txtPhoneNumber.getText());


        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonListGUI.fxml"));
        loader.load();
        PersonListViewController controller =
                (PersonListViewController) loader.getController();
        controller.deleteContactPerson(DBContactPerson.getContactPerson(txtPhoneNumber.getText()));*/
        /*try {

            for(int i =0; i < Systeem.getContactPersons().size(); i++) {
                if (Systeem.getContactPersons().get(i).getPhoneNumber() == (txtPhoneNumber.getText())) {
                    Systeem.deleteContactPerson(Systeem.getContactPersons().get(i));

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonListGUI.fxml"));
                    loader.load();
                    PersonListViewController controller =
                            (PersonListViewController) loader.getController();
                    controller.deleteContactPerson(Systeem.getContactPersons().get(i));
                    DBContactPerson.deletePerson(txtPhoneNumber.getText());
                    Systeem.deleteContactPerson(DBContactPerson.getContactPerson(txtPhoneNumber.getText()));
                }
            }*/

            //studentListView.getItems().add(student);
            //model.addContactPerson(person);
            //
        /*} catch (IOException | DBException ex) {
            Logger.getLogger(AddPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }*/



    }
}


