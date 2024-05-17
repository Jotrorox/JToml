package com.jotrorox.jtoml.types;

/**
 * Represents a TOML Float
 * 
 * This class represents a TOML float.
 * It is used to store TOML floats and convert them to TOML strings.
 * 
 * @since 0.2
 */
public class TomlFloat extends TomlType {
    /**
     * The value of the TOML float
     */
    private final double value;

    /**
     * The key of the TOML float
     */
    private final String key;

    /**
     * Creates a new TOML float
     * 
     * @param key The key of the TOML float
     * @param value The value of the TOML float
     */
    public TomlFloat(String key, double value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toTomlString() {
        return key + " = " + value;
    }

    @Override
    public boolean equals(TomlType obj) {
        TomlFloat other = (TomlFloat) obj;
        return other.key.equals(key) && other.value == value;
    }

    @Override
    public boolean keyEquals(String key) {
        return this.key.equals(key);
    }

    @Override
    public boolean valueEquals(Object value) {
        return this.value == (double) value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() + (int) value;
    }
    
    /** Custom Functions **/

    /**
     * Checks if the TOML float is equal to another float
     * 
     * @param value The float to compare to
     * @return If the TOML float is equal to the float
     */
    public boolean equals(double value) {
        return this.value == value;
    }

    /**
     * Gets the value of the TOML float
     * 
     * @return The value of the TOML float
     */
    public double getValue() {
        return value;
    }

    /**
     * Gets the key of the TOML float
     * 
     * @return The key of the TOML float
     */
    public String getKey() {
        return key;
    }

    public static TomlFloat fromString(String toml) {
        String[] parts = toml.split("=");
        String key = parts[0].trim();
        double value = Double.parseDouble(parts[1].trim());
        return new TomlFloat(key, value);
    }
}
