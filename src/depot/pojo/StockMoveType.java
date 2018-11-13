
package depot.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockMoveType {
       
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty increase;
    private final SimpleStringProperty prefix;

    public StockMoveType(Integer id, String name, Integer increase, String prefix) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.increase = new SimpleIntegerProperty(increase);
        this.prefix = new SimpleStringProperty(prefix);
    }

    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public Integer getIncrease() {
        return increase.get();
    }

    public String getPrefix() {
        return prefix.get();
    }
    
    
}
