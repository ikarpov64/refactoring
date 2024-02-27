package com.javaacademy;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Runner
 * Создает город, который является источником мусора
 * Город, создает мусор
 * Далее, создается журнал переработки (файл journal.txt в корневой папке)
 * После чего происходит процесс переработки
 */
public class Runner {
    @SneakyThrows
    public static void main(String[] args) {
        City paris = new City("Paris", 10_000_000);
        Garbage[] garbageArray = paris.createGarbage();
        @Cleanup BufferedWriter journal = new BufferedWriter(new FileWriter("journal.txt"));
        UtilizationFactory.refactorGarbage(garbageArray, journal);
    }
}
