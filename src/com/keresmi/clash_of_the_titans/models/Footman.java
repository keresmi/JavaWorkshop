package com.keresmi.clash_of_the_titans.models;

import java.util.Random;

public class Footman extends Person implements Warrior {

    private int health;
    private final int attack;
    private final int cost;
    private final int minAttack;

    private final Random random;

    public Footman(String name) {
        super(name);
        this.health = 50;
        this.attack = 30;
        this.cost = 10000;
        this.minAttack = 0;
        this.random = new Random();
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getCost() {
        return cost;
    }

    public int getMinAttack() {
        return minAttack;
    }

    @Override
    public int attack() {
        return random.nextInt(attack + 1);
    }

    @Override
    public String toString() {
        return "Footman{" +
                "health=" + health +
                ", attack=" + attack +
                ", cost=" + cost +
                ", minAttack=" + minAttack +
                '}';
    }
}
