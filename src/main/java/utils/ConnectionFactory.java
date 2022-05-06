package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс предоставляет подключение Базе Данных.
 */
public class ConnectionFactory {

    /**
     * Настройки соединения.
     */
    private String CONNECTION_URL = "";
    private String DB_USER = "";
    private String DB_PASSWORD = "";

    /**
     * Само подключение к БД.
     */
    private Connection connection;

    /**
     * Получить подключение к БД.
     *
     * @return подключение к БД
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            newConnection();
        }
        return connection;
    }

    /**
     * Создание нового подключения.
     */
    private void newConnection() throws SQLException {
        connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
    }


}
