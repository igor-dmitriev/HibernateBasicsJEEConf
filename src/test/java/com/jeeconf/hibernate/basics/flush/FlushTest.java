package com.jeeconf.hibernate.basics.flush;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.entity.Account;
import com.jeeconf.hibernate.basics.entity.Client;
import com.jeeconf.hibernate.basics.entity.Report;
import org.junit.Test;
import org.springframework.test.annotation.Commit;

/**
 * Created by Igor Dmitriev / Mikalai Alimenkou on 4/29/16
 */

@DatabaseSetup("/flush.xml")
public class FlushTest extends BaseTest {

    @Test
    @Commit
    public void showSpecificExecutionOrder() {
        // 1. select client
        Client client = em.find(Client.class, 10);
        // 2. select account
        Account account = client.getAccounts().get(0);
        // 3. delete account
        em.remove(account);
        // 4. update client
        client.setName("John");
        // 5. insert new report
        Report report = new Report();
        report.setDescription("Client has been updated; Account has been removed");
        em.persist(report);
    }

    @Test
    @Commit
    public void showFlushNativeSelect() {
        Client client = new Client();
        client.setName("John");
        getSession().persist(client);
        String sql = "select c.id,c.name,c.age from Client c";
        getSession().createSQLQuery(sql).list();
        //em.createNativeQuery(sql).getResultList();
    }

    @Test
    @Commit
    public void updateAllFields() {
        Client client = em.find(Client.class, 10);
        client.setAge(30);
    }

}
