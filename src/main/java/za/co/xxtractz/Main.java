package za.co.xxtractz;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Select number of players (Maximum 2): ");
        int players = scanner.nextInt();

        if (players > 0 && players < 3) {
            GamePlayStrategy gamePlayStrategy;
            if (players == 2) {
                gamePlayStrategy = new HumanVsHumanStrategy();
            } else {
                gamePlayStrategy = new CPUVsHuman();
            }
            gamePlayStrategy.play(scanner);
            scanner.close();
        }
    }
}