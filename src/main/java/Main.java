import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String tempo = "";
    public static List<String> parsingString = new ArrayList<String>();
    public static boolean isMinus = false;
    static int result;

    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Input a number: ");
        //String expression = in.next();

        //Calculate.calc("5*2+10");
        Parse("-5*2(-2+3)");
        parsingString = Calculate.charComparison(parsingString);
        result = Calculate.CalcResult(parsingString);
        System.out.println(result+" - результат");
    }

    public static void Parse(String str)
    {
        System.out.println(str+" - Исходное выражение");
        for(int x = 0; x <str.length();x++)
        {
            if(Character.isDigit(str.charAt(x))){
                System.out.println(str.charAt(x)+" - Число");
                tempo = tempo + str.charAt(x);
                System.out.println(tempo+" - Число");
                if(x==str.length()-1){
                    parsingString.add(tempo);
                }
            }
            else {

                System.out.println(str.charAt(x)+" - Не число");
                if(str.charAt(x) == '-'){
                    isMinus = true;
                    continue;
                }
                if(isMinus == true){
                parsingString.add(tempo = "-"+tempo);
                isMinus=false;}
                else {parsingString.add(tempo);}
                parsingString.add(String.valueOf(str.charAt(x)));

                tempo = "";
            }
        }
        System.out.println(parsingString+" - Выходной массив");
    }
}
