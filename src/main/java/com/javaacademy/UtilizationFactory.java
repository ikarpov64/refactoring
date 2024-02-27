package com.javaacademy;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Фабрика по переработке мусора
 */
@UtilityClass
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class UtilizationFactory {
    double BOTTLE_SIZE = 500;

    private Bottle refactorGlassGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.GLASS) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из стекла!");
        }
        return new Bottle(BOTTLE_SIZE, garbage.getCityFrom());
    }

    private Cartoon refactorPaperGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.PAPER) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из бумаги!");
        }
        return new Cartoon(garbage.getWeight() / 2);
    }

    public void refactorGarbage(Garbage[] garbageArray, BufferedWriter journal)
            throws GarbageNotRefactorableException, IOException {
        for (Garbage garbage : garbageArray) {
            switch (garbage.getGarbageType()) {
                case GLASS ->
                        journal.write(new JournalRecord(com.javaacademy.UtilizationFactory.refactorGlassGarbage(garbage)).toString());
                case PAPER ->
                        journal.write(new JournalRecord(com.javaacademy.UtilizationFactory.refactorPaperGarbage(garbage)).toString());
                default -> journal.write(new JournalRecord(garbage.getWeight()).toString());
            }
        }
    }
}