package com.javaacademy;

import lombok.Value;

@Value
public class Garbage {
    GarbageType garbageType;
    double weight;
    String cityFrom;
}
