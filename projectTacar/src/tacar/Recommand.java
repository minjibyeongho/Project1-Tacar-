package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.python.modules.math;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class Recommand {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static int br;
	private JTextField textField;

	public Recommand() {

		JFrame f = new JFrame();

		f.setSize(500, 500);

		f.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 482, 100);
		f.getContentPane().add(panel);

		JLabel label = new JLabel("TACAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBounds(0, 0, 190, 47);
		panel.add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "현대", "기아", "쉐보레", "제네시스", "기타" }));
		comboBox.setFont(new Font("돋움", Font.BOLD, 16));
		comboBox.setBounds(34, 141, 160, 40);
		f.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() { // actionlistener를 활용하여 combobox를 선택했을 때 하위 performed를 실행한다.
			public void actionPerformed(ActionEvent e) {
				br = comboBox.getSelectedIndex();
			}
		});

		JButton btnNewButton = new JButton("Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame name = new MainFrame();
				f.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 102, 78, 27);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Go");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 20));

		btnNewButton_1.setBounds(390, 140, 78, 40);
		f.getContentPane().add(btnNewButton_1);

		JLabel lblEngineDisplacement = new JLabel("Engine Displacement");
		lblEngineDisplacement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEngineDisplacement.setBounds(34, 193, 197, 46);
		f.getContentPane().add(lblEngineDisplacement);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(229, 193, 99, 46);
		f.getContentPane().add(textField_1);

		JLabel lblKm = new JLabel("Distance Driven");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKm.setBounds(34, 251, 187, 46);
		f.getContentPane().add(lblKm);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(229, 251, 99, 46);
		f.getContentPane().add(textField_2);

		JLabel lblInsu = new JLabel("Self Damage");
		lblInsu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInsu.setBounds(34, 309, 187, 46);
		f.getContentPane().add(lblInsu);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(229, 309, 99, 46);
		f.getContentPane().add(textField_3);

		JLabel lblCc = new JLabel("CC");
		lblCc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCc.setBounds(329, 193, 53, 46);
		f.getContentPane().add(lblCc);

		JLabel lblKm_1 = new JLabel("Km");
		lblKm_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKm_1.setBounds(329, 251, 53, 46);
		f.getContentPane().add(lblKm_1);

		JLabel label_2 = new JLabel("%");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(329, 309, 53, 46);
		f.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setFont(new Font("돋움", Font.BOLD, 16));
		textField.setBounds(34, 379, 438, 46);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				double cc = Double.parseDouble(textField_1.getText());
				double km = Double.parseDouble(textField_2.getText());
				double per = Double.parseDouble(textField_3.getText());

				try {
//					RR.Regression(); // 계수배열 끌어오기
					CSVLoader loader = new CSVLoader();
					loader.setFieldSeparator(",");
					// 필드의 구분자는 ","쉼표이다

					loader.setSource(new File("C:\\Users\\mos46\\Desktop\\K-391\\preview_final.csv"));
					Instances data = loader.getDataSet();
					System.out.println("1.데이터가져오기 완료");

					data.setClassIndex(data.numAttributes() - 1);
					// 뒤에서 첫번째 필드를 종속변수로 설정함

					LinearRegression model = new LinearRegression();
					model.buildClassifier(data);

					System.out.println("2.선형회귀모델 : \n" + model);

					double coef[] = model.coefficients(); // 상관계수

					System.out.println("진행성공");

					for (int i = 0; i < coef.length; i++) {
						System.out.println(coef[i]);
					}

					double price = (cc * coef[0]) + (km * coef[1]) + (br * coef[2]) + (per * coef[3]) + coef[5];
//					label_1.setText("조건에 해당하는 차량 적정가는 : " + price+ "원 입니다.");
					textField.setText("조건에 해당하는 차량 적정가는 " + math.floor(price) + "만원 입니다.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		f.setVisible(true);

	}
	public Recommand(String id) {

		JFrame f = new JFrame();

		f.setSize(500, 500);

		f.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 482, 100);
		f.getContentPane().add(panel);

		JLabel label = new JLabel("TACAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBounds(0, 0, 190, 47);
		panel.add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "현대", "기아", "쉐보레", "제네시스", "기타" }));
		comboBox.setFont(new Font("돋움", Font.BOLD, 16));
		comboBox.setBounds(34, 141, 160, 40);
		f.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() { // actionlistener를 활용하여 combobox를 선택했을 때 하위 performed를 실행한다.
			public void actionPerformed(ActionEvent e) {
				br = comboBox.getSelectedIndex();
			}
		});

		JButton btnNewButton = new JButton("Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrameLogIn name = new MainFrameLogIn(id);
				f.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 102, 78, 27);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Go");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 20));

		btnNewButton_1.setBounds(390, 140, 78, 40);
		f.getContentPane().add(btnNewButton_1);

		JLabel lblEngineDisplacement = new JLabel("Engine Displacement");
		lblEngineDisplacement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEngineDisplacement.setBounds(34, 193, 197, 46);
		f.getContentPane().add(lblEngineDisplacement);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(229, 193, 99, 46);
		f.getContentPane().add(textField_1);

		JLabel lblKm = new JLabel("Distance Driven");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKm.setBounds(34, 251, 187, 46);
		f.getContentPane().add(lblKm);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(229, 251, 99, 46);
		f.getContentPane().add(textField_2);

		JLabel lblInsu = new JLabel("Self Damage");
		lblInsu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInsu.setBounds(34, 309, 187, 46);
		f.getContentPane().add(lblInsu);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(229, 309, 99, 46);
		f.getContentPane().add(textField_3);

		JLabel lblCc = new JLabel("CC");
		lblCc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCc.setBounds(329, 193, 53, 46);
		f.getContentPane().add(lblCc);

		JLabel lblKm_1 = new JLabel("Km");
		lblKm_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKm_1.setBounds(329, 251, 53, 46);
		f.getContentPane().add(lblKm_1);

		JLabel label_2 = new JLabel("%");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(329, 309, 53, 46);
		f.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setFont(new Font("돋움", Font.BOLD, 16));
		textField.setBounds(34, 379, 438, 46);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				double cc = Double.parseDouble(textField_1.getText());
				double km = Double.parseDouble(textField_2.getText());
				double per = Double.parseDouble(textField_3.getText());

				try {
//					RR.Regression(); // 계수배열 끌어오기
					CSVLoader loader = new CSVLoader();
					loader.setFieldSeparator(",");
					// 필드의 구분자는 ","쉼표이다

					loader.setSource(new File("C:\\Users\\mos46\\Desktop\\K-391\\preview_final.csv"));
					Instances data = loader.getDataSet();
					System.out.println("1.데이터가져오기 완료");

					data.setClassIndex(data.numAttributes() - 1);
					// 뒤에서 첫번째 필드를 종속변수로 설정함

					LinearRegression model = new LinearRegression();
					model.buildClassifier(data);

					System.out.println("2.선형회귀모델 : \n" + model);

					double coef[] = model.coefficients(); // 상관계수

					System.out.println("진행성공");

					for (int i = 0; i < coef.length; i++) {
						System.out.println(coef[i]);
					}

					double price = (cc * coef[0]) + (km * coef[1]) + (br * coef[2]) + (per * coef[3]) + coef[5];
					textField.setText("조건에 해당하는 차량 적정가는 " + math.floor(price) + "만원 입니다.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		f.setVisible(true);

	}
}
