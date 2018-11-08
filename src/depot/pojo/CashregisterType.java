package depot.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CashregisterType {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty licenseNumber;
    private final SimpleStringProperty name;

    public CashregisterType(int id, String licenseNumber, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.licenseNumber = new SimpleStringProperty(licenseNumber);
        this.name = new SimpleStringProperty(name);
    }

    public int getId() {
        return id.get();
    }

    public String getLicenseNumber() {
        return licenseNumber.get();
    }

    public String getName() {
        return name.get();
    }
    
    
}
