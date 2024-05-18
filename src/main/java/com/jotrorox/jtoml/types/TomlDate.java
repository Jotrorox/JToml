package com.jotrorox.jtoml.types;

import java.util.Date;

/**
 * Represents a TOML Date
 * 
 * This class represents a TOML date.
 * It is used to store TOML dates and convert them to TOML strings.
 * 
 * @since 0.2
 * 
 * <b>This class has not been fully implemented yet</b>
 */
public class TomlDate extends TomlType {
    /**
     * The value of the TOML date
     */
    private final Date value;
    
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
    public TomlDate(String key, Date value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toTomlString() {
        return key + " = " + value.toString();
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
    public Date getValue() {
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

    /**
     * Creates a new TOML date from a TOML string
     * 
     * @param toml The TOML string to convert
     * @return The TOML date created from the TOML string
     */
    public static TomlDate fromToml(String toml) {
        return null;
    }
}
