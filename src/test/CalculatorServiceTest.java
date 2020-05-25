package test;

import Service.CalculatorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Classname:Calculator
 *
 * @description:{description}
 * @author: 陌意随影
 * @Date: 2020-05-25 16:52
 */
public class CalculatorServiceTest {
    CalculatorService calculatorService = null;
    @Before
    public void setUp() throws Exception {
        calculatorService = new CalculatorService();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getExpResult() {
        String code = "4*9+(3*4)";
        String expResult = calculatorService.getExpResult(code);
        System.out.println( "表达式："+code+"的结果是："+expResult);
        code = "+4*9+(3*4)";
        expResult = calculatorService.getExpResult(code);
        System.out.println( "表达式："+code+"的结果是："+expResult);
        code = "-4*9+(3*4)";
        expResult = calculatorService.getExpResult(code);
        System.out.println( "表达式："+code+"的结果是："+expResult);
        code = "(-5+6)";
        expResult = calculatorService.getExpResult(code);
        System.out.println( "表达式："+code+"的结果是："+expResult);
    }

    @Test
    public void getOperation() {
        String exp ="";
        Stack<Object> stack = calculatorService.getOperation(exp);
        if (stack.size() == 0){
            System.out.println("表达式："+exp+"转化后的对象栈为："+stack);
        }
        exp ="1+5*(8-5)/8%3";
        stack = calculatorService.getOperation(exp);
        System.out.println("表达式："+exp+"转化后的对象栈为："+stack);
        exp ="1+5*(8-5)/8-5";
        stack = calculatorService.getOperation(exp);
        System.out.println("表达式："+exp+"转化后的对象栈为："+stack);
        exp ="1+5*(8-5)/(8-5)";
        stack = calculatorService.getOperation(exp);
        System.out.println("表达式："+exp+"转化后的对象栈为："+stack);

    }

@Test
public  void testSub(){
    //测试减法
   char c = '-';
    double num1=4;
    double num2 = 5;
    double result = calculatorService.expResult(num1, c, num2);
    System.out.println(num1+"-"+num2+"="+result);
    num1=-4;
    num2 = 5;
    result = calculatorService.expResult(num1, c, num2);
    System.out.println(num1+"-"+num2+"="+result);
    num1=-4;
    num2 =- 5;
    result = calculatorService.expResult(num1, c, num2);
    System.out.println(num1+"-"+num2+"="+result);
}
    @Test
    public  void testMod(){
        //测试取模
        char c = '%';
        double num1=4;
        double num2 = 5;
        double result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"%"+num2+"="+result);
        num1=-40;
        num2 = 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"%"+num2+"="+result);
        num1=-4;
        num2 =- 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"%"+num2+"="+result);
        num1=-4;
        num2 = 0;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"%"+num2+"="+result);
    }
    @Test
    public  void testDivid(){
        //测试除法法
        char c = '/';
        double num1=4;
        double num2 = 5;
        double result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"/"+num2+"="+result);
        num1=-4;
        num2 = 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"/"+num2+"="+result);
        num1=-4;
        num2 =- 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"/"+num2+"="+result);
        num1=0;
        num2 =- 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"/"+num2+"="+result);
        num1=-4;
        num2 =0;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"/"+num2+"="+result);
    }
    @Test
    public  void testMutility(){
        //测试乘法
        char c = '*';
        double num1=4;
        double num2 = 5;
        double result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"*"+num2+"="+result);
        num1=-4;
        num2 = 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"*"+num2+"="+result);
        num1=-4;
        num2 =- 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"*"+num2+"="+result);
        num1=0;
        num2 =- 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"*"+num2+"="+result);
        num1=-4;
        num2 =0;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"*"+num2+"="+result);
    }
    @Test
    public void testAdd() {
        //测试加法
        char c = '+';
        double num1=4;
        double num2 = 5;
        double result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"+"+num2+"="+result);
        num1=-4;
        num2 = 5;
      result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"+"+num2+"="+result);
        num1=-4;
        num2 =- 5;
        result = calculatorService.expResult(num1, c, num2);
        System.out.println(num1+"+"+num2+"="+result);


    }

    /**
     * @Description :测试表达式中运算符的优先级
     * @Date 19:41 2020/5/25 0025
     * @Param * @param  ：
     * @return void
     **/
    @Test
    public void precede() {
      //测试+
        char c='+';
        switch (c)
        {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
        //测试/
        c='/';
        switch (c)
        {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
        //测试-
            c='-';
            switch (c)
            {
                case '+':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
                case '-':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
                case '*':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
                case '/':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
                case '%':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
                case '(':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
                case ')':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
                case '#':
                    System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
            }
            //测试*
            c='*';
            switch (c)
            {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
        //测试%
        c='%';
        switch (c)
        {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
        //测试(
        c='(';
        switch (c)
        {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
        //测试)
        c=')';
        switch (c)
        {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
        //测试#
        c='#';
        switch (c)
        {
            case '+':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" 的优先级"+ calculatorService.Precede(c,'#')+"  #");
        }
    }
    /**
     * @Description :测试判断某个字符是操作数还是运算符
     * @Date 18:02 2020/5/25 0025
     * @Param * @param  ：
     * @return void
     **/
    @Test
    public void isSymbol() {
        String code = "4*9+(3*4)/5-6%8";
        for (int i = 0; i < code.length(); i++) {
            boolean fla = calculatorService.isSymbol(code.charAt(i));
            System.out.println("该字符："+code.charAt(i)+(fla==true?"是操作符":"是运算符"));
        }


    }

    @Test
    public void isCanCalculate() {
        String code = "4*9+(3*4)";
        boolean sureCode = calculatorService.isCanCalculate(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "+4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "-4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "*4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "%4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
    }
    /**
     * @Description :测试输入的表达式是否符合计算格式
     * @Date 16:39 2020/5/25 0025
     * @Param * @param  ：
     * @return void
     **/
    @Test
    public void isSureCode() {
        String code = "4*9+(3*4)=";
        boolean sureCode = calculatorService.isSureCode(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "+4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));

        code = "-4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "*4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "%4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
        code = "";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("该字符串\""+code+"\""+(sureCode == true?"正确！":"错误"));
    }

}