
package depot.ui.stockmove.add;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddStockMoveViewController implements Initializable {

    @FXML
    private ComboBox<?> partnerCBox;
    @FXML
    private ComboBox<?> moveCBox;
    @FXML
    private TextField transferringField;
    @FXML
    private TextField recipientField;
    @FXML
    private TextArea commentArea;
    @FXML
    private TableView<?> patrsListTable;
    @FXML
    private HBox selecktedPartBox;
    @FXML
    private VBox addedPartsBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void appPart(ActionEvent event) {
    }

    @FXML
    private void addStockMove(ActionEvent event) {
    }
    
}
