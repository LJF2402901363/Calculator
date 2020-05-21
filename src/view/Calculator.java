package view;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author İ����Ӱ
 TODO :ģ�������
 *2019��12��17��  ����5:39:20
 */
public class Calculator extends JFrame{

private static final long serialVersionUID = 1L;
  private Container contentPanel = null;
  private JButton[] btns = new JButton[22];
  private JTextArea textArea  = null;
  private static final String[] names ={
		  "C","ɾ��","%","/",
		  "7","8","9","*",
		  "4","5","6","-",
		  "1","2","3","+",
		  " ","0",".","=",
		  "(",")"
  };
  @SuppressWarnings("javadoc")
public Calculator(){
	  this.setTitle("������");
	  this.setBounds(300, 100, 600, 580);
	  this.contentPanel = this.getContentPane();
	  this.textArea = new JTextArea();
	  textArea.setFont(new Font("΢���ź�",Font.BOLD,14));
	  initConponents();
	  this.setVisible(true);
	  this.setResizable(false);
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
private void initConponents() {
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	this.textArea.setPreferredSize(new Dimension(580,200));
	 panel1.add(this.textArea);
	 panel.add(panel1);
	   GridLayout gridLayout = new GridLayout(6,4);
	   JPanel panel2 = new JPanel(gridLayout);
	   panel2.setPreferredSize(new Dimension(600,320));
	   for(int i = 0;i < names.length;i++){
		   this.btns[i] = new JButton(names[i]); 
	   }
	   //���������İ�ť����¼�
	   ClearBtnActionEvent();
	   //��ɾ���İ�ť����¼�
	   delBtnActionEvent();
	   for(int i = 2; i < this.btns.length;i++){
		   if(i == 19){
			   //���Ⱥ� =��ť����¼�
			   ResultActionEvent(this.btns[i]);
		   }else{
			   //�����ְ�ť����¼�
			   digBtnEvent(this.btns[i]);
		   }
	   }
	  
	   Font font = new Font("΢���ź�",Font.BOLD,16);
	   for(int i = 0;i  < this.btns.length;i++){
		   this.btns[i].setFont(font);
		   panel2.add(this.btns[i]);
	   }
	   panel.add(panel2);
	   this.contentPanel.add(panel);
}
/***
 * �ȺŽ�����¼�
 * @param btn
 */
private void ResultActionEvent(JButton btn) {
	 btn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String exp = textArea.getText();
			boolean fla = isCanCalculate(exp);
			if(!fla){
				JOptionPane.showConfirmDialog(Calculator.this, "�����ʽ�����޷����㣡");
				return ;
			}
			String reultValue =  exp+"="+getExpResult(exp.trim());
			if(reultValue != null &&reultValue.trim().length()!= 0 ){
						textArea.setText(reultValue);
			}else{
				JOptionPane.showConfirmDialog(Calculator.this, "��������");
			}
		}
	});
}
/**
 * ���ظñ��ʽ�Ƿ��ʽ��ȷ�ܽ��м���
 * @param str
 * @return ��ȷ����true�����򷵻�false
 */
private boolean isCanCalculate(String str){
	if(str == null||str.trim().length() == 0){
		return false;
	}
	
	if(str.startsWith("*")||str.startsWith("/")||str.startsWith("%")|| str.contains("=")){
		return false;
	}
	if(!isSureCode(str)){
		return false;
	}
	return true ;
	
}
/**
 * @return �����жϱ��ʽ������
 */
public boolean isSureCode(String code) {
	
	if(code.isEmpty() || code.length() == 0) {
		return false;
	}
	 Map<Integer,Character> map1 = new HashMap<Integer,Character>();
	 Map<Integer,Character> map2 =new HashMap<Integer,Character>();
	 Stack<Character> stack = new Stack<>();
	 map1.put(0,'{');
	 map1.put(1,'[');
	 map1.put(2,'(');
	 map2.put(0,'}');
	 map2.put(1,']');
	 map2.put(2,')');
	char temp = '\0';
	for(int i = 0;i < code.length();i++) {
		temp = code.charAt(i);
		if(map1.containsValue(temp)) {
		 stack.push(temp);
		}else if(map2.containsValue(temp)) {
			char pop = '\0';
			try {
				 pop = stack.pop();
			} catch (Exception e) {
				return false;
			}
			for(int j = 0;j < map2.size();j++) {
				if(temp ==map2.get(j)) {
					if(pop != map1.get(j)) {
						return false;
					}
				}
			}
			
		}
	}
	 if(stack.size() != 0){
		 return false;
	 }
		return true;
	 
 }


