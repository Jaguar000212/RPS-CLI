import java.util.Random;
import java.util.Scanner;

import Objs.Players.*;
import Objs.Weapons.*;

public class Main {

    static int selectWeapon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select your weapon: ");
        System.out.println("1. Stone");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");

        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Stone stone = new Stone();
        Paper paper = new Paper();
        Scissors scissors = new Scissors();

        Human human;
        Bot bot;

        System.out.println("#############################################");
        System.out.println("#         Welcome to the Ultimate           #");
        System.out.println("#             Weapon Battle                 #");
        System.out.println("#       Stone... Paper... Scissors...       #");
        System.out.println("#############################################");
        System.out.println("#         Developed by: Jaguar000212        #");
        System.out.println("#############################################");

        System.out.println("Lets get going...");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int n = 0;
        while (n != 1 && n != 2 && n != 3) {
            n = selectWeapon();
            if (n != 1 && n != 2 && n != 3) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        if (n == 1) {
            human = new Human<Stone>(name);
            human.setWeapon(stone);
        } else if (n == 2) {
            human = new Human<Paper>(name);
            human.setWeapon(paper);
        } else {
            human = new Human<Scissors>(name);
            human.setWeapon(scissors);
        }
        System.out.println(human.getName() + " has selected " + human.getWeapon().getName() + " as their weapon.");

        System.out.println("Bot is thinking...");
        int rnd = new Random().nextInt(3);
        if (rnd == 0) {
            bot = new Bot<>(stone);
        } else if (rnd == 1) {
            bot = new Bot<>(paper);
        } else {
            bot = new Bot<>(scissors);
        }
        Thread.sleep(1000);
        System.out.println("Bot has selected its weapon..." + bot.getWeapon().getName());

        System.out.println("and the winner is...");
        Thread.sleep(1000);
        try {
            Player winner = human.fight(bot);
            if (winner == null) {
                System.out.println("It's a draw!");
            } else if (winner.getName().compareToIgnoreCase(human.getName()) == 0) {
                System.out.println(human.getName() + " wins!");
                human.setWins(human.getWins() + 1);
                human.setStreak(human.getStreak() + 1);
                human.setLosses(0);
            } else {
                System.out.println(bot.getName() + " wins!");
                human.setLosses(human.getLosses() + 1);
                human.setStreak(0);
                human.setWins(0);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
