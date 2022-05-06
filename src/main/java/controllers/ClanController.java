package controllers;

import services.ClanManager;
import services.TrackerManager;
import utils.ConnectionFactory;

/**
 * @author Morozkin V. A.
 */
public class ClanController {

    ConnectionFactory connectionFactory;
    ClanManager clanManager;
    TrackerManager trackerManager;

    public ClanController() {
        this.connectionFactory = new ConnectionFactory();
        this.clanManager = new ClanManager(connectionFactory);
        this.trackerManager = new TrackerManager(connectionFactory);

    }

// Допустим этот метод вызывается параллельно пользователями 1000 раз в секунду в разных потоках

    /**
     * Метод меняет кол-во золото у клана.
     * Я сделал возвращение String, предполагая что игрок должен понимать, что произошло... :)
     *
     * @param clanId - ID клана
     * @param gold   - значение, на которое меняется кол-во золота в клане
     * @param value  1 - прирост золота, 2 - убыль золота
     */
    public synchronized String changeGold(Long clanId, Integer gold, Long userId, int value) {
        boolean result = value == 1 ? clanManager.plusGoldById(clanId, gold) : clanManager.minusGoldById(clanId, gold);
        if (result == true) {
            trackerManager.trackerClanGold(clanId, userId, gold, value);
            return "Казна клана успешно Вами пополнена, милорд!";
        } else {
            return "К сожалению Вы исключены из клана/Вам запрещено пополнять казну клана!";
        }
    }

}
