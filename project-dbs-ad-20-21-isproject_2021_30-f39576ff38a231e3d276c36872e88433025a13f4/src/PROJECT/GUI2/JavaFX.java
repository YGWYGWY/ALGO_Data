package PROJECT.GUI2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PROJECT.LOGIC2.Systeem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

/**
 *
 * @author fgailly
 */
public class JavaFX extends Application {

    private Systeem systeem;

    @Override
    public void start(Stage stage) throws Exception {

        systeem = new Systeem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PROJECT/GUI2/StartWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

