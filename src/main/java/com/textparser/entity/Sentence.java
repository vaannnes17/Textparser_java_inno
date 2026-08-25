package com.textparser.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Lexeme> lexemes;

    public Sentence() {
        this.lexemes = new ArrayList<>();
    }

    public void addLexeme(Lexeme lexeme) {
        this.lexemes.add(lexeme);
    }

    public List<Lexeme> getLexemes() {
        return this.lexemes;
    }

    private boolean isPunctuation(String text) {
        return text.matches("[.,!?;:()\"'\\-]+");
    }

    public String getOriginalText() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        boolean lastWasPunctuation = false;

        for (Lexeme lexeme : lexemes) {
            String text = lexeme.getOriginalText();

            if (text == null || text.isEmpty()) {
                continue;
            }

            boolean isPunct = isPunctuation(text);
            boolean isSpace = text.matches("\\s+");

            if (isPunct) {
                sb.append(text);
                lastWasPunctuation = true;
            } else if (isSpace) {
                if (!first && !sb.toString().endsWith(" ")) {
                    sb.append(" ");
                }
                lastWasPunctuation = false;
            } else {
                if (!first) {
                    if (lastWasPunctuation) {
                        sb.append(" ");
                    } else if (!sb.toString().endsWith(" ")) {
                        sb.append(" ");
                    }
                }
                sb.append(text);
                first = false;
                lastWasPunctuation = false;
            }
        }

        return sb.toString().trim();
    }

    public int countLetter(char letter) {
        int count = 0;
        for (Lexeme lexeme : this.lexemes) {
            count += lexeme.countLetter(letter);
        }
        return count;
    }
}