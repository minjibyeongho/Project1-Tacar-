package tacar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class SignUp2 {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public SignUp2(MemberDTO dto) {

		JFrame f = new JFrame();
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("* PWASK");
		lblNewLabel.setBounds(90, 109, 62, 18);
		f.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(208, 109, 116, 24);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPw = new JLabel("OWNNERD");
		lblPw.setBounds(90, 142, 91, 18);
		f.getContentPane().add(lblPw);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 142, 116, 24);
		f.getContentPane().add(textField_1);

		JLabel lblPwcheck = new JLabel("EMAIL");
		lblPwcheck.setBounds(90, 175, 104, 18);
		f.getContentPane().add(lblPwcheck);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 175, 116, 24);
		f.getContentPane().add(textField_2);

		JLabel lblName = new JLabel("PURPOSE");
		lblName.setBounds(90, 208, 62, 18);
		f.getContentPane().add(lblName);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(208, 208, 116, 24);
		f.getContentPane().add(textField_3);

		JLabel lblBirth = new JLabel("ADMINKEY");
		lblBirth.setBounds(90, 244, 104, 18);
		f.getContentPane().add(lblBirth);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(208, 244, 116, 24);
		f.getContentPane().add(textField_4);

		JButton btnNewButton_1 = new JButton("가입하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MemberDAO dao = new MemberDAO();

				String pwask = textField.getText();
				String ownnered = textField_1.getText();
				String email = textField_2.getText();
				String purpose = textField_3.getText();
				String adminkey = textField_4.getText();

				dto.setPwask(pwask);
				dto.setOwnnered(ownnered);
				dto.setEmail(email);
				dto.setPurpose(purpose);
				dto.setAdminkey(adminkey);

				if (pwask.equals("")) {
					JOptionPane.showMessageDialog(null, "필수 항목을 입력하세요.");
				} else {

					dao.insert(dto);
					f.setVisible(false);

					MainFrame name = new MainFrame();
				}

			}
		});
		btnNewButton_1.setBounds(282, 308, 105, 27);
		f.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Main");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame name = new MainFrame();
				f.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(0, 72, 68, 27);
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

		f.setSize(500, 500);
		f.setVisible(true);

	}
}
