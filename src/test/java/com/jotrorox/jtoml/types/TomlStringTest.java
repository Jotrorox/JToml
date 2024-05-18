package com.jotrorox.jtoml.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomlStringTest {

    @Test
    void testToTomlString() {
        TomlString tomlString = new TomlString("key", "value");
        assertEquals("key = \"value\"", tomlString.toTomlString());
    }

    @Test
    void testEquals() {
        TomlString tomlString1 = new TomlString("key", "value");
        TomlString tomlString2 = new TomlString("key", "value");
        assertTrue(tomlString1.equals(tomlString2));
    }

    @Test
    void testHashCode() {
        TomlString tomlString = new TomlString("key", "value");
        assertEquals("key".hashCode() + "value".hashCode(), tomlString.hashCode());
    }

    @Test
    void testKeyEquals() {
        TomlString tomlString = new TomlString("key", "value");
        assertTrue(tomlString.keyEquals("key"));
    }

    @Test
    void testValueEquals() {
        TomlString tomlString = new TomlString("key", "value");
        assertTrue(tomlString.valueEquals("value"));
    }

    @Test
    void testGetKey() {
        TomlString tomlString = new TomlString("key", "value");
        assertEquals("key", tomlString.getKey());
    }

    @Test
    void testGetValue() {
        TomlString tomlString = new TomlString("key", "value");
        assertEquals("value", tomlString.getValue());
    }

    @Test
    void testFromString() {
        TomlString tomlString = TomlString.fromString("key = \"value\"");
        assertEquals("key", tomlString.getKey());
        assertEquals("value", tomlString.getValue());
    }

}