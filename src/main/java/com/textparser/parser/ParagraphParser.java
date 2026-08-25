package com.textparser.parser;

import com.textparser.entity.Paragraph;
import com.textparser.entity.Sentence;
import com.textparser.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser {
    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private static final String SENTENCE_SPLIT = "(?<=[.!?])\\s+";

    private SentenceParser sentenceParser;

    public ParagraphParser() {
        this.sentenceParser = new SentenceParser();
    }

    public Paragraph parse(String text) throws TextException {
        if (text == null || text.trim().isEmpty()) {
            throw new TextException("Paragraph text can't be null or empty");
        }

        LOGGER.debug("Paragraph parsing started");

        Paragraph paragraph = new Paragraph();
        String[] sentences = text.split(SENTENCE_SPLIT);
        for (String sentenceText : sentences) {
            if(!sentenceText.trim().isEmpty()){
                Sentence sentence = sentenceParser.parse(sentenceText.trim());
                paragraph.addSentence(sentence);
            }
        }
        LOGGER.debug("Paragraph parsing finished");
        return paragraph;
    }

}
