package PROJECT.GUI2;

import PROJECT.DB2.DBMeasurement;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AverageMeasurement implements Initializable {
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    public BarChart co2barchart = new BarChart(xAxis, yAxis);
    private SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
    private Date date;

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
            data.getData().add(Integer.parseInt("Today - "+ i), DBMeasurement.getAverageOfAllLocations(date, i));

        }
        co2barchart.getData().add(data);
    }
    //moet dit per locatie zijn of alle locaties opgeteld en hiervan het gemiddelde
    //hoe maken we hier een grafiek van?




}
