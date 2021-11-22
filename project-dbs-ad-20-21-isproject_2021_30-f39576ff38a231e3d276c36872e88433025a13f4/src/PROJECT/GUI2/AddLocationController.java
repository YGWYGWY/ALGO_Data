package PROJECT.GUI2;

import PROJECT.DB2.DBLocation;
import PROJECT.LOGIC2.Locations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddLocationController implements Initializable {

    @FXML
    public TextField txtStreetName;
    @FXML
    public TextField txtStreetNumber;
    @FXML
    public TextField txtCity;
    @FXML
    public TextField txtZip;

    @FXML
    public TextField txtType;
    @FXML
    public Button addLocationbttn;
    @FXML
    public TextField txtRoomNumber;
    @FXML
    public TextField txtLocationID;

    public void AddLocation(ActionEvent event) {
        try {
            String streetName = txtStreetName.getText();
            short streetNumber = Short.parseShort(txtStreetNumber.getText());
            String city = txtCity.getText();
            Short zip = Short.parseShort(txtZip.getText());
            String locationType = txtType.getText();
            short roomNumber = Short.parseShort(txtRoomNumber.getText());
            int locationID = Integer.parseInt(txtLocationID.getText());


            Locations locations = new Locations(locationID, locationType, streetName, streetNumber, roomNumber,zip,city, LocalDate.now().toString());

            DBLocation.save(locations);
            //nog methode om deze locatie aan de juiste persoon toe te voegen










        }catch (Exception ex) {
            Logger.getLogger(AddLocationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
