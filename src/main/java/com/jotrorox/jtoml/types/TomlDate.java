package com.jotrorox.jtoml.types;

/**
 * Represents a TOML Date
 * 
 * This class represents a TOML date.
 * It is used to store TOML dates and convert them to TOML strings.
 * 
 * @since 0.2
 * @apiNote This class is not yet implemented
 */
public class TomlDate extends TomlType {
    /**
     * The value of the TOML date
     */
    private final String value;
    
    /**
     * The key of the TOML date
     */
    private final String key;

    /**
     * Creates a new TOML date
     * 
     * @param key The key of the TOML date
     * @param value The value of the TOML date
     */
    public TomlDate(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toTomlString() {
        return key + " = " + value;
    }

    @Override
    public boolean equals(TomlType obj) {
        TomlDate other = (TomlDate) obj;
        return other.key.equals(key) && other.value.equals(value);
    }

    @Override
    public boolean keyEquals(String key) {
        return this.key.equals(key);
    }

    @Override
    public boolean valueEquals(Object value) {
        return this.value.equals(value);
    }

    @Override
    public int hashCode() {
        return key.hashCode() + value.hashCode();
    }

    /** Custom Functions **/

    /**
     * Returns the value of the TOML date
     * 
     * @return The value of the TOML date
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the key of the TOML date
     * 
     * @return The key of the TOML date
     */
    public String getKey() {
        return key;
    }
}
