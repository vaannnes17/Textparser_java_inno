package com.textparser.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    @Test
    void testAddParagraph() {
        Text text = new Text();
        Paragraph paragraph = new Paragraph();
        text.addParagraph(paragraph);
        assertEquals(1, text.getParagraphs().size());
    }

    @Test
    void testGetOriginalText() {
        Text text = new Text();

        Paragraph p1 = new Paragraph();
        Sentence s1 = new Sentence();
        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        s1.addLexeme(l1);
        p1.addSentence(s1);
        text.addParagraph(p1);

        Paragraph p2 = new Paragraph();
        Sentence s2 = new Sentence();
        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        s2.addLexeme(l2);
        p2.addSentence(s2);
        text.addParagraph(p2);

        String expected = "Hello\n\nWorld";
        String actual = text.getOriginalText();

        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual:   '" + actual + "'");

        assertEquals(expected, actual);
    }

    @Test
    void testCountLetter() {
        Text text = new Text();

        Paragraph p1 = new Paragraph();
        Sentence s1 = new Sentence();
        Lexeme l1 = new Lexeme();
        l1.addPart(new Word("Hello"));
        s1.addLexeme(l1);
        p1.addSentence(s1);
        text.addParagraph(p1);

        Paragraph p2 = new Paragraph();
        Sentence s2 = new Sentence();
        Lexeme l2 = new Lexeme();
        l2.addPart(new Word("World"));
        s2.addLexeme(l2);
        p2.addSentence(s2);
        text.addParagraph(p2);

        assertEquals(3, text.countLetter('l'));
        assertEquals(1, text.countLetter('e'));
    }
}