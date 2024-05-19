package com.jotrorox.jtoml.types;

/**
 * Represents a TOML Array
 * <p>
 * This class represents a TOML Array.
 * It is a list of values of the same type.
 *
 * @since 0.2
 */
public class TomlArray extends TomlType {

    /**
     * The key of the array
     */
    String key;

    /**
     * The values of the array
     */
    TomlType[] values;

    /**
     * The type of the values
     */
    TomlTypes valueType;

    /**
     * Creates a new TOML Array
     *
     * @param key The key of the array
     * @param values The values of the array
     * @param valueType The type of the values
     */
    public TomlArray(String key, TomlType[] values, TomlTypes valueType) {
        this.key = key;
        this.values = values;
        this.valueType = valueType;
    }

    @Override
    public String toTomlString() {
        return "";
    }

    @Override
    public boolean equals(TomlType obj) {
        return false;
    }

    @Override
    public boolean keyEquals(String key) {
        return false;
    }

    @Override
    public boolean valueEquals(Object value) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
