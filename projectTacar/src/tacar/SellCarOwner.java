package tacar;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class SellCarOwner extends JFrame {
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JTextField email;

	public SellCarOwner(String cid) {	// 판매자 id인 cid만 들어오는 경우
		
		setTitle("*****판매자 정보*****");
		setSize(380, 330);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(14, 12, 133, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblName.setBounds(14, 65, 133, 41);
		getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblPhone.setBounds(14, 118, 133, 41);
		getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEmail.setBounds(14, 175, 133, 41);
		getContentPane().add(lblEmail);
		
		id = new JTextField();
		id.setBounds(147, 12, 178, 41);
		getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(147, 65, 178, 41);
		getContentPane().add(name);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(147, 118, 178, 41);
		getContentPane().add(phone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(147, 171, 178, 41);
		getContentPane().add(email);
		
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();
		
		mdto = mdao.select(cid);
		
		id.setText(mdto.getId());
		id.setEditable(false);	//수정 필요 없으므로 잠금
		name.setText(mdto.getName());
		name.setEditable(false);
		phone.setText(mdto.getPhone());
		phone.setEditable(false);
		email.setText(mdto.getEmail());
		email.setEditable(false);
		
		setVisible(true);
		
	}


}
