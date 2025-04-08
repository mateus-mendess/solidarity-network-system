package model.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactoryInterface {
    Connection getConnection() throws SQLException;
}
