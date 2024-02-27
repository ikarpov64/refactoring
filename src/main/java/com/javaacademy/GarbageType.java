package com.javaacademy;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GarbageType {
    PAPER("Бумага"), GLASS("Стекло"), MIXED("Смешанный мусор");
    @NonNull
    private final String value;
}
