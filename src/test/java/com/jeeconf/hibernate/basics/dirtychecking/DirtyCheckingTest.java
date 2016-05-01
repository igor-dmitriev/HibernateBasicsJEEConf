package com.jeeconf.hibernate.basics.dirtychecking;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.dirtychecking.entity.Account;
import org.junit.Test;
import org.springframework.test.annotation.Commit;

/**
 * Created by Igor Dmitriev on 4/29/16
 */
@DatabaseSetup("/dirtychecking.xml")
public class DirtyCheckingTest extends BaseTest {
    @Test
    @Commit
    public void test() {
        Account account = em.find(Account.class, 1);
        account.setAmount(500);
    }
}
