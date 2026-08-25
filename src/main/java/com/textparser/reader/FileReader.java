package com.textparser.reader;

import com.textparser.exception.TextException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public String readFile(String filePath) throws TextException {
        Path path = Paths.get(filePath);

        if(!Files.exists(path)){
            throw new TextException("File not found" + filePath);
        }

        try {
            return Files.readString(path);
        } catch (Exception e) {
            throw new TextException("Error reading file " +  e.getMessage());
        }
    }
}
