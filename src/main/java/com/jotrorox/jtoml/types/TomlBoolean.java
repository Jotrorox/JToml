package com.jotrorox.jtoml.types;

/**
 * Represents a TOML Boolean
 * <p>
 * This class represents a TOML boolean.
 * It is used to store TOML booleans and convert them to TOML strings.
 * 
 * @since 0.2
 */
public class TomlBoolean extends TomlType {
    /**
     * The value of the TOML boolean
     */
    private final boolean value;
    
    /**
     * The key of the TOML boolean
     */
    private final String key;

    /**
     * Creates a new TOML boolean
     * 
     * @param key The key of the TOML boolean
     * @param value The value of the TOML boolean
     */
    public TomlBoolean(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toTomlString() {
        if (value) return key + " = true";
        else return key + " = false";
    }

    @Override
    public boolean equals(TomlType obj) {
        TomlBoolean other = (TomlBoolean) obj;
        return other.key.equals(key) && other.value == value;
    }

    @Override
    public boolean keyEquals(String key) {
        return this.key.equals(key);
    }

    @Override
    public boolean valueEquals(Object value) {
        return this.value == (boolean) value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() + (value ? 1 : 0);
    }

    /* Custom Functions */

    /**
     * Checks if the TOML boolean is equal to another given boolean
     * 
     * @param value The boolean to compare to
     * @return If the TOML boolean is equal to the given boolean
     */
    public boolean valueEquals(boolean value) {
        return this.value == value;
    }

    /**
     * Gets the value of the TOML boolean
     * 
     * @return The value of the TOML boolean
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Gets the key of the TOML boolean
     * 
     * @return The key of the TOML boolean
     */
    public String getKey() {
        return key;
    }

    public static TomlBoolean fromString(String toml) {
        String[] parts = toml.split("=");
        String key = parts[0].trim();
        String value = parts[1].trim();
        if (value.equals("true")) return new TomlBoolean(key, true);
        else if (value.equals("false")) return new TomlBoolean(key, false);
        else throw new IllegalArgumentException("Invalid TOML boolean: " + toml);        
    }
}
