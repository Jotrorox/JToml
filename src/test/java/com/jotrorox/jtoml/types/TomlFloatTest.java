package com.jotrorox.jtoml.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomlFloatTest {

    @Test
    void testToTomlString() {
        TomlFloat tomlFloat = new TomlFloat("key", 1.0);
        assertEquals("key = 1.0", tomlFloat.toTomlString());
    }

    @Test
    void testEquals() {
        TomlFloat tomlFloat = new TomlFloat("key", 1.0);
        TomlFloat tomlFloat2 = new TomlFloat("key", 1.0);
        assertTrue(tomlFloat.equals(tomlFloat2));
    }

    @Test
    void testKeyEquals() {
        TomlFloat tomlFloat = new TomlFloat("key", 1.0);
        assertTrue(tomlFloat.keyEquals("key"));
    }

    @Test
    void testValueEquals() {
        TomlFloat tomlFloat = new TomlFloat("key", 1.0);
        assertTrue(tomlFloat.valueEquals(1.0));
    }

    @Test
    void testGetKey() {
        TomlFloat tomlFloat = new TomlFloat("key", 1.0);
        assertEquals("key", tomlFloat.getKey());
    }

    @Test
    void testGetValue() {
        TomlFloat tomlFloat = new TomlFloat("key", 1.0);
        assertEquals(1.0, tomlFloat.getValue());
    }

    void testFromString() {
        TomlFloat tomlFloat = TomlFloat.fromString("key = 1.0");
        assertEquals("key", tomlFloat.getKey());
        assertEquals(1.0, tomlFloat.getValue());
    }

}