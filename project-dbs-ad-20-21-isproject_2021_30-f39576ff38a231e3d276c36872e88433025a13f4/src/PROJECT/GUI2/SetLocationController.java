package PROJECT.GUI2;

import PROJECT.DB2.DBContactPerson;
import PROJECT.DB2.DBException;
import PROJECT.DB2.DBLocation;
import PROJECT.LOGIC2.Device;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Measurement;
import PROJECT.LOGIC2.Systeem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static PROJECT.DB2.DBContactPerson.*;

public class SetLocationController {
    public TextField txtOldStreetName;
    public TextField txtOldCity;
    public TextField txtOldZip;
    public TextField txtOldType;
    public TextField txtOldRoomNumber;
    public TextField txtOldLocationID;
    public TextField txtOldStreetNumber;
    public TextField txtNewZip;
    public TextField txtNewType;
    public TextField txtNewRoomNumber;
    public TextField txtNewCity;
    public TextField txtNewStreetNumber;
    public TextField txtNewStreetName;
    public TextField txtNewLocationID;
    public Button setlocationbttn;
    private Locations location;

    public void setLocation(ActionEvent mouseEvent) throws DBException {

        Locations location = new Locations(Integer.parseInt(txtOldLocationID.getText()),txtNewType.getText(), txtNewStreetName.getText(),Short.parseShort(txtNewStreetNumber.getText()),Short.parseShort(txtNewRoomNumber.getText()),Short.parseShort(txtNewZip.getText()),  txtNewCity.getText(),  LocalDate.now().toString());
        Measurement measurement = DBLocation.getMeasurement(Long.parseLong(txtOldLocationID.getText()));
        Device device = DBLocation.getDevice(Long.parseLong(txtOldLocationID.getText()));
        DBLocation.save(location);
        location.setMeasurement(measurement);
        location.setDevice(device);
        /*DBLocation.setStreetName(Long.parseLong(txtOldLocationID.getText()), txtNewStreetName.getText());
        DBLocation.setStreetNumber(Long.parseLong(txtOldLocationID.getText()), Short.parseShort(txtNewStreetNumber.getText()));
        DBLocation.setCity(Long.parseLong(txtOldLocationID.getText()), txtNewCity.getText());
        DBLocation.setZip(Long.parseLong(txtOldLocationID.getText()), Short.parseShort(txtNewZip.getText()));
        DBLocation.setLocationType(Long.parseLong(txtOldLocationID.getText()), txtNewType.getText());
        DBLocation.setRoomNumber(Long.parseLong(txtOldLocationID.getText()), Short.parseShort(txtNewRoomNumber.getText()));
        DBLocation.setLocationID(Long.parseLong(txtOldLocationID.getText()), Long.parseLong(txtNewLocationID.getText()));*/
    }

}
