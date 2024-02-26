package com.javaacademy;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Бутылка
 */
@RequiredArgsConstructor
@ToString(exclude = {"cityProducer"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
public class Bottle {
    @Getter
    final double volume;
    final String cityProducer;
    double nestedVolume;

    public void addLiquid(double liquidVolume) {
        if (liquidVolume > nestedVolume) {
            throw new RuntimeException("Объем добавляемой жидкости больше чем объем бутылки");
        }
        double newNestedVolume = nestedVolume + liquidVolume;
        if (newNestedVolume > volume) {
            throw new RuntimeException("Нет места в бутылки, все выливается!");
        }
        setNestedVolume(newNestedVolume);
    }
}