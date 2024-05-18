package com.jotrorox.jtoml;

import java.util.HashMap;
import java.util.Map;

public class JTomlParser {
    private final String content;
    private int index;

    /**
     * Create a new TOML parser
     * @param content The content of the TOML file
     */
    public JTomlParser(String content) {
        this.content = content;
        this.index = 0;
    }

    private Map<String, Object> parseTable() {
        index++; // Skip opening bracket
        parseKey();
        skipWhitespace();
        if (index < content.length() && content.charAt(index) == ']') {
            index++; // Skip closing bracket
        } else {
            throw new IllegalArgumentException("Missing closing bracket for table");
        }
        skipWhitespace();
        if (index < content.length() && content.charAt(index) == '\n') {
            index++; // Skip newline
        }
        Map<String, Object> table = new HashMap<>();
        while (index < content.length() && content.charAt(index) != '[') {
            if (content.charAt(index) == '\n') {
                index++; // Skip newline
                continue;
            }
            String key = parseKey();
            skipWhitespace();
            if (index < content.length() && content.charAt(index) == '=') {
                index++; // Skip '='
                skipWhitespace();
                Object value = parseValue();
                table.put(key, value);
            }
            skipWhitespace();
        }
        return table;
    }

    public Map<String, Object> parse() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> currentTable = result;
        while (index < content.length()) {
            skipWhitespace();
            if (index < content.length() && content.charAt(index) == '#') skipComment();
            else if (index < content.length()) {
                if (content.charAt(index) == '[') {
                    Map<String, Object> table = parseTable();
                    currentTable.putAll(table);
                    currentTable = table;
                } else {
                    String key = parseKey();
                    skipWhitespace();
                    if (index < content.length() && content.charAt(index) == '=') {
                        index++; // Skip '='
                        skipWhitespace();
                        Object value = parseValue();
                        currentTable.put(key, value);
                    }
                }
            }
        }
        return result;
    }

   /**
     * Checks all the whitespace characters from the current index and skips them, so the index points to the next non-whitespace character.
     */
    private void skipWhitespace() {
        while (index < content.length() && Character.isWhitespace(content.charAt(index))) index++;
    }

    /**
     * Skips the comment from the current index to the end of the line.
     */
    private void skipComment() {
        while (index < content.length() && content.charAt(index)!= '\n') index++;
    }

    /**
     * Parses the key from the current index to the next whitespace or '=' character.
     * @return The parsed key
     */
    private String parseKey() {
        StringBuilder key = new StringBuilder();
        while (index < content.length() && content.charAt(index)!= '=' && content.charAt(index) != ']' && !Character.isWhitespace(content.charAt(index))) {
            key.append(content.charAt(index));
            index++;
        }
        return key.toString();
    }

    /**
     * Parses the value from the current index to the next whitespace or end of the line.
     * @return The parsed value
     */
    private Object parseValue() {
        skipWhitespace();
        char firstChar = content.charAt(index);
        if (firstChar == '"') return parseString();
        else if (Character.isDigit(firstChar)) return parseInt();
        else if (firstChar == 't' || firstChar == 'f') return parseBoolean();
        else throw new IllegalArgumentException("Unsupported value type");
    }

    /**
     * Parses the string from the current index to the next closing quote.
     * @return The parsed string
     */
    private String parseString() {
        index++; // Skip opening quote
        StringBuilder str = new StringBuilder();
        while (index < content.length() && content.charAt(index)!= '"') {
            str.append(content.charAt(index));
            index++;
        }
        index++; // Skip closing quote
        return str.toString();
    }

    /**
     * Parses the integer from the current index to the next non-digit character.
     * @return The parsed integer
     */
    private Integer parseInt() {
        StringBuilder num = new StringBuilder();
        while (index < content.length() && Character.isDigit(content.charAt(index))) {
            num.append(content.charAt(index));
            index++;
        }
        return Integer.parseInt(num.toString());
    }

    /**
     * Parses the boolean from the current index to the next non-letter character.
     * @return The parsed boolean
     */
    private Boolean parseBoolean() {
        String boolStr = content.substring(index, index + 4);
        index += 4;
        return "true".equals(boolStr);
    }
}
