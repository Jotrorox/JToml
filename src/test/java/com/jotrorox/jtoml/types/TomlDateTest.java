package com.jotrorox.jtoml.types;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TomlDateTest {

    @Test
    void testToTomlString() {
        TomlDate date = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        assertEquals("date = 1979-5-27T7:32:0Z", date.toTomlString());
    }

    @Test
    void testEquals() {
        TomlDate date1 = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        TomlDate date2 = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        assertTrue(date1.equals(date2));
    }

    @Test
    void testKeyEquals() {
        TomlDate date = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        assertTrue(date.keyEquals("date"));
    }

    @Test
    void testValueEquals() {
        TomlDate date = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        assertTrue(date.valueEquals(new Date(79, 4, 27, 7, 32, 0)));
    }

    @Test
    void testGetKey() {
        TomlDate date = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        assertEquals("date", date.getKey());
    }

    @Test
    void testGetValue() {
        TomlDate date = new TomlDate("date", new Date(79, 4, 27, 7, 32, 0));
        assertEquals(new Date(79, 4, 27, 7, 32, 0), date.getValue());
    }

    @Test
    void testFromString() {
        TomlDate date = TomlDate.fromString("key = 1979-5-27T7:32:0Z");
        assertEquals("key = 1979-5-27T7:32:0Z", date.toTomlString());
    }

}