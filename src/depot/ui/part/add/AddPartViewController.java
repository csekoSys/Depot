package depot.ui.part.add;

import depot.database.DatabaseHandler;
import depot.pojo.CashregisterType;
import depot.pojo.PartCategory;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddPartViewController implements Initializable {

    private DatabaseHandler databaseHandler;
    private ObservableList<PartCategory> partCategoriesList = FXCollections.observableArrayList();

    @FXML
    private TextField nameField;
    @FXML
    private TextField barcodeField;
    @FXML
    private TextArea commentArea;
    @FXML
    private ComboBox<PartCategory> partCategoryCBox;
    @FXML
    private AnchorPane partPane;
    private VBox cashregisterTypeListAndQuntityBox;
    private GridPane crGridPane;
    @FXML
    private TextField placeField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPartCategoryCBox();
    }

    private void addPart() {
        int partCategoryId = partCategoryCBox.getSelectionModel().getSelectedItem().getId();
        String partName = nameField.getText();
        String partBarcode = barcodeField.getText();
        String partPlace = placeField.getText();
        String partComment = commentArea.getText();

        if (partName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("A név mező kitöltése kötelező!");
            alert.showAndWait();
            return;
        }

        String query = "INSERT INTO PARTS (part_categories_id,name,barcode,place,quantity,comment) VALUES ("
                + "'" + partCategoryId + "',"
                + "'" + partName + "',"
                + "'" + partBarcode + "',"
                + "'" + partPlace + "',"
                + 0 + ","
                + "'" + partComment + "'"
                + ")";

        System.out.println("QUERY: " + query);

        if (databaseHandler.execAction(query)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Az alkatrész mentése sikeres!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Az alkatrész mentése NEM sikerült!");
            alert.showAndWait();
        }
    }

    private void exit() {
        Stage stage = (Stage) partPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addPartAndCancel(ActionEvent event) {
        addPart();
        exit();
    }

    @FXML
    private void addPartAndNew(ActionEvent event) {
        addPart();
        
        //törölni a fieldeket
    }

    @FXML
    private void cancel(ActionEvent event) {
        exit();
    }

    /**
     * Új alkatrészkategória rögzítése
     * @param event 
     */
    @FXML
    private void addPartCategory(ActionEvent event) {
        System.out.println("depot.ui.part.AddPartViewController.addPartCategory()");
    }

    private void loadPartCategory() {
        databaseHandler = DatabaseHandler.getInstance();

        String query = "SELECT * FROM PART_CATEGORIES";
        ResultSet rs = databaseHandler.execQuery(query);

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                partCategoriesList.add(new PartCategory(id, name));
            }
        } catch (SQLException ex) {
        }
    }

    private void initPartCategoryCBox() {
        loadPartCategory();
        partCategoryCBox.setItems(partCategoriesList);
    }

}
