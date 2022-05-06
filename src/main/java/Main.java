import controllers.ClanController;

/**
 * Задача:
 * Обязательная часть
 * 1. Нужно реализовать логику добавления/уменьшения золота в клан
 * 2. Предусмотреть конкурентный доступ с разных потоков
 * (допустим ~1000 параллельных запросов в секунду от разных пользователей)
 * ---------------------
 *
 * @author Morozkin V. A.
 */
public class Main {

    public static void main(String[] args) {

        ClanController clanController = new ClanController();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> clanController.changeGold(1L, 10,666L, 1)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> clanController.changeGold(1L, 5,555L, 2)).start();
        }

    }


}
