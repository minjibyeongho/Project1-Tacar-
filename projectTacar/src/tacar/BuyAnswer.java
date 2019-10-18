package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.python.modules.math;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyAnswer extends JFrame {
	private JTextField aid;
	private JTextField aname;
	private JTextField agender;
	private JTextField aphone;
	private JTextField aemail;
	private JTextField aaddress;
	private JTextField sprice;
	private JTextField bprice;
	private JTextField benefit1;

	CarinfoDAO cdao = null;
	CarinfoDTO cdto = null;
	MemberDAO mdao = null;
	MemberDTO mdto1 = null;
	MemberDTO mdto2 = null;
	public BuyAnswer(String id) {	// 로그인한 사람의 id 넘겨옴, 구매요청자의 id는 DB bid에 있음
		
//		setSize(500, 500);
		
		setBounds(300, 300, 600, 439);
		
		getContentPane().setLayout(null);
		
		mdao = new MemberDAO();
		
		System.out.println("---test id---");
		System.out.println(id);	// test 완료 1
		mdto1 = mdao.select(id);	// 로그인한 id의 dto정보를 select
		
		mdto2 = new MemberDTO();
		System.out.println("----------");
		System.out.println(mdto1.getBid());	//test null로 나옴
		
		mdto2 = mdao.select(mdto1.getBid());	//구매요청자의 member정보를 가져옴
		
		
		cdao = new CarinfoDAO();
		cdto = new CarinfoDTO();
		cdto = cdao.selectPrice(id);	// 판매자(로그인한 사람의 차량 정보를 가져옴)
		
		System.out.println("----price test-----");
		System.out.println(cdto.getBrand());
		System.out.println(cdto.getPrice());
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 582, 400);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(14, 12, 105, 43);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblName.setBounds(14, 67, 105, 43);
		panel.add(lblName);
		
		JLabel lblLocation = new JLabel("Gender : ");
		lblLocation.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblLocation.setBounds(14, 123, 105, 43);
		panel.add(lblLocation);
		
		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblPhone.setBounds(266, 12, 105, 43);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAddress.setBounds(266, 123, 105, 43);
		panel.add(lblAddress);
		
		JLabel lblBprice = new JLabel("Bprice : ");
		lblBprice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBprice.setBounds(14, 265, 105, 43);
		panel.add(lblBprice);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblEmail.setBounds(266, 67, 105, 43);
		panel.add(lblEmail);
		
		JLabel lblSprice = new JLabel("Sprice : ");
		lblSprice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblSprice.setBounds(14, 198, 105, 43);
		panel.add(lblSprice);
		
		aid = new JTextField();
		aid.setBounds(109, 12, 143, 43);
		panel.add(aid);
		aid.setColumns(10);
		
		aname = new JTextField();
		aname.setColumns(10);
		aname.setBounds(109, 67, 143, 43);
		panel.add(aname);
		
		agender = new JTextField();
		agender.setColumns(10);
		agender.setBounds(109, 122, 143, 43);
		panel.add(agender);
		
		aphone = new JTextField();
		aphone.setColumns(10);
		aphone.setBounds(368, 12, 143, 43);
		panel.add(aphone);
		
		aemail = new JTextField();
		aemail.setColumns(10);
		aemail.setBounds(368, 67, 143, 43);
		panel.add(aemail);
		
		aaddress = new JTextField();
		aaddress.setColumns(10);
		aaddress.setBounds(368, 123, 143, 43);
		panel.add(aaddress);
		
		sprice = new JTextField();
		sprice.setColumns(10);
		sprice.setBounds(109, 198, 143, 43);
		panel.add(sprice);
		
		bprice = new JTextField();
		bprice.setColumns(10);
		bprice.setBounds(109, 265, 143, 43);
		panel.add(bprice);
		
		JLabel label = new JLabel("차액 : ");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(266, 265, 105, 43);
		panel.add(label);
		
		benefit1 = new JTextField();
		benefit1.setColumns(10);
		benefit1.setBounds(368, 265, 143, 43);
		panel.add(benefit1);
		
		// 정보 넣기
		aid.setText(mdto2.getId());
		aname.setText(mdto2.getName());
		agender.setText(mdto2.getGender());
		aphone.setText(mdto2.getPhone());
		aemail.setText(mdto2.getEmail());
		aaddress.setText(mdto2.getAddress());
		sprice.setText(cdto.getPrice());	//판매자의 판매금액
		bprice.setText(mdto1.getBprice());	//구매요청자의 희망금액
		int benefit = Integer.parseInt(cdto.getPrice()) - Integer.parseInt(mdto1.getBprice());
		
		// (판매금액 - 구매희망금액) > 0, (판매금액 - 구매희망금액) < 0, (판매금액 - 구매희망금액) = 0 
		if(benefit>0) {
			benefit1.setText(Integer.toString(benefit)+"만원 손해입니다!");
		}else if(benefit<0) {
			benefit1.setText(Integer.toString(Math.abs(benefit))+"만원 이익입니다!");
		}else {
			benefit1.setText("판매희망 금액과 동일합니다!");
		}
		
		
		JButton btnNewButton = new JButton("판매");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "판매가 성사되었습니다!");
				cdao.delete(cdto.getNamber());	// 판매자의 목록 삭제
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton.setBounds(14, 336, 150, 50);
		panel.add(btnNewButton);
		
		JButton button = new JButton("거절");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "판매를 거절하였습니다!");
				mdto1.setBid(null);
				mdto1.setBprice(null);
				System.out.println(mdto1);
				mdao.update(mdto1);
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 25));
		button.setBounds(361, 336, 150, 50);
		panel.add(button);
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
		
	}
}
