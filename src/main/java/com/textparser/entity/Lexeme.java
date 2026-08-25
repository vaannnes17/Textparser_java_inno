package com.textparser.entity;

import java.util.ArrayList;
import java.util.List;

public class Lexeme {
    private List<TextComponent> parts;

    public Lexeme() {
        this.parts = new ArrayList<>();
    }

    public void addPart(TextComponent part){
        this.parts.add(part);
    }

    public List<TextComponent> getParts(){
        return this.parts;
    }

    public String getOriginalText() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent part : parts) {
            sb.append(part.getOriginalText());
        }
        return sb.toString();
    }

    public int countLetter(char letter) {
        int count = 0;
        for (TextComponent part : parts) {
            count += part.countLetter(letter);
        }
        return count;
    }
}
