package com.javaacademy;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Фабрика по переработке мусора
 */
public class UtilizationFactory {
    public static final double BOTTLE_SIZE = 500;

    private UtilizationFactory() {
    }

    private static Bottle refactorGlassGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.GLASS) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из стекла!");
        }
        return new Bottle(BOTTLE_SIZE, garbage.getCityFrom());
    }

    private static Cartoon refactorPaperGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.PAPER) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из бумаги!");
        }
        return new Cartoon(garbage.getWeight() / 2);
    }

    public static void refactorGarbage(Garbage[] garbageArray, BufferedWriter journal)
            throws GarbageNotRefactorableException, IOException {
        for (Garbage garbage : garbageArray) {
            switch (garbage.getGarbageType()) {
                case GLASS -> journal.write(
                        JournalRecord.builder()
                                .bottle(UtilizationFactory.refactorGlassGarbage(garbage))
                                .build()
                                .toString());
                case PAPER -> journal.write(
                        JournalRecord.builder()
                                .cartoon(UtilizationFactory.refactorPaperGarbage(garbage))
                                .build()
                                .toString());
                default -> journal.write(
                        JournalRecord.builder()
                                .garbageWeight(garbage.getWeight())
                                .toString());
            }
        }
    }
}
