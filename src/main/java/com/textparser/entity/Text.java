package com.textparser.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs;

    public Text() {
        this.paragraphs = new ArrayList<>();
    }

    public void addParagraph(Paragraph paragraph){
        this.paragraphs.add(paragraph);
    }

    public List<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    public String getOriginalText(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.paragraphs.size(); i++) {
            sb.append(paragraphs.get(i).getOriginalText());
            if(i < this.paragraphs.size()-1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int countLetter(char letter){
        int count = 0;
        for (Paragraph paragraph : this.paragraphs) {
            count += paragraph.countLetter(letter);
        }
        return count;
    }
}
