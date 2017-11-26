package com.github.dugasz1.seriesbase.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    FEMALE, MALE, OTHER;

    @JsonCreator
    public static Gender forValue(String value) {
        return Gender.valueOf(value);
    }

    @JsonValue
    public String toValue() {
        return this.toString();
    }
}
