package softpubdbmanagertest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softpub.config.DBManager;

public class SoftPubDBManagerTest {

    public static void main(String[] args) {
        DBManager dbManager = null;
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        Connection conexion = dbManager.getConnection();        
    }
    
}
