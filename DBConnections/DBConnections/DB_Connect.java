package DBConnections;

import java.util.Properties;
import java.io.FileInputStream;
import java.util.logging.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;



public class DB_Connect
{
    static Logger logger = Logger.getLogger(GFG.class.getName());
    public static Properties accessories = new Properties();

    public Connection authConnection() throws SQLException, IOException
    {
            // Pull resources for secure connection
            accessories.load(new FileInputStream("config..properties"));

            String url = accessories.getProperty("dbConnection");
            String rsu = accessories.getProperty("user");
            String dwp = accessories.getProperty("pass");

            try
            {
                Connection data_bond = DriverManager.getConnection(url, rsu, dwp);
                return data_bond;

            } catch (Exception e)
            { logger.warning("Database operation failed. "); }
            
            return null;
    }
}