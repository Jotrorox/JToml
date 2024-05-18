package com.jotrorox.jtoml.types;

import java.util.Date;

/**
 * Represents a TOML Date
 * <p>
 * This class represents a TOML date.
 * It is used to store TOML dates and convert them to TOML strings.
 * 
 * @since 0.2
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

    @SuppressWarnings("deprecation")
    @Override
    public String toTomlString() {
        // Format the date into the following format: 1979-05-27T07:32:00Z
        return key + " = " +  (value.getYear() + 1900) +
                "-" +
                (value.getMonth() + 1) +
                "-" +
                value.getDate() +
                "T" +
                value.getHours() +
                ":" +
                value.getMinutes() +
                ":" +
                value.getSeconds() +
                "Z";
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

    /* Custom Functions */

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
    @SuppressWarnings("deprecation")
    public static TomlDate fromString(String toml) {
        // Get the JavaDate from the following format: key = 1979-05-27T07:32:00Z
        if (!toml.contains("=")) {
            throw new IllegalArgumentException("Invalid TOML string: " + toml);
        }

        String[] split = toml.split("=");
        String key = split[0].trim();
        Date date = new Date();
        String[] dateSplit = split[1].trim().split("T"); // 1979-05-27T07:32:00Z
        String[] dateSplit2 = dateSplit[0].split("-"); // 1979-05-27
        String[] timeSplit = dateSplit[1].split(":"); // 07:32:00Z
        date.setYear(Integer.parseInt(dateSplit2[0]) - 1900);
        date.setMonth(Integer.parseInt(dateSplit2[1]) - 1);
        date.setDate(Integer.parseInt(dateSplit2[2]));
        date.setHours(Integer.parseInt(timeSplit[0]));
        date.setMinutes(Integer.parseInt(timeSplit[1]));
        String secondsString = timeSplit[2];
        if (secondsString.endsWith("Z")) {
            secondsString = secondsString.substring(0, secondsString.length() - 1);
        }
        date.setSeconds(Integer.parseInt(secondsString));
        return new TomlDate(key, date);
    }
}
