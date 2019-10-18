package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoticeBoardContent {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int num3;

	BoardDAO dao = new BoardDAO();
	BoardDTO dto = new BoardDTO();
	private JTextField textField_3;
	MemberDAO mdao = new MemberDAO();
	MemberDTO mdto = new MemberDTO();
	public NoticeBoardContent(String id, int num) {

		JFrame f = new JFrame();
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

		textField = new JTextField();
		textField.setBounds(70, 172, 396, 56);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(70, 240, 747, 253);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		dto = dao.search(num);

		textField.setText(dto.getTitle());
		textField_1.setText(dto.getContent());

		num3 = num;

		JButton btnNewButton = new JButton("▲");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num3++;
				dto.setNumber(num3);
				int numx = dao.newnum(id);

				if (num3 <= numx) {
					dao.select(dto);
					textField.setText(dto.getTitle());
					textField_1.setText(dto.getContent());
					textField_2.setText(dto.getId() + " 님");
				} else {
					num3 = num3 - 1;
					JOptionPane.showMessageDialog(null, "현재 가장 최신 글입니다.");
				}

			}
		});
		btnNewButton.setBounds(713, 666, 53, 27);
		f.getContentPane().add(btnNewButton);

		JButton button = new JButton("▼");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num3 = num3 - 1;
				dto.setNumber(num3);
				int numx = dao.newnum(id);

				if (num3 >= 1) {
					dao.select(dto);
					textField.setText(dto.getTitle());
					textField_1.setText(dto.getContent());
					textField_2.setText(dto.getId() + " 님");
				} else {
					num3 = num3 + 1;
					JOptionPane.showMessageDialog(null, "현재 가장 마지막 글입니다.");
				}
			}
		});
		button.setBounds(764, 666, 53, 27);
		f.getContentPane().add(button);

		JButton btnNewButton_2 = new JButton("Main");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrameLogIn name = new MainFrameLogIn(id);
			}
		});
		btnNewButton_2.setBounds(0, 124, 80, 27);
		f.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("삭제하기");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardDTO dto = dao.search(num);
				MemberDTO mdto = new MemberDTO();
				MemberDAO mdao = new MemberDAO();
				////////////
				if ((mdao.select(id)).getAdminkey().equals("admin")) { // 어드민키는 "admin" 관리자일 경우 바로 삭제
					dao.delete(dto);
					NoticeBoardList name = new NoticeBoardList(id);
					f.setVisible(false);
				} else { //관리자가 아닐 경우 비밀번호 확인 후 삭제가능
					String bpw2 = dto.getBpw();
					String bpw1 = JOptionPane.showInputDialog("게시글 비밀번호를 입력하세요.");

					if (bpw2.equals(bpw1)) {
						// delete 실행
						dao.delete(dto);
						NoticeBoardList name = new NoticeBoardList(id);
						f.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					}
				}
				//////////////
			}
		});

		btnNewButton_3.setBounds(724, 133, 93, 27);
		f.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("목록으로");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeBoardList name = new NoticeBoardList(id);
				f.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(70, 666, 93, 27);
		f.getContentPane().add(btnNewButton_4);

		JLabel lblNewLabel = new JLabel("작성자");
		lblNewLabel.setBounds(551, 191, 62, 18);
		f.getContentPane().add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(627, 172, 190, 56);
		textField_2.setText(dto.getId() + " 님");

		f.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(70, 528, 582, 93);
		f.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText((dao.search(num)).getReply());
		
		JButton btnNewButton_1 = new JButton("답글달기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((mdao.select(id)).getAdminkey().equals("admin")) {
					String reply = textField_3.getText();
					dto = dao.search(num);
					dto.setReply(reply);
					dao.update(dto);
				} else {
					JOptionPane.showMessageDialog(null, "관리자만 답글을 달 수 있습니다.");
				}
			}
		});
		btnNewButton_1.setBounds(666, 553, 151, 43);
		f.getContentPane().add(btnNewButton_1);
		f.setVisible(true);
		f.setSize(1000, 800);
	}
}
