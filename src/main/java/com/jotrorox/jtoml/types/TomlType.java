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
    public abstract boolean equals(TomlType obj);

    public abstract boolean keyEquals(String key);
    public abstract boolean valueEquals(Object value);

    /**
     * Gets the hash code of the TOML type
     * 
     * @return The hash code
     */
    public abstract int hashCode();
}
