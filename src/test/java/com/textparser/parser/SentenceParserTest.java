package com.textparser.parser;

import com.textparser.entity.Sentence;
import com.textparser.exception.TextException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SentenceParserTest {

    private final SentenceParser parser = new SentenceParser();

    @Test
    void testParseSimpleSentence() throws TextException {
        String input = "Hello World";
        Sentence sentence = parser.parse(input);
        assertEquals(2, sentence.getLexemes().size());
        assertEquals("Hello World", sentence.getOriginalText());
    }

    @Test
    void testParseSentenceWithPunctuation() throws TextException {
        String input = "Hello, World!";
        Sentence sentence = parser.parse(input);
        assertEquals(5, sentence.getLexemes().size());
        assertEquals("Hello, World!", sentence.getOriginalText());
    }

    @Test
    void testParseSentenceWithMultipleSpaces() throws TextException {
        String input = "Hello  World";
        Sentence sentence = parser.parse(input);
        assertEquals(3, sentence.getLexemes().size());
        assertEquals("Hello World", sentence.getOriginalText());
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
        String input = "Hello, World! How are you?";
        Sentence sentence = parser.parse(input);
        assertEquals("Hello, World! How are you?", sentence.getOriginalText());
    }
}