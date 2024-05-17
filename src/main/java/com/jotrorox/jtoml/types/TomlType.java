package com.jotrorox.jtoml.types;

/**
 * Represents all future TOML Types
 * 
 * This class is the base class for all TOML types.
 * It is just utility and for some standardization.
 * 
 * @since 0.2
 */
public abstract class TomlType {
    /**
     * The key of the TOML type
     */
    String key;

    /**
     * The value of the TOML type
     * 
     * This is an Object because it can be any type and will be adjusted accordingly
     */
    Object value;
    
    /**
     * Creates a new TOML type
     * 
     * @param key The key of the TOML type
     * @param value The value of the TOML type
     */
    public TomlType(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Converts the TOML type to a TOML string
     * 
     * @return The TOML string
     */
    public abstract String toTomlString();

    /**
     * Checks if the TOML type is equal to another given object
     * 
     * @param obj The object to compare to
     * @return If the TOML type is equal to the object
     */
    public abstract boolean equals(Object obj);

    /**
     * Gets the hash code of the TOML type
     * 
     * @return The hash code
     */
    public abstract int hashCode();
    
    /**
     * Gets the key of the TOML type
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets the value of the TOML type
     * @return The value
     */
    public Object getValue() {
        return value;
    }
}
