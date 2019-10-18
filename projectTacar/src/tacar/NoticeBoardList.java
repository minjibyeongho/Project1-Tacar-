package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class NoticeBoardList {

	BoardDAO dao = new BoardDAO();
	BoardDTO dto = new BoardDTO();
	static int i;

	public NoticeBoardList(String id) { // 로그인 한 id
		JButton[] bnArray = new JButton[5];
		BoardDTO[] dto = new BoardDTO[5];

		ArrayList listAll = dao.selectAll(); // 모든 Board DB 추출

		JFrame f = new JFrame();
		f.setSize(1000, 800);
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

		JButton btnNewButton_1 = new JButton("글쓰기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeResiter name = new NoticeResiter(id);
				f.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(695, 676, 100, 27);
		f.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Main");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrameLogIn name = new MainFrameLogIn(id);
				f.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(14, 151, 105, 27);
		f.getContentPane().add(btnNewButton_2);

//		BoardDTO dto1 = (BoardDTO) listAll.get(0); // SelectAll로 가져온 리스트 중 첫번째 DTO를 빼옴
		bnArray[0] = new JButton("");
		bnArray[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAll.size() - 1 >= 0) {
					NoticeBoardContent name = new NoticeBoardContent(id, dto[0].getNumber());
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "비어있습니다.");
				}
			}
		});
		bnArray[0].setFont(new Font("돋움", Font.BOLD, 18));
		bnArray[0].setBounds(95, 200, 700, 60);
		f.getContentPane().add(bnArray[0]);

//		BoardDTO dto2 = (BoardDTO) listAll.get(1);
		bnArray[1] = new JButton("");
		bnArray[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAll.size() - 1 >= 1) {
					NoticeBoardContent name = new NoticeBoardContent(id, dto[1].getNumber());
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "비어있습니다.");
				}
			}
		});
		bnArray[1].setFont(new Font("돋움", Font.BOLD, 18));
		bnArray[1].setBounds(95, 300, 700, 60);
		f.getContentPane().add(bnArray[1]);

//		BoardDTO dto3=  (BoardDTO) listAll.get(2); // SelectAll로 가져온 리스트 중 세번째 DTO를 빼옴
		bnArray[2] = new JButton("");
		bnArray[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAll.size() - 1 >= 2) {
					NoticeBoardContent name = new NoticeBoardContent(id, dto[2].getNumber());
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "비어있습니다.");
				}
			}
		});
		bnArray[2].setFont(new Font("돋움", Font.BOLD, 18));
		bnArray[2].setBounds(95, 400, 700, 60);
		f.getContentPane().add(bnArray[2]);

//		BoardDTO dto4 = (BoardDTO) listAll.get(3); // SelectAll로 가져온 리스트 중 네번째 DTO를 빼옴
		bnArray[3] = new JButton("");
		bnArray[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAll.size() - 1 >= 3) {
					NoticeBoardContent name = new NoticeBoardContent(id, dto[3].getNumber());
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "비어있습니다.");
				}
			}
		});
		bnArray[3].setFont(new Font("돋움", Font.BOLD, 18));
		bnArray[3].setBounds(95, 500, 700, 60);
		f.getContentPane().add(bnArray[3]);

//		BoardDTO dto5 = (BoardDTO) listAll.get(4); // SelectAll로 가져온 리스트 중 네번째 DTO를 빼옴
		bnArray[4] = new JButton("");
		bnArray[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAll.size() - 1 >= 4) {
					NoticeBoardContent name = new NoticeBoardContent(id, dto[4].getNumber());
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "비어있습니다.");
				}
			}
		});

		for (i = 0; i < 5; i++) { // 버튼창에 표시되는 각 글의 제목
			if (i < listAll.size()) {
				dto[i] = (BoardDTO) listAll.get(i); // SelectAll로 가져온 리스트 중 네번째 DTO를 빼옴
				System.out.println("DTO 끌어오기 성공");
				bnArray[i].setText(dto[i].getTitle() + "            / 작성시간 : " + dto[i].getTime());
			} else {
				bnArray[i].setText("없는 글 입니다.");
			}
		}

//		for (i = 0; i < 5; i++) { // 버튼 실행
//			bnArray[i].addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					if (listAll.size() - 1 >= i) {
//						NoticeBoardContent name = new NoticeBoardContent(id, dto[i].getNumber());
//						f.setVisible(false);
//					} else {
//						JOptionPane.showMessageDialog(null, "비어있습니다.");
//					}
//				}
//			});
//
//		}
		bnArray[4].setFont(new Font("돋움", Font.BOLD, 18));
		bnArray[4].setBounds(95, 600, 700, 60);
		f.getContentPane().add(bnArray[4]);

		f.setVisible(true);
	}
}
