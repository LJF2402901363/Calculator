package Service;

import java.util.*;

/**
 * Classname:CalculatorUtil
 *
 * @description:计算器的业务逻辑类
 * @author: 陌意随影
 * @Date: 2020-05-25 15:22
 * @Version: 1.0
 **/
public class CalculatorService {
   /**
    * @Description :返回运算结果的字符串
    * @Date 15:39 2020/5/25 0025
    * @Param * @param str ：
    * @return java.lang.String
    **/
    public String getExpResult(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        //给输入的字符串表达式添加一个结束标识
        str = str+"#";
        //字符栈
        Stack<Object> stack =  getOperation(str);

        //操作数栈
        Stack<Double> OPND = new Stack<>();
        //运算符栈
        Stack<Character> OPTR = new Stack<>();
        //给操作符栈添加一个结束标识
        OPTR.add('#');
        Object obj = stack.pop();
        if(obj instanceof Double && stack.size() == 0){
            return  obj.toString();
        }
        if(obj instanceof Character && stack.size() == 0){
            return  obj.toString();
        }
        while(true){
            if(obj instanceof Double){
                Double value =  (Double) obj;
                OPND.push(value);
                obj = stack.pop();
            }else{
                Character value =  (Character) obj;
                //调出循环
                if(value == '#'&& OPTR.peek()=='#'){
                    break;
                }
                //获取两个操作符的运算优先级。
                char temp = this.Precede( OPTR.peek(), value);
                switch (temp) {
                    case '<':
                        OPTR.push(value);
                        obj = stack.pop();
                        break;
                    case '=':
                        OPTR.pop();
                        obj = stack.pop();
                        break;
                    case '>':
                        char  theta = OPTR.pop();
                        Double b = OPND.pop();
                        Double a = OPND.pop();
                        //获取运算结果
                        Double result = expResult(a, theta, b);
                        //结果入栈
                        OPND.push(result);
                        break;
                    default:
                        break;
                }
            }

        }
        if(OPND.size() != 1){
            return "运算出现错误！";
        }
        return OPND.peek().toString();

    }
    /**
     * @Description :获取输入的字符串的的后缀表达式的字符栈
     * @Date 15:30 2020/5/25 0025
     * @Param * @param str ：
     * @return java.util.Stack<java.lang.Object>
     **/
    public   Stack<Object>  getOperation(String str){
        Stack<Object> stack = new Stack<>();
        if(str == null || str.length() == 0){
            return stack;
        }
       //操作符集合
        ArrayList<Character> OPTR = new ArrayList<>();
        //将非操作数的字符入栈+ - * / % ( )
        for(int i = 0;i < str.length();i++){
            char c  = str.charAt(i);
           //判断是字符类型
            if(isSymbol(c)){
               //操作符入栈
                OPTR.add(c);
            }
        }
        //利用操作符进行分割得到操作数。
        for(int i = 0;i < OPTR.size();i++){
            int index = str.indexOf(OPTR.get(i));
            String value = str.substring(0,index);
            if(value.trim().length() != 0){
             Double val   =  Double.valueOf(value);
           Object ch =  stack.peek();
                stack.push(Double.valueOf(val));
            }
            stack.push(OPTR.get(i));
            str = str.substring(index+1);
        }
        if (str.length() > 0) {
            if(str.trim().length() != 0){
                stack.push(Double.valueOf(str));
            }

        }

       //将栈逆序
        Collections.reverse(stack);
        //如果第一个是+或-操作符，则需要进行相应的处理。
        Object o = stack.peek();
        if(o instanceof Character){
            Character c = (Character) o;
            if(c == '-'||c == '+'){
                stack.push(0.0);
            }
        }
        return stack;
    }
  /**
   * @Description :获取num1和num2的运算结果
   * @Date 15:29 2020/5/25 0025
   *@param num1：操作数1
   * @param c ：运算符
   * @param num2 ：操作数2
   * @return double
   **/
    public double expResult(double num1, char c,double num2)
    {
        double result = 0;
        switch (c)
        {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '%':
                result = num1 % num2;
                break;
        }
        return result;
    }

