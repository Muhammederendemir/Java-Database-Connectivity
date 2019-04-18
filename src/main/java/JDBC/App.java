package JDBC;
import java.sql.*;
import java.util.Scanner;

public class App
{

    public static void main(String[] args) {
        DBConnection dbConnection=new DBConnection();
        Connection connection= (Connection) dbConnection.getConnection();
        Operation operation=new OperationImpl();
        //String command="CREATE TABLE muhammed(id INT ,isim VARCHAR(19))";
        //operation.createTable(command,connection);
        operation.selectCommand(connection);
        operation.closeConnection(connection);
    }
}
