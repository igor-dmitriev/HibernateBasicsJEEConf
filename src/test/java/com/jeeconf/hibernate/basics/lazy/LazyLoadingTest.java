package com.jeeconf.hibernate.basics.lazy;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.lazy.entity.Account;
import com.jeeconf.hibernate.basics.lazy.entity.Client;
import org.junit.Test;

/**
 * Created by Igor Dmitriev on 4/29/16
 */

@DatabaseSetup("/lazy.xml")
public class LazyLoadingTest extends BaseTest {

    @Test
    public void lazyCollection() {
        Client client = em.find(Client.class, 1);
        client.getAccounts();
    }

    @Test
    public void lazyEntity() {
        Account account = em.find(Account.class, 1);
        account.getClient();
    }

    @Test
    public void load() {
        getSession().load(Client.class, 1);
    }
}
