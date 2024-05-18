package com.jotrorox.jtoml.types;

import java.util.Date;

/**
 * Represents all future TOML Types
 * <p>
 * This class is the base class for all TOML types.
 * It is just utility and for some standardization.
 * 
 * @since 0.2
 */
public enum TomlTypes {
    /**
     * Represents a TOML String
     * @since 0.2
     */
    STRING,

    /**
     * Represents a TOML Integer
     * @since 0.2
     */
    INTEGER,

    /**
     * Represents a TOML Boolean
     * @since 0.2
     */
    BOOLEAN,

    /**
     * Represents a TOML Float
     * @since 0.2
     */
    FLOAT,

    /**
     * Represents a TOML Date
     * @since 0.2
     */
    DATE,

    /**
     * Represents a TOML Array
     * @since 0.2
     * 
     * <b>This has not been implemented yet</b>
     */
    ARRAY,

    /**
     * Represents a TOML Table
     * @since 0.2
     * 
     * <b>This has not been implemented yet</b>
     */
    TABLE;

    public static TomlTypes fromString(String type) {
        return switch (type) {
            case "string" -> STRING;
            case "integer" -> INTEGER;
            case "boolean" -> BOOLEAN;
            case "float" -> FLOAT;
            case "date" -> DATE;
            case "array" -> ARRAY;
            case "table" -> TABLE;
            default -> throw new IllegalArgumentException("Unknown TOML type: " + type);
        };
    }

    public static String toString(TomlTypes type) {
        return switch (type) {
            case STRING -> "string";
            case INTEGER -> "integer";
            case BOOLEAN -> "boolean";
            case FLOAT -> "float";
            case DATE -> "date";
            case ARRAY -> "array";
            case TABLE -> "table";
        };
    }

    public static TomlType create(TomlTypes type, String key, Object value) {
        return switch (type) {
            case STRING -> new TomlString(key, (String) value);
            case INTEGER -> new TomlInteger(key, (int) value);
            case BOOLEAN -> new TomlBoolean(key, (boolean) value);
            case FLOAT -> new TomlFloat(key, (double) value);
            case DATE -> new TomlDate(key, (Date) value);
            default -> throw new IllegalArgumentException("Unknown TOML type: " + type);
        };
    }    
}
