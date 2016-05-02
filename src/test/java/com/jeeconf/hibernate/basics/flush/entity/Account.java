package com.jeeconf.hibernate.basics.flush.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Dmitriev on 4/29/16
 */
@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    private int amount;
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

}
