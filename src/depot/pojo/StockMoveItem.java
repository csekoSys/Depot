
package depot.pojo;

import javafx.beans.property.SimpleIntegerProperty;

public class StockMoveItem {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty stockMoveId;
    private final SimpleIntegerProperty partId;
    private final SimpleIntegerProperty quantity;

    public StockMoveItem(Integer id, Integer stockMoveId, Integer partId, Integer quantity) {
        this.id = new SimpleIntegerProperty(id);
        this.stockMoveId = new SimpleIntegerProperty(stockMoveId);
        this.partId = new SimpleIntegerProperty(partId);
        this.quantity = new SimpleIntegerProperty(quantity);
    }
    
    

    public Integer getId() {
        return id.get();
    }

    public Integer getStockMoveId() {
        return stockMoveId.get();
    }

    public Integer getPartId() {
        return partId.get();
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    
}
