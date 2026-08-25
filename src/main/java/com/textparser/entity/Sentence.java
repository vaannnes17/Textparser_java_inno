package com.textparser.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Lexeme> lexemes;

    public Sentence(){
        this.lexemes = new ArrayList<>();
    }

    public void addLexeme(Lexeme lexeme){
        this.lexemes.add(lexeme);
    }

    public List<Lexeme> getLexemes(){
        return this.lexemes;
    }

    private boolean isPunctuation(String ch){
        return ch.matches("[.,!?;:()\"']+");
    }

    public String getOriginalText(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.lexemes.size(); i++){
            String lex = lexemes.get(i).getOriginalText();
            if(isPunctuation(lex) && i > 0){
                sb.append(lex);
            } else {
                if(i > 0){
                    String prevLex = lexemes.get(i - 1).getOriginalText();
                    boolean prevIsPunctuation = isPunctuation(prevLex);
                    if(!prevIsPunctuation){
                        sb.append(" ");
                    }
                }
                sb.append(lex);
            }
        }
        return sb.toString();
    }

    public int countLetter(char letter){
        int count = 0;
        for(Lexeme lexeme : this.lexemes){
            count += lexeme.countLetter(letter);
        }
        return count;
    }


}
