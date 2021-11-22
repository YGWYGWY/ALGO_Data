
package PROJECT.GUI2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import PROJECT.DB2.DBConnector;
import PROJECT.LOGIC2.Systeem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fgailly
 */
public class StartWindowController implements Initializable {

    public AnchorPane dataPane2;
    public Button exitbttn;
    @FXML
    private Button personenBtn;

    @FXML
    private Button adminBttn;

    private Systeem model;
    @FXML
    private AnchorPane dataPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = Systeem.getInstance();
        System.out.println("Model set");
    }

    @FXML
    private void loadPersonPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/PersonListGUI.fxml"));
        dataPane2.getChildren().setAll(pane);
    }

    @FXML
    public void loadAdminOptions(ActionEvent event){
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AdminPassword.fxml"));
            dataPane2.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML public void handleCloseButtonAction(ActionEvent event) {
        DBConnector.closeConnection(DBConnector.getInstance());
        Stage stage = (Stage) exitbttn.getScene().getWindow();
        stage.close();
    }
}

