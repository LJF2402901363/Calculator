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
 * @author: İ����Ӱ
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
        System.out.println( "���ʽ��"+code+"�Ľ���ǣ�"+expResult);
        code = "+4*9+(3*4)";
        expResult = calculatorService.getExpResult(code);
        System.out.println( "���ʽ��"+code+"�Ľ���ǣ�"+expResult);
        code = "-4*9+(3*4)";
        expResult = calculatorService.getExpResult(code);
        System.out.println( "���ʽ��"+code+"�Ľ���ǣ�"+expResult);
        code = "(-5+6)";
        expResult = calculatorService.getExpResult(code);
        System.out.println( "���ʽ��"+code+"�Ľ���ǣ�"+expResult);
    }

    @Test
    public void getOperation() {
        String exp ="";
        Stack<Object> stack = calculatorService.getOperation(exp);
        if (stack.size() == 0){
            System.out.println("���ʽ��"+exp+"ת����Ķ���ջΪ��"+stack);
        }
        exp ="1+5*(8-5)/8%3";
        stack = calculatorService.getOperation(exp);
        System.out.println("���ʽ��"+exp+"ת����Ķ���ջΪ��"+stack);
        exp ="1+5*(8-5)/8-5";
        stack = calculatorService.getOperation(exp);
        System.out.println("���ʽ��"+exp+"ת����Ķ���ջΪ��"+stack);
        exp ="1+5*(8-5)/(8-5)";
        stack = calculatorService.getOperation(exp);
        System.out.println("���ʽ��"+exp+"ת����Ķ���ջΪ��"+stack);

    }

@Test
public  void testSub(){
    //���Լ���
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
        //����ȡģ
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
        //���Գ�����
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
        //���Գ˷�
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
        //���Լӷ�
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
     * @Description :���Ա��ʽ������������ȼ�
     * @Date 19:41 2020/5/25 0025
     * @Param * @param  ��
     * @return void
     **/
    @Test
    public void precede() {
      //����+
        char c='+';
        switch (c)
        {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
        //����/
        c='/';
        switch (c)
        {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
        //����-
            c='-';
            switch (c)
            {
                case '+':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
                case '-':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
                case '*':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
                case '/':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
                case '%':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
                case '(':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
                case ')':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
                case '#':
                    System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
            }
            //����*
            c='*';
            switch (c)
            {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
        //����%
        c='%';
        switch (c)
        {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
        //����(
        c='(';
        switch (c)
        {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
        //����)
        c=')';
        switch (c)
        {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
        //����#
        c='#';
        switch (c)
        {
            case '+':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'+')+"  +");
            case '-':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'-')+"  -");
            case '*':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'*')+"  *");
            case '/':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'/')+"  /");
            case '%':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'%')+"  %");
            case '(':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'(')+"  (");
            case ')':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,')')+"  )");
            case '#':
                System.out.println(c+" �����ȼ�"+ calculatorService.Precede(c,'#')+"  #");
        }
    }
    /**
     * @Description :�����ж�ĳ���ַ��ǲ��������������
     * @Date 18:02 2020/5/25 0025
     * @Param * @param  ��
     * @return void
     **/
    @Test
    public void isSymbol() {
        String code = "4*9+(3*4)/5-6%8";
        for (int i = 0; i < code.length(); i++) {
            boolean fla = calculatorService.isSymbol(code.charAt(i));
            System.out.println("���ַ���"+code.charAt(i)+(fla==true?"�ǲ�����":"�������"));
        }


    }

    @Test
    public void isCanCalculate() {
        String code = "4*9+(3*4)";
        boolean sureCode = calculatorService.isCanCalculate(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "+4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "-4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "*4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "%4*9+(3*4)";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "";
        sureCode = calculatorService.isCanCalculate(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
    }
    /**
     * @Description :��������ı��ʽ�Ƿ���ϼ����ʽ
     * @Date 16:39 2020/5/25 0025
     * @Param * @param  ��
     * @return void
     **/
    @Test
    public void isSureCode() {
        String code = "4*9+(3*4)=";
        boolean sureCode = calculatorService.isSureCode(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "+4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));

        code = "-4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "*4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "%4*9+(3*4)=";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
        code = "";
        sureCode = calculatorService.isSureCode(code);
        System.out.println("���ַ���\""+code+"\""+(sureCode == true?"��ȷ��":"����"));
    }

}