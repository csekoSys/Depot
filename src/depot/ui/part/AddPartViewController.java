/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depot.ui.part;

import depot.pojo.PartCategory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author szerviz2
 */
public class AddPartViewController implements Initializable {

    @FXML
    private AnchorPane partPane;
    @FXML
    private TextField nameField;
    @FXML
    private TextField barcodeField;
    @FXML
    private TextField placeField;
    @FXML
    private TextArea commentArea;
    @FXML
    private ComboBox<PartCategory> partCategoryCBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPartCategory(ActionEvent event) {
    }

    @FXML
    private void addPartAndCancel(ActionEvent event) {
    }

    @FXML
    private void addPartAndNew(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
    
}
