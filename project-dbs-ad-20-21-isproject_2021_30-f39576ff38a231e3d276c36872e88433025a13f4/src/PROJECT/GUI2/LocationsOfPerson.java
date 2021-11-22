package PROJECT.GUI2;

import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.DB2.DBLocation;
import PROJECT.LOGIC2.Device;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Systeem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationsOfPerson implements Initializable {


    public ListView personlocationListView = new ListView<>();
    public AnchorPane dataPane;
    public Button deviceinformationbttn;
    public static Device device;
    public static Locations location;

    public LocationsOfPerson()  throws DBException {
    }

    public void showDeviceInformation(ActionEvent mouseEvent) {
        try {
            ObservableList<Locations> loc = personlocationListView.getSelectionModel().getSelectedItems();
            location = loc.get(0);
            device = DBLocation.getDevice(location.getLocationID()); //gaat die werken in de database?
            //ArrayList<Double> = DBDevice.getGasTypes(device.getDeviceNumber());

            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/EnterMeasurement.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException | DBException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Device getDevice() {
        return device;
    }

    /*public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            personlocationListView =  DBContactPerson.getLocations(PersonListViewController.getPersonen().get(0).getPhoneNumber()); //PersonListViewController.getLocations());
        } catch (DBException e) {
            e.printStackTrace();
        }
        //database nodig om de de personen uit de database te halen, anders nullPointerException
    }*/

    public static Locations getLocation() {
        return location;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //model = Systeem.getInstance();
        ObservableList<Locations> locations = null;
        try {
            locations = FXCollections.observableArrayList(DBLocation.getLocations(PersonListViewController.getPersonen().get(0).getPhoneNumber()));
        } catch (DBException e) {
            e.printStackTrace();
        }
        personlocationListView.setItems(locations);
    }
}
