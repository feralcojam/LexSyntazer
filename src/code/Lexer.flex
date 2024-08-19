package code;
import static code.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
SL = \"([^\\\"]|\\\\[\"ntbrf])*\"
blank_space=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
"," {lexeme=yytext(); return Comma;}
";" {lexeme=yytext(); return Semicolon;}
String {lexeme=yytext(); return STRING;}
int {lexeme=yytext(); return INT;}
if {lexeme=yytext(); return IF;}
else {lexeme=yytext(); return ELSE;}
while {lexeme=yytext(); return WHILE;}
for {lexeme=yytext(); return FOR;}
do {lexeme=yytext(); return DO;}
{blank_space} {/*Ignore*/}
"\n" {return LineBreak;}
"//".* {/*Ignore*/}
"=" {lexeme=yytext(); return Equal;}
"+" {lexeme=yytext(); return Add;}
"-" {lexeme=yytext(); return Subtract;}
"*" {lexeme=yytext(); return Multiplication;}
"/" {lexeme=yytext(); return Division;}
"%" {lexeme=yytext(); return Modulo;}
"(" {lexeme=yytext(); return OpenParenthesis;}
")" {lexeme=yytext(); return CloseParenthesis;}
"{" {lexeme=yytext(); return OpenBrace;}
"}" {lexeme=yytext(); return CloseBrace;}
"[" {lexeme=yytext(); return OpenBracket;}
"]" {lexeme=yytext(); return CloseBracket;}
"public" {lexeme=yytext(); return Public;}
"class" {lexeme=yytext(); return Class;}
"static" {lexeme=yytext(); return Static;}
"void" {lexeme=yytext(); return Void;}
"args" {lexeme=yytext(); return Args;}
"main" {lexeme=yytext(); return Main;}
 
{L}({L}|{D})* {lexeme=yytext(); return Identifier;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Number;}
{SL} {lexeme=yytext(); return StringLiteral;}
 . {return ERROR;}