   /**
    * @Description :判断字符是运算符还是数字
    * @Date 15:28 2020/5/25 0025
    * @Param * @param c ：需要判断的字符
    * @return boolean
    **/
    public boolean isSymbol(char c)
    {
        if (c == '+'||c == '-'||c=='*'|| c == '/' ||c== '%' || c =='('||c =='#'||c==')')
        {
            return true;

        }

        return false;
    }
  /**
   * @Description :获取两个字符中运算优先级的符号如果优先级a>ch，则返回">";a =ch，则返回"="，否则返回“<”
   * @Date 15:25 2020/5/25 0025
   * @Param  @param a :运算符a
   * @param ch ：运算符ch
   * @return char
   **/
    public     char Precede(char a, char ch) {
        switch (a)
        {
            case '+':
                switch (ch)
                {
                    case '+':
                        return '>';
                    case '-':
                        return '>';
                    case '*':
                        return '<';
                    case '/':
                        return '<';
                    case '%':
                        return '<';
                    case '(':
                        return '<';
                    case ')':
                        return '>';
                    case '#':
                        return '>';
                }

            case '-':
                switch (ch)
                {
                    case '+':
                        return '>';
                    case '-':
                        return '>';
                    case '*':
                        return '<';
                    case '%':
                        return '<';
                    case '/':
                        return '<';
                    case '(':
                        return '<';
                    case ')':
                        return '>';
                    case '#':
                        return '>';
                }
            case '*':
                switch (ch)
                {
                    case '+':
                        return '>';
                    case '-':
                        return '>';
                    case '*':
                        return '>';
                    case '%':
                        return '>';
                    case '/':
                        return '>';
                    case '(':
                        return '<';
                    case ')':
                        return '>';
                    case '#':
                        return '>';
                }
            case '%':
                switch (ch)
                {
                    case '+':
                        return '>';
                    case '-':
                        return '>';
                    case '*':
                        return '>';
                    case '/':
                        return '>';
                    case '%':
                        return '>';
                    case '(':
                        return '<';
                    case ')':
                        return '>';
                    case '#':
                        return '>';
                }
            case '/':
                switch (ch)
                {
                    case '+':
                        return '>';
                    case '-':
                        return '>';
                    case '*':
                        return '>';
                    case '/':
                        return '>';
                    case '%':
                        return '>';
                    case '(':
                        return '<';
                    case ')':
                        return '>';
                    case '#':
                        return '>';
                }
            case '(':
                if (ch == ')')
                {
                    return '=';
                }else {
                    return '<';
                }
            case ')':
                return '>';
            case '#':
                if (ch =='#')
                {
                    return '=';
                }
                else {
                    return '<';
                }
        }
        return ' ';
    }
   /**
    * @Description :判断表达式是否正确
    * @Date 15:45 2020/5/25 0025
    * @Param * @param code ：
    * @return boolean
    **/
    public boolean isSureCode(String code) {

        if (code.isEmpty() || code.length() == 0) {
            return false;
        }
        Map<Integer, Character> map1 = new HashMap<Integer, Character>();
        Map<Integer, Character> map2 = new HashMap<Integer, Character>();
        Stack<Character> stack = new Stack<>();
        map1.put(0, '{');
        map1.put(1, '[');
        map1.put(2, '(');
        map2.put(0, '}');
        map2.put(1, ']');
        map2.put(2, ')');
        char temp = '\0';
        for (int i = 0; i < code.length(); i++) {
            temp = code.charAt(i);
            if (map1.containsValue(temp)) {
                stack.push(temp);
            } else if (map2.containsValue(temp)) {
                char pop = '\0';
                try {
                    pop = stack.pop();
                } catch (Exception e) {
                    return false;
                }
                for (int j = 0; j < map2.size(); j++) {
                    if (temp == map2.get(j)) {
                        if (pop != map1.get(j)) {
                            return false;
                        }
                    }
                }

            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;

    }
    /**
     * @Description :判断是否可以进行计算
     * @Date 16:26 2020/5/25 0025
     * @Param * @param str ：
     * @return boolean
     **/
    public boolean isCanCalculate(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }

        if (str.startsWith("*") || str.startsWith("/") || str.startsWith("%") || str.contains("=")) {
            return false;
        }
        if (!isSureCode(str)) {
            return false;
        }
        return true;

    }
}
