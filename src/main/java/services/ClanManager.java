package services;

import dao.Clan;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Morozkin V. A.
 */
public class ClanManager {

    ConnectionFactory connectionFactory;

    //SQL запросы
    private String SQL_GET_CLAN_BY_ID = "SELECT * FROM system.clans WHERE CLAN_ID = ?";
    private String SQL_SAVE_CLAN = "INSERT INTO system.clans (clan_id, clan_name) values (?, ?)";
    private String SQL_PLUS_GOLD = "UPDATE system.clans SET gold = gold + ? where clan_id = ?";
    private String SQL_MINUS_GOLD = "UPDATE system.clans SET gold = gold - ? where clan_id = ?";

    /**
     * Получаем подклчюение к БД.
     *
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    public ClanManager(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Метод возвращает клан по ID.
     *
     * @param clanId - id клана
     * @return - класс клана
     */
    public Clan getClan(Long clanId) {

        Clan clan = new Clan();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_GET_CLAN_BY_ID);
            ps.setInt(1, Math.toIntExact(clanId));
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            clan
                    .setId(resultSet.getLong(1))
                    .setName(resultSet.getString(2))
                    .setGold(resultSet.getInt(3));

        } catch (SQLException e) {
            //logger
            e.printStackTrace();
            return null;
        }

        return clan;
    }

    /**
     * Метод сохраняет клан в БД.
     *
     * @param clanId    - id клана.
     * @param clan_name - имя клана.
     * @return - true если сохранили успешно, false провал сохранения.
     */
    public boolean saveClan(Long clanId, String clan_name) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SAVE_CLAN);
            ps.setLong(1, clanId);
            ps.setString(2, clan_name);
            ps.executeQuery();
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Метод меняет кол-во золото у клана в БД.
     *
     * @param clanId - ID клана
     * @param gold   - значение, на которое меняется кол-во золота в клане
     */
    public boolean plusGoldById(Long clanId, Integer gold) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_PLUS_GOLD);
            ps.setInt(1, gold);
            ps.setLong(2, clanId);
            ps.executeQuery();
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Метод меняет кол-во золото у клана в БД.
     *
     * @param clanId - ID клана
     * @param gold   - значение, на которое меняется кол-во золота в клане
     */
    public boolean minusGoldById(Long clanId, Integer gold) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_MINUS_GOLD);
            ps.setInt(1, gold);
            ps.setLong(2, clanId);
            ps.executeQuery();
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
