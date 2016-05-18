package com.jeeconf.hibernate.basics.nplusone;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.entity.Client;
import org.junit.Test;
import org.springframework.test.annotation.Commit;

import java.util.List;

/**
 * Created by Igor Dmitriev / Mikalai Alimenkou on 5/18/16
 */
@DatabaseSetup("/data.xml")
public class NplusOneTest extends BaseTest {

    @Test
    public void nPlusOneIssue() {
        List<Client> clients = em.createQuery("select c from Client c", Client.class)
                .getResultList();
        clients.forEach(c -> c.getAccounts().size());
    }

    @Test
    public void extraLazy() {
        Client client = em.find(Client.class, 10);
        client.getAccounts().size();
        client.getAccounts().get(0);
    }

    @Test
    @Commit
    // TODO: clarify with Mikalai Alinemkou
    public void mergeCollections() {
        Client client = em.find(Client.class, 10);
    }
}
