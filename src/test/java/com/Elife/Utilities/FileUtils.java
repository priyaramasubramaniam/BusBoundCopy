package com.Elife.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
      public static String getFileTextAsIs(String filePath) throws IOException {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Join the lines into a single string, maintaining line breaks
            return String.join("\n", lines).trim();
      }
}
