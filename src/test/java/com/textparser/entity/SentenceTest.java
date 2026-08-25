package com.textparser.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SentenceTest {

    @Test
    void testAddLexeme() {
        Sentence sentence = new Sentence();
        Lexeme lexeme = new Lexeme();
        sentence.addLexeme(lexeme);
        assertEquals(1, sentence.getLexemes().size());
    }

    @Test
    void testGetOriginalTextWithWords() {
        Sentence sentence = new Sentence();

        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        sentence.addLexeme(l1);

        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        sentence.addLexeme(l2);

        assertEquals("Hello World", sentence.getOriginalText());
    }

    @Test
    void testGetOriginalTextWithPunctuation() {
        Sentence sentence = new Sentence();

        Lexeme w1 = new Lexeme();
        w1.addPart(new Word("Hello"));
        sentence.addLexeme(w1);

        Lexeme p1 = new Lexeme();
        p1.addPart(new Punctuation(","));
        sentence.addLexeme(p1);

        Lexeme w2 = new Lexeme();
        w2.addPart(new Word("World"));
        sentence.addLexeme(w2);

        Lexeme p2 = new Lexeme();
        p2.addPart(new Punctuation("!"));
        sentence.addLexeme(p2);

        assertEquals("Hello, World!", sentence.getOriginalText());
    }

    @Test
    void testGetOriginalTextWithSymbols() {
        Sentence sentence = new Sentence();

        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        sentence.addLexeme(l1);

        Lexeme s1 = new Lexeme();
        s1.addPart(new Symbol(' '));
        sentence.addLexeme(s1);

        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        sentence.addLexeme(l2);

        assertEquals("Hello World", sentence.getOriginalText());
    }

    @Test
    void testCountLetter() {
        Sentence sentence = new Sentence();

        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        sentence.addLexeme(l1);

        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        sentence.addLexeme(l2);

        assertEquals(3, sentence.countLetter('l'));
        assertEquals(1, sentence.countLetter('e'));
        assertEquals(0, sentence.countLetter('z'));
    }

    @Test
    void testCountLetterCaseInsensitive() {
        Sentence sentence = new Sentence();

        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        sentence.addLexeme(l1);

        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("WORLD"));
        sentence.addLexeme(l2);

        assertEquals(3, sentence.countLetter('l'));
        assertEquals(1, sentence.countLetter('e'));
    }
}