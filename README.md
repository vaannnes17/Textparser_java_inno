# Task 2: Information Handling (Composite Pattern)

Java application for parsing and analyzing text using Composite and Chain of Responsibility patterns.

## Features

- Parse text into hierarchical structure: Text → Paragraph → Sentence → Lexeme → Word/Symbol
- Restore original text from parsed structure
- Count letters and symbols in text
- Find maximum number of sentences with same words
- Sort sentences by count of specific letter
- Swap first and last lexeme in each sentence
- Logging with Log4J2
- JUnit5 tests

## Technologies

- Java 17
- Maven
- Log4J2
- JUnit5
- Composite Pattern
- Chain of Responsibility Pattern

## Project Structure

```
src/main/java/com/task2/
├── entity/
│   ├── TextComponent.java
│   ├── Text.java
│   ├── Paragraph.java
│   ├── Sentence.java
│   ├── Lexeme.java
│   ├── Word.java
│   ├── Punctuation.java
│   └── Symbol.java
├── parser/
│   ├── TextParser.java
│   ├── ParagraphParser.java
│   ├── SentenceParser.java
│   └── LexemeParser.java
├── service/
│   ├── TextAnalyzer.java
│   ├── TextOperations.java
│   └── TextRestorer.java
├── reader/
│   └── FileReader.java
├── exception/
│   └── TextException.java
└── Main.java
```

## Patterns Used

### Composite Pattern

- **Text** - root container (contains Paragraphs)
- **Paragraph** - container (contains Sentences)
- **Sentence** - container (contains Lexemes)
- **Lexeme** - container (contains Words and Symbols)
- **Word** - leaf (individual word)
- **Punctuation** - leaf (punctuation mark)
- **Symbol** - leaf (other characters)

### Chain of Responsibility

- **TextParser** → splits text into paragraphs
- **ParagraphParser** → splits paragraphs into sentences
- **SentenceParser** → splits sentences into lexemes
- **LexemeParser** → splits lexemes into words and symbols

## Operations

1. **Find maximum sentences with same words**
   - Counts how many sentences contain each word
   - Returns the maximum count and the words

2. **Count letters and symbols**
   - Counts all letters (a-z, A-Z, а-я, А-Я)
   - Counts all other characters (punctuation, spaces, etc.)

3. **Sort sentences by letter count**
   - Sorts all sentences by number of specific letter (case insensitive)
   - Shows each sentence with its count

4. **Swap first and last lexeme**
   - Swaps the first and last lexeme in each sentence
   - Preserves all other text structure

## Run

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.task2.Main"
```

## Tests

```bash
mvn test
```

## Data

Input text file: `data/text.txt`

## Author

Senko Ivan

