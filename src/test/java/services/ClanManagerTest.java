package services;

import junit.framework.Assert;
import junit.framework.TestCase;
import utils.ConnectionFactory;

public class ClanManagerTest extends TestCase {

    public void testGetClan() {
        ClanManager clanManager = new ClanManager(new ConnectionFactory());
        Assert.assertTrue(clanManager.getClan(1L).getId() != null);
    }

    public void testSaveClan() {
    }
}