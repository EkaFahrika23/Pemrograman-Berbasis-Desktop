
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author Eka Fahrika
 */
public class KoneksiHelper {

    private static final String DB_NAME = "app_penjualan";
    private static final String USE = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(URL, USE, PASSWORD);
        return connection;
    }
}
