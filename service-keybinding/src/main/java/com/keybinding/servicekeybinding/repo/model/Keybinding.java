package com.keybinding.servicekeybinding.repo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "keybindings")
public final class Keybinding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String up;
    private String down;
    private String left;
    private String right;

    public Keybinding() {

    }

    public Keybinding(String up, String down, String left, String right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public long getId() {
        return id;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
