package JDBC;

import java.sql.Connection;

public interface Operation {
    void createTable(String command,Connection connection);
    void closeConnection(Connection connection);
    void selectCommand(Connection connection);
}
