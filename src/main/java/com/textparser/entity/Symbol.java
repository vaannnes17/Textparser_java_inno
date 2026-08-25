package com.textparser.entity;

public class Symbol implements TextComponent {
    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

    @Override
    public String getOriginalText() {
        return String.valueOf(this.value);
    }

    @Override
    public int countLetter(char letter) {
        return 0;
    }
}