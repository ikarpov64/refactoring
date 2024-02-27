package com.javaacademy;

import lombok.*;

/**
 * Город
 */
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"peopleCount"})
public class City {
    @NonNull
    private final String name;
    private int peopleCount;

    public Garbage[] createGarbage() {
        return new Garbage[] {
            new Garbage(GarbageType.GLASS, 1000, this.name),
            new Garbage(GarbageType.PAPER, 15000, this.name),
            new Garbage(GarbageType.MIXED, 200000, this.name),
        };
    }
}
