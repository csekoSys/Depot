package depot.ui.part;

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
    private ObservableList<CashregisterType> cashregisterTypesList = FXCollections.observableArrayList();

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
    @FXML
    private VBox cashregisterTypeListAndQuntityBox;
    private GridPane crGridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPartCategoryCBox();
        initCashregisterTypes();

    }

    @FXML
    private void addPart(ActionEvent event) {
        int partCategoryId = partCategoryCBox.getSelectionModel().getSelectedItem().getId();
        String partName = nameField.getText();
        String partBarcode = barcodeField.getText();
        String partComment = commentArea.getText();

        if (partName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("A név mező kitöltése kötelező!");
            alert.showAndWait();
            return;
        }

        String query = "INSERT INTO PARTS (part_categories_id,name,barcode,quantity,comment) VALUES ("
                + "'" + partCategoryId + "',"
                + "'" + partName + "',"
                + "'" + partBarcode + "',"
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

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) partPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addPartCategory(ActionEvent event) {
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

    private void loadCashregisterType() {
        databaseHandler = DatabaseHandler.getInstance();

        String query = "SELECT * FROM CASHREGISTER_TYPES";
        ResultSet rs = databaseHandler.execQuery(query);

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String licenseNumber = rs.getString("licensenumber");
                String name = rs.getString("name");

                cashregisterTypesList.add(new CashregisterType(id, licenseNumber, name));
            }
        } catch (SQLException ex) {
        }
    }

    private void showCashregisterTypes() {
        crGridPane = new GridPane();

        for (int i = 0; i < cashregisterTypesList.size(); i++) {
            crGridPane.add(new Label(cashregisterTypesList.get(i).getLicenseNumber()), 0, i);
            crGridPane.getColumnConstraints().add(new ColumnConstraints(40));
            crGridPane.add(new Label(cashregisterTypesList.get(i).getName()), 1, i);
            crGridPane.getColumnConstraints().add(new ColumnConstraints(120));
            crGridPane.add(new TextField("0"), 2, i);
        }

        cashregisterTypeListAndQuntityBox.getChildren().add(crGridPane);
    }

    private void initCashregisterTypes() {
        loadCashregisterType();
        showCashregisterTypes();
    }

}
