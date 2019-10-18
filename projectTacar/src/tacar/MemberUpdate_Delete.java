package tacar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Member;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class MemberUpdate_Delete {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	public MemberUpdate_Delete(String id) {
		JFrame f = new JFrame();
		MemberDTO dto2 = new MemberDTO();
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setBounds(118, 84, 57, 15);
		f.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(208, 84, 116, 21);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPwcheck = new JLabel("PWCHECK");
		lblPwcheck.setBounds(118, 115, 78, 15);
		f.getContentPane().add(lblPwcheck);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 115, 116, 21);
		f.getContentPane().add(textField_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(118, 146, 57, 15);
		f.getContentPane().add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 146, 116, 21);
		f.getContentPane().add(textField_2);
		
		JLabel lblBirth = new JLabel("BIRTH");
		lblBirth.setBounds(118, 177, 57, 15);
		f.getContentPane().add(lblBirth);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(208, 177, 116, 21);
		f.getContentPane().add(textField_3);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(118, 208, 57, 15);
		f.getContentPane().add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(208, 208, 116, 21);
		f.getContentPane().add(textField_4);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(118, 239, 57, 15);
		f.getContentPane().add(lblPhone);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(208, 239, 116, 21);
		f.getContentPane().add(textField_5);
		
		JLabel lblPwask = new JLabel("PWASK");
		lblPwask.setBounds(118, 270, 57, 15);
		f.getContentPane().add(lblPwask);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(208, 270, 116, 21);
		f.getContentPane().add(textField_6);
		
		JLabel lblOwnnered = new JLabel("OWNNERED");
		lblOwnnered.setBounds(118, 301, 78, 15);
		f.getContentPane().add(lblOwnnered);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(208, 301, 116, 21);
		f.getContentPane().add(textField_7);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(118, 332, 57, 15);
		f.getContentPane().add(lblEmail);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(208, 332, 116, 21);
		f.getContentPane().add(textField_8);
		
		JLabel lblPurpose = new JLabel("PURPOSE");
		lblPurpose.setBounds(118, 360, 57, 15);
		f.getContentPane().add(lblPurpose);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(208, 360, 116, 21);
		f.getContentPane().add(textField_9);
		
		JLabel lblAdminkey = new JLabel("ADMINKEY");
		lblAdminkey.setBounds(118, 391, 78, 15);
		f.getContentPane().add(lblAdminkey);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(208, 391, 116, 21);
		f.getContentPane().add(textField_10);
		
		dto = dao.select(id);
		
		textField.setText(dto.getPw());
		textField_1.setText(dto.getPw());
		textField_2.setText(dto.getName());
		textField_3.setText(dto.getBirth());
		textField_4.setText(dto.getGender());		
		textField_5.setText(dto.getAddress());
		textField_6.setText(dto.getPhone());
		textField_7.setText(dto.getPwask());
		textField_8.setText(dto.getOwnnered());
		textField_9.setText(dto.getEmail());
		textField_10.setText(dto.getPurpose());
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pw = textField.getText();
				String pwcheck = textField_1.getText();
				String name = textField_2.getText();
				String birth = textField_3.getText();
				String address = textField_4.getText();
				String phone = textField_5.getText();
				String pwask = textField_6.getText();
				String ownnered = textField_7.getText();
				String email = textField_8.getText();
				String purpose = textField_9.getText();
				String adminkey = textField_10.getText();
				
				dto2.setId(id);
				dto2.setPw(pw);
				dto2.setPwcheck(pwcheck);
				dto2.setName(name);
				dto2.setBirth(birth);
				dto2.setAddress(address);
				dto2.setPhone(phone);
				dto2.setPwask(pwask);
				dto2.setOwnnered(ownnered);
				dto2.setEmail(email);
				dto2.setPurpose(purpose);
				dto2.setAdminkey(adminkey);
				
				dao.update(dto2);
				JOptionPane.showMessageDialog(null, "수정완료");
				f.setVisible(false);
				MainFrameLogIn name1 = new MainFrameLogIn(id);
			}
		});
		
		btnNewButton.setBounds(188, 428, 71, 23);
		f.getContentPane().add(btnNewButton);
		
		JButton button_6 = new JButton("탈퇴하기");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDTO dto = new MemberDTO();
				
				dto = dao.select(id);
				
				String pw1 = JOptionPane.showInputDialog("비밀번호를 재 입력하세요.");
				if(pw1.equals(dto.getPw())) {
					dao.delete(dto);
					JOptionPane.showMessageDialog(null, "이용해주셔서 감사합니다.");
					f.setVisible(false);
					MainFrame name = new MainFrame();
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				}
				
			}
		});
		button_6.setBounds(375, 428, 97, 23);
		f.getContentPane().add(button_6);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 481, 60);
		f.getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("TACAR");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 40));
		label_1.setBounds(0, 0, 190, 47);
		panel.add(label_1);
		
		JButton btnNewButton_1 = new JButton("Main");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrameLogIn name = new MainFrameLogIn(id);
				f.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 58, 64, 27);
		f.getContentPane().add(btnNewButton_1);
		
		f.setVisible(true);
		f.setSize(500, 500);
	
	}
}
