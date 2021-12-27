package com.keybinding.servicekeybinding.repo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "keybindings")
public class Keybinding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private char up;
    private char down;
    private char left;
    private char right;

    public Keybinding(char up, char down, char left, char right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public long getId() {
        return id;
    }

    public char getUp() {
        return up;
    }

    public void setUp(char up) {
        this.up = up;
    }

    public char getDown() {
        return down;
    }

    public void setDown(char down) {
        this.down = down;
    }

    public char getLeft() {
        return left;
    }

    public void setLeft(char left) {
        this.left = left;
    }

    public char getRight() {
        return right;
    }

    public void setRight(char right) {
        this.right = right;
    }
}
