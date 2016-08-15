package com.thoughtworks.tfoster.twu.util;

public class FormattingUtility {
    public static String fixFieldWidth(String field, int width) {
        String maxedString = field.substring(0, Math.min(field.length(), width));

        return String.format("%1$" + width + "s", maxedString);
    }
}
