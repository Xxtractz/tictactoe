package za.co.xxtractz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class HumanVsHumanStrategy extends GamePlay implements GamePlayStrategy  {

    @Override
    public void play(Scanner scanner) {
      promptPlayerDetails(scanner);
      gameData.setAvailableMoves(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        boolean isGameInProgress = true;
        while (isGameInProgress) {
            System.out.println(gameData.getAvailableMoves().toString() + "At Restart");
            Player player = getCurrentPlayer();

            if (gameData.getAvailableMoves().isEmpty()) {
                System.out.println("Game over. It's a draw!");
                isGameInProgress = false;
            } else {
                System.out.println(player.getName() + " :: Enter your move (1-9): ");
                int move = scanner.nextInt();

                if (isValidInput(move)) {
                    if (isValidMove(move)) {
                        setGameBoardPosition(move, player.getSymbol());
                        player.addMove(move);
                        if (isWinner()) {
                            System.out.println(getCurrentPlayer().getName() + " wins!");
                            isGameInProgress = false;
                        }
                        gameData.getAvailableMoves().remove(Integer.valueOf(move));
                        switchPlayers();
                        System.out.println(MessageFormat.format("{0}::: {1}", player.getName(), player));
                    } else {
                        System.out.println("Invalid move. Please try again.");
                    }
                } else {
                    isGameInProgress = false;
                }
                printBoard();
            }
        }
    }
    @Override
    public void promptPlayerDetails(Scanner scanner){
        System.out.println("Enter player 1 name: ");
        String name1 = scanner.nextLine();
        player1 = PlayerFactory.createPlayer(name1, PlayerType.HUMAN, 'X', true);



        if (scanner.hasNext() && !name1.isEmpty()){
            System.out.println("Enter player 2 name: ");
            String name2 = scanner.nextLine();

            player2 = PlayerFactory.createPlayer(name2, PlayerType.HUMAN, 'O', false);
        }

    }
}
