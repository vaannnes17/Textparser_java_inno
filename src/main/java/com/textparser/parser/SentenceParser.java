package com.textparser.parser;

import com.textparser.entity.Lexeme;
import com.textparser.entity.Sentence;
import com.textparser.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser {
    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);

    private LexemeParser lexemeParser;

    public SentenceParser() {
        this.lexemeParser = new LexemeParser();
    }

    public Sentence parse(String text) throws TextException {
        if (text == null || text.trim().isEmpty()) {
            throw new TextException("Sentence text is null or empty");
        }

        LOGGER.debug("Parsing sentence: {}", text);

        Sentence sentence = new Sentence();

        StringBuilder currentLexeme = new StringBuilder();
        boolean inSpace = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isWhitespace(c)) {
                if (!inSpace && currentLexeme.length() > 0) {
                    sentence.addLexeme(lexemeParser.parse(currentLexeme.toString()));
                    currentLexeme.setLength(0);
                }
                inSpace = true;
                currentLexeme.append(c);
            } else {
                if (inSpace && currentLexeme.length() > 0) {
                    sentence.addLexeme(lexemeParser.parse(currentLexeme.toString()));
                    currentLexeme.setLength(0);
                }
                inSpace = false;
                currentLexeme.append(c);
            }
        }

        if (currentLexeme.length() > 0) {
            sentence.addLexeme(lexemeParser.parse(currentLexeme.toString()));
        }

        return sentence;
    }
}