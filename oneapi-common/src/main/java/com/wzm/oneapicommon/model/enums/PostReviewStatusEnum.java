package com.wzm.oneapicommon.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * enumeration of post audit status
 *
 * @author wzm
 */
public enum PostReviewStatusEnum {

    REVIEWING("Pending", 0),
    PASS("Passed", 1),
    REJECT("Refused", 2);

    private final String text;

    private final int value;


    PostReviewStatusEnum(String text, int value) {
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
