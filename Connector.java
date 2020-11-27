import java.sql.*;
import com.mysql.jdbc.Driver;

public class Connector
{
    public static void main(String[] args) throws SQLException
    {
        Connection con = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(conUrl, "Manager", "password");
            System.out.println("Connected to " + con.getCatalog() + " successfully.");

            ResultSet testResult = null;

            Statement statement = con.createStatement();
            String sqlSelect = "SELECT * FROM blank";
            testResult = statement.executeQuery(sqlSelect);

            while(testResult.next())
            {
                System.out.println(testResult.getString(1));
            }

            System.out.println();

            //System.out.println("List of student IDs:\n" + );
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }
}