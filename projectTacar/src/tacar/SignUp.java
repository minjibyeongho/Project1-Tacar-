package tacar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class SignUp {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	int idi;

	public SignUp() {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("* ID");
		lblNewLabel.setBounds(90, 109, 62, 18);
		f.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(208, 109, 116, 24);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPw = new JLabel("* PW");
		lblPw.setBounds(90, 142, 62, 18);
		f.getContentPane().add(lblPw);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 142, 116, 24);
		f.getContentPane().add(textField_1);

		JLabel lblPwcheck = new JLabel("* PWCHECK");
		lblPwcheck.setBounds(90, 175, 104, 18);
		f.getContentPane().add(lblPwcheck);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 175, 116, 24);
		f.getContentPane().add(textField_2);

		JLabel lblName = new JLabel("* NAME");
		lblName.setBounds(90, 208, 62, 18);
		f.getContentPane().add(lblName);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(208, 208, 116, 24);
		f.getContentPane().add(textField_3);

		JLabel lblBirth = new JLabel("BIRTH");
		lblBirth.setBounds(90, 244, 62, 18);
		f.getContentPane().add(lblBirth);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(208, 244, 116, 24);
		f.getContentPane().add(textField_4);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(90, 280, 62, 18);
		f.getContentPane().add(lblGender);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(208, 280, 116, 24);
		f.getContentPane().add(textField_5);

		JLabel lblAddress = new JLabel("* ADDRESS");
		lblAddress.setBounds(90, 313, 104, 18);
		f.getContentPane().add(lblAddress);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(208, 313, 116, 24);
		f.getContentPane().add(textField_6);

		JLabel lblPhone = new JLabel("* PHONE");
		lblPhone.setBounds(90, 349, 62, 18);
		f.getContentPane().add(lblPhone);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(208, 349, 116, 24);
		f.getContentPane().add(textField_7);

		JButton btnNewButton = new JButton("중복검사");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();
				String id = textField.getText();
				dto = dao.select(id);
				try {
					if (dto == null) {
						JOptionPane.showMessageDialog(null, "사용가능");
						idi = 1;
					} else {
						JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
						idi = 0;
					}
				} catch (Exception e1) {
					System.out.println("중복검색 중 오류발생");
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(338, 105, 105, 27);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("다음");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();

				String id = textField.getText();
				String pw = textField_1.getText();
				String pwcheck = textField_2.getText();
				String name = textField_3.getText();
				String birth = textField_4.getText();
				String gender = textField_5.getText();
				String address = textField_6.getText();
				String phone = textField_7.getText();

				dto.setId(id);
				dto.setPw(pw);
				dto.setPwcheck(pwcheck);
				dto.setName(name);
				dto.setBirth(birth);
				dto.setGender(gender);
				dto.setAddress(address);
				dto.setPhone(phone);

				if (idi == 1) {
					if (pw.equals("") || pwcheck.equals("") || name.equals("") || address.equals("")
							|| phone.equals("")) {

						JOptionPane.showMessageDialog(null, "필수 항목을 입력하세요.");
					} else {
						SignUp2 login2 = new SignUp2(dto);
						f.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "ID 중복검사를 실행하세요.");
				}

			}
		});
		btnNewButton_1.setBounds(276, 400, 105, 27);
		f.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Main");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame name = new MainFrame();
				f.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(0, 62, 68, 27);
		f.getContentPane().add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 481, 60);
		f.getContentPane().add(panel);

		JLabel label = new JLabel("TACAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBounds(0, 0, 190, 47);
		panel.add(label);
		
		JLabel label_1 = new JLabel("* 필수항목");
		label_1.setFont(new Font("돋움", Font.BOLD, 14));
		label_1.setBounds(46, 376, 104, 36);
		f.getContentPane().add(label_1);

		f.setSize(500, 500);
		f.setVisible(true);

	}
}
