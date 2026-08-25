package com.textparser.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LexemeTest {

    @Test
    void testAddPart() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Word("Hello"));
        assertEquals(1, lexeme.getParts().size());
    }

    @Test
    void testGetOriginalTextWithWord() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Word("Hello"));
        assertEquals("Hello", lexeme.getOriginalText());
    }

    @Test
    void testGetOriginalTextWithPunctuation() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Punctuation(","));
        assertEquals(",", lexeme.getOriginalText());
    }

    @Test
    void testGetOriginalTextWithSymbol() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Symbol(' '));
        assertEquals(" ", lexeme.getOriginalText());
    }

    @Test
    void testGetOriginalTextWithMultipleParts() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Word("Hello"));
        lexeme.addPart(new Punctuation(","));
        lexeme.addPart(new Symbol(' '));
        lexeme.addPart(new Word("World"));
        assertEquals("Hello, World", lexeme.getOriginalText());
    }

    @Test
    void testCountLetter() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Word("Hello"));
        lexeme.addPart(new Word("World"));
        assertEquals(3, lexeme.countLetter('l'));
        assertEquals(1, lexeme.countLetter('e'));
    }

    @Test
    void testCountLetterWithPunctuation() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Word("Hello"));
        lexeme.addPart(new Punctuation(","));
        lexeme.addPart(new Word("World"));
        assertEquals(3, lexeme.countLetter('l'));
    }

    @Test
    void testCountLetterCaseInsensitive() {
        Lexeme lexeme = new Lexeme();
        lexeme.addPart(new Word("Hello"));
        lexeme.addPart(new Word("WORLD"));
        assertEquals(3, lexeme.countLetter('l'));
        assertEquals(1, lexeme.countLetter('e'));
    }
}