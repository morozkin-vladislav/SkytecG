package services;

import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Класс создан для мониторинга казны в клане.
 *
 * @author Morozkin V. A.
 */
public class TrackerManager {

    ConnectionFactory connectionFactory;

    //SQL
    private String SQL_TACK_GOLD = "INSERT INTO system.TRACK_GOLD (clan_id, user_id, gold, action) values (?, ?, ?, ?)";

    public TrackerManager(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    private Connection getConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    public boolean trackerClanGold(Long clanId, Long userId, Integer gold, Integer action) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_TACK_GOLD);
            ps.setLong(1, clanId);
            ps.setLong(2, userId);
            ps.setInt(3, gold);
            ps.setInt(4, action);
            ps.executeQuery();
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

// вызов добавления в трекер должен иметь вид
// сначала начисляем золото в клан
// Clan clan = ClanManager.getClan(clanId);
//clan.incGold(gold);
// далее сохраняем в трекер пользователя и кол-во золота
// TrackerManager.trackGold(clanId, userId, gold);


