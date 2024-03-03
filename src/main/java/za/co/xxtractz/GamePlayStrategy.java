package za.co.xxtractz;

import java.util.Scanner;

interface GamePlayStrategy {
    void play(Scanner scanner);

    void promptPlayerDetails(Scanner scanner);
}
