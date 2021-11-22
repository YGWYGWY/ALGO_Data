package PROJECT.GUI2;

import PROJECT.DB2.*;
import PROJECT.LOGIC2.GasNames;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Measurement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnterMeasurement {
    public static TextField txtDate;
    public TextField txtCO2;
    public TextField txtN2;
    public TextField txtPM25;
    public TextField txtPM5;
    public TextField txtPM10;
    public Button enterbttn;
    public Locations location = LocationsOfPerson.getLocation();
    private SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
    public TextField txtMeasurementID;
    @FXML
    private AnchorPane dataPane;
    private int numberOfFields = 0;

    public void enterMeasurement(ActionEvent event) throws ParseException, DBException {
        //new Measurement mes
        //device.setMeasurement(mes)
        //DBDevice.enterMeasurement(device.getMeasurement)
        String date1 = txtDate.getText();
        Date date = formatter1.parse(date1);


        if(LocalDate.now().equals(date)){
            if(DBLocation.searchForDate(date, LocationsOfPerson.getLocation()).equals(null)){
                if(Double.parseDouble(txtCO2.getText()) < 0.0001) {
                    try {
                        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                        dataPane.getChildren().setAll(pane);
                    } catch (IOException ex) {
                        Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(Double.parseDouble(txtN2.getText()) > 0.0001) {
                    if (Double.parseDouble(txtCO2.getText()) < 0.0001) {
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if(Double.parseDouble(txtPM25.getText()) > 0.0001 || Double.parseDouble(txtPM5.getText()) > 0.0001 ||Double.parseDouble(txtN2.getText()) > 0.0001){
                    if(Double.parseDouble(txtPM25.getText()) < 0.0001 && Double.parseDouble(txtPM5.getText()) < 0.0001&& Double.parseDouble(txtN2.getText()) < 0.0001){
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(Double.parseDouble(txtCO2.getText()) < 0.0001 && Double.parseDouble(txtN2.getText()) < 0.0001){
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                if(Double.parseDouble(txtCO2.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtN2.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtPM25.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtPM5.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtPM10.getText())>0.001){
                    numberOfFields++;
                }

                if(LocationsOfPerson.getDevice().getGasTypes().size() == numberOfFields) {
                    if (LocationsOfPerson.getDevice().getGasTypes().size() == 1) {
                        Measurement measurement = new Measurement(date, LocationsOfPerson.getLocation(),txtMeasurementID.getText());
                        GasNames gasNames = new GasNames(Double.parseDouble(txtCO2.getText()), "CO2");
                        measurement.addGasName(gasNames);
                        DBMeasurement.save(measurement);
                        DBGasname.addGasName(gasNames.getName(),measurement.getMeasurementID());
                    } else if (LocationsOfPerson.getDevice().getGasTypes().size() == 2) {
                        Measurement measurement = new Measurement(date, LocationsOfPerson.getLocation(),txtMeasurementID.getText());
                        GasNames gasNames1 = new GasNames(Double.parseDouble(txtCO2.getText()), "CO2");
                        GasNames gasNames2 = new GasNames(Double.parseDouble(txtN2.getText()), "N2");
                        measurement.addGasName(gasNames1);
                        measurement.addGasName(gasNames2);
                        DBMeasurement.save(measurement);
                        DBGasname.addGasName(gasNames1.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames2.getName(),measurement.getMeasurementID());
                    } else if (LocationsOfPerson.getDevice().getGasTypes().size() == 5) {
                        Measurement measurement = new Measurement(date, LocationsOfPerson.getLocation(),txtMeasurementID.getText());
                        GasNames gasNames1 = new GasNames(Double.parseDouble(txtCO2.getText()), "CO2");
                        GasNames gasNames2 = new GasNames(Double.parseDouble(txtN2.getText()), "N2");
                        GasNames gasNames3 = new GasNames(Double.parseDouble(txtPM25.getText()), "PM2.5");
                        GasNames gasNames4 = new GasNames(Double.parseDouble(txtPM5.getText()), "PM5");
                        GasNames gasNames5 = new GasNames(Double.parseDouble(txtPM10.getText()), "PM10");
                        measurement.addGasName(gasNames1);
                        measurement.addGasName(gasNames2);
                        measurement.addGasName(gasNames3);
                        measurement.addGasName(gasNames4);
                        measurement.addGasName(gasNames5);
                        DBMeasurement.save(measurement);
                        DBGasname.addGasName(gasNames1.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames2.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames3.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames4.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames5.getName(),measurement.getMeasurementID());
                    } else {
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    try {
                        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                        dataPane.getChildren().setAll(pane);
                    } catch (IOException ex) {
                        Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                //location.setMeasurement(location, measurement); //is niet nodig als we via de DB setten
                //DBLocation.enterMeasurement(LocationsOfPerson.getDevice().getDeviceNumber(), location.getMeasurement()); //gaan dit werken in de database?//moeten we hier niet werken met locationID ipv deviceNr
            }else{
                DBMeasurement.deleteMeasurement(Long.parseLong(txtMeasurementID.getText()));
                if(Double.parseDouble(txtCO2.getText()) < 0.0001) {
                    try {
                        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                        dataPane.getChildren().setAll(pane);
                    } catch (IOException ex) {
                        Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(Double.parseDouble(txtN2.getText()) > 0.0001) {
                    if (Double.parseDouble(txtCO2.getText()) < 0.0001) {
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if(Double.parseDouble(txtPM25.getText()) > 0.0001 || Double.parseDouble(txtPM5.getText()) > 0.0001 ||Double.parseDouble(txtN2.getText()) > 0.0001){
                    if(Double.parseDouble(txtPM25.getText()) < 0.0001 && Double.parseDouble(txtPM5.getText()) < 0.0001&& Double.parseDouble(txtN2.getText()) < 0.0001){
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(Double.parseDouble(txtCO2.getText()) < 0.0001 && Double.parseDouble(txtN2.getText()) < 0.0001){
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                if(Double.parseDouble(txtCO2.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtN2.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtPM25.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtPM5.getText())>0.001){
                    numberOfFields++;
                }
                if(Double.parseDouble(txtPM10.getText())>0.001){
                    numberOfFields++;
                }

                if(LocationsOfPerson.getDevice().getGasTypes().size() == numberOfFields) {
                    if (LocationsOfPerson.getDevice().getGasTypes().size() == 1) {
                        Measurement measurement = new Measurement(date, LocationsOfPerson.getLocation(),txtMeasurementID.getText());
                        GasNames gasNames = new GasNames(Double.parseDouble(txtCO2.getText()), "CO2");
                        measurement.addGasName(gasNames);
                        DBMeasurement.save(measurement);
                        DBGasname.addGasName(gasNames.getName(),measurement.getMeasurementID());
                    } else if (LocationsOfPerson.getDevice().getGasTypes().size() == 2) {
                        Measurement measurement = new Measurement(date, LocationsOfPerson.getLocation(),txtMeasurementID.getText());
                        GasNames gasNames1 = new GasNames(Double.parseDouble(txtCO2.getText()), "CO2");
                        GasNames gasNames2 = new GasNames(Double.parseDouble(txtN2.getText()), "N2");
                        measurement.addGasName(gasNames1);
                        measurement.addGasName(gasNames2);
                        DBMeasurement.save(measurement);
                        DBGasname.addGasName(gasNames1.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames2.getName(),measurement.getMeasurementID());
                    } else if (LocationsOfPerson.getDevice().getGasTypes().size() == 5) {
                        Measurement measurement = new Measurement(date, LocationsOfPerson.getLocation(),txtMeasurementID.getText());
                        GasNames gasNames1 = new GasNames(Double.parseDouble(txtCO2.getText()), "CO2");
                        GasNames gasNames2 = new GasNames(Double.parseDouble(txtN2.getText()), "N2");
                        GasNames gasNames3 = new GasNames(Double.parseDouble(txtPM25.getText()), "PM2.5");
                        GasNames gasNames4 = new GasNames(Double.parseDouble(txtPM5.getText()), "PM5");
                        GasNames gasNames5 = new GasNames(Double.parseDouble(txtPM10.getText()), "PM10");
                        measurement.addGasName(gasNames1);
                        measurement.addGasName(gasNames2);
                        measurement.addGasName(gasNames3);
                        measurement.addGasName(gasNames4);
                        measurement.addGasName(gasNames5);
                        DBMeasurement.save(measurement);
                        DBGasname.addGasName(gasNames1.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames2.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames3.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames4.getName(),measurement.getMeasurementID());
                        DBGasname.addGasName(gasNames5.getName(),measurement.getMeasurementID());
                    } else {
                        try {
                            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                            dataPane.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    try {
                        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/IllegalMeasurement.fxml"));
                        dataPane.getChildren().setAll(pane);
                    } catch (IOException ex) {
                        Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }else{
            try {
                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/CannotChangeMeasurement.fxml"));
                dataPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
