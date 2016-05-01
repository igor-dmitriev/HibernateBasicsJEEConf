package com.jeeconf.hibernate.basics.onetoone;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.onetoone.entity.Client;
import org.junit.Test;

/**
 * Created by Igor Dmitriev on 4/30/16
 */
@DatabaseSetup("/onetoone.xml")
public class OneToOneTest extends BaseTest {
    @Test
    public void findOne() {
        em.find(Client.class, 1);
    }
}
