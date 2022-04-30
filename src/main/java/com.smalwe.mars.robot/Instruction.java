package com.smalwe.mars.robot;

/**
 * Enumeration to the instructions available
 */
public enum Instruction {
    L("L"), R("R"), F("F");

    private String value;
    Instruction(String value) {
        this.value = value;
    }
}
