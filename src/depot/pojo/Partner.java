
package depot.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Partner {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty address;

    public Partner(Integer id, String name, String address) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
    }

    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getAddress() {
        return address.get();
    }

    
    
}
