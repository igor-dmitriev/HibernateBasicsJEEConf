package com.jeeconf.hibernate.basics.onetoone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Dmitriev on 4/29/16
 */
@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;
    private int age;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private Passport passport;
}
