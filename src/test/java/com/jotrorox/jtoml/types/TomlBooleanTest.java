package com.jotrorox.jtoml.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomlBooleanTest {

    @Test
    void testToTomlString() {
        TomlBoolean tomlBoolean = new TomlBoolean("key", true);
        assertEquals("key = true", tomlBoolean.toTomlString());
    }

    @Test
    void testEquals() {
        TomlBoolean tomlBoolean1 = new TomlBoolean("key", true);
        TomlBoolean tomlBoolean2 = new TomlBoolean("key", true);
        assertTrue(tomlBoolean1.equals(tomlBoolean2));
    }

    @Test
    void testKeyEquals() {
        TomlBoolean tomlBoolean = new TomlBoolean("key", true);
        assertTrue(tomlBoolean.keyEquals("key"));
    }

    @Test
    void testValueEquals() {
        TomlBoolean tomlBoolean = new TomlBoolean("key", true);
        assertTrue(tomlBoolean.valueEquals(true));
    }

    @Test
    void testFromString() {
        TomlBoolean tomlBoolean = TomlBoolean.fromString("key = true");
        assertEquals("key", tomlBoolean.getKey());
        assertTrue(tomlBoolean.getValue());
    }

    @Test
    void testGetKey() {
        TomlBoolean tomlBoolean = new TomlBoolean("key", true);
        assertEquals("key", tomlBoolean.getKey());
    }

    @Test
    void testGetValue() {
        TomlBoolean tomlBoolean = new TomlBoolean("key", true);
        assertTrue(tomlBoolean.getValue());
    }

}