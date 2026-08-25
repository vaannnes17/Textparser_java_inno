package com.textparser.parser;

import com.textparser.entity.Paragraph;
import com.textparser.exception.TextException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParagraphParserTest {

    private final ParagraphParser parser = new ParagraphParser();

    @Test
    void testParseSimpleParagraph() throws TextException {
        String input = "Hello. World!";
        Paragraph paragraph = parser.parse(input);
        assertEquals(2, paragraph.getSentences().size());
    }

    @Test
    void testParseParagraphWithQuestion() throws TextException {
        String input = "How are you? I am fine.";
        Paragraph paragraph = parser.parse(input);
        assertEquals(2, paragraph.getSentences().size());
    }

    @Test
    void testParseParagraphWithExclamation() throws TextException {
        String input = "Hello! World!";
        Paragraph paragraph = parser.parse(input);
        assertEquals(2, paragraph.getSentences().size());
    }

    @Test
    void testParseParagraphWithMixedPunctuation() throws TextException {
        String input = "Hello. How are you? I am fine!";
        Paragraph paragraph = parser.parse(input);
        assertEquals(3, paragraph.getSentences().size());
    }

    @Test
    void testParseNullThrowsException() {
        assertThrows(TextException.class, () -> parser.parse(null));
    }

    @Test
    void testParseEmptyThrowsException() {
        assertThrows(TextException.class, () -> parser.parse(""));
    }

    @Test
    void testPreservePunctuation() throws TextException {
        String input = "Hello, World!";
        Paragraph paragraph = parser.parse(input);
        assertEquals(1, paragraph.getSentences().size());
        assertEquals("Hello, World!", paragraph.getOriginalText());
    }
}