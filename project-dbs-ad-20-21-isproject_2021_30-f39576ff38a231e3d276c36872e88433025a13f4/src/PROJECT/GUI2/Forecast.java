package PROJECT.GUI2;

import PROJECT.DB2.DBMeasurement;
import PROJECT.LOGIC2.Measurement;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Forecast implements Initializable {
    public AnchorPane dataPane;
    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    public BarChart forecastChart = new BarChart(xAxis, yAxis);
    private SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
    private Date date;
    private double average;
    private double sum;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            date = formatter1.parse(String.valueOf(LocalDate.now()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        xAxis.setLabel("ppm");
        yAxis.setLabel("Date");
        XYChart.Series data = new XYChart.Series();

        for(int i = 7; i >0; i--){
            data.getData().add(Integer.parseInt("Today - "+ i), DBMeasurement.getForecast(date, i));
            sum += DBMeasurement.getForecast(date, i);

        }
        forecastChart.getData().add(data);

        //misschien hier delen door 6.65 en dropping delen door 7.35 de marge hiertussen is dan stable (5%erboven en 5%eronder)
        if(sum/6.65 < DBMeasurement.getForecast(date, 0)){
            try {
                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/Rising.fxml"));
                dataPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else if(sum/7.35 > DBMeasurement.getForecast(date, 0)){
            try {
                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/Dropping.fxml"));
                dataPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/PROJECT/GUI2/Stable.fxml"));
                dataPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(StartWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //geeft foutmelding of de getter
    //public BarChart forecastChart = new BarChart(0,100, DBMeasurement.getForecast(LocalDate.now()));




}

