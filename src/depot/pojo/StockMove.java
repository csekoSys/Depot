
package depot.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockMove {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty partnerId;
    private final SimpleIntegerProperty stockMoveTypeId;
    private final SimpleStringProperty transfering;
    private final SimpleStringProperty recipient;
    private final SimpleStringProperty comment;
    private final SimpleStringProperty date;

    public StockMove(Integer id, Integer partnerId, Integer stockMoveTypeId, String transfering, String recipient, String comment, String date) {
        this.id = new SimpleIntegerProperty(id);
        this.partnerId = new SimpleIntegerProperty(partnerId);
        this.stockMoveTypeId = new SimpleIntegerProperty(stockMoveTypeId);
        this.transfering = new SimpleStringProperty(transfering);
        this.recipient = new SimpleStringProperty(recipient);
        this.comment = new SimpleStringProperty(comment);
        this.date = new SimpleStringProperty(date);
    }

    public Integer getId() {
        return id.get();
    }

    public Integer getPartnerId() {
        return partnerId.get();
    }

    public Integer getStockMoveTypeId() {
        return stockMoveTypeId.get();
    }

    public String getTransfering() {
        return transfering.get();
    }

    public String getRecipient() {
        return recipient.get();
    }

    public String getComment() {
        return comment.get();
    }

    public String getDate() {
        return date.get();
    }
    
    
    
}
