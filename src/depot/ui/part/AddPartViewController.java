
package depot.ui.part;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddPartViewController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField barcodeField;
    @FXML
    private TextArea commentArea;
    @FXML
    private ComboBox<?> partCategoryCBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void addPart(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void addPartCategory(ActionEvent event) {
    }
    
}
