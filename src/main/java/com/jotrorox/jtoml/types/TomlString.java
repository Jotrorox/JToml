package com.jotrorox.jtoml.types;

public class TomlString extends TomlType {

    public TomlString(String key, Object value) {
        super(key, value);
    }

    @Override
    public String toTomlString() {
        throw new UnsupportedOperationException("Unimplemented method 'toTomlString'");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Unimplemented method 'hashCode'");
    }
    
}
