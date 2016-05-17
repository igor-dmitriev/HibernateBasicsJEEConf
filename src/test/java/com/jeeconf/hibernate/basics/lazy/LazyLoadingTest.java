package com.jeeconf.hibernate.basics.lazy;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.entity.Account;
import com.jeeconf.hibernate.basics.entity.Client;
import org.junit.Test;
import org.springframework.test.annotation.Commit;

import java.util.List;

/**
 * Created by Igor Dmitriev / Mikalai Alimenkou on 4/29/16
 */

@DatabaseSetup("/data.xml")
public class LazyLoadingTest extends BaseTest {

    @Test
    public void lazyCollection() {
        Client client = em.find(Client.class, 10);
        System.out.println("<- got client");
        client.getAccounts();
        System.out.println("<- got accounts");
        client.getAccounts().size();
        System.out.println("<- got accounts size");
    }

    @Test
    public void lazyEntity() {
        Account account = em.find(Account.class, 10);
        System.out.println("<- got account");
        account.getClient();
        System.out.println("<- got client");
        account.getClient().getId();
        System.out.println("<- got client id");
    }

    @Test
    public void loadMethod() {
        Client client = getSession().load(Client.class, 10);
        System.out.println("<- got client");
        client.getAge();
        System.out.println("<- got age");
    }

    @Test
    public void nPlusOneIssue() {
        List<Client> clients = em.createQuery("select c from Client c", Client.class)
                .getResultList();
        clients.forEach(a -> a.getAccounts().size());
    }

    @Test
    public void extraLazy() {
        Client client = em.find(Client.class, 10);
        client.getAccounts().size();
        client.getAccounts().get(0);
    }

    @Test
    @Commit
    // TODO: 5/17/16
    public void mergeCollections() {
        Client client = em.find(Client.class, 10);
    }
}
