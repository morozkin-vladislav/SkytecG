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

    public Clan setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Clan setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGold() {
        return gold;
    }

    public Clan setGold(int gold) {
        this.gold = gold;
        return this;
    }

    public void printClan() {
        System.out.println("Clan - id: " + id.toString() + " Name: " + name + " Gold: " + gold.toString());
    }
}
