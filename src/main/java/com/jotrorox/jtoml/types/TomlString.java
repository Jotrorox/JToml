package com.jotrorox.jtoml.types;

/**
 * Represents a TOML String
 * 
 * This class represents a TOML string.
 * It is used to store TOML strings and convert them to TOML strings.
 * 
 * @since 0.2
 */
public class TomlString extends TomlType {
    /**
     * The value of the TOML string
     */
    String value;

    /**
     * The key of the TOML string
     */
    String key;

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

    public boolean valueEquals(String value) {
        return this.value.equals(value);
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
