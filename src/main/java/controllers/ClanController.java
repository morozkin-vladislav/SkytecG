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
     *
     * @param clanId - ID клана
     * @param gold   - значение, на которое меняется кол-во золота в клане
     * @param value  1 - прирост золота, 2 - убыль золота
     */
    public synchronized void changeGold(Long clanId, Integer gold, Long userId, int value) {

        boolean result = false;
        String msg = "";

        if (value == 1) {
            result = clanManager.plusGoldById(clanId, gold);
            msg = "Казна клана успешно Вами пополнена, милорд!";
        } else if (value == 2) {
            result = clanManager.minusGoldById(clanId, gold);
            msg = "Вы забрали золото из клана!";
        }

        if (result == true) {
            trackerManager.trackerClanGold(clanId, userId, gold, value);
            System.out.println(msg);
        } else {
            System.out.println("К сожалению Вы исключены из клана/Вам запрещено пополнять казну клана!");
        }
    }

}
