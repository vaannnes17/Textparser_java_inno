package com.textparser.parser;

import com.textparser.entity.Text;
import com.textparser.exception.TextException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextParserTest {

    private final TextParser parser = new TextParser();

    @Test
    void testParseSimpleText() throws TextException {
        String input = "Hello. World!";
        Text text = parser.parse(input);
        assertEquals(1, text.getParagraphs().size());
        assertEquals("Hello. World!", text.getOriginalText());
    }

    @Test
    void testParseMultiParagraphText() throws TextException {
        String input = "Hello. World!\n\nHow are you?";
        Text text = parser.parse(input);
        assertEquals(2, text.getParagraphs().size());
    }

    @Test
    void testParseWithEmptyLines() throws TextException {
        String input = "Hello.\n\n\nWorld!\n\n\n\nBye!";
        Text text = parser.parse(input);
        assertEquals(3, text.getParagraphs().size());
    }

    @Test
    void testParseNullThrowsException() {
        assertThrows(TextException.class, () -> parser.parse(null));
    }

    @Test
    void testParseEmptyThrowsException() {
        assertThrows(TextException.class, () -> parser.parse(""));
        assertThrows(TextException.class, () -> parser.parse("   "));
    }

    @Test
    void testPreservePunctuation() throws TextException {
        String input = "Hello, World!";
        Text text = parser.parse(input);
        assertEquals("Hello, World!", text.getOriginalText());
    }
}