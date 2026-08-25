package com.textparser.service;

import com.textparser.entity.*;

import java.util.*;

public class TextOperations {
    public void findMaxSentencesWithSameWords(Text text) {
        Map<String,Integer> wordCount = new HashMap<>();
        Map<String, List<String>> sentenceWords = new HashMap<>();

        int sentenceIndex = 0;
        for(Paragraph paragraph : text.getParagraphs()) {
            for(Sentence sentence : paragraph.getSentences()) {
                Set<String> uniqueWords = new HashSet<>();
                for(Lexeme lexeme : sentence.getLexemes()) {
                    for(TextComponent part : lexeme.getParts()){
                        if(part instanceof Word){
                            String word = ((Word) part).getValue().toLowerCase();
                            uniqueWords.add(word);
                        }
                    }
                }
                for(String word : uniqueWords) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
                sentenceIndex++;
            }
        }
        int maxCount = 0;
        for(int count : wordCount.values()){
            if(count > maxCount){
                maxCount = count;
            }
        }
        System.out.println("Max word count: " + maxCount);
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if(entry.getValue() == maxCount){
                System.out.println("Found word: " + entry.getKey() + " in " + entry.getValue() + " count");
            }
        }
    }

    public void sortSentencesByLetter(Text text, char letter) {
        List<Sentence> allSentences = new ArrayList<>();

        for(Paragraph paragraph : text.getParagraphs()) {
            allSentences.addAll(paragraph.getSentences());
        }

        allSentences.sort((s1, s2) ->{
                int count1 = s1.countLetter(letter);
                int count2 = s2.countLetter(letter);
                return Integer.compare(count1, count2);
        });

        System.out.println("Sorted Sentences: " +  letter + ":");
        for(Sentence sentence : allSentences){
            System.out.println(" " + sentence.getOriginalText() + "(letter '"
                    + letter + "':" + sentence.countLetter(letter) + ")");
        }
    }

    public void swapFirstLastLexeme(Text text) {
        for (Paragraph paragraph : text.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                List<Lexeme> lexemes = sentence.getLexemes();
                if(lexemes.size() > 1){
                    Lexeme firstLexeme = lexemes.get(0);
                    Lexeme lastLexeme = lexemes.get(lexemes.size() - 1);
                    lexemes.set(0, lastLexeme);
                    lexemes.set(lexemes.size() - 1, firstLexeme);
                }
            }
        }
        System.out.println("Swapped First Last Lexeme: " +  text.getOriginalText());
    }
}
