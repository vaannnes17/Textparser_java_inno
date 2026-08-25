package com.textparser.parser;

import com.textparser.entity.Lexeme;
import com.textparser.entity.Sentence;
import com.textparser.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser {
    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String LEXEME_SPLIT = "(?<=\\s+)";

    private LexemeParser lexemeParser;

    public SentenceParser() {
        this.lexemeParser = new LexemeParser();
    }

    public Sentence parse(String text) throws TextException {
        if(text == null || text.trim().isEmpty()){
            throw new TextException("sentence text is null or empty");
        }
        LOGGER.debug("parse sentence text");
        Sentence sentence = new Sentence();
        String[] parts = text.split(LEXEME_SPLIT);

        for (String part : parts) {
            if(!part.trim().isEmpty()){
                Lexeme lexeme = lexemeParser.parse(part);
                sentence.addLexeme(lexeme);
            }
        }
        return sentence;
    }
}
