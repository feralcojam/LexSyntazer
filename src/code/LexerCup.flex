package code;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
blank_space=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
String {return new Symbol(sym.STRING, yychar, yyline, yytext());}
int {return new Symbol(sym.INT, yychar, yyline, yytext());}
if {return new Symbol(sym.IF, yychar, yyline, yytext());}
else {return new Symbol(sym.ELSE, yychar, yyline, yytext());}
while {return new Symbol(sym.WHILE, yychar, yyline, yytext());}
for {return new Symbol(sym.FOR, yychar, yyline, yytext());}
do {return new Symbol(sym.DO, yychar, yyline, yytext());}
{blank_space} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return new Symbol(sym.Equal, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Add, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Subtract, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplication, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"%" {return new Symbol(sym.Modulo, yychar, yyline, yytext());}
"(" {return new Symbol(sym.OpenParenthesis, yychar, yyline, yytext());}
")" {return new Symbol(sym.CloseParenthesis, yychar, yyline, yytext());}
"{" {return new Symbol(sym.OpenBrace, yychar, yyline, yytext());}
"}" {return new Symbol(sym.CloseBrace, yychar, yyline, yytext());}
"[" {return new Symbol(sym.OpenBracket, yychar, yyline, yytext());}
"]" {return new Symbol(sym.CloseBracket, yychar, yyline, yytext());}
"public" {return new Symbol(sym.Public, yychar, yyline, yytext());}
"class" {return new Symbol(sym.Class, yychar, yyline, yytext());}
"static" {return new Symbol(sym.Static, yychar, yyline, yytext());}
"void" {return new Symbol(sym.Void, yychar, yyline, yytext());}
"args" {return new Symbol(sym.Args, yychar, yyline, yytext());}
"main" {return new Symbol(sym.Main, yychar, yyline, yytext());}
";" {return new Symbol(sym.Semicolon, yychar, yyline, yytext());}
 
{L}({L}|{D})* {return new Symbol(sym.Identifier, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Number, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