/**
 * ɾ����ť���¼�
 */
private void delBtnActionEvent() {
this.btns[1].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		 String text = textArea.getText().trim();
		 if(text.length() == 0){
			 return;
		 }
		 text = text.substring(0, text.length()-1) ;
		 textArea.setText(text);
		}
	});;
}
/**
 * �����ť�ļ����¼�
 */
private void ClearBtnActionEvent() {
	this.btns[0].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
		}
	});;
}
/**
 * ���е����ְ�ť�Ͳ�������ť���¼�����
 * @param btn
 */
  private void   digBtnEvent(JButton btn){
	  btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 String text = textArea.getText().trim();
			 text = text+ btn.getText() ;
			 textArea.setText(text);
		}
	});
	  
  }
  /**
   * ��ȡ���ʽ��ֵ
   * @param str
   * @return ����һ�����ʽ��ֵ�ַ���
   */
  private String getExpResult(String str){
	  if(str == null || str.length() == 0){
		  return "";
	  }
	  //�ڱ��ʽβ������һ��������ʶ
	  str = str+"#";
	  //��ȡ���ʽÿ��Ԫ�صĶ���ջ
	  Stack<Object>  stack =  getOperation(str);
	  //������ջ
	  Stack<Double> OPND = new Stack<>();
	  //����ջ
	  Stack<Character> OPTR = new Stack<>();
	  //������ջ���һ�������ı�ʶ
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
			  //�����ж�����ѭ��
			  if(value == '#'&& OPTR.peek()=='#'){
				  break;
			  }
			  //��ȡ��������ȼ�
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
		 return "�������";
	 }
		return OPND.peek().toString();
		
	}
 /***
  * �����ʽ���ַ����з�Ϊ�������������,Ȼ�����δ�ŵ�����ջ��
  * ���磺(8-4)*4+6#  �ֽ�Ϊ ջ{(,8,-,4,),*,4,+,6,#}
  * @param str
  * @return  ����һ������ջ
  */
  private  Stack<Object>  getOperation(String str){
	  Stack<Object> stack = new Stack<>();
	  if(str == null || str.length() == 0){
		  return stack;
	  }
	  //���ż���
	  ArrayList<Character> OPTR = new ArrayList<>();
	  //��ȡ���еķ��ţ�����+ - * / % ( )
	  for(int i = 0;i < str.length();i++){
		  char c  = str.charAt(i);
		  //�ж��Ƿ��Ƿ���
		  if(isSymbol(c)){
			  //��������ӵ����ż�����
			  OPTR.add(c);
		  }
		  }
	  //���÷���Ϊ�ֽ��߽��������ͷ�����һ�ָ����Ȼ����ӵ�����ջ��
	  for(int i = 0;i < OPTR.size();i++){
		int index = str.indexOf(OPTR.get(i));
		String value = str.substring(0,index);
		if(value.trim().length() != 0){
			stack.push(Double.valueOf(value));
		}
		stack.push(OPTR.get(i));
		str = str.substring(index+1);
	  }
	  //��ջ�����ݵ���
	  Collections.reverse(stack);
	  //������ʽ��+��-��ʼ����ջ��Ԫ��Ϊ+��-����ô��Ҫ��-��+��ǰ����һ��double 0.00
	  Object o = stack.peek();
	  if(o instanceof Character){
		  Character c = (Character) o;
		  if(c == '-'||c == '+'){
			  stack.push(0.0);
		  }
	  }
	  //����һ������ջ
	  return stack;
	  }
  
  /**
   * ��ȡ����������������
   * @param num1
   * @param c
   * @param num2
   * @return
   */
  private double expResult(double num1, char c,double num2)
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
 * @param c
 * @return  ���ظ��ַ��Ƿ��������
 */
  private boolean isSymbol(char c)
  {
		if (c == '+'||c == '-'||c=='*'|| c == '/' ||c== '%' || c =='('||c =='#'||c==')')
		{
			return true;

		}

		return false;
	}
  /**
   * ��������������������ȼ�
   * @param a
   * @param ch
   * @return 
   */
  private  char Precede(char a, char ch) {
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
  
  
}
