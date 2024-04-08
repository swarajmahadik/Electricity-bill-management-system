package electricity.billing.system;

import java.sql.*;
public class database {
    Connection connection;
    Statement statement;
    database(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "Anuj99");

            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


