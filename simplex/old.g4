parser grammar SimplexParser;

options { tokenVocab=SimplexLexer; }

program
	: statement*
;

inlineStatement
	: returnStatement
	| breakStatement
	| continueStatement
	| expressionStatement
	| variableDeclaration
	| variableAssignment
;

returnStatement
	: RETURN expression?
;

breakStatement
	: BREAK
;

continueStatement
	: CONTINUE
;

statement
	: inlineStatement EOS
	| simpleFor
	| tripleFor
	| doFor
	| ifStatement
	| funcDeclaration
	| scope
;


variableDeclaration
	: identifierList COLON typeExpression EQ expressionList
;

identifierList
	: IDENTIFIER
;

variableAssignment
	: expressionList EQ expressionList
;

sliceIndicator
	: SQUARE_OPEN SQUARE_CLOSE
;

typeExpression
	: sliceIndicator typeExpression
	| CARET typeExpression
	| IDENTIFIER
;

funcDeclaration
	: FUN IDENTIFIER PAREN_OPEN fieldList? PAREN_CLOSE (RIGHT_ARROW typeExpression)? scope
;

field
	: IDENTIFIER COLON typeExpression
;

fieldList
	: field (COMMA field)*
;

scope
	: CURLY_OPEN statement* CURLY_CLOSE
;

simpleFor
	: FOR expression scope
;

tripleFor
	: FOR inlineStatement EOS expression EOS inlineStatement scope
;
	
doFor
	: DO scope FOR inlineStatement EOS
;

ifStatement
	: IF expression scope (ELSE ifStatement)* (ELSE scope)?
;

expressionStatement
	: expression
;

expression
	: logicDisjunction
;

logicDisjunction
	: logicConjunction ((LOGIC_OR | LOGIC_XOR) logicConjunction)*
;

logicConjunction
	: comparison ((LOGIC_AND) comparison)*
;

comparison
	: term ((EQ_EQ | NOT_EQ | GT | GT_EQ | LT | LT_EQ) term)*
;

term
	: factor ((PLUS | MINUS | OR | XOR) factor)*
;

factor
	: bitShift ((STAR | SLASH | MOD | AND) bitShift)*
;

bitShift
	: unary ((SHIFT_LEFT | SHIFT_RIGHT) unary)*
;

unary
	: ((MINUS | PLUS | XOR | LOGIC_NOT) unary)
	| primary
;

primary
	: indexing
	| IDENTIFIER
	| integer
	| real
	| literal_char
	| boolean
	| NULL
	| group
	| functionCall
;

literal_char
	: LITERAL_RUNE
	| LITERAL_STRING
;

group
	: PAREN_OPEN expression PAREN_CLOSE
;

functionCall
	: IDENTIFIER PAREN_OPEN expressionList PAREN_CLOSE
	| IDENTIFIER PAREN_OPEN PAREN_CLOSE
;

expressionList
	: expression (COMMA expression)*
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

indexing
	: IDENTIFIER (SQUARE_OPEN expression SQUARE_CLOSE)*
;