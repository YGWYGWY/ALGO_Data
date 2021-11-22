package PROJECT.GUI2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminPassword implements Initializable{


    @FXML
    private TextField txtPassword;
    private String password = "ADMIN2020";
    @FXML
    private Button checkPasswordbttn;
    @FXML
    private AnchorPane dataPane;


    public void testMethode(ContextMenuEvent contextMenuEvent) {
    }

    public void checkPassword(ActionEvent event) throws Exception {
        boolean wachtwoord = false;
        wachtwoord = txtPassword.getText().equals(password);
        if(wachtwoord == false){
            try {
                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/WrongPassword.fxml"));
                dataPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/AdminOptions.fxml"));
                dataPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
