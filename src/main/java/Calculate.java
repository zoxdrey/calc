
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class  Calculate {

    private static Stack<String> stack = new Stack<>();
    private static Stack<Integer> calcResult = new Stack<>();
    public static List<String> all = new ArrayList<>();
    public static List<String> numbers = new ArrayList<>();
    public static List<String> oper = new ArrayList<>();
    public static  List<String> result = new ArrayList<>();
    private static List<String> exitString = new ArrayList<>();
    public static int oper1;
    public static int oper2;
    public static String operation;
    public static int calculationResult;
    public static String calc(String expression) throws Exception {
        //System.out.println(Parse(expression));
        CalcResult(result);
        return expression;
    }

    static Integer CalcResult(List<String> result) {

        for(int x = 0; x < result.size();x++) {
            if(result.get(x) == "" ) continue;
            switch (result.get(x))
            {
                case "+":
                    oper1 = calcResult.pop();
                    oper2 = calcResult.pop();
                    calculationResult = oper1 + oper2;
                    calcResult.push(calculationResult);
                    System.out.println(calcResult);
                    break;
                case "-":
                    oper1 = calcResult.pop();
                    oper2 = calcResult.pop();
                    calculationResult = oper1 - oper2;
                    calcResult.push(calculationResult);
                    System.out.println(calcResult);
                    break;
                case "*":
                    oper1 = calcResult.pop();
                    oper2 = calcResult.pop();
                    calculationResult = oper1 * oper2;
                    calcResult.push(calculationResult);
                    System.out.println(calcResult);
                    break;
                case "/":
                    oper1 = calcResult.pop();
                    oper2 = calcResult.pop();
                    calculationResult = oper2 / oper1;
                    calcResult.push(calculationResult);
                    System.out.println(calcResult);
                    break;
                default:
                    calcResult.push(Integer.parseInt(result.get(x)));
                    System.out.println(calcResult);
            }
        }
        System.out.println(calcResult);

        return calculationResult;
    }


    static List<String> charComparison(List<String> Elements) throws Exception {
        for (String element:Elements) {
            switch (element)
            {
            case "(":
                if(stack.isEmpty()){
                    stack.push("(");
                    break;}
                stack.push("(");
                break;
            case ")":
                if(stack.isEmpty()){
                throw  new Exception("WTF");
                }
                while(!stack.peek().equals("(")){
                    if(stack.isEmpty()){break;}
                    exitString.add(stack.pop());
                }
                stack.pop();
                break;
            case "+":
                if(stack.isEmpty()){
                    stack.push("+");
                    break;}
                if(GetPriority(stack.peek()) > 1) {
                    exitString.add(stack.pop());
                    stack.push("+");
                    break;
                }
                else if(GetPriority(stack.peek()) == 1) {

                    exitString.add(stack.pop());
                    stack.push("+");
                    break;
                }
                stack.push("+");
                break;
            case "-":
                if(stack.isEmpty()){
                    stack.push("-");
                    break;}
                if(GetPriority(stack.peek()) > 1) {
                    exitString.add(stack.pop());
                    stack.push("-");
                    break;
                }
                else if(GetPriority(stack.peek()) == 1) {
                    exitString.add(stack.pop());
                    stack.push("-");
                    break;
                }
                stack.push("-");
                break;
            case "*":
                if(stack.isEmpty()){
                    stack.push("*");
                    break;}
                if(GetPriority(stack.peek()) > 2) {
                    exitString.add(stack.pop());
                    stack.push("*");
                    break;
                }
                else if(GetPriority(stack.peek()) == 2) {
                    exitString.add(stack.pop());
                    stack.push("*");
                    break;
                }
                stack.push("*");
                break;
            case "/":
                if(stack.isEmpty()){
                    stack.push("/");
                    break;}
                if(GetPriority(stack.peek()) > 2) {
                    exitString.add(stack.pop());
                    stack.push("/");
                    break;
                }
                else if(GetPriority(stack.peek()) == 2) {
                    exitString.add(stack.pop());
                    stack.push("/");
                    break;
                }
                stack.push("/");
                break;
            case "^":
                stack.push("^");
                break;
            default:
                exitString.add(element);
                break;
        }
        }
        while(!stack.isEmpty()){
        exitString.add(stack.pop());}
        System.out.println(exitString);
        return exitString;
    }



    public static byte GetPriority(String s)
    {
        switch (s)
        {
            case "(":
            case ")":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 4;
        }
    }


}
