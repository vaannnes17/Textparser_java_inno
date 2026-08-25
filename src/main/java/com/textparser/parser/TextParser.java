package com.textparser.parser;

import com.textparser.entity.Paragraph;
import com.textparser.entity.Text;
import com.textparser.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser {
    private  static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String PARAGRAPH_SPLIT = "\n+";

    private ParagraphParser paragraphParser;

    public TextParser() {
        this.paragraphParser = new ParagraphParser();
    }

    public Text parse(String text) throws TextException {
        if (text == null || text.trim().isEmpty()) {
            throw new TextException("Text is null or empty");
        }
        LOGGER.info("Parsing text, length: {}", text.length());
        Text parsedText = new Text();
        String[] paragraphs = text.split(PARAGRAPH_SPLIT);

        for (String paragraphText : paragraphs) {
            if (paragraphText == null || paragraphText.trim().isEmpty()) {
                throw new TextException("Paragraph is null or empty");
            } else {
                Paragraph paragraph = paragraphParser.parse(paragraphText.trim());
                parsedText.addParagraph(paragraph);
            }
        }
        LOGGER.info("Parsed text: {}", parsedText.getParagraphs().size());
        return parsedText;
    }
}
