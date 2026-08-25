package com.textparser.parser;

import com.textparser.entity.Lexeme;
import com.textparser.entity.Word;
import com.textparser.entity.Punctuation;
import com.textparser.entity.Symbol;
import com.textparser.exception.TextException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LexemeParserTest {

    private final LexemeParser parser = new LexemeParser();

    @Test
    void testParseWord() throws TextException {
        String input = "Hello";
        Lexeme lexeme = parser.parse(input);
        assertEquals(5, lexeme.getParts().size());
        assertTrue(lexeme.getParts().get(0) instanceof Word);
        assertEquals("Hello", lexeme.getOriginalText());
    }

    @Test
    void testParsePunctuation() throws TextException {
        String input = ",";
        Lexeme lexeme = parser.parse(input);
        assertEquals(1, lexeme.getParts().size());
        assertTrue(lexeme.getParts().get(0) instanceof Punctuation);
        assertEquals(",", lexeme.getOriginalText());
    }

    @Test
    void testParseSpace() throws TextException {
        String input = " ";
        Lexeme lexeme = parser.parse(input);
        assertEquals(1, lexeme.getParts().size());
        assertTrue(lexeme.getParts().get(0) instanceof Symbol);
        assertEquals(" ", lexeme.getOriginalText());
    }

    @Test
    void testParseWordWithPunctuation() throws TextException {
        String input = "Hello,";
        Lexeme lexeme = parser.parse(input);
        assertEquals(6, lexeme.getParts().size());
        assertTrue(lexeme.getParts().get(0) instanceof Word);
        assertTrue(lexeme.getParts().get(5) instanceof Punctuation);
        assertEquals("Hello,", lexeme.getOriginalText());
    }

    @Test
    void testParseMixedContent() throws TextException {
        String input = "Hello, World!";
        Lexeme lexeme = parser.parse(input);
        assertEquals(13, lexeme.getParts().size());
        assertEquals("Hello, World!", lexeme.getOriginalText());
    }

    @Test
    void testParseNullThrowsException() {
        assertThrows(TextException.class, () -> parser.parse(null));
    }

    @Test
    void testParseEmptyReturnsSpace() throws TextException {
        Lexeme lexeme = parser.parse("");
        assertEquals(1, lexeme.getParts().size());
        assertTrue(lexeme.getParts().get(0) instanceof Symbol);
        assertEquals(" ", lexeme.getOriginalText());
    }

    @Test
    void testParseNumbers() throws TextException {
        String input = "123";
        Lexeme lexeme = parser.parse(input);
        assertEquals(3, lexeme.getParts().size());
        assertTrue(lexeme.getParts().get(0) instanceof Word);
        assertEquals("123", lexeme.getOriginalText());
    }

    @Test
    void testParseMixedLettersAndNumbers() throws TextException {
        String input = "Hello123";
        Lexeme lexeme = parser.parse(input);
        assertEquals(8, lexeme.getParts().size());
        assertEquals("Hello123", lexeme.getOriginalText());
    }
}