# THE LOX LANGUAGE

lox language implemented from this beautiful website [crafting interpreters](https://craftinginterpreters.com)

## LEXEMES AND TOKENS 

`var language = "lox";`

Here `var`, `language`, `=`, `"lox"`, and `;` are lexemes of the program. To get these lexemes we have to scan through each character of the file and group them together into the smallest sequence that still represents something. When we take the lexeme and bundle it together with that other data, the result is a token. It contains useful stuff like:

- Token Type 
- Literal Value
- Location Information



