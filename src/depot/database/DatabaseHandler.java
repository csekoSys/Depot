
package depot.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DatabaseHandler {
    
    private static DatabaseHandler handler = null;
    
    private static final String DB_URL = "jdbc:sqlite:Database/DepotDB.db";
    private static Connection conn = null;
    private static Statement stmt = null;

    private DatabaseHandler() {
        createConnection();
        createPartTable();
        createPartCategoriesTable();
        createCashregisterTypesTable();
    }
    
    public static DatabaseHandler getInstance() {
        if(handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }
    
    void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * PARTS tábla létrehozása, ha nem létezik
     */
    void createPartTable() {
        String TABLE_NAME = "PARTS";
        
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()) {
                System.out.println("A(z) " + TABLE_NAME + " tábla már létezik!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "part_categories_id INTEGER,\n"
                        + "name VARCHAR(255),\n"
                        + "barcode VARCHAR(255),\n"
                        + "place VARCHAR(255),\n"
                        + "quantity INTEGER(100),\n"
                        + "comment VARCHAR(255)\n"
                        + ")");
            }
            
        } catch (SQLException ex) {
            System.err.println("Hiba : " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void createPartCategoriesTable() {
        String TABLE_NAME = "PART_CATEGORIES";
        
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()) {
                System.out.println("A(z) " + TABLE_NAME + " tábla már létezik!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "name VARCHAR(255),\n"
                        + "comment VARCHAR(255)\n"
                        + ")");
            }
            
        } catch (SQLException ex) {
            System.err.println("Hiba: " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createCashregisterTypesTable() {
        String TABLE_NAME = "CASHREGISTER_TYPES";
        
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()) {
                System.out.println("A(z) " + TABLE_NAME + " tábla már létezik!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "licensenumber VARCHAR(255),\n"
                        + "name VARCHAR(255)\n"
                        + ")");
            }
            
        } catch (SQLException ex) {
            System.err.println("Hiba: " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void createPartnersTable() {
        String TABLE_NAME = "PARTNERS";
        
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()) {
                System.out.println("A(z) " + TABLE_NAME + " tábla már létezik!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "name VARCHAR(255),\n"
                        + "address VARCHAR(255)\n"
                        + ")");
            }
            
        } catch (SQLException ex) {
            System.err.println("Hiba: " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
   
    private void createStockMoveTypesTable() {
        String TABLE_NAME = "STOCK_MOVE_TYPES";
        
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()) {
                System.out.println("A(z) " + TABLE_NAME + " tábla már létezik!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "name VARCHAR(255),\n"
                        + "prefix VARCHAR(255),\n"
                        + "add BOOLEAN(255)\n"
                        + ")");
            }
            
        } catch (SQLException ex) {
            System.err.println("Hiba: " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
 
    /*
    private void createStockMovesTable() {
        String TABLE_NAME = "STOCK_MOVESS";
        
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            if(tables.next()) {
                System.out.println("A(z) " + TABLE_NAME + " tábla már létezik!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "partner_id INTEGER,\n"
                        + "name VARCHAR(255),\n"
                        + "name VARCHAR(255),\n"
                        + "prefix VARCHAR(255),\n"
                        + "add BOOLEAN(255)\n"
                        + ")");
            }
            
        } catch (SQLException ex) {
            System.err.println("Hiba: " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
 */
    
    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("database.DatabaseHandler.execQuery(): " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return result;
    }
    
    public boolean execAction(String query) {
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            System.err.println("database.DatabaseHandler.execAction(): " + ex);
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }


}
