package com.jeeconf.hibernate.basics.eager;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jeeconf.hibernate.basics.BaseTest;
import com.jeeconf.hibernate.basics.eager.entity.Account;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * Created by Igor Dmitriev on 4/30/16
 */
@DatabaseSetup("/eager.xml")
public class EagerTest extends BaseTest {
    @Test
    public void eagerFindOne() {
        Account client = em.find(Account.class, 1);
    }

    @Test
    public void eagerHql() {
        List<Account> res = em.createQuery("select a from Account a where a.amount >= :amount", Account.class)
                .setParameter("amount", 0).getResultList();
        // the same result for CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    }

    @Test
    public void eagerHibernateCriteria() {
        Criteria criteria = getSession().createCriteria(Account.class);
        criteria.add(Restrictions.gt("amount", 0)).list();
    }
}
