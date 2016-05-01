package com.jeeconf.hibernate.basics.onetoone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Dmitriev on 4/30/16
 */
@Entity
@Getter
@Setter
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;
}
