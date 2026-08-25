package com.textparser;

import com.textparser.entity.Text;
import com.textparser.parser.TextParser;
import com.textparser.reader.FileReader;
import com.textparser.service.TextAnalyzer;
import com.textparser.service.TextOperations;
import com.textparser.service.TextRestorer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.textparser.exception.TextException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String FILE_PATH = "data/text.txt";

    public static void main(String[] args) {
        LOGGER.info("== App started ==");
        FileReader reader = new FileReader();
        TextParser parser = new TextParser();
        TextOperations operations = new TextOperations();
        TextAnalyzer analyzer = new TextAnalyzer();
        TextRestorer  restorer = new TextRestorer();

        try{
            String textContent = reader.readFile(FILE_PATH);
            LOGGER.info("Read text from file, length {}", textContent.length());
            Text text = parser.parse(textContent);
            LOGGER.info("Text parsed, length {}", textContent.length());
            System.out.println("\n == Original Text ==");
            System.out.println(restorer.restore(text));

            System.out.println("\n === Task 1: The greatest number of sentences containing identical words ");
            operations.findMaxSentencesWithSameWords(text);

            System.out.println("\n == Task 2: Count of letters & symbols ===");
            analyzer.countLetterAndSymbols(text);

            System.out.println("\n === Task 3: Sorting sentences by letter 'e' ");
            operations.sortSentencesByLetter(text, 'e');

            System.out.println("\n === Task 4: Replacing the first lexeme with last lexeme");
            operations.swapFirstLastLexeme(text);

            System.out.println("\n === Text after replacing === ");
            System.out.println(restorer.restore(text));
        } catch (TextException e) {
        LOGGER.error("Application error: {}", e.getMessage());
        }
        LOGGER.info("== App ended ==");
    }
}