import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;
import java.util.TimeZone;


public class ImplExample implements Dean {
    @Override
    public List<Product> getProducts() throws Exception {
        List<Product> list = new ArrayList<Product>();

        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/hardware";

        // Database credentials
        String USER = "root";
        String PASS = "Dean";

        Connection conn = null;
        Statement stmt = null;

        //Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        //Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();
        String sql = "SELECT * FROM product_data";
        ResultSet rs = stmt.executeQuery(sql);

        //Extract data from result set
        while(rs.next()) {
            // Retrieve by column name
            int id  = rs.getInt("id");
            String quantity  = rs.getString("quantity");

            String name = rs.getString("name");



            // Setting the values
            Product product = new Product();
            product.setID(id);
            product.setName(name);
            product.setQuantity(quantity);
            list.add(product);
        }
        rs.close();
        return list;
    }
}

