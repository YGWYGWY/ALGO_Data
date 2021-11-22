package PROJECT.GUI2;

import PROJECT.DB2.DBDevice;
import PROJECT.DB2.DBException;
import PROJECT.DB2.DBLocation;
import PROJECT.LOGIC2.Device;
import PROJECT.LOGIC2.GasTypes;
import PROJECT.LOGIC2.Measurement;
import PROJECT.LOGIC2.MeasurementType;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class AddDeviceController {
    public Button addDevicebttn;
    public TextField txtStreetName;
    public TextField txtStreetNumber;
    public TextField txtDeviceNumber;
    public TextField txtLocationID;
    public CheckBox averageBox;
    public CheckBox maximumBox;
    public CheckBox minimumBox;
    public CheckBox PMBox;
    public CheckBox N2Box;
    public CheckBox CO2Box;
    public TextField txtmeasurementID;
    private SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");

    public void addDevice(ActionEvent actionEvent) throws Exception {
        if(averageBox.isSelected() && maximumBox.isSelected() && minimumBox.isSelected()){
            ArrayList<MeasurementType> list = new ArrayList<>();
            list.add(MeasurementType.Average);
            list.add(MeasurementType.Minimum);
            list.add(MeasurementType.Maximum);
            Device device = new Device(Long.parseLong(txtDeviceNumber.getText()), list);
            DBDevice.save(device);
            if(CO2Box.isSelected() && N2Box.isSelected() && PMBox.isSelected()){
                device.addGasType(GasTypes.CO2);
                device.addGasType(GasTypes.N2);
                device.addGasType(GasTypes.PM25);
                device.addGasType(GasTypes.PM5);
                device.addGasType(GasTypes.PM10);
            }else if (CO2Box.isSelected() && N2Box.isSelected()){
                device.addGasType(GasTypes.CO2);
                device.addGasType(GasTypes.N2);
            }else if(CO2Box.isSelected()){
                device.addGasType(GasTypes.CO2);
            }else{
                throw new Exception();
            }
        }else if(averageBox.isSelected()){
            ArrayList<MeasurementType> list = new ArrayList<>();
            list.add(MeasurementType.Average);
            Device device = new Device(Long.parseLong(txtDeviceNumber.getText()), list);
            DBDevice.save(device);
            if(CO2Box.isSelected() && N2Box.isSelected() && PMBox.isSelected()){
                device.addGasType(GasTypes.CO2);
                device.addGasType(GasTypes.N2);
                device.addGasType(GasTypes.PM25);
                device.addGasType(GasTypes.PM5);
                device.addGasType(GasTypes.PM10);
            }else if (CO2Box.isSelected() && N2Box.isSelected()){
                device.addGasType(GasTypes.CO2);
                device.addGasType(GasTypes.N2);
            }else if(CO2Box.isSelected()){
                device.addGasType(GasTypes.CO2);
            }else{
                throw new Exception();
            }
        }
    }

    public void testMethode(ContextMenuEvent contextMenuEvent) {
    }
}
