package PROJECT.GUI2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminOptionsController implements Initializable {

    @FXML
    public Button deleteDevicebttn;
    @FXML
    public Button addDevicebttn;
    @FXML
    public Button setDevicebttn;
    @FXML
    public Button daybydayBttn;
    @FXML
    public Button averageCO2Bttn;
    @FXML
    public Button forecastbttn;

    @FXML
    private Button addPersonbttn;
    @FXML
    private Button deletePersonbttn;
    @FXML
    private Button setPersonbttn;
    @FXML
    private Button addLocationbttn;
    @FXML
    private Button deleteLocationbttn;
    @FXML
    private Button setLocationbttn;
    @FXML
    private AnchorPane dataPane;

    @FXML
    private TextField txtPassword;
    private String password = "ADMIN2020";
    @FXML
    private Button checkPasswordbttn;
    @FXML

    //Person add, set, delete
    //adds a person
    public void addPerson(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AddPerson.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //changes a person
    public void setPerson(ActionEvent actionEvent) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/SetPerson.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //deletes a person
    public void deletePerson(ActionEvent actionEvent) {
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/DeletePerson.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Location add, set, delete

    //adds a location TO A PERSON
    public void addLocation(ActionEvent actionEvent) {
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AddLocationPersons.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //nog eens overlopen
    //changes a location FROM A PERSON
    public void setLocation(ActionEvent actionEvent) {

        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/SetLocationPersons.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //deletes a location FROM A PERSON
    public void deleteLocation(ActionEvent actionEvent) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/DeleteLocationPersons.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    //Device add, set, delete
    //adds a device (to a location?)
    public void addDevice(ActionEvent event) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AddDevice.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //changes a device ( other location??)
    public void setDevice(ActionEvent event) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/SetDevice.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // deletes a device
    public void deleteDevice(ActionEvent event) {

        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/DeleteDevice.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //reports
    public void getDaybyDayOverview(ActionEvent event) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/LocationsDayByDay.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getAverageCO2Bttn(ActionEvent event) {
        try{
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AverageMeasurement.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testMethode(ContextMenuEvent contextMenuEvent) {
    }

//    public void checkPassword(ActionEvent event) throws Exception {
//        boolean wachtwoord = false;
//        wachtwoord = txtPassword.getText().equals(password);
//        if(wachtwoord == false){
//            try {
//                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/WrongPassword.fxml"));
//                dataPane.getChildren().setAll(pane);
//            } catch (IOException ex) {
//                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else{
//            try {
//                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AdminOptions.fxml"));
//                dataPane.getChildren().setAll(pane);
//            } catch (IOException ex) {
//                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }

    public void getForecast(ActionEvent event) {
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/Forecast.fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
