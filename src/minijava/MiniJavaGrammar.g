grammar MiniJavaGrammar ;

program : mainclass classdecl* ;

mainclass : CLASS ID LBRACE methoddecl* mainmethod methoddecl* RBRACE
          ;

mainmethod : PUBLIC STATIC VOID MAIN LPAREN STRING LSQUARE RSQUARE ID RPAREN LBRACE methodbody* RBRACE
           ;

classdecl : CLASS ID LBRACE vardecl* methoddecl* RBRACE  
          | CLASS ID EXTENDS ID LBRACE vardecl* methoddecl* RBRACE
        ;
    
vardecl  : type ID SEMICOLON ;

methoddecl : PUBLIC type ID LPAREN formallist? RPAREN LBRACE methodbody* RBRACE ;

methodbody : vardecl
           | statement;

formallist : type ID formalrest* ;

formalrest : COMMA type ID ;

type : INT LSQUARE RSQUARE
     | BOOLEAN 
     | INT
     | ID
     ;

statement : LBRACE statement* RBRACE # Braces
          | IF LPAREN expr RPAREN statement ELSE statement # If
          | WHILE LPAREN expr RPAREN statement # While
          | SYSTEMOUT LPAREN expr RPAREN SEMICOLON # Print
          | ID EQUALS expr SEMICOLON # Assignment
          | ID LSQUARE expr RSQUARE EQUALS expr SEMICOLON # ArrayAssignment
          | RETURN expr SEMICOLON # Return
            ;

expr : expr op expr # OpExpr
     | expr LSQUARE expr RSQUARE # IndexExpr
     | expr DOT LENGTH # LengthExpr
     | expr DOT ID LPAREN exprlist? RPAREN # MethodExpr
     | INTEGER # IntegerExpr
     | TRUE # BooleanExpr
     | FALSE # BooleanExpr
     | ID # IdExpr
     | THIS # ThisExpr
     | NEW INT LSQUARE expr RSQUARE # NewArrExpr
     | NEW ID LPAREN RPAREN # NewClassExpr
     | NOT expr # BooleanExpr
     | LPAREN expr RPAREN # ParenExpr
    ;

op : AND | LT | PLUS | MINUS | MUL ; 

exprlist : expr exprrest* ;

exprrest : COMMA expr;

WS : (' ' | '\t' | '\r'? '\n')+ -> skip;

//INTEGER : [0-9]+ ;

COMMENT : '/*' .*? '*/'  -> skip;

LINE_COMMENT : '//' .*? '\n' -> skip;

// STRING : '"' (ESC | .)*? '"' ;

ESC : '\\' [btnr"\\] ;

AND : '&&' ;
LT : '<' ;
PLUS : '+' ;
MINUS : '-' ;
MUL : '*' ;

CLASS : 'class';
PUBLIC : 'public' ;
STATIC : 'static' ;
VOID : 'void' ;
MAIN : 'main' ;
STRING : 'String' ;
EXTENDS : 'extends';
RETURN : 'return' ;
WHILE : 'while';
IF : 'if' ;
ELSE : 'else' ;
BOOLEAN : 'boolean' ;
INT : 'int' ;
SYSTEMOUT : 'System.out.println' ;
LENGTH : 'length' ;
NEW : 'new';
THIS : 'this';


TRUE : 'true';
FALSE : 'false';

NOT : '!';
DOT : '.';
COMMA : ',' ;
SEMICOLON : ';' ;
LBRACE : '{';
RBRACE : '}';
LPAREN : '(' ;
RPAREN : ')' ;
LSQUARE : '[' ;
RSQUARE : ']' ;
EQUALS : '=';

ID  :   LETTER (LETTER | [0-9])* ;

LETTER : [a-zA-Z] | '_' ;

INTEGER : [0-9]+ ;
