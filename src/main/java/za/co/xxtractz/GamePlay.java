package za.co.xxtractz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Game play.
 */
public abstract class GamePlay {
    /**
     * The constant gameData.
     */
    protected static final GameData gameData = GameData.getInstance();
    /**
     * The constant player1.
     */
    protected Player player1;
    /**
     * The constant player2.
     */
    protected Player player2;
    /**
     * The constant MOVE_POSITIONS.
     */
    protected  final int[][] MOVE_POSITIONS = new int[][]{
            {0, 0}, {0, 2}, {0, 4}, {2, 0}, {2, 2}, {2, 4}, {4, 0}, {4, 2}, {4, 4}
    };

    /**
     * Instantiates a new Game play.
     */
    GamePlay() {
    }

    /**
     * Sets game board position.
     *
     * @param move         the move
     * @param playerSymbol the player symbol
     */
    protected  void setGameBoardPosition(int move, Character playerSymbol) {
        if (move >= 1 && move <= 9) {
            int[] position = MOVE_POSITIONS[move - 1];
            gameData.updateGameBoard(position[0], position[1], playerSymbol);
        }
    }

    /**
     * Print board.
     */
    protected void printBoard() {
        for (Character[] characters : gameData.getGameBoard()) {
            for (Character character : characters) {
                System.out.print(character.toString());
            }
            System.out.println();
        }
    }

    /**
     * Switch players.
     */
    protected  void switchPlayers() {
        if (player1.isPlayerTurn()) {
            player2.setPlayerTurn(true);
            player1.setPlayerTurn(false);

        } else {
            player2.setPlayerTurn(false);
            player1.setPlayerTurn(true);
        }
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    protected Player getCurrentPlayer() {
        if (player1.isPlayerTurn()) {
            return player1;
        } else {
            return player2;
        }
    }

    /**
     * Is valid input boolean.
     *
     * @param move the move
     * @return the boolean
     */
    protected static boolean isValidInput(int move) {
        return move > 0 && move <= 9;
    }

    /**
     * Is valid move boolean.
     *
     * @param value the value
     * @return the boolean
     */
    protected static boolean isValidMove(int value) {
        return value > 0 && value <= 9 && (gameData.getAvailableMoves().contains(value));
    }

    /**
     * Sets available moves.
     */
    protected static void setAvailableMoves() {
        gameData.setAvailableMoves(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }


    /**
     * Is winner boolean.
     *
     * @return the boolean
     */
    protected boolean isWinner() {

        if (getCurrentPlayer().getMoves().size() < 3) return false;
        List<Integer> moves = getCurrentPlayer().getMoves();

        // List of winning combinations
        int[][] winningCombinations = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
                {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
                {1, 5, 9}, {3, 5, 7}
        };

        for (int[] combination : winningCombinations) {
            if (moves.contains(combination[0]) && moves.contains(combination[1]) && moves.contains(combination[2])) {
                return true;
            }
        }
        return false;
    }
}
