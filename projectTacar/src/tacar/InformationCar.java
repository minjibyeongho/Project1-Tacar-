package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InformationCar {

	public InformationCar() {

		JFrame f = new JFrame();
		f.setSize(1000, 800);
		f.setTitle("차량정보");
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 982, 100);
		f.getContentPane().add(panel);
		
		JLabel label = new JLabel("TACAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBounds(0, 0, 190, 47);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 98, 982, 655);
		panel_1.setLayout(null);
		f.getContentPane().add(panel_1);
		
		JButton picture1 = new JButton("사진1");
		picture1.setBounds(14, 12, 557, 598);
		panel_1.add(picture1);
		
		JLabel lblNewLabel = new JLabel("제조사 : ");
		lblNewLabel.setFont(new Font("돋움", Font.BOLD, 25));
		lblNewLabel.setBounds(585, 12, 124, 31);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("차종 : ");
		lblNewLabel_1.setFont(new Font("돋움", Font.BOLD, 25));
		lblNewLabel_1.setBounds(585, 98, 99, 34);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("가격 : ");
		lblNewLabel_2.setFont(new Font("돋움", Font.BOLD, 25));
		lblNewLabel_2.setBounds(585, 144, 124, 31);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("키로수 : ");
		lblNewLabel_3.setFont(new Font("돋움", Font.BOLD, 25));
		lblNewLabel_3.setBounds(585, 188, 124, 31);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("연식 : ");
		lblNewLabel_4.setFont(new Font("돋움", Font.BOLD, 25));
		lblNewLabel_4.setBounds(585, 233, 124, 28);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("위치 : ");
		lblNewLabel_5.setFont(new Font("돋움", Font.BOLD, 25));
		lblNewLabel_5.setBounds(585, 273, 149, 31);
		panel_1.add(lblNewLabel_5);
		
		JLabel label_1 = new JLabel("차량번호 : ");
		label_1.setFont(new Font("돋움", Font.BOLD, 25));
		label_1.setBounds(585, 529, 149, 31);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("보증기간 : ");
		label_2.setFont(new Font("돋움", Font.BOLD, 25));
		label_2.setBounds(585, 489, 149, 31);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("옵션 : ");
		label_3.setFont(new Font("돋움", Font.BOLD, 25));
		label_3.setBounds(585, 444, 149, 33);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("트랜스미션 : ");
		label_4.setFont(new Font("돋움", Font.BOLD, 25));
		label_4.setBounds(585, 400, 164, 32);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("연료종류 : ");
		label_5.setFont(new Font("돋움", Font.BOLD, 25));
		label_5.setBounds(585, 358, 149, 31);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("색상 : ");
		label_6.setFont(new Font("돋움", Font.BOLD, 25));
		label_6.setBounds(585, 316, 124, 28);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("차종명 : ");
		label_7.setFont(new Font("돋움", Font.BOLD, 25));
		label_7.setBounds(585, 55, 124, 31);
		panel_1.add(label_7);
		
		JLabel label_16 = new JLabel("1");
		label_16.setFont(new Font("돋움", Font.BOLD, 25));
		label_16.setBounds(736, 358, 232, 31);
		panel_1.add(label_16);
		
		JLabel label_8 = new JLabel("1");
		label_8.setFont(new Font("돋움", Font.BOLD, 25));
		label_8.setBounds(736, 316, 232, 31);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("1");
		label_9.setFont(new Font("돋움", Font.BOLD, 25));
		label_9.setBounds(736, 233, 232, 31);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("1");
		label_10.setFont(new Font("돋움", Font.BOLD, 25));
		label_10.setBounds(736, 275, 232, 31);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("1");
		label_11.setFont(new Font("돋움", Font.BOLD, 25));
		label_11.setBounds(736, 144, 232, 31);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("1");
		label_12.setFont(new Font("돋움", Font.BOLD, 25));
		label_12.setBounds(736, 186, 232, 31);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("1");
		label_13.setFont(new Font("돋움", Font.BOLD, 25));
		label_13.setBounds(736, 55, 232, 31);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("1");
		label_14.setFont(new Font("돋움", Font.BOLD, 25));
		label_14.setBounds(736, 97, 232, 31);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("1");
		label_15.setFont(new Font("돋움", Font.BOLD, 25));
		label_15.setBounds(736, 12, 232, 31);
		panel_1.add(label_15);
		
		JLabel label_17 = new JLabel("1");
		label_17.setFont(new Font("돋움", Font.BOLD, 25));
		label_17.setBounds(736, 525, 232, 31);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("1");
		label_18.setFont(new Font("돋움", Font.BOLD, 25));
		label_18.setBounds(736, 483, 232, 31);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("1");
		label_19.setFont(new Font("돋움", Font.BOLD, 25));
		label_19.setBounds(736, 442, 232, 31);
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("1");
		label_20.setFont(new Font("돋움", Font.BOLD, 25));
		label_20.setBounds(736, 400, 232, 31);
		panel_1.add(label_20);

		
		
		
		
		
		f.setVisible(true);

	}
}
