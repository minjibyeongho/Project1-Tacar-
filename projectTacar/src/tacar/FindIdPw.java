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

public class FindIdPw {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;

	public FindIdPw() {
		JFrame f = new JFrame("ID / PW 찾기");
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(93, 117, 62, 18);
		f.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 114, 116, 24);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBirth = new JLabel("BIRTH");
		lblBirth.setBounds(93, 150, 62, 18);
		f.getContentPane().add(lblBirth);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 147, 116, 24);
		f.getContentPane().add(textField_1);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(93, 183, 62, 18);
		f.getContentPane().add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 180, 116, 24);
		f.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("ID찾기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				MemberDTO dto = new MemberDTO();
				String name = textField.getText();
				String birth = textField_1.getText();
				String phone = textField_2.getText();
				
				dto = dao.select(name);
				String name1=dto.getName();
				String birth1=dto.getBirth();
				String phone1=dto.getPhone();
				String id = dto.getId();
				
				if(birth.equals(birth1) && phone.equals(phone1)) {
					JOptionPane.showMessageDialog(null, "ID는 ["+id+"] 입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
				}
			}
		});
		btnNewButton.setBounds(331, 141, 105, 27);
		f.getContentPane().add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(93, 306, 62, 18);
		f.getContentPane().add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(161, 303, 116, 24);
		f.getContentPane().add(textField_3);
		
		JLabel lblPwask = new JLabel("PWASK");
		lblPwask.setBounds(93, 370, 62, 18);
		f.getContentPane().add(lblPwask);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(161, 367, 116, 24);
		f.getContentPane().add(textField_4);
		
		JButton btnPw = new JButton("PW찾기");
		btnPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				MemberDTO dto = new MemberDTO();
				
				String id = textField_3.getText();
				String ans = textField_4.getText();
				
				dto = dao.select(id);
				
				String id1=dto.getId();
				String ans1=dto.getPwask();
				String pw = dto.getPw();
				
				
				if(id.equals(id1)&&ans.equals(ans1)) {
					JOptionPane.showMessageDialog(null, "PW는 ["+pw+"] 입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
				}
			}
		});
		btnPw.setBounds(331, 330, 105, 27);
		f.getContentPane().add(btnPw);
		
		JLabel lblNewLabel_1 = new JLabel("PW찾기 질문");
		lblNewLabel_1.setBounds(93, 336, 184, 24);
		f.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Main");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame name = new MainFrame();
				f.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 60, 79, 27);
		f.getContentPane().add(btnNewButton_1);
		
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
