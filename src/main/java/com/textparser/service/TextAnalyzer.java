package com.textparser.service;

import com.textparser.entity.Text;

public class TextAnalyzer {
    public void countLetterAndSymbols(Text text){
        int letters = 0;
        int symbols = 0;

        String originalText = text.getOriginalText();

        for (char c : originalText.toCharArray()) {
            if (Character.isLetter(c)) {
                letters++;
            } else {
                symbols++;
            }
        }
        System.out.println("Total letters: " + letters);
        System.out.println("Total symbols: " + symbols);
        System.out.println("Total words: " + (letters + symbols));
    }
}
