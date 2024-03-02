package za.co.xxtractz;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlayerType {
    CPU(0,"Computer"),HUMAN(1,"Human");
    private final int value;
    private final String description;
}
