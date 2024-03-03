package za.co.xxtractz;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameData {
    private Character[][] gameBoard;
    private List<Integer> availableMoves;
    public static GameData getInstance() {
        return new GameData();
    }

    public void updateGameBoard(int row, int column, Character value) {
        if (row < 0 || row >= gameBoard.length || column < 0 || column >= gameBoard[0].length) {
            throw new IllegalArgumentException("Invalid row or column values");
        }
        gameBoard[row][column] = value;
    }
}
