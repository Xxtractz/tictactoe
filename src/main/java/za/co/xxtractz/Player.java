package za.co.xxtractz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Player  implements Serializable {
    private static final long serialVersionUID = -7336568396012176555L;
    private String name;
    private List<Integer> moves;
    private PlayerType playerType;
    private Character symbol;
    private boolean isPlayerTurn;
    public void addMove(int move) {
        moves.add(move);
    }
}
