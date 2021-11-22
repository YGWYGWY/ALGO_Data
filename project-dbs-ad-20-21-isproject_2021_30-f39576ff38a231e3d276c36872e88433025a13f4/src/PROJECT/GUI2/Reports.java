package PROJECT.GUI2;

import PROJECT.DB2.DBException;
import PROJECT.DB2.DBMeasurement;
import PROJECT.LOGIC2.Locations;
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

public class Reports implements Initializable {
    public Button showoverviewbttn;
    public ListView LocationDayByDayListView = new ListView((ObservableList) PersonListViewController.getLocations());
    public AnchorPane dataPane;
    private static Locations locations;
    public ListView daybydayListView = new ListView(DBMeasurement.getmeasurement(Reports.getLocations()));//alle measurement types of basic van datum geordend

    public Reports() throws DBException {
    }

    public void showOverview(ActionEvent event) {
        ObservableList<Locations> con = LocationDayByDayListView.getSelectionModel().getSelectedItems();
        Locations locations = con.get(0);
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/Daybyday.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Locations getLocations() {
        return locations;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
