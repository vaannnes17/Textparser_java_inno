package com.textparser.entity;

public class Punctuation implements TextComponent {
    private String value;

    public Punctuation(String value) {
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
        return 0;
    }
}