package PROJECT.GUI2;

import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Systeem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DeleteLocationController {


    public ListView<Locations> LocationListView;
    public TextField txtStreetName;
    public TextField txtStreetNumber;
    public Button deleteLocationbttn;
    public TextField txtLocationID;
    public TextField txtPhoneNumber;
    private ObservableList<Locations> locations;



    /*public void initialize(){
        ArrayList<Locations> list = new ArrayList<>();
        for(int i = 0; i< Systeem.getContactPersons().size(); i++){
            if(Systeem.getContactPersons().get(i).getPhoneNumber(Systeem.getContactPersons().get(i)) == ){
                list = DBContactPerson.getLocations(Systeem.getContactPersons().get(i).getPhoneNumber(Systeem.getContactPersons().get(i)));
            }
        }
        locations = (ObservableList<Locations>) FXCollections.observableArrayList(list);
        LocationListView.setItems(locations);
    }
    /*public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Locations> list = new ArrayList<>();
        for(int i = 0; i< Systeem.getContactPersons().size(); i++){
            if(Systeem.getContactPersons().get(i).getPhoneNumber(Systeem.getContactPersons().get(i))){
                list = DBContactPerson.getLocations(Systeem.getContactPersons().get(i).getPhoneNumber(Systeem.getContactPersons().get(i)));
            }
        }
        locations = (ObservableList<Locations>) FXCollections.observableArrayList(list);
        LocationListView.setItems(locations);
        //database nodig om de de personen uit de database te halen, anders nullPointerException
    }*/

    public void deleteLocation(ActionEvent mouseEvent) throws DBException {
        DBContactPerson.deleteLocation(Long.parseLong(txtPhoneNumber.getText()), (int) Long.parseLong(txtLocationID.getText()));

    }
}
