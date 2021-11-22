package PROJECT.GUI2;

import PROJECT.DB2.DBDevice;
import PROJECT.DB2.DBException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

public class DeleteDeviceController {
    public Button deleteDevicebttn;
    public TextField txtDeviceNumber;

    public void deleteDevice(ActionEvent actionEvent) throws DBException {
        DBDevice.deleteDevice(Long.parseLong(txtDeviceNumber.getText()));
    }

    public void testMethode(ContextMenuEvent contextMenuEvent) {
    }
}
