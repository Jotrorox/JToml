package com.jotrorox.jtoml.types;

/**
 * Represents a TOML String
 * <p>
 * This class represents a TOML string.
 * It is used to store TOML strings and convert them to TOML strings.
 * 
 * @since 0.2
 */
public class TomlString extends TomlType {
    /**
     * The value of the TOML string
     */
    private final String value;

    /**
     * The key of the TOML string
     */
    private final String key;

    /**
     * Creates a new TOML string
     * 
     * @param key The key of the TOML string
     * @param value The value of the TOML string
     */
    public TomlString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toTomlString() {
        return key + " = \"" + value + "\"";
    }

    @Override
    public boolean equals(TomlType obj) {
        TomlString other = (TomlString) obj;
        return other.key.equals(key) && other.value.equals(value);
    }

    @Override
    public int hashCode() {
        return key.hashCode() + value.hashCode();
    }

    @Override
    public boolean keyEquals(String key) {
        return this.key.equals(key);
    }

    @Override
    public boolean valueEquals(Object value) {
        return this.value.equals(value);
    }

    /* Custom Functions */

    /**
     * Checks if the TOML string is equal to another given string
     * 
     * @param value The string to compare to
     * @return If the TOML string is equal to the string
     */
    public boolean valueEquals(String value) {
        return this.value.equals(value);
    }

    /**
     * Gets the value of the TOML string
     * 
     * @return The value of the TOML string
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the key of the TOML string
     * 
     * @return The key of the TOML string
     */
    public String getKey() {
        return key;
    }

    /**
     * Creates a TOML string from a string
     * @param toml The raw TOML string
     * @return The TOML string
     */
    public static TomlString fromString(String toml) {
        toml.trim();
        String[] parts = toml.split("=");
        String key = parts[0].trim();
        String value = parts[1].trim();
        value = value.substring(1, value.length() - 1);
        return new TomlString(key, value);
    }
}
