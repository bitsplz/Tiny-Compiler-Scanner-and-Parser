import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import static java.lang.System.exit;

enum tokenType {
    ID, INT, IF, WHILE, ROUND_LPAREN, ROUND_RPAREN, COMPARE, OP, INVALID, ASSIGN, EOF
}
public class MyScanner {
    int lineNum=0;
    //String arr[]=new String[50];
    Token arr[]=new Token[50];
    static String token;
    //public String[] getToken() throws IOException {
    public Token[] getToken() throws IOException {
        try {
            removeComments();
            //creating File instance to reference text file in Java
            File inputFile = new File("removecomment.txt");
            Scanner scanner = new Scanner(inputFile);
            int count=0;
            while (scanner.hasNextLine()) {
                String line=scanner.nextLine();
                lineNum++;
                StringTokenizer st = new StringTokenizer(line," ");
                while (st.hasMoreTokens()) {
                    String t=st.nextToken();
                    //String token=rawToken(t);
                    Token token=rawToken(t);
                    arr[count]=token;
                    count++;
                }
                //arr[count]="$";
                //count++;
                //token = scanner.next();//.next will make tokens
                //rawToken(token);
            }
            //arr[count]="eof";
            //arr[count]="$";
            arr[count]= new Token("$", tokenType.EOF);
            scanner.close();
        }
        catch(Exception e){

        }
        return arr;
    }

    //private String rawToken(String token){
    private Token rawToken(String token){
        tokenType Type = null;
            if(token.equals("if")){
                Token newToken= new Token(token,Type.IF);
                //return newToken.value;
                return newToken;
            }
            else if(token.equals("while")) {
                Token newToken= new Token(token,Type.WHILE);
                //return newToken.value;
                return newToken;
            }
            else if(token.equals("(")) {
                Token newToken= new Token(token,Type.ROUND_LPAREN);
                //return newToken.value;
                return newToken;
            }
            else if(token.equals(")")) {
                Token newToken= new Token(token,Type.ROUND_RPAREN);
                //return newToken.value;
                return newToken;
            }
            else if(Pattern.matches("^[a-zA-Z_][a-zA-Z0-9_]*$", token)) {
                Token newToken= new Token(token,Type.ID, "id");
                //return newToken.value;
                //return "id";
                return newToken;
            }
            else if(Pattern.matches("[+|-|*|/]", token)) {
                Token newToken= new Token(token,Type.OP,"OP");
                //return newToken.value;
                //return "OP";
                return newToken;
            }
            else if(token.equals("=")) {
                Token newToken= new Token(token,Type.ASSIGN);
                //return newToken.value;
                return newToken;
            }
            else if(token.equals("==")) {
                Token newToken= new Token(token,Type.COMPARE);
                //return newToken.value;
                return newToken;
            }
            else if(Pattern.matches("[0-9]+", token)) {
                int temp=Integer.valueOf(token);
                //System.out.print(temp);
                Token newToken= new Token(Integer.parseInt(token),Type.INT,"int");
                //return newToken.value;
                //return "int";
                return newToken;
            }
            else {
                Token newToken= new Token(token,Type.INVALID);
                System.out.println("Invalid Token: "+token+" at Line: "+lineNum);
                exit(1);
            }
            return new Token("",Type.INVALID);
    }

    public static void removeComments() throws IOException {
        try {
            File file=new File("tiny_language.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader inFile=new BufferedReader(fr);  //creates a buffering character input stream
            //StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            int character=0;
            String str="";
            //int chk=0;
            while ((character=inFile.read())!=-1)
            {
                if (character=='/'){
                    int temp=inFile.read();
                    if ((char)temp=='/'){
                        inFile.readLine();
                        str+="\n";
                    }
                    else if((char)temp=='*'){
                        temp=inFile.read();
                        while((char)temp!='*'){
                            temp=inFile.read();
                        }
                        if ((char)temp=='/'){
                            inFile.read();
                        }
                    }
                }
                else{
                    str=str+(char)character;
                }
                //char c=(char)character;

            }
            //System.out.println(str);
            FileWriter outputFile = new FileWriter("removecomment.txt");
            outputFile.write(str);
            outputFile.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

class Token{
    //tokenType type;
    String type;
    String value;
    String name;//id or int
    int val;
    Token(String val, tokenType myType){
        this.name=val;
        this.type= String.valueOf(myType);
    }
    Token(int val, tokenType myType,String name){
        this.val=val;
        this.type= String.valueOf(myType);
        this.name=name;//int
    }
    Token(String val, tokenType myType, String name){
        this.value=val;
        this.type= String.valueOf(myType);
        this.name=name;//id or op
    }
}