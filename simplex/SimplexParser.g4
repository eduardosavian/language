parser grammar SimplexParser;

options { tokenVocab=SimplexLexer; }

program
    : (statement EOS)*
    ;

statement
	: boolean
	| integer
	| real
;

boolean
	: TRUE | FALSE
;

integer
	: LITERAL_HEX
	| LITERAL_BIN
	| LITERAL_INT
;

real
	: LITERAL_REAL
;