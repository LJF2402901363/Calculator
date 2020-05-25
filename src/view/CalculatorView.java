package view;
import Controller.CalculatorController;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @Description :��������UI����
 **/
public class CalculatorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container contentPanel = null;
	private JButton[] btns = new JButton[22];
	private JTextArea textArea = null;
	CalculatorController calculatorController = new CalculatorController();
	private static final String[] names = {
			"C", "����", "%", "/",
			"7", "8", "9", "*",
			"4", "5", "6", "-",
			"1", "2", "3", "+",
			" ", "0", ".", "=",
			"(", ")"
	};

	@SuppressWarnings("javadoc")
	public CalculatorView() {
		this.setTitle("������");
		this.setBounds(300, 100, 600, 580);
		this.contentPanel = this.getContentPane();
		this.textArea = new JTextArea();
		textArea.setFont(new Font("΢���ź�", Font.BOLD, 14));
		initConponents();
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initConponents() {
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		this.textArea.setPreferredSize(new Dimension(580, 200));
		panel1.add(this.textArea);
		panel.add(panel1);
		GridLayout gridLayout = new GridLayout(6, 4);
		JPanel panel2 = new JPanel(gridLayout);
		panel2.setPreferredSize(new Dimension(600, 320));
		for (int i = 0; i < names.length; i++) {
			this.btns[i] = new JButton(names[i]);
		}
		//����հ�ť��ӵ���¼�
		ClearBtnActionEvent();
		//��ɾ����ť��ӵ���¼�
		delBtnActionEvent();
		for (int i = 2; i < this.btns.length; i++) {
			if (i == 19) {
				//�������ť��ӵ���¼�
				ResultActionEvent(this.btns[i]);
			} else {
				//�����ְ�ť��ӵ���¼�
				digBtnEvent(this.btns[i]);
			}
		}

		Font font = new Font("΢���ź�", Font.BOLD, 16);
		for (int i = 0; i < this.btns.length; i++) {
			this.btns[i].setFont(font);
			panel2.add(this.btns[i]);
		}
		panel.add(panel2);
		this.contentPanel.add(panel);
	}
/**
 * @Description :����ť��ӵ���¼�
 * @Date 15:45 2020/5/25 0025
 * @Param * @param btn ��
 * @return void
 **/
	private void ResultActionEvent(JButton btn) {

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String exp = textArea.getText();
				//�ж��Ƿ���Խ��м���
				boolean fla = calculatorController.isCanCalculate(exp);
				if (!fla) {
					JOptionPane.showConfirmDialog(CalculatorView.this, "�������");
					return;
				}
				String reultValue = exp + "=" + calculatorController.getExpResult(exp.trim());
				if (reultValue != null && reultValue.trim().length() != 0) {
					textArea.setText(reultValue);
				} else {
					JOptionPane.showConfirmDialog(CalculatorView.this, "�������");
				}
			}
		});
	}






	/**
	 * @Description :��ɾ����ť��ӵ���¼�
	 * @Date 16:26 2020/5/25 0025
	 * @Param * @param  ��
	 * @return void
	 **/
	private void delBtnActionEvent() {
		this.btns[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText().trim();
				if (text.length() == 0) {
					return;
				}
				text = text.substring(0, text.length() - 1);
				textArea.setText(text);
			}
		});
		;
	}

	/**
	 * ����հ�ť��ӵ���¼�
	 */
	private void ClearBtnActionEvent() {
		this.btns[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		;
	}
/**
 * @Description :�����е����ְ�����ӵ���¼�
 * @Date 16:31 2020/5/25 0025
 * @Param * @param btn ��
 * @return void
 **/
	private void digBtnEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText().trim();
				text = text + btn.getText();
				textArea.setText(text);
			}
		});

	}


}
