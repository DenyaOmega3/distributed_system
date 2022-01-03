package com.relic.servicerelicshop.repo.model;


import javax.persistence.*;

@Entity
@Table(name = "relicshops")
public final class Relicshop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String relic_name;
    private long goldPrice;
    private long platinumPrice;
    private String buff;
    private String description;

    public Relicshop(String relic_name, long goldPrice, long platinumPrice, String buff, String description) {
        this.relic_name = relic_name;
        this.goldPrice = goldPrice;
        this.platinumPrice = platinumPrice;
        this.buff = buff;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getRelic_name() {
        return relic_name;
    }

    public void setRelic_name(String relic_name) {
        this.relic_name = relic_name;
    }

    public long getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(long goldPrice) {
        this.goldPrice = goldPrice;
    }

    public long getPlatinumPrice() {
        return platinumPrice;
    }

    public void setPlatinumPrice(long platinumPrice) {
        this.platinumPrice = platinumPrice;
    }

    public String getBuff() {
        return buff;
    }

    public void setBuff(String buff) {
        this.buff = buff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
