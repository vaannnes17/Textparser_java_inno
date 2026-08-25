package com.textparser.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences;

    public Paragraph() {
        this.sentences = new ArrayList<>();
    }

    public void  addSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return this.sentences;
    }

    public String getOriginalText() {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < this.sentences.size(); i++){
            sb.append(sentences.get(i).getOriginalText());
            if(i < this.sentences.size()-1){
                sb.append(" ");

            }
        }
        return sb.toString().trim();
    }

    public int countLetter(char letter) {
        int count = 0;
        for(Sentence sentence : this.sentences){
            count += sentence.countLetter(letter);
        }
        return count;
    }
}
