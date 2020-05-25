package Service;

import java.util.*;

/**
 * Classname:CalculatorUtil
 *
 * @description:��������ҵ���߼���
 * @author: İ����Ӱ
 * @Date: 2020-05-25 15:22
 * @Version: 1.0
 **/
public class CalculatorService {
   /**
    * @Description :�������������ַ���
    * @Date 15:39 2020/5/25 0025
    * @Param * @param str ��
    * @return java.lang.String
    **/
    public String getExpResult(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        //��������ַ������ʽ���һ��������ʶ
        str = str+"#";
        //�ַ�ջ
        Stack<Object> stack =  getOperation(str);

        //������ջ
        Stack<Double> OPND = new Stack<>();
        //�����ջ
        Stack<Character> OPTR = new Stack<>();
        //��������ջ���һ��������ʶ
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
                //����ѭ��
                if(value == '#'&& OPTR.peek()=='#'){
                    break;
                }
                //��ȡ�������������������ȼ���
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
                        //��ȡ������
                        Double result = expResult(a, theta, b);
                        //�����ջ
                        OPND.push(result);
                        break;
                    default:
                        break;
                }
            }

        }
        if(OPND.size() != 1){
            return "������ִ���";
        }
        return OPND.peek().toString();

    }
    /**
     * @Description :��ȡ������ַ����ĵĺ�׺���ʽ���ַ�ջ
     * @Date 15:30 2020/5/25 0025
     * @Param * @param str ��
     * @return java.util.Stack<java.lang.Object>
     **/
    public   Stack<Object>  getOperation(String str){
        Stack<Object> stack = new Stack<>();
        if(str == null || str.length() == 0){
            return stack;
        }
       //����������
        ArrayList<Character> OPTR = new ArrayList<>();
        //���ǲ��������ַ���ջ+ - * / % ( )
        for(int i = 0;i < str.length();i++){
            char c  = str.charAt(i);
           //�ж����ַ�����
            if(isSymbol(c)){
               //��������ջ
                OPTR.add(c);
            }
        }
        //���ò��������зָ�õ���������
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

       //��ջ����
        Collections.reverse(stack);
        //�����һ����+��-������������Ҫ������Ӧ�Ĵ���
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
   * @Description :��ȡnum1��num2��������
   * @Date 15:29 2020/5/25 0025
   *@param num1��������1
   * @param c �������
   * @param num2 ��������2
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
    * @Description :�ж��ַ����������������
    * @Date 15:28 2020/5/25 0025
    * @Param * @param c ����Ҫ�жϵ��ַ�
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
   * @Description :��ȡ�����ַ����������ȼ��ķ���������ȼ�a>ch���򷵻�">";a =ch���򷵻�"="�����򷵻ء�<��
   * @Date 15:25 2020/5/25 0025
   * @Param  @param a :�����a
   * @param ch �������ch
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
    * @Description :�жϱ��ʽ�Ƿ���ȷ
    * @Date 15:45 2020/5/25 0025
    * @Param * @param code ��
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
     * @Description :�ж��Ƿ���Խ��м���
     * @Date 16:26 2020/5/25 0025
     * @Param * @param str ��
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
