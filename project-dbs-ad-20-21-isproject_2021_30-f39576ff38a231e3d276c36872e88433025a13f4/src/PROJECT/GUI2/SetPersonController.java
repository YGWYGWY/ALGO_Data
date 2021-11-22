package PROJECT.GUI2;

import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.LOGIC2.ContactPerson;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Systeem;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class SetPersonController {

    public Button applyChangesBttn;
    public TextField txtOldFirstName;
    public TextField txtOldLastName;
    public TextField txtOldEmail;
    public TextField txtOldPhoneNumber;
    public TextField txtNewFirstName;
    public TextField txtNewLastName;
    public TextField txtNewEmail;
    public TextField txtNewPhoneNumber;

    public void ApplyChanges(ActionEvent actionEvent) throws DBException {
        /*for (int i = 0; i < Systeem.getContactPersons().size(); i++) {
            if (Systeem.getContactPersons().get(i).getFirstName().equalsIgnoreCase(txtOldFirstName.getText()) && Systeem.getContactPersons().get(i).getLastName().equalsIgnoreCase(txtOldLastName.getText()) &&
                    Systeem.getContactPersons().get(i).getEmail().equalsIgnoreCase(txtOldEmail.getText()) && (Systeem.getContactPersons().get(i).getPhoneNumber() == (txtOldPhoneNumber.getText()))) {
                if (!txtOldFirstName.getText().equalsIgnoreCase(txtNewFirstName.getText())) {
                    DBContactPerson.setFirstName(txtNewFirstName.getText(), Systeem.getContactPersons().get(i));
                }
                if (!txtOldLastName.getText().equalsIgnoreCase(txtNewLastName.getText())) {
                    DBContactPerson.setFirstName(txtNewLastName.getText(), Systeem.getContactPersons().get(i));
                }
                if (!txtOldEmail.getText().equalsIgnoreCase(txtNewEmail.getText())) {
                    DBContactPerson.setEmail(txtNewEmail.getText(), Systeem.getContactPersons().get(i));
                }
                if (!txtOldPhoneNumber.getText().equalsIgnoreCase(txtNewPhoneNumber.getText())) {
                    DBContactPerson.setPhoneNumber(txtOldPhoneNumber.getText(), txtNewPhoneNumber.getText());

                }
            }

        }*/
        ContactPerson person = new ContactPerson(txtNewFirstName.getText(), txtNewLastName.getText(), txtNewEmail.getText(), txtOldPhoneNumber.getText());
        ArrayList<Locations> list = DBContactPerson.getLocations(txtOldPhoneNumber.getText());
        DBContactPerson.save(person);
        person.setLocations(list);

    }
}

