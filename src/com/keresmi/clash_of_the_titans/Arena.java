package com.keresmi.clash_of_the_titans;

import com.keresmi.clash_of_the_titans.models.Footman;
import com.keresmi.clash_of_the_titans.models.Knight;
import com.keresmi.clash_of_the_titans.models.Palladin;
import com.keresmi.clash_of_the_titans.models.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arena {

    private int firstTeamBudget = 100000;
    private int secondTeamBudget = 100000;

    private List<Warrior> firstTeamWarriors;
    private List<Warrior> secondTeamWarriors;

    private String firstTeamName;
    private String secondTeamName;

    public Arena() {
        this.firstTeamWarriors = new ArrayList<>();
        this.secondTeamWarriors = new ArrayList<>();
    }

    public void startGame() {
        System.out.println("Clash of the Titans");
        System.out.println();
        chooseFirstTeamName();
        System.out.println();
        chooseSecondTeamName();
        chooseTeamWarriors(firstTeamWarriors, firstTeamName, firstTeamBudget);
        System.out.println();
        chooseTeamWarriors(secondTeamWarriors, secondTeamName, secondTeamBudget);
    }

    private void chooseFirstTeamName() {
        System.out.println("Choose first team name: ");
        Scanner scanner = new Scanner(System.in);
        firstTeamName = scanner.nextLine();
    }

    private void chooseSecondTeamName() {
        System.out.println("Choose second team name: ");
        Scanner scanner = new Scanner(System.in);
        secondTeamName = scanner.nextLine();
    }

    private void chooseTeamWarriors(List<Warrior> warriors, String teamName, int teamBudget) {
        Footman footman = null;
        Knight knight = null;
        Palladin palladin = null;

        while (teamBudget >= 10000) {
            System.out.println("Choose warrior for team " + teamName);
            System.out.println("Your budget is " + teamBudget);
            System.out.println();
            System.out.println("0 <- Footman, cost: 10 000");
            System.out.println("1 <- Knight, cost 25 000");
            System.out.println("2 <- Palladin, cost 60 000");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case WarriorType.FOOTMAN:
                    if (footman == null)
                        footman = new Footman("Footman");

                    if (teamBudget >= footman.getCost()) {
                        teamBudget -= footman.getCost();
                        warriors.add(footman);

                    } else {
                        System.out.println("No enough money to buy this warrior");
                        System.out.println();
                    }
                    break;

                case WarriorType.KNIGHT:
                    if (knight == null)
                        knight = new Knight("Knight");

                    if (teamBudget >= knight.getCost()) {
                        teamBudget -= knight.getCost();
                        warriors.add(knight);

                    } else {
                        System.out.println("No enough money to buy this warrior");
                        System.out.println();
                    }
                    break;

                case WarriorType.PALLADIN:
                    if (palladin == null)
                        palladin = new Palladin("Palladin");

                    if (teamBudget >= palladin.getCost()) {
                        teamBudget -= palladin.getCost();
                        warriors.add(palladin);

                    } else {
                        System.out.println("No enough money to buy this warrior");
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Wrong number! Try again.");
                    System.out.println();
                    break;
            }

            System.out.println();
            System.out.println("Available budget: " + teamBudget);
            System.out.println();
        }

        System.out.println("You cannot afford to buy another warrior.");
        System.out.println();

        System.out.println("Team " + teamName + " army: ");
        for (Warrior warrior : warriors) {
            System.out.println(warrior.toString());
        }
    }
}
