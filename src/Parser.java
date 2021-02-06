import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Parser {
    public static void main(String[] args) throws IOException {
        Table<String, String, String> action = HashBasedTable.create(); //Use google Guava lib
        {
            action.put("0", "id", "s6");//0
            action.put("0", "=", "-");
            action.put("0", "if", "s7");
            action.put("0", "(", "-");
            action.put("0", ")", "-");
            action.put("0", "while", "s8");
            action.put("0", "int", "-");
            action.put("0", "OP", "-");
            action.put("0", "==", "-");
            action.put("0", "$", "-");

            action.put("1", "id", "-");//1
            action.put("1", "=", "-");
            action.put("1", "if", "-");
            action.put("1", "(", "-");
            action.put("1", ")", "-");
            action.put("1", "while", "-");
            action.put("1", "int", "-");
            action.put("1", "OP", "-");
            action.put("1", "==", "-");
            action.put("1", "$", "accept");

            action.put("2", "id", "s6");//2
            action.put("2", "=", "-");
            action.put("2", "if", "s7");
            action.put("2", "(", "-");
            action.put("2", ")", "-");
            action.put("2", "while", "s8");
            action.put("2", "int", "-");
            action.put("2", "OP", "-");
            action.put("2", "==", "-");
            action.put("2", "$", "r2");
//            action.put("2", "$", "r2");


            action.put("3", "id", "r4");//3
            action.put("3", "=", "-");
            action.put("3", "if", "r4");
            action.put("3", "(", "-");
            action.put("3", ")", "-");
            action.put("3", "while", "r4");
            action.put("3", "int", "-");
            action.put("3", "OP", "-");
            action.put("3", "==", "-");
            action.put("3", "$", "r4");

            action.put("4", "id", "r5");//4
            action.put("4", "=", "-");
            action.put("4", "if", "r5");
            action.put("4", "(", "-");
            action.put("4", ")", "-");
            action.put("4", "while", "r5");
            action.put("4", "int", "-");
            action.put("4", "OP", "-");
            action.put("4", "==", "-");
            action.put("4", "$", "r5");

            action.put("5", "id", "r6");//5
            action.put("5", "=", "-");
            action.put("5", "if", "r6");
            action.put("5", "(", "-");
            action.put("5", ")", "-");
            action.put("5", "while", "r6");
            action.put("5", "int", "-");
            action.put("5", "OP", "-");
            action.put("5", "==", "-");
            action.put("5", "$", "r6");

            action.put("6", "id", "-");//6
            action.put("6", "=", "s10");
            action.put("6", "if", "-");
            action.put("6", "(", "-");
            action.put("6", ")", "-");
            action.put("6", "while", "-");
            action.put("6", "int", "-");
            action.put("6", "OP", "-");
            action.put("6", "==", "-");
            action.put("6", "$", "-");

            action.put("7", "id", "-");//7
            action.put("7", "=", "-");
            action.put("7", "if", "-");
            action.put("7", "(", "s11");
            action.put("7", ")", "-");
            action.put("7", "while", "-");
            action.put("7", "int", "-");
            action.put("7", "OP", "-");
            action.put("7", "==", "-");
            action.put("7", "$", "-");

            action.put("8", "id", "-");//8
            action.put("8", "=", "-");
            action.put("8", "if", "-");
            action.put("8", "(", "s12");
            action.put("8", ")", "-");
            action.put("8", "while", "-");
            action.put("8", "int", "-");
            action.put("8", "OP", "-");
            action.put("8", "==", "-");
            action.put("8", "$", "-");

            action.put("9", "id", "-");//9
            action.put("9", "=", "-");
            action.put("9", "if", "-");
            action.put("9", "(", "-");
            action.put("9", ")", "-");
            action.put("9", "while", "-");
            action.put("9", "int", "-");
            action.put("9", "OP", "-");
            action.put("9", "==", "-");
            action.put("9", "$", "r3");

            action.put("10", "id", "s14");//10
            action.put("10", "=", "-");
            action.put("10", "if", "-");
            action.put("10", "(", "-");
            action.put("10", ")", "-");
            action.put("10", "while", "-");
            action.put("10", "int", "s15");
            action.put("10", "OP", "-");
            action.put("10", "==", "-");
            action.put("10", "$", "-");

            action.put("11", "id", "s19");//11
            action.put("11", "=", "-");
            action.put("11", "if", "-");
            action.put("11", "(", "-");
            action.put("11", ")", "-");
            action.put("11", "while", "-");
            action.put("11", "int", "-");
            action.put("11", "OP", "-");
            action.put("11", "==", "-");
            action.put("11", "$", "-");

            action.put("12", "id", "s19");//12
            action.put("12", "=", "-");
            action.put("12", "if", "-");
            action.put("12", "(", "-");
            action.put("12", ")", "-");
            action.put("12", "while", "-");
            action.put("12", "int", "-");
            action.put("12", "OP", "-");
            action.put("12", "==", "-");
            action.put("12", "$", "-");

            action.put("13", "id", "r7");//13
            action.put("13", "=", "-");
            action.put("13", "if", "r7");
            action.put("13", "(", "-");
            action.put("13", ")", "-");
            action.put("13", "while", "r7");
            action.put("13", "int", "-");
            action.put("13", "OP", "-");
            action.put("13", "==", "-");
            action.put("13", "$", "r7");

            action.put("14", "id", "r10");//14
            action.put("14", "=", "-");
            action.put("14", "if", "r10");
            action.put("14", "(", "-");
            action.put("14", ")", "-");
            action.put("14", "while", "r10");
            action.put("14", "int", "-");
            action.put("14", "OP", "r14");
            action.put("14", "==", "-");
            action.put("14", "$", "r10");

            action.put("15", "id", "r11");//15
            action.put("15", "=", "-");
            action.put("15", "if", "r11");
            action.put("15", "(", "-");
            action.put("15", ")", "-");
            action.put("15", "while", "r11");
            action.put("15", "int", "-");
            action.put("15", "OP", "-");
            action.put("15", "==", "-");
            action.put("15", "$", "r11");

            action.put("16", "id", "-");//16
            action.put("16", "=", "-");
            action.put("16", "if", "-");
            action.put("16", "(", "-");
            action.put("16", ")", "-");
            action.put("16", "while", "-");
            action.put("16", "int", "-");
            action.put("16", "OP", "s21");
            action.put("16", "==", "-");
            action.put("16", "$", "-");

            action.put("17", "id", "-");//17
            action.put("17", "=", "-");
            action.put("17", "if", "-");
            action.put("17", "(", "-");
            action.put("17", ")", "s22");
            action.put("17", "while", "-");
            action.put("17", "int", "-");
            action.put("17", "OP", "-");
            action.put("17", "==", "-");
            action.put("17", "$", "-");

            action.put("18", "id", "-");//18
            action.put("18", "=", "-");
            action.put("18", "if", "-");
            action.put("18", "(", "-");
            action.put("18", ")", "-");
            action.put("18", "while", "-");
            action.put("18", "int", "-");
            action.put("18", "OP", "-");
            action.put("18", "==", "s23");
            action.put("18", "$", "-");

            action.put("19", "id", "-");//19
            action.put("19", "=", "-");
            action.put("19", "if", "-");
            action.put("19", "(", "-");
            action.put("19", ")", "-");
            action.put("19", "while", "-");
            action.put("19", "int", "-");
            action.put("19", "OP", "-");
            action.put("19", "==", "r14");
            action.put("19", "$", "-");

            action.put("20", "id", "-");//20
            action.put("20", "=", "-");
            action.put("20", "if", "-");
            action.put("20", "(", "-");
            action.put("20", ")", "s24");
            action.put("20", "while", "-");
            action.put("20", "int", "-");
            action.put("20", "OP", "-");
            action.put("20", "==", "-");
            action.put("20", "$", "-");

            action.put("21", "id", "s14");//21
            action.put("21", "=", "-");
            action.put("21", "if", "-");
            action.put("21", "(", "-");
            action.put("21", ")", "-");
            action.put("21", "while", "-");
            action.put("21", "int", "s15");
            action.put("21", "OP", "-");
            action.put("21", "==", "-");
            action.put("21", "$", "-");

            action.put("22", "id", "s6");//22
            action.put("22", "=", "-");
            action.put("22", "if", "s7");
            action.put("22", "(", "-");
            action.put("22", ")", "-");
            action.put("22", "while", "s8");
            action.put("22", "int", "-");
            action.put("22", "OP", "-");
            action.put("22", "==", "-");
            action.put("22", "$", "-");

            action.put("23", "id", "s28");//23
            action.put("23", "=", "-");
            action.put("23", "if", "-");
            action.put("23", "(", "-");
            action.put("23", ")", "-");
            action.put("23", "while", "-");
            action.put("23", "int", "s29");
            action.put("23", "OP", "-");
            action.put("23", "==", "-");
            action.put("23", "$", "-");

            action.put("24", "id", "s6");//24
            action.put("24", "=", "-");
            action.put("24", "if", "s7");
            action.put("24", "(", "-");
            action.put("24", ")", "-");
            action.put("24", "while", "s8");
            action.put("24", "int", "-");
            action.put("24", "OP", "-");
            action.put("24", "==", "-");
            action.put("24", "$", "-");

            action.put("25", "id", "r12");//25
            action.put("25", "=", "-");
            action.put("25", "if", "r12");
            action.put("25", "(", "-");
            action.put("25", ")", "-");
            action.put("25", "while", "r12");
            action.put("25", "int", "-");
            action.put("25", "OP", "-");
            action.put("25", "==", "-");
            action.put("25", "$", "r12");

            action.put("26", "id", "r8");//26
            action.put("26", "=", "-");
            action.put("26", "if", "r8");
            action.put("26", "(", "-");
            action.put("26", ")", "-");
            action.put("26", "while", "r8");
            action.put("26", "int", "-");
            action.put("26", "OP", "-");
            action.put("26", "==", "-");
            action.put("26", "$", "r8");

            action.put("27", "id", "-");//27
            action.put("27", "=", "-");
            action.put("27", "if", "-");
            action.put("27", "(", "-");
            action.put("27", ")", "r13");
            action.put("27", "while", "-");
            action.put("27", "int", "-");
            action.put("27", "OP", "-");
            action.put("27", "==", "-");
            action.put("27", "$", "-");

            action.put("28", "id", "-");//28
            action.put("28", "=", "-");
            action.put("28", "if", "-");
            action.put("28", "(", "-");
            action.put("28", ")", "r10");
            action.put("28", "while", "-");
            action.put("28", "int", "-");
            action.put("28", "OP", "r14");
            action.put("28", "==", "-");
            action.put("28", "$", "-");

            action.put("29", "id", "-");//29
            action.put("29", "=", "-");
            action.put("29", "if", "-");
            action.put("29", "(", "-");
            action.put("29", ")", "r11");
            action.put("29", "while", "-");
            action.put("29", "int", "-");
            action.put("29", "OP", "-");
            action.put("29", "==", "-");
            action.put("29", "$", "-");

            action.put("30", "id", "-");//30
            action.put("30", "=", "-");
            action.put("30", "if", "-");
            action.put("30", "(", "-");
            action.put("30", ")", "-");
            action.put("30", "while", "-");
            action.put("30", "int", "-");
            action.put("30", "OP", "s32");
            action.put("30", "==", "-");
            action.put("30", "$", "-");

            action.put("31", "id", "r9");//31
            action.put("31", "=", "-");
            action.put("31", "if", "r9");
            action.put("31", "(", "-");
            action.put("31", ")", "-");
            action.put("31", "while", "r9");
            action.put("31", "int", "-");
            action.put("31", "OP", "-");
            action.put("31", "==", "-");
            action.put("31", "$", "r9");

            action.put("32", "id", "s28");//32
            action.put("32", "=", "-");
            action.put("32", "if", "-");
            action.put("32", "(", "-");
            action.put("32", ")", "-");
            action.put("32", "while", "-");
            action.put("32", "int", "s29");
            action.put("32", "OP", "-");
            action.put("32", "==", "-");
            action.put("32", "$", "-");

            action.put("33", "id", "-");//33
            action.put("33", "=", "-");
            action.put("33", "if", "-");
            action.put("33", "(", "-");
            action.put("33", ")", "r11");
            action.put("33", "while", "-");
            action.put("33", "int", "-");
            action.put("33", "OP", "-");
            action.put("33", "==", "-");
            action.put("33", "$", "-");
        }//populate table
        //GOTO Table
        Table<String, String, String> goto_table = HashBasedTable.create(); //Use google Guava lib
        {
            goto_table.put("0", "program", "-");
            goto_table.put("0", "statements", "g1");
            goto_table.put("0", "statement", "g2");
            goto_table.put("0", "assignStmt", "g3");
            goto_table.put("0", "ifStmt", "g4");
            goto_table.put("0", "whileStmt", "g5");
            goto_table.put("0", "expr", "-");
            goto_table.put("0", "cmpr", "-");
            goto_table.put("0", "term", "-");

            goto_table.put("1", "program", "-");
            goto_table.put("1", "statements", "-");
            goto_table.put("1", "statement", "-");
            goto_table.put("1", "assignStmt", "-");
            goto_table.put("1", "ifStmt", "-");
            goto_table.put("1", "whileStmt", "-");
            goto_table.put("1", "expr", "-");
            goto_table.put("1", "cmpr", "-");
            goto_table.put("1", "term", "-");

            goto_table.put("2", "program", "-");
            goto_table.put("2", "statements", "g9");
            goto_table.put("2", "statement", "g2");
            goto_table.put("2", "assignStmt", "g3");
            goto_table.put("2", "ifStmt", "g4");
            goto_table.put("2", "whileStmt", "g5");
            goto_table.put("2", "expr", "-");
            goto_table.put("2", "cmpr", "-");
            goto_table.put("2", "term", "-");

            goto_table.put("3", "program", "-");
            goto_table.put("3", "statements", "-");
            goto_table.put("3", "statement", "-");
            goto_table.put("3", "assignStmt", "-");
            goto_table.put("3", "ifStmt", "-");
            goto_table.put("3", "whileStmt", "-");
            goto_table.put("3", "expr", "-");
            goto_table.put("3", "cmpr", "-");
            goto_table.put("3", "term", "-");

            goto_table.put("4", "program", "-");
            goto_table.put("4", "statements", "-");
            goto_table.put("4", "statement", "-");
            goto_table.put("4", "assignStmt", "-");
            goto_table.put("4", "ifStmt", "-");
            goto_table.put("4", "whileStmt", "-");
            goto_table.put("4", "expr", "-");
            goto_table.put("4", "cmpr", "-");
            goto_table.put("4", "term", "-");

            goto_table.put("5", "program", "-");
            goto_table.put("5", "statements", "-");
            goto_table.put("5", "statement", "-");
            goto_table.put("5", "assignStmt", "-");
            goto_table.put("5", "ifStmt", "-");
            goto_table.put("5", "whileStmt", "-");
            goto_table.put("5", "expr", "-");
            goto_table.put("5", "cmpr", "-");
            goto_table.put("5", "term", "-");

            goto_table.put("6", "program", "-");
            goto_table.put("6", "statements", "-");
            goto_table.put("6", "statement", "-");
            goto_table.put("6", "assignStmt", "-");
            goto_table.put("6", "ifStmt", "-");
            goto_table.put("6", "whileStmt", "-");
            goto_table.put("6", "expr", "-");
            goto_table.put("6", "cmpr", "-");
            goto_table.put("6", "term", "-");

            goto_table.put("7", "program", "-");
            goto_table.put("7", "statements", "-");
            goto_table.put("7", "statement", "-");
            goto_table.put("7", "assignStmt", "-");
            goto_table.put("7", "ifStmt", "-");
            goto_table.put("7", "whileStmt", "-");
            goto_table.put("7", "expr", "-");
            goto_table.put("7", "cmpr", "-");
            goto_table.put("7", "term", "-");

            goto_table.put("8", "program", "-");
            goto_table.put("8", "statements", "-");
            goto_table.put("8", "statement", "-");
            goto_table.put("8", "assignStmt", "-");
            goto_table.put("8", "ifStmt", "-");
            goto_table.put("8", "whileStmt", "-");
            goto_table.put("8", "expr", "-");
            goto_table.put("8", "cmpr", "-");
            goto_table.put("8", "term", "-");

            goto_table.put("9", "program", "-");
            goto_table.put("9", "statements", "-");
            goto_table.put("9", "statement", "-");
            goto_table.put("9", "assignStmt", "-");
            goto_table.put("9", "ifStmt", "-");
            goto_table.put("9", "whileStmt", "-");
            goto_table.put("9", "expr", "-");
            goto_table.put("9", "cmpr", "-");
            goto_table.put("9", "term", "-");

            goto_table.put("10", "program", "-");
            goto_table.put("10", "statements", "-");
            goto_table.put("10", "statement", "-");
            goto_table.put("10", "assignStmt", "-");
            goto_table.put("10", "ifStmt", "-");
            goto_table.put("10", "whileStmt", "-");
            goto_table.put("10", "expr", "g13");
            goto_table.put("10", "cmpr", "-");
            goto_table.put("10", "term", "g16");

            goto_table.put("11", "program", "-");
            goto_table.put("11", "statements", "-");
            goto_table.put("11", "statement", "-");
            goto_table.put("11", "assignStmt", "-");
            goto_table.put("11", "ifStmt", "-");
            goto_table.put("11", "whileStmt", "-");
            goto_table.put("11", "expr", "-");
            goto_table.put("11", "cmpr", "g17");
            goto_table.put("11", "term", "g18");

            goto_table.put("12", "program", "-");
            goto_table.put("12", "statements", "-");
            goto_table.put("12", "statement", "-");
            goto_table.put("12", "assignStmt", "-");
            goto_table.put("12", "ifStmt", "-");
            goto_table.put("12", "whileStmt", "-");
            goto_table.put("12", "expr", "-");
            goto_table.put("12", "cmpr", "g20");
            goto_table.put("12", "term", "g18");

            goto_table.put("13", "program", "-");
            goto_table.put("13", "statements", "-");
            goto_table.put("13", "statement", "-");
            goto_table.put("13", "assignStmt", "-");
            goto_table.put("13", "ifStmt", "-");
            goto_table.put("13", "whileStmt", "-");
            goto_table.put("13", "expr", "-");
            goto_table.put("13", "cmpr", "-");
            goto_table.put("13", "term", "-");

            goto_table.put("14", "program", "-");
            goto_table.put("14", "statements", "-");
            goto_table.put("14", "statement", "-");
            goto_table.put("14", "assignStmt", "-");
            goto_table.put("14", "ifStmt", "-");
            goto_table.put("14", "whileStmt", "-");
            goto_table.put("14", "expr", "-");
            goto_table.put("14", "cmpr", "-");
            goto_table.put("14", "term", "-");

            goto_table.put("15", "program", "-");
            goto_table.put("15", "statements", "-");
            goto_table.put("15", "statement", "-");
            goto_table.put("15", "assignStmt", "-");
            goto_table.put("15", "ifStmt", "-");
            goto_table.put("15", "whileStmt", "-");
            goto_table.put("15", "expr", "-");
            goto_table.put("15", "cmpr", "-");
            goto_table.put("15", "term", "-");

            goto_table.put("16", "program", "-");
            goto_table.put("16", "statements", "-");
            goto_table.put("16", "statement", "-");
            goto_table.put("16", "assignStmt", "-");
            goto_table.put("16", "ifStmt", "-");
            goto_table.put("16", "whileStmt", "-");
            goto_table.put("16", "expr", "-");
            goto_table.put("16", "cmpr", "-");
            goto_table.put("16", "term", "-");

            goto_table.put("17", "program", "-");
            goto_table.put("17", "statements", "-");
            goto_table.put("17", "statement", "-");
            goto_table.put("17", "assignStmt", "-");
            goto_table.put("17", "ifStmt", "-");
            goto_table.put("17", "whileStmt", "-");
            goto_table.put("17", "expr", "-");
            goto_table.put("17", "cmpr", "-");
            goto_table.put("17", "term", "-");

            goto_table.put("18", "program", "-");
            goto_table.put("18", "statements", "-");
            goto_table.put("18", "statement", "-");
            goto_table.put("18", "assignStmt", "-");
            goto_table.put("18", "ifStmt", "-");
            goto_table.put("18", "whileStmt", "-");
            goto_table.put("18", "expr", "-");
            goto_table.put("18", "cmpr", "-");
            goto_table.put("18", "term", "-");

            goto_table.put("19", "program", "-");
            goto_table.put("19", "statements", "-");
            goto_table.put("19", "statement", "-");
            goto_table.put("19", "assignStmt", "-");
            goto_table.put("19", "ifStmt", "-");
            goto_table.put("19", "whileStmt", "-");
            goto_table.put("19", "expr", "g23");
            goto_table.put("19", "cmpr", "-");
            goto_table.put("19", "term", "g14");

            goto_table.put("20", "program", "-");
            goto_table.put("20", "statements", "-");
            goto_table.put("20", "statement", "g24");
            goto_table.put("20", "assignStmt", "g2");
            goto_table.put("20", "ifStmt", "g3");
            goto_table.put("20", "whileStmt", "g4");
            goto_table.put("20", "expr", "-");
            goto_table.put("20", "cmpr", "-");
            goto_table.put("20", "term", "-");

            goto_table.put("21", "program", "-");
            goto_table.put("21", "statements", "-");
            goto_table.put("21", "statement", "-");
            goto_table.put("21", "assignStmt", "-");
            goto_table.put("21", "ifStmt", "-");
            goto_table.put("21", "whileStmt", "-");
            goto_table.put("21", "expr", "g25");
            goto_table.put("21", "cmpr", "-");
            goto_table.put("21", "term", "g16");

            goto_table.put("22", "program", "-");
            goto_table.put("22", "statements", "-");
            goto_table.put("22", "statement", "g26");
            goto_table.put("22", "assignStmt", "g3");
            goto_table.put("22", "ifStmt", "g4");
            goto_table.put("22", "whileStmt", "g5");
            goto_table.put("22", "expr", "-");
            goto_table.put("22", "cmpr", "-");
            goto_table.put("22", "term", "-");

            goto_table.put("23", "program", "-");
            goto_table.put("23", "statements", "-");
            goto_table.put("23", "statement", "-");
            goto_table.put("23", "assignStmt", "-");
            goto_table.put("23", "ifStmt", "-");
            goto_table.put("23", "whileStmt", "-");
            goto_table.put("23", "expr", "g27");
            goto_table.put("23", "cmpr", "-");
            goto_table.put("23", "term", "g30");

            goto_table.put("24", "program", "-");
            goto_table.put("24", "statements", "-");
            goto_table.put("24", "statement", "g31");
            goto_table.put("24", "assignStmt", "g3");
            goto_table.put("24", "ifStmt", "g4");
            goto_table.put("24", "whileStmt", "g5");
            goto_table.put("24", "expr", "-");
            goto_table.put("24", "cmpr", "-");
            goto_table.put("24", "term", "-");

            goto_table.put("25", "program", "-");
            goto_table.put("25", "statements", "-");
            goto_table.put("25", "statement", "-");
            goto_table.put("25", "assignStmt", "-");
            goto_table.put("25", "ifStmt", "-");
            goto_table.put("25", "whileStmt", "-");
            goto_table.put("25", "expr", "-");
            goto_table.put("25", "cmpr", "-");
            goto_table.put("25", "term", "-");

            goto_table.put("26", "program", "-");
            goto_table.put("26", "statements", "-");
            goto_table.put("26", "statement", "-");
            goto_table.put("26", "assignStmt", "-");
            goto_table.put("26", "ifStmt", "-");
            goto_table.put("26", "whileStmt", "-");
            goto_table.put("26", "expr", "-");
            goto_table.put("26", "cmpr", "-");
            goto_table.put("26", "term", "-");

            goto_table.put("27", "program", "-");
            goto_table.put("27", "statements", "-");
            goto_table.put("27", "statement", "-");
            goto_table.put("27", "assignStmt", "-");
            goto_table.put("27", "ifStmt", "-");
            goto_table.put("27", "whileStmt", "-");
            goto_table.put("27", "expr", "-");
            goto_table.put("27", "cmpr", "-");
            goto_table.put("27", "term", "-");

            goto_table.put("28", "program", "-");
            goto_table.put("28", "statements", "-");
            goto_table.put("28", "statement", "-");
            goto_table.put("28", "assignStmt", "-");
            goto_table.put("28", "ifStmt", "-");
            goto_table.put("28", "whileStmt", "-");
            goto_table.put("28", "expr", "-");
            goto_table.put("28", "cmpr", "-");
            goto_table.put("28", "term", "-");

            goto_table.put("29", "program", "-");
            goto_table.put("29", "statements", "-");
            goto_table.put("29", "statement", "-");
            goto_table.put("29", "assignStmt", "-");
            goto_table.put("29", "ifStmt", "-");
            goto_table.put("29", "whileStmt", "-");
            goto_table.put("29", "expr", "-");
            goto_table.put("29", "cmpr", "-");
            goto_table.put("29", "term", "-");

            goto_table.put("30", "program", "-");
            goto_table.put("30", "statements", "-");
            goto_table.put("30", "statement", "-");
            goto_table.put("30", "assignStmt", "-");
            goto_table.put("30", "ifStmt", "-");
            goto_table.put("30", "whileStmt", "-");
            goto_table.put("30", "expr", "-");
            goto_table.put("30", "cmpr", "-");
            goto_table.put("30", "term", "-");

            goto_table.put("31", "program", "-");
            goto_table.put("31", "statements", "-");
            goto_table.put("31", "statement", "-");
            goto_table.put("31", "assignStmt", "-");
            goto_table.put("31", "ifStmt", "-");
            goto_table.put("31", "whileStmt", "-");
            goto_table.put("31", "expr", "-");
            goto_table.put("31", "cmpr", "-");
            goto_table.put("31", "term", "-");

            goto_table.put("32", "program", "-");
            goto_table.put("32", "statements", "-");
            goto_table.put("32", "statement", "-");
            goto_table.put("32", "assignStmt", "-");
            goto_table.put("32", "ifStmt", "-");
            goto_table.put("32", "whileStmt", "-");
            goto_table.put("32", "expr", "g33");
            goto_table.put("32", "cmpr", "-");
            goto_table.put("32", "term", "g30");

            goto_table.put("33", "program", "-");
            goto_table.put("33", "statements", "-");
            goto_table.put("33", "statement", "-");
            goto_table.put("33", "assignStmt", "-");
            goto_table.put("33", "ifStmt", "-");
            goto_table.put("33", "whileStmt", "-");
            goto_table.put("33", "expr", "-");
            goto_table.put("33", "cmpr", "-");
            goto_table.put("33", "term", "-");
        } //populate table
        //        for (Table.Cell<String, String, String> cell: action.cellSet()){
//            System.out.println(cell.getRowKey()+" "+cell.getColumnKey()+" "+cell.getValue());
//        }
        //input String to check
        //String[] input={"if","(","id","=", "int",")","id","=", "int","$"};//change this
        //String[] input={"id","=", "int","$"};//change this
        //String[] input={"while","(","id","=", "int",")","id","=", "int","$"};//change this
        //String[] input={"if","(","id","=", "int",")","while","(","id","=", "int",")","id","=", "int","$"};
        //TinyScanner t= new TinyScanner();
        MyScanner t = new MyScanner();
        Token[] input = t.getToken();
        //char[] input={'a','b','c','d','e','$'};//incorrect input

        String[][] rules = {
                {},//0
                {"program", "1"},//1
                {"statements", "1"},//2
                {"statements", "12"},//3
                {"statement", "1"},//4
                {"statement", "1"},//5
                {"statement", "1"},//6
                {"assignStmt", "123"},//7
                {"ifStmt", "12345"},//8
                {"whileStmt", "12345"},//9
                {"expr", "1"},//10
                {"expr", "1"},//11
                {"expr", "123"},//12
                {"cmpr", "123"},//13
                {"term", "1"}//14
        };
        //Stack myStack = new Stack();//object type Stack
        Stack<TokenClass> myStack = new Stack();
        int ptr = 0;//keep track of input
        Token word = input[ptr];
        //String word = input[ptr].name;
        //myStack.push('0');//starting state
        myStack.push(new TokenClass(0));
        while (true) {
            String act = "";//store action performed
            //char s= myStack.peek();
            //String s = String.valueOf(myStack.peek());
            String s = String.valueOf(myStack.peek().state);
            char temp = action.get(s, word.name).charAt(0);
            //char temp = action.get(s, word).charAt(0);
            act += temp;
            if (temp == 's') {
                //myStack.push(word);
                myStack.push(new TokenClass(word));
                String a = action.get(s, word.name).substring(1);//get state
                act += a;
                myStack.push(new TokenClass(Integer.parseInt(a)));//push state
                ptr += 1;
                //word = input[ptr].name;
                word = input[ptr];
            } else if (temp == 'r') {
                int rule_number = Integer.parseInt(action.get(s, word.name).substring(1));
                act += rule_number;
                String left_side = rules[rule_number][0];
                String right_side = rules[rule_number][1];
                int num = 2 * right_side.length();//op plus rule
                ArrayList<TokenClass> temptoken = new ArrayList<TokenClass>();//store popped tokens only
                while (num != 0) {
                    if (num % 2 != 0) {
                        temptoken.add(myStack.pop());
                    } else {
                        myStack.pop();
                    }
                    num -= 1;
                }
                //char uncovered_s= (char) myStack.peek();
                String uncovered_s = String.valueOf(myStack.peek().state);//get state on top of stack
                //myStack.push(left_side);//add non-terminal after reduction
                myStack.push(new TokenClass(createNode(left_side,temptoken),left_side));
                myStack.push(new TokenClass(Integer.parseInt(goto_table.get(uncovered_s, left_side).substring(1))));//fetch state number as we need to back
            } else if (action.get(s, word.name).equalsIgnoreCase("accept")) {
                System.out.println("Accepted!");
                myStack.pop();
                System.out.println("AST Printing");
                printAst("",myStack.peek().node);
                break;
            } else {
                System.out.println("Rejected!");
                //System.out.println("error at: "+t.lineNum);
                break;
            }
//            for (int i = ptr; i < input.length; i++) {//to print remaining input
//                System.out.print(input[i]+" ");
//            }
            //System.out.println(act);
        }

//        System.out.println(myStack.peek().node.children.get(0).children.get(0));
    }


    public static void printAst(String beforeNode, Node node){
//        if(lastNode){
//            System.out.println(beforeNode+"-"+node+"");
//            beforeNode+=" ";
//        }
        System.out.println(beforeNode+"-|-"+node+"");
        beforeNode+=" "+"| ";
        //System.out.println(node+"--");
        if(node.children!=null){
            int len=node.children.size();
            for (int i = 0; i < len; i++) {
                printAst(beforeNode,node.children.get(i));
                //lastNode=(i==len-1);
            }
        }
    }


    public static Node createNode(String left_side, ArrayList<TokenClass> temp) {
        //Node rtn=new prog_stmt((statementNode) temp.get(0));//ignore
//        if (left_side.equals("program")) {
//            Node node = new statementsNode((statementsNode) temp.get(0).node) {
//            };
//            return node;
//        }
        if(left_side.equals("statements")){
            Node node;
            if(temp.size()==1){
                return temp.get(0).node;
            }
            if(temp.get(1).name.equals("statement")&&temp.get(0).name.equals("statement")) {
                node = new stmts((statementNode) temp.get(1).node, (statementNode) temp.get(0).node);
            }
            else{
                node = new stmts((statementNode) temp.get(1).node, (statementsNode) temp.get(0).node);
            }
            return node;
        } else if (left_side.equals("statement")) {
            Node node;
            if(temp.get(0).name.equals("assignStmt")){
                node= new prog_stmt((stmt_assign)temp.get(0).node);
                return node;
            }
            if(temp.get(0).name.equals("ifStmt")){
                node= new prog_stmt((stmt_if)temp.get(0).node);
                return node;
            }
            if(temp.get(0).name.equals("whileStmt")){
                node= new prog_stmt((stmt_while)temp.get(0).node);
                return node;
            }
            //Node node = new stmt((statementNode) temp.get(0).node);
        } else if (left_side.equals("assignStmt")) {
            //Node node = new stmt_assign((idNode) temp.get(1), (exprNode) temp.get(0));
            Node node = new stmt_assign(new idNode(temp.get(2).token.value), (exprNode) temp.get(0).node);
            return node;
        } else if (left_side.equals("ifStmt")) {
            Node node = new stmt_if((cmprNode) temp.get(2).node, (statementNode) temp.get(0).node);
            return node;
        } else if (left_side.equals("whileStmt")) {
            Node node = new stmt_while((cmprNode) temp.get(2).node, (statementNode) temp.get(0).node);
            return node;
        } else if (left_side.equals("expr")) {
            Node node;
            if (temp.size() > 1) {
                node = new expr_termopexpr( (termNode)temp.get(2).node,new opNode(temp.get(1).token.value) ,(exprNode)temp.get(0).node);
                //node = new expr_termopexpr(new termNode((idNode) temp.get(1).node), (exprNode) temp.get(0).node);
            } else {
                if (temp.get(0).token.name.equals("int")) {
                    //node = new expr_int(temp.get(0).token.val);
                    node = new expr_int(new intNode(temp.get(0).token.val));
                }
                else {
                    node = new expr_id(new idNode(temp.get(0).token.value));
                }
            }
            return node;
        } else if (left_side.equals("cmpr")) {
            Node node = new cmprNode((termNode) temp.get(2).node,new opNode(temp.get(1).token.name), (exprNode) temp.get(0).node);
            return node;
        }
        else if (left_side.equals("term")) {
            Node node = new termNode(new idNode(temp.get(0).token.value));
            return node;
        }
        return new prog_stmt((statementNode) temp.get(0).node);
    }
}
//abstract class Program extends Node{
//
//}
class statementsNode extends Node{

}
class prog_stmt extends statementNode{
    statementNode stmt;
    prog_stmt(statementNode stmt){
        this.stmt=stmt;
        super.children=new ArrayList<>();
        super.children.add(this.stmt);
    }
    public String toString(){
        return "Statement";
    }
}
class stmts extends statementsNode{
    statementNode stmt1;
    statementNode stmt2;
    statementsNode stmts;
    stmts(statementNode stmt, statementNode stmts){
        this.stmt1=stmt;
        this.stmt2=stmts;
        super.children=new ArrayList<>();
        super.children.add(this.stmt1);
        super.children.add(this.stmt2);
    }
    stmts(statementNode stmt, statementsNode stmts){
        this.stmt1=stmt;
        this.stmts=stmts;
        super.children=new ArrayList<>();
        super.children.add(this.stmt1);
        super.children.add(this.stmts);
    }
    public String toString(){
        return "Statements";
    }
}
//abstract class statementsNode extends Node{
//
//}
abstract class statementNode extends statementsNode{

}

