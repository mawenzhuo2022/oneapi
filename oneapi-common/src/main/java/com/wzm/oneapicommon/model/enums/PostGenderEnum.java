package com.wzm.oneapicommon.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * post gender enumeration
 *
 * @author wzm
 */
public enum PostGenderEnum {

    MALE("Male", 0),
    FEMALE("Female", 1);

    private final String text;

    private final int value;

    PostGenderEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * get value list
     *
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
