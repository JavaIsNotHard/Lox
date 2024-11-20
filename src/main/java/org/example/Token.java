package org.example;

public class Token {

    final TokenType type;
    final String lexeme;
    final Object literal;
    final int count;

    Token(TokenType type, String lexeme, Object literal, int count) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.count = count;
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
    }

}
