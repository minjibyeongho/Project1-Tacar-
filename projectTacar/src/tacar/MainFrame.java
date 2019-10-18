package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JList;

public class MainFrame {
	private static JTextField textField;
	private static JPasswordField textField_1;

	static String recent1 = "CAR.png";
	static String recent2 = "CAR.png";
	static String recent3 = "CAR.png";
	static int i = 0;
	// 최근 본 게시물 번호저장
	JButton[] bts = new JButton[3];
	JTextArea[] tas = new JTextArea[3];
	JLabel clock = null;
	

	public MainFrame() { // 기본생성자(로그아웃 시 다시 돌아올 때 사용)
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		CarinfoDAO cdao = new CarinfoDAO();
		CarinfoDTO cdto = new CarinfoDTO();
		ImageIcon icon0 = null;
		ImageIcon icon1 = null;
		ImageIcon icon2 = null;
		Thread1 t1 = new Thread1();

		JFrame f = new JFrame(); // frame 객체 생성

		f.setSize(1000, 800); // frame size 설정
		f.getContentPane().setLayout(null); // layout 설정

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 982, 100);
		panel.setLayout(null);
		f.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("TACAR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 0, 190, 47);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("\uB0B4\uCC28\uD314\uAE30"); // 내차 팔기 버튼
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "먼저 로그인 하세요!");

			}
		});
		btnNewButton.setBounds(118, 73, 105, 27);
		panel.add(btnNewButton);
		btnNewButton.setEnabled(false);

		JButton btnNewButton_1 = new JButton("\uCC28\uB7C9\uCD94\uCC9C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recommand name = new Recommand();
				f.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(222, 73, 105, 27);
		panel.add(btnNewButton_1);

		JButton Center = new JButton("\uACE0\uAC1D\uC13C\uD130"); // 고객센터 버튼
		Center.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "먼저 로그인 하세요.");
			}
		});
		Center.setBounds(327, 73, 105, 27);
		panel.add(Center);
		Center.setEnabled(false);

		JButton btnNewButton_4 = new JButton("게시판");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "먼저 로그인 하세요.");
			}
		});
		btnNewButton_4.setBounds(432, 73, 105, 27);
		panel.add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);

		JButton btnNewButton_7 = new JButton("\uB0B4\uCC28\uC0AC\uAE30"); // 내차사기 버튼
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuyCar buy1 = new BuyCar();
				f.setVisible(false);
			}
		});
		btnNewButton_7.setBounds(14, 73, 105, 27);
		panel.add(btnNewButton_7);

		clock = new JLabel("");
		clock.setForeground(new Color(255, 255, 255));
		clock.setFont(new Font("돋움", Font.BOLD, 18));
		clock.setBounds(587, 71, 321, 30);
		panel.add(clock);

		new Time().start(); // 생성자에서 시간 나타냄

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 101, 982, 652);
		panel_1.setLayout(null);
		f.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 240, 869, 400);
		panel_2.setLayout(null);
		panel_1.add(panel_2);

		// panel3,4,5의 목록들은 스레드를 이용하여 올라온 매물들이 주기적으로 변경되도록 구현
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(14, 12, 270, 376);
		panel_3.setLayout(null);
		panel_2.add(panel_3);

		bts[0] = new JButton("\uC0AC\uC9C41");
		bts[0].setBounds(14, 12, 242, 202);
		panel_3.add(bts[0]);
		
		tas[0] = new JTextArea();
		tas[0].setBounds(14, 226, 242, 138);
		panel_3.add(tas[0]);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(298, 12, 270, 376);
		panel_4.setLayout(null);
		panel_2.add(panel_4);

		bts[1] = new JButton("\uC0AC\uC9C42");
		bts[1].setBounds(14, 12, 242, 202);
		panel_4.add(bts[1]);
		
		tas[1] = new JTextArea();
		tas[1].setBounds(14, 226, 242, 138);
		panel_4.add(tas[1]);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(582, 12, 270, 376);
		panel_5.setLayout(null);
		panel_2.add(panel_5);

		bts[2] = new JButton("\uC0AC\uC9C43");
		bts[2].setBounds(14, 12, 242, 202);
		panel_5.add(bts[2]);
		
		tas[2] = new JTextArea();
		tas[2].setBounds(14, 226, 242, 138);
		panel_5.add(tas[2]);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(613, 28, 339, 178);
		panel_6.setLayout(null);
		panel_1.add(panel_6);

		JLabel lblNewLabel_3 = new JLabel("ID : ");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_3.setBounds(14, 12, 79, 35);
		panel_6.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PW : ");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_4.setBounds(14, 59, 91, 35);
		panel_6.add(lblNewLabel_4);

		textField = new JTextField(10);
		textField.setBounds(107, 12, 129, 35);
		panel_6.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField(10);
		textField_1.setEchoChar('*');
		textField_1.setBounds(107, 59, 129, 35);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		JButton btnNewButton_5 = new JButton("\uB85C\uADF8\uC778");
		btnNewButton_5.setBounds(250, 20, 79, 27);
		panel_6.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\uD68C\uC6D0\uAC00\uC785"); // 회원가입
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp login = new SignUp();
				f.setVisible(false);
			}
		});
		btnNewButton_6.setBounds(183, 120, 105, 27);
		panel_6.add(btnNewButton_6);

		JButton btnIdPw = new JButton("ID, PW 찾기");
		btnIdPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindIdPw name = new FindIdPw();
				f.setVisible(false);
			}
		});
		btnIdPw.setBounds(14, 120, 141, 27);
		panel_6.add(btnIdPw);

		JButton recentBtn0 = new JButton("목록1");
		recentBtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recent1.equals("CAR.png")) {

				} else {
					CarinfoDTO cdto1 = cdao.select(recent1);
					BuyCarInformation name = new BuyCarInformation(cdto1);
				}
			}
		});
		recentBtn0.setBounds(14, 50, 179, 178);
		panel_1.add(recentBtn0);

		if (recent1.equals("CAR.png")) {
			icon0 = new ImageIcon(recent1);
		} else {
			icon0 = new ImageIcon((cdao.select(recent1)).getImg());
		}

		Image img0 = icon0.getImage();
		Image newing0 = img0.getScaledInstance(179, 178, java.awt.Image.SCALE_SMOOTH);
		icon0 = new ImageIcon(newing0);
		recentBtn0.setIcon(icon0);

		JButton recentBtn1 = new JButton("목록2");
		recentBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recent2.equals("CAR.png")) {

				} else {
					CarinfoDTO cdto1 = cdao.select(recent2);
					BuyCarInformation name = new BuyCarInformation(cdto1);
				}
			}
		});
		recentBtn1.setBounds(207, 50, 179, 178);
		panel_1.add(recentBtn1);

		if (recent2.equals("CAR.png")) {
			icon1 = new ImageIcon(recent2);
		} else {
			icon1 = new ImageIcon((cdao.select(recent2)).getImg());
		}

		Image img1 = icon1.getImage();
		Image newing1 = img1.getScaledInstance(179, 178, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(newing1);
		recentBtn1.setIcon(icon1);

		JButton recentBtn2 = new JButton("목록3");
		recentBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recent3.equals("CAR.png")) {

				} else {
					CarinfoDTO cdto1 = cdao.select(recent3);
					BuyCarInformation name = new BuyCarInformation(cdto1);
				}
			}
		});
		recentBtn2.setBounds(400, 50, 179, 178);
		panel_1.add(recentBtn2);

		if (recent3.equals("CAR.png")) {
			icon2 = new ImageIcon(recent3);
		} else {
			icon2 = new ImageIcon((cdao.select(recent3)).getImg());
		}

		Image img2 = icon2.getImage();
		Image newing2 = img2.getScaledInstance(179, 178, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newing2);
		recentBtn2.setIcon(icon2);

		JLabel lblNewLabel_5 = new JLabel("로그인"); // 로그인 버튼
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_5.setBounds(14, 12, 133, 26);
		panel_1.add(lblNewLabel_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDTO dto = new MemberDTO();
				String id = textField.getText();
				String pw = textField_1.getText();
				dto = dao.select(id);

				if (dto == null) {
					JOptionPane.showMessageDialog(null, "없는 아이디입니다.");
				} else {
					String pw1 = dto.getPw();
					if (pw.equals(pw1)) {
						MainFrameLogIn login = new MainFrameLogIn(id); // id를 가지고 로그인 프레임을 열음.
						f.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					}
				}
			}
		});

		t1.start(); // thread1 동작

		System.out.println(recent1);
		f.setVisible(true); // frame 창을 보이게 하는 것
	}

	public static void main(String[] args) { // main 시작

		MainFrame main = new MainFrame();

	}

	class Thread1 extends Thread {
		CarinfoDAO cdao = new CarinfoDAO();
		ArrayList list3 = cdao.selectAll();
		int l = 0;
		ImageIcon icon1 = null;

		@Override
		public void run() {
				//list3의 인덱스 컨트롤을 위한 인자

			while (true) {

				if(l>=list3.size()) {
					l=0;
				}
				
				if(l>=list3.size()-(list3.size()%3)) {	// mainframe에서 사진 버튼 3개 다 없을 때
					for (int k = 0; k < list3.size()%3; k++) {
						//버튼 아이콘 setting
						icon1 = new ImageIcon(((CarinfoDTO) list3.get(l)).getImg());	//list3에서 이미지를 하나씩 빼옴
						Image img1 = icon1.getImage();
						Image newing1 = img1.getScaledInstance(242, 202, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newing1);
						bts[k].setIcon(icon1);
						
						
						//버튼 하단 textarea setting
						tas[k].setText(((CarinfoDTO) list3.get(l)).getBrand() + " " + ((CarinfoDTO) list3.get(l)).getCname() + " "
								+ ((CarinfoDTO) list3.get(l)).getFuel() + "\n" + ((CarinfoDTO) list3.get(l)).getPrice() + " "
								+ ((CarinfoDTO) list3.get(l)).getTransmission() + " " + ((CarinfoDTO) list3.get(l)).getPrice()
								+ "\n" + ((CarinfoDTO) list3.get(l)).getType());
						
						l++;
					}
					
					for (int j = 0; j < 3-(list3.size()%3); j++) {
						bts[2-j].setText("*상품 준비중*");
						tas[j].setText("");
						l++;
					}
				}else {		// mainframe에서 사진 버튼 3개 다 있을 떄
					for (int j = 0; j < 3; j++) {
						//버튼 사진 setting
						icon1 = new ImageIcon(((CarinfoDTO) list3.get(l)).getImg());	//list3에서 이미지를 하나씩 빼옴
						Image img1 = icon1.getImage();
						Image newing1 = img1.getScaledInstance(242, 202, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newing1);
						bts[j].setIcon(icon1);
						bts[j].setVisible(true);
						
						
						//버튼 하단 textarea setting
						tas[j].setText(((CarinfoDTO) list3.get(l)).getBrand() + " " + ((CarinfoDTO) list3.get(l)).getCname() + " "
								+ ((CarinfoDTO) list3.get(l)).getFuel() + "\n" + ((CarinfoDTO) list3.get(l)).getPrice() + " "
								+ ((CarinfoDTO) list3.get(l)).getTransmission() + " " + ((CarinfoDTO) list3.get(l)).getPrice()
								+ "\n" + ((CarinfoDTO) list3.get(l)).getType());
						
						l++;
					}
				}
				
				try {
					sleep(5000); // 5초 뒤 화면 전환
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

		}

	}

	class Time extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					Calendar cal = Calendar.getInstance();
					clock.setText("현재시각 : " + cal.getTime().getHours() + ":" + cal.getTime().getMinutes() + ":"
							+ cal.getTime().getSeconds() + " / " + (cal.getTime().getMonth() + 1) + "월"
							+ cal.getTime().getDate() + "일");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
