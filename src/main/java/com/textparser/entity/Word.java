package com.textparser.entity;

public class Word implements TextComponent {
    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String getOriginalText() {
        return this.value;
    }

    @Override
    public int countLetter(char letter) {
        int count = 0;
        for (char c : value.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(letter)) {
                count++;
            }
        }
        return count;
    }
}