package za.co.xxtractz;

import lombok.NonNull;

import java.util.ArrayList;

public class PlayerFactory {
    PlayerFactory(){}
    @NonNull
    public static Player createPlayer(String name, PlayerType playerType, char symbol, boolean isPlayerTurn) {
        return new Player(name, new ArrayList<>(), playerType, symbol, isPlayerTurn);
    }
}
