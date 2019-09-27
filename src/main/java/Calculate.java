import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class  Calculate {

    private static Stack<String> stack = new Stack<>();
    public static List<String> all = new ArrayList<>();
    public static List<String> numbers = new ArrayList<>();
    public static List<String> oper = new ArrayList<>();
    public static  List<StringBuilder> result = new ArrayList<>();
    private static List<String> operands = new ArrayList<>();
    public static String calc(String expression) throws Exception {

        System.out.println(Parse(expression));
        System.out.println(charComparison(all));
        System.out.println(stack);
        return expression;
    }




    private static List<String> charComparison(List<String> Elements) throws Exception {
        for (String element:Elements) {
            switch (element)
            {
            case "(":
                stack.push("(");
                break;

            case ")":
                stack.push(")");
                break;
            case "+":
                stack.push("+");
                break;
            case "-":
                stack.push("-");
                break;
            case "*":
                stack.push("*");
                break;
            case "/":
                stack.push("/");
                break;
            case "^":
                stack.push("^");
                break;
            default:
                operands.add(element);
                break;
        }
        }
        return operands;
    }



    public byte GetPriority(char s)
    {
        switch (s)
        {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 4;
        }
    }

    static List<String> Parse(String expression)  {
        GetNumbers(expression);
        GetChars(expression);
        for(int x=0; x<numbers.size(); x++){
            all.add(numbers.get(x));
            if(x != numbers.size()-1){
                all.add(oper.get(x));}
        }
        return all;
    }



    static List<String>  GetNumbers(String str){
        String replaceString = str.replaceAll("[^-?0-9]+", " ");
        String[] replaceString1 = replaceString.split(" ");
        for (String elem : replaceString1) {
            numbers.add(elem);
        }
        return numbers;
    }

    static List<String>  GetChars(String str){
        String replaceString = str.replaceAll("[-?0-9]+", " ");
        String[] replaceString1 = replaceString.split(" ");
        for (String elem : replaceString1) {
            oper.add(elem);
        }
        oper.remove(0);
        return oper;
    }
}
