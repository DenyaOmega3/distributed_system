package com.personcreation.serviceperson.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public final class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private long level;
    private long gold;
    private long platinum;

    public Person() {

    }

    public Person(String username, long level, long gold, long platinum) {
        this.username = username;
        this.level = level;
        this.gold = gold;
        this.platinum = platinum;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getGold() { return gold; }

    public void setGold(long gold) { this.gold = gold; }

    public long getPlatinum() { return platinum; }

    public void setPlatinum(long platinum) { this.platinum = platinum; }
}
