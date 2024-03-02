package za.co.xxtractz;


import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Logger;


public class Main {
    private static Character[][] gameBoard;

    private static List<Integer> availableMoves;
    private static Player player1;
    private static Player player2;
    private static final int[][] MOVE_POSITIONS = new int[][]{
            {0, 0}, {0, 2}, {0, 4}, {2, 0}, {2, 2}, {2, 4}, {4, 0}, {4, 2}, {4, 4}
    };
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        /*
         * 0|X|0
         * -+-+-
         * X|O|X
         * -+-+-
         * X|0|X
         * */
        setAvailableMoves();
        gameBoard = new Character[][]{{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        play();

    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Please Select number of players (Maximum 2): ");
        int players = scanner.nextInt();

        if (players > 0 && players < 3) {

            if (players == 2) {
                player1 = new Player("Musa", new ArrayList<>(), PlayerType.HUMAN, 'X', true);
                player2 = new Player("Xxtract", new ArrayList<>(), PlayerType.HUMAN, 'O', false);
            } else {
                player1 = new Player("Musa", new ArrayList<>(), PlayerType.HUMAN, 'X', true);
                player2 = new Player(PlayerType.CPU.getDescription(), new ArrayList<>(), PlayerType.CPU, 'O', false);
            }


            boolean isGameInProgress = true;
            while (isGameInProgress) {
                LOGGER.info(availableMoves.toString() + "At Restart");
                Player player = getCurrentPlayer();

                if (availableMoves.isEmpty()) {
                    LOGGER.info("Game over. It's a draw!");
                    isGameInProgress = false;
                } else {
                    LOGGER.info(player.getName() + " :: Enter your move (1-9): ");
                    int move = scanner.nextInt();

                    if (isValidInput(move)) {
                        if (isValidMove(move)) {
                            setGameBoardPosition(move, player.getSymbol());
                            player.addMove(move);
                            if (isWinner()) {
                                LOGGER.info(getCurrentPlayer().getName() + " wins!");
                                isGameInProgress = false;
                            }
                            availableMoves.remove(Integer.valueOf(move));
                            switchPlayers();
                            LOGGER.info(MessageFormat.format("{0}::: {1}", player.getName(), player));
                        } else {
                            LOGGER.info("Invalid move. Please try again.");
                        }
                    } else {
                        isGameInProgress = false;
                    }
                    printBoard();
                }
            }
        }
    }

    private static void printBoard() {
        for (Character[] characters : gameBoard) {
            for (Character character : characters) {
                System.out.print(character.toString());
            }
            System.out.println();
        }
    }

    private static void switchPlayers() {
        if (player1.isPlayerTurn()) {
            player2.setPlayerTurn(true);
            player1.setPlayerTurn(false);

        } else {
            player2.setPlayerTurn(false);
            player1.setPlayerTurn(true);
        }
    }

    private static Player getCurrentPlayer() {
        if (player1.isPlayerTurn()) {
            return player1;
        } else {
            return player2;
        }
    }

    private static boolean isValidInput(int move) {
        return move > 0 && move <= 9;
    }

    private static boolean isValidMove(int value) {
        return value > 0 && value <= 9 && (availableMoves.contains(value));
    }

    private static void setAvailableMoves() {
        availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private static void setGameBoardPosition(int move, Character playerSymbol) {
        if (move >= 1 && move <= 9) {
            int[] position = MOVE_POSITIONS[move - 1];
            gameBoard[position[0]][position[1]] = playerSymbol;
        }
    }

    private static boolean isWinner() {

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