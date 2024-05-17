package com.jotrorox.jtoml.types;

/**
 * Represents all future TOML Types
 * 
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
     * 
     * <b>This has not been implemented yet</b>
     */
    FLOAT,

    /**
     * Represents a TOML Date
     * @since 0.2
     * 
     * <b>This has not been implemented yet</b>
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
    TABLE,

    /**
     * Represents a TOML Table Array
     * @since 0.2
     * 
     * <b>This has not been implemented yet</b>
     */
    TABLE_ARRAY;

    public static TomlTypes fromString(String type) {
        switch (type) {
            case "string":
                return STRING;
            case "integer":
                return INTEGER;
            case "boolean":
                return BOOLEAN;
            case "float":
                return FLOAT;
            case "date":
                return DATE;
            case "array":
                return ARRAY;
            case "table":
                return TABLE;
            case "table_array":
                return TABLE_ARRAY;
            default:
                throw new IllegalArgumentException("Unknown TOML type: " + type);
        }
    }

    public static String toString(TomlTypes type) {
        switch (type) {
            case STRING:
                return "string";
            case INTEGER:
                return "integer";
            case BOOLEAN:
                return "boolean";
            case FLOAT:
                return "float";
            case DATE:
                return "date";
            case ARRAY:
                return "array";
            case TABLE:
                return "table";
            case TABLE_ARRAY:
                return "table_array";
            default:
                throw new IllegalArgumentException("Unknown TOML type: " + type);
        }
    }

    public static TomlType create(TomlTypes type, String key, Object value) {
        switch (type) {
            case STRING:
                return new TomlString(key, (String) value);
            case INTEGER:
                return new TomlInteger(key, (int) value);
            case BOOLEAN:
                return new TomlBoolean(key, (boolean) value);
            default:
                throw new IllegalArgumentException("Unknown TOML type: " + type);
        }
    }    
}
