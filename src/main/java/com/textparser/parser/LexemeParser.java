package com.textparser.parser;

import com.textparser.entity.Lexeme;
import com.textparser.entity.Word;
import com.textparser.entity.Punctuation;
import com.textparser.entity.Symbol;
import com.textparser.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser {
    private static final Logger LOGGER = LogManager.getLogger(LexemeParser.class);
    private static final String WORD_PATTERN = "[a-zA-Zа-яА-Я0-9]+";
    private static final String PUNCTUATION_PATTERN = "[.,!?;:()\"'\\-]+";

    public Lexeme parse(String text) throws TextException {
        if (text == null) {
            throw new TextException("Lexeme text is null");
        }

        if (text.isEmpty()) {
            Lexeme lexeme = new Lexeme();
            lexeme.addPart(new Symbol(' '));
            return lexeme;
        }

        Lexeme lexeme = new Lexeme();

        for (char c : text.toCharArray()) {
            String charStr = String.valueOf(c);

            if (charStr.matches(WORD_PATTERN)) {
                lexeme.addPart(new Word(charStr));
            } else if (charStr.matches(PUNCTUATION_PATTERN)) {
                lexeme.addPart(new Punctuation(charStr));
            } else {
                lexeme.addPart(new Symbol(c));
            }
        }

        return lexeme;
    }
}