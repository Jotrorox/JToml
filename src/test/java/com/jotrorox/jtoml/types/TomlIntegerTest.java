package com.jotrorox.jtoml.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomlIntegerTest {

    @Test
    void testToTomlString() {
        TomlInteger tomlInteger = new TomlInteger("key", 1);
        assertEquals("key = 1", tomlInteger.toTomlString());
    }

    @Test
    void testEquals() {
        TomlInteger tomlInteger1 = new TomlInteger("key", 1);
        TomlInteger tomlInteger2 = new TomlInteger("key", 1);
        assertTrue(tomlInteger1.equals(tomlInteger2));
    }

    @Test
    void testKeyEquals() {
        TomlInteger tomlInteger = new TomlInteger("key", 1);
        assertTrue(tomlInteger.keyEquals("key"));
    }

    @Test
    void testValueEquals() {
        TomlInteger tomlInteger = new TomlInteger("key", 1);
        assertTrue(tomlInteger.valueEquals(1));
    }

    @Test
    void testGetKey() {
        TomlInteger tomlInteger = new TomlInteger("key", 1);
        assertEquals("key", tomlInteger.getKey());
    }

    @Test
    void testGetValue() {
        TomlInteger tomlInteger = new TomlInteger("key", 1);
        assertEquals(1, tomlInteger.getValue());
    }

    @Test
    void testFromString() {
        TomlInteger tomlInteger = TomlInteger.fromString("key = 1");
        assertEquals("key", tomlInteger.getKey());
        assertEquals(1, tomlInteger.getValue());
    }

}