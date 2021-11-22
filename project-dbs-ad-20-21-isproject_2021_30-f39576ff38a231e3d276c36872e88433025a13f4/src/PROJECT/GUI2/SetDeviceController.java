package PROJECT.GUI2;

import PROJECT.DB2.DBDevice;
import PROJECT.DB2.DBException;
import PROJECT.LOGIC2.Device;
import PROJECT.LOGIC2.Locations;
import PROJECT.LOGIC2.Measurement;
import PROJECT.LOGIC2.MeasurementType;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

import java.util.ArrayList;

public class SetDeviceController {

    public Button setDevicebttn;

    public TextField txtNewDeviceNumber;

    public TextField txtOldDeviceNumber;

    public void setDevice(ActionEvent actionEvent) throws DBException {
        ArrayList<MeasurementType> type = DBDevice.getMeasurementType(Long.parseLong(txtOldDeviceNumber.getText()));
        Device device = new Device(Long.parseLong(txtNewDeviceNumber.getText()), type);
        //long locationID = DBDevice.getLocationID(Long.parseLong(txtOldDeviceNumber.getText()));
        Locations location = DBDevice.getLocation(Long.parseLong(txtOldDeviceNumber.getText()));

        DBDevice.save(device);
        device.setLocation(location);
        device.setMeasurementType(type);
        
}

    public void testMethode(ContextMenuEvent contextMenuEvent) {
    }
}

