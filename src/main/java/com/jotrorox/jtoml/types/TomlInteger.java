package com.jotrorox.jtoml.types;

/**
 * Represents a TOML Integer
 * <p>
 * This class represents a TOML integer.
 * It is used to store TOML integers and convert them to TOML strings.
 * 
 * @since 0.2
 */
public class TomlInteger extends TomlType {
    /**
     * The value of the TOML integer
     */
    private final int value;
    /**
     * The key of the TOML integer
     */
    private final String key;

    /**
     * Creates a new TOML integer
     * 
     * @param key The key of the TOML integer
     * @param value The value of the TOML integer
     */
    public TomlInteger(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toTomlString() {
        return key + " = " + value;
    }

    @Override
    public boolean equals(TomlType obj) {
        TomlInteger other = (TomlInteger) obj;
        return other.key.equals(key) && other.value == value;
    }

    @Override
    public boolean keyEquals(String key) {
        return this.key.equals(key);
    }

    @Override
    public boolean valueEquals(Object value) {
        return this.value == (int) value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() + value;
    }

    /* Custom Functions */

    /**
     * Checks if the TOML integer is equal to another integer
     * 
     * @param value The integer to compare to
     * @return If the TOML integer is equal to the integer
     */
    public boolean equals(int value) {
        return this.value == value;
    }

    /**
     * Gets the value of the TOML integer
     * @return The value of the TOML integer
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the key of the TOML integer
     * @return The key of the TOML integer
     */
    public String getKey() {
        return key;
    }

    /**
     * Creates a TOML integer from a TOML string
     * 
     * @param toml The TOML string to convert
     * @return The TOML integer
     */
    public static TomlInteger fromString(String toml) {
        String[] parts = toml.split(" = ");
        String key = parts[0];
        int value = Integer.parseInt(parts[1]);
        return new TomlInteger(key, value);
    }
}
