package com.jotrorox.jtoml.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomlTypesTest {

    @Test
    void testTomlTypes() {
        TomlTypes[] types = TomlTypes.values();
        assertEquals(7, types.length);
        assertEquals(TomlTypes.STRING, types[0]);
        assertEquals(TomlTypes.INTEGER, types[1]);
        assertEquals(TomlTypes.BOOLEAN, types[2]);
        assertEquals(TomlTypes.FLOAT, types[3]);
        assertEquals(TomlTypes.DATE, types[4]);
        assertEquals(TomlTypes.ARRAY, types[5]);
        assertEquals(TomlTypes.TABLE, types[6]);
    }

    @Test
    void testTomlTypesToString() {
        assertEquals("STRING", TomlTypes.STRING.toString());
        assertEquals("INTEGER", TomlTypes.INTEGER.toString());
        assertEquals("BOOLEAN", TomlTypes.BOOLEAN.toString());
        assertEquals("FLOAT", TomlTypes.FLOAT.toString());
        assertEquals("DATE", TomlTypes.DATE.toString());
        assertEquals("ARRAY", TomlTypes.ARRAY.toString());
        assertEquals("TABLE", TomlTypes.TABLE.toString());
    }

    @Test
    void testTomlTypesValueOf() {
        assertEquals(TomlTypes.STRING, TomlTypes.valueOf("STRING"));
        assertEquals(TomlTypes.INTEGER, TomlTypes.valueOf("INTEGER"));
        assertEquals(TomlTypes.BOOLEAN, TomlTypes.valueOf("BOOLEAN"));
        assertEquals(TomlTypes.FLOAT, TomlTypes.valueOf("FLOAT"));
        assertEquals(TomlTypes.DATE, TomlTypes.valueOf("DATE"));
        assertEquals(TomlTypes.ARRAY, TomlTypes.valueOf("ARRAY"));
        assertEquals(TomlTypes.TABLE, TomlTypes.valueOf("TABLE"));
    }

}