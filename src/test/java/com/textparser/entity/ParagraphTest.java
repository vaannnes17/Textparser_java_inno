package com.textparser.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParagraphTest {

    @Test
    void testAddSentence() {
        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        paragraph.addSentence(sentence);
        assertEquals(1, paragraph.getSentences().size());
    }

    @Test
    void testGetOriginalText() {
        Paragraph paragraph = new Paragraph();

        Sentence s1 = new Sentence();
        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        s1.addLexeme(l1);
        paragraph.addSentence(s1);

        Sentence s2 = new Sentence();
        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        s2.addLexeme(l2);
        paragraph.addSentence(s2);

        assertEquals("Hello World", paragraph.getOriginalText());
    }

    @Test
    void testGetOriginalTextWithPunctuation() {
        Paragraph paragraph = new Paragraph();

        Sentence s1 = new Sentence();
        Lexeme w1 = new Lexeme();
        w1.addPart(new Word("Hello"));
        Lexeme p1 = new Lexeme();
        p1.addPart(new Punctuation(","));
        s1.addLexeme(w1);
        s1.addLexeme(p1);
        paragraph.addSentence(s1);

        Sentence s2 = new Sentence();
        Lexeme w2 = new Lexeme();
        w2.addPart(new Word("World"));
        Lexeme p2 = new Lexeme();
        p2.addPart(new Punctuation("!"));
        s2.addLexeme(w2);
        s2.addLexeme(p2);
        paragraph.addSentence(s2);

        assertEquals("Hello, World!", paragraph.getOriginalText());
    }

    @Test
    void testCountLetter() {
        Paragraph paragraph = new Paragraph();

        Sentence s1 = new Sentence();
        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        s1.addLexeme(l1);
        paragraph.addSentence(s1);

        Sentence s2 = new Sentence();
        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        s2.addLexeme(l2);
        paragraph.addSentence(s2);

        assertEquals(3, paragraph.countLetter('l'));
        assertEquals(1, paragraph.countLetter('e'));
    }
}