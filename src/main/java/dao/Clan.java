package dao;

/**
 * @author Morozkin V. A.
 */
public class Clan {

    private Long id;
    private String name;
    private Integer gold;

    public Clan(long id, String name, int gold) {
        this.id = id;
        this.name = name;
        this.gold = gold;
    }

    public Clan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void printClan() {
        System.out.println("Clan - id: " + id.toString() + " Name: " + name + " Gold: " + gold.toString());
    }
}