class stmt_if extends statementNode{
    cmprNode cmpr;
    statementNode stmt;
    stmt_if(cmprNode cmpr,statementNode stmt){
        this.cmpr=cmpr;
        this.stmt=stmt;
        super.children=new ArrayList<>();
        super.children.add(this.cmpr);
        super.children.add(this.stmt);
    }
    public String toString(){
        return "IfStatement";
    }
}
class stmt_while extends statementNode{
    cmprNode cmpr;
    statementNode stmt;
    stmt_while(cmprNode cmpr,statementNode stmt){
        this.cmpr=cmpr;
        this.stmt=stmt;
        super.children=new ArrayList<>();
        super.children.add(this.cmpr);
        super.children.add(this.stmt);
    }
    public String toString(){
        return "whileStmt";
    }
}
class stmt_assign extends statementNode{
    idNode id;
    equalNode eq;
    exprNode expr;
    stmt_assign(idNode id,exprNode expr){
        this.id=id;
        this.expr=expr;
        super.children=new ArrayList<>();
        super.children.add(this.id);
        super.children.add(this.eq=new equalNode());
        super.children.add(this.expr);
    }
    public String toString(){
        return "AssignStmt";
    }
}
class equalNode extends Node{
    String eq="=";
    public String toString(){
        return eq;
    }
}
abstract class exprNode extends Node{

}
class expr_id extends exprNode{
    idNode id;
    //String ID;
    expr_id(idNode id){
        this.id=id;
        super.children=new ArrayList<>();
        super.children.add(this.id);
    }
    public String toString(){
        return "expr";
        //return this.id.id;
    }
}
class expr_int extends exprNode{
    intNode intgr;
    //int INT;
    expr_int(intNode intgr){
        this.intgr=intgr;
        super.children=new ArrayList<>();
        super.children.add(this.intgr);
    }
    public String toString(){
        //return String.valueOf(this.intgr.val);
        return "expr";
    }
}
class expr_termopexpr extends exprNode{
    termNode term;
    opNode op;
    exprNode expr;
    expr_termopexpr(termNode term,opNode op, exprNode expr){
        this.expr=expr;
        this.op=op;
        this.term=term;
        super.children=new ArrayList<>();
        super.children.add(this.term);
        super.children.add(this.op);
        super.children.add(this.expr);
    }
    public String toString(){
        return "expr";
    }
}
class cmprNode extends Node {
    termNode term;
    opNode op;
    exprNode expr;
    cmprNode(termNode term,opNode op, exprNode expr){
        this.expr=expr;
        this.op=op;
        this.term=term;
        super.children=new ArrayList<>();
        super.children.add(this.term);
        super.children.add(this.op);
        super.children.add(this.expr);
    }
    public String toString(){
        return "Cmpr";
    }
}
class termNode extends Node{
    idNode id;
    termNode(idNode id){
        this.id=id;
        super.children=new ArrayList<>();
        super.children.add(this.id);
    }
    public String toString(){
        return "term";
    }
}
class opNode extends Node{
    String op;
    opNode(String op){
        this.op=op;
    }
    public String toString(){
        return "OP: "+this.op;
    }
}
class idNode extends Node{
    String id;
    idNode(String id){
        this.id=id;
    }
    public String toString(){
        return "id: "+this.id;
    }
}
class intNode extends Node{
    int val;
    intNode(int val){
        this.val=val;
    }
    public String toString(){
        return "int: "+String.valueOf(this.val);
    }
}
abstract class Node{
    ArrayList<Node> children;
}
class TokenClass{
    String type;
    int state;
    Node node;
    Token token;
    String name;
    TokenClass(int state){
        this.state=state;
        this.type="state";
    }
    TokenClass(Node node, String name){
        this.node=node;
        this.type="node";
        this.name=name;
    }
    TokenClass(Token node){
        this.token=node;
        this.type="token";
    }
}