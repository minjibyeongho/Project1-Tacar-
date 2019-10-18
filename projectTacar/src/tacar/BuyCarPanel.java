package tacar;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;

public class BuyCarPanel extends JPanel {

	public BuyCarPanel(ArrayList list) { // 기본생성자 사용, list는 buycar에서 정보가 들은 arraylist만 넘겨옴
		System.out.println("buycarpanel : list!");
		setPreferredSize(new Dimension(870, 1520));

		JButton[] bs = new JButton[12];
		JTextArea[] tas = new JTextArea[12];

		System.out.println(list);
//		GridLayout gr = new GridLayout(10,3,50,50);
		setLayout(null);

//		textArea.setBackground(Color.LIGHT_GRAY);
//		textArea.setFont(new Font("새굴림", Font.BOLD, 20));
//		textArea.setBounds(25, 57, 200, 300);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 290, 380);
		panel_1.setLayout(null);
		add(panel_1);

		bs[0] = new JButton("버튼1");
		bs[0].setBounds(10, 10, 270, 250);
		panel_1.add(bs[0]);
		bs[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C = new BuyCarInformation((CarinfoDTO)list.get(0));
			}
		});
		

		
		tas[0] = new JTextArea();
		tas[0].setBackground(Color.GRAY);
		tas[0].setBounds(10, 270, 270, 100);
		tas[0].setFont(new Font("돋움", Font.PLAIN, 20));
		tas[0].setForeground(Color.WHITE);
		panel_1.add(tas[0]);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 0, 290, 380);
		add(panel);

		bs[1] = new JButton("버튼2");
		bs[1].setBounds(10, 10, 270, 250);
		panel.add(bs[1]);
		bs[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C = new BuyCarInformation((CarinfoDTO)list.get(1));
			}
		});

		tas[1] = new JTextArea();
		tas[1].setBackground(Color.GRAY);
		tas[1].setBounds(10, 270, 270, 100);
		tas[1].setFont(new Font("돋움", Font.PLAIN, 20));
		tas[1].setForeground(Color.WHITE);
		panel.add(tas[1]);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(580, 0, 290, 380);
		add(panel_2);

		bs[2] = new JButton("버튼3");
		bs[2].setBounds(10, 10, 270, 250);
		panel_2.add(bs[2]);
		bs[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C = new BuyCarInformation((CarinfoDTO)list.get(2));
			}
		});

		tas[2] = new JTextArea();
		tas[2].setBackground(Color.GRAY);
		tas[2].setBounds(10, 270, 270, 100);
		tas[2].setFont(new Font("돋움", Font.PLAIN, 20));
		tas[2].setForeground(Color.WHITE);
		panel_2.add(tas[2]);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 380, 290, 380);
		add(panel_3);

		bs[3] = new JButton("버튼4");
		bs[3].setBounds(10, 10, 270, 250);
		panel_3.add(bs[3]);
		bs[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(3));
			}
		});

		tas[3] = new JTextArea();
		tas[3].setBackground(Color.GRAY);
		tas[3].setBounds(10, 270, 270, 100);
		tas[3].setFont(new Font("돋움", Font.PLAIN, 20));
		tas[3].setForeground(Color.WHITE);
		panel_3.add(tas[3]);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(290, 380, 290, 380);
		add(panel_4);

		bs[4] = new JButton("버튼5");
		bs[4].setBounds(10, 10, 270, 250);
		panel_4.add(bs[4]);
		bs[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(4));
			}
		});

		tas[4] = new JTextArea();
		tas[4].setBackground(Color.GRAY);
		tas[4].setBounds(10, 270, 270, 100);
		tas[4].setFont(new Font("돋움", Font.PLAIN, 20));
		tas[4].setForeground(Color.WHITE);
		panel_4.add(tas[4]);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(580, 380, 290, 380);
		add(panel_5);

		bs[5] = new JButton("버튼6");
		bs[5].setBounds(10, 10, 270, 250);
		panel_5.add(bs[5]);
		bs[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(5));
			}
		});

		tas[5] = new JTextArea();
		tas[5].setBackground(Color.GRAY);
		tas[5].setBounds(10, 270, 270, 100);
		panel_5.add(tas[5]);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 760, 290, 380);
		add(panel_6);

		bs[6] = new JButton("버튼7");
		bs[6].setBounds(10, 10, 270, 250);
		panel_6.add(bs[6]);
		bs[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(6));
			}
		});

		tas[6] = new JTextArea();
		tas[6].setBackground(Color.GRAY);
		tas[6].setBounds(10, 270, 270, 100);
		panel_6.add(tas[6]);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(290, 760, 290, 380);
		add(panel_7);

		bs[7] = new JButton("버튼8");
		bs[7].setBounds(10, 10, 270, 250);
		panel_7.add(bs[7]);
		bs[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(7));
			}
		});

		tas[7] = new JTextArea();
		tas[7].setBackground(Color.GRAY);
		tas[7].setBounds(10, 270, 270, 100);
		panel_7.add(tas[7]);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(580, 760, 290, 380);
		add(panel_8);

		bs[8] = new JButton("버튼9");
		bs[8].setBounds(10, 10, 270, 250);
		panel_8.add(bs[8]);
		bs[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(8));
			}
		});

		tas[8] = new JTextArea();
		tas[8].setBackground(Color.GRAY);
		tas[8].setBounds(10, 270, 270, 100);
		panel_8.add(tas[8]);

		JPanel panel_9 = new JPanel(); // 좌 최하단
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(0, 1140, 290, 380);
		add(panel_9);

		bs[9] = new JButton("버튼10");
		bs[9].setBounds(10, 10, 270, 250);
		panel_9.add(bs[9]);
		bs[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(9));
			}
		});

		tas[9] = new JTextArea();
		tas[9].setBackground(Color.GRAY);
		tas[9].setBounds(10, 270, 270, 100);
		panel_9.add(tas[9]);

		JPanel panel_10 = new JPanel(); // 중앙 최하단
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(290, 1140, 290, 380);
		add(panel_10);

		bs[10] = new JButton("버튼11");
		bs[10].setBounds(10, 10, 270, 250);
		panel_10.add(bs[10]);
		bs[10].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(10));
			}
		});

		tas[10] = new JTextArea();
		tas[10].setBackground(Color.GRAY);
		tas[10].setBounds(10, 270, 270, 100);
		panel_10.add(tas[10]);

		JPanel panel_11 = new JPanel(); // 우 최하단
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(580, 1140, 290, 380);
		add(panel_11);

		bs[11] = new JButton("버튼12");
		bs[11].setBounds(10, 10, 270, 250);
		panel_11.add(bs[11]);
		bs[11].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(11));
			}
		});

		tas[11] = new JTextArea();
		tas[11].setBackground(Color.GRAY);
		tas[11].setBounds(10, 270, 270, 100);
		panel_11.add(tas[11]);

		if (list.size() >= 12) {
			ImageIcon icon = null;
			for (int i = 0; i < bs.length; i++) {
				icon = new ImageIcon(((CarinfoDTO) list.get(i)).getImg());
				Image img = icon.getImage();
				Image newing = img.getScaledInstance(270, 250, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newing);
				bs[i].setIcon(icon);
				tas[i].setText(((CarinfoDTO) list.get(i)).getBrand() + " " + ((CarinfoDTO) list.get(i)).getCname() + " "
						+ ((CarinfoDTO) list.get(i)).getFuel() + "\n" + ((CarinfoDTO) list.get(i)).getPrice() + " "
						+ ((CarinfoDTO) list.get(i)).getTransmission() + " " + ((CarinfoDTO) list.get(i)).getPrice()
						+ "\n" + ((CarinfoDTO) list.get(i)).getType());
			}
		} else {
			ImageIcon icon = null;
			for (int i = 0; i < list.size(); i++) {
				icon = new ImageIcon(((CarinfoDTO) list.get(i)).getImg());
				Image img = icon.getImage();
				Image newing = img.getScaledInstance(270, 250, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newing);
				bs[i].setIcon(icon);
				tas[i].setText(((CarinfoDTO) list.get(i)).getBrand() + " " + ((CarinfoDTO) list.get(i)).getCname() + " "
						+ ((CarinfoDTO) list.get(i)).getFuel() + "\n" + ((CarinfoDTO) list.get(i)).getPrice() + " "
						+ ((CarinfoDTO) list.get(i)).getTransmission() + " " + ((CarinfoDTO) list.get(i)).getPrice()
						+ "\n" + ((CarinfoDTO) list.get(i)).getType());
			}
			for (int i = list.size(); i < 12; i++) {
				bs[i].setIcon(null);
				bs[i].setVisible(false);
				tas[i].setText("비어있음");
				tas[i].setVisible(false);
			}
		}

	}

	public BuyCarPanel(ArrayList list, String id) { // list는 buycar에서 정보가 들은 arraylist만 넘겨옴, id는 로그인한 본인 것(구매예정자)
		System.out.println("buycarpanel : list, id!");
		setPreferredSize(new Dimension(870, 1520));

		JButton[] bs = new JButton[12];
		JTextArea[] tas = new JTextArea[12];

		System.out.println(list);
//		GridLayout gr = new GridLayout(10,3,50,50);
		setLayout(null);

//		textArea.setBackground(Color.LIGHT_GRAY);
//		textArea.setFont(new Font("새굴림", Font.BOLD, 20));
//		textArea.setBounds(25, 57, 200, 300);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 290, 380);
		panel_1.setLayout(null);
		add(panel_1);

		bs[0] = new JButton("버튼1");
		bs[0].setBounds(10, 10, 270, 250);
		panel_1.add(bs[0]);
		bs[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C = new BuyCarInformation((CarinfoDTO)list.get(0), id);
			}
		});
		

		
		tas[0] = new JTextArea();
		tas[0].setBackground(Color.GRAY);
		tas[0].setBounds(10, 270, 270, 100);
		tas[0].setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
		tas[0].setForeground(Color.WHITE);
		panel_1.add(tas[0]);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(290, 0, 290, 380);
		add(panel);

		bs[1] = new JButton("버튼2");
		bs[1].setBounds(10, 10, 270, 250);
		panel.add(bs[1]);
		bs[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C = new BuyCarInformation((CarinfoDTO)list.get(1), id);
			}
		});

		tas[1] = new JTextArea();
		tas[1].setBackground(Color.GRAY);
		tas[1].setBounds(10, 270, 270, 100);
		panel.add(tas[1]);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(580, 0, 290, 380);
		add(panel_2);

		bs[2] = new JButton("버튼3");
		bs[2].setBounds(10, 10, 270, 250);
		panel_2.add(bs[2]);
		bs[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C = new BuyCarInformation((CarinfoDTO)list.get(2), id);
			}
		});

		tas[2] = new JTextArea();
		tas[2].setBackground(Color.GRAY);
		tas[2].setBounds(10, 270, 270, 100);
		panel_2.add(tas[2]);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 380, 290, 380);
		add(panel_3);

		bs[3] = new JButton("버튼4");
		bs[3].setBounds(10, 10, 270, 250);
		panel_3.add(bs[3]);
		bs[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(3), id);
			}
		});

		tas[3] = new JTextArea();
		tas[3].setBackground(Color.GRAY);
		tas[3].setBounds(10, 270, 270, 100);
		panel_3.add(tas[3]);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(290, 380, 290, 380);
		add(panel_4);

		bs[4] = new JButton("버튼5");
		bs[4].setBounds(10, 10, 270, 250);
		panel_4.add(bs[4]);
		bs[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(4), id);
			}
		});

		tas[4] = new JTextArea();
		tas[4].setBackground(Color.GRAY);
		tas[4].setBounds(10, 270, 270, 100);
		panel_4.add(tas[4]);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(580, 380, 290, 380);
		add(panel_5);

		bs[5] = new JButton("버튼6");
		bs[5].setBounds(10, 10, 270, 250);
		panel_5.add(bs[5]);
		bs[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(5), id);
			}
		});

		tas[5] = new JTextArea();
		tas[5].setBackground(Color.GRAY);
		tas[5].setBounds(10, 270, 270, 100);
		panel_5.add(tas[5]);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 760, 290, 380);
		add(panel_6);

		bs[6] = new JButton("버튼7");
		bs[6].setBounds(10, 10, 270, 250);
		panel_6.add(bs[6]);
		bs[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(6), id);
			}
		});

		tas[6] = new JTextArea();
		tas[6].setBackground(Color.GRAY);
		tas[6].setBounds(10, 270, 270, 100);
		panel_6.add(tas[6]);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(290, 760, 290, 380);
		add(panel_7);

		bs[7] = new JButton("버튼8");
		bs[7].setBounds(10, 10, 270, 250);
		panel_7.add(bs[7]);
		bs[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(7), id);
			}
		});

		tas[7] = new JTextArea();
		tas[7].setBackground(Color.GRAY);
		tas[7].setBounds(10, 270, 270, 100);
		panel_7.add(tas[7]);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(580, 760, 290, 380);
		add(panel_8);

		bs[8] = new JButton("버튼9");
		bs[8].setBounds(10, 10, 270, 250);
		panel_8.add(bs[8]);
		bs[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(8), id);
			}
		});

		tas[8] = new JTextArea();
		tas[8].setBackground(Color.GRAY);
		tas[8].setBounds(10, 270, 270, 100);
		panel_8.add(tas[8]);

		JPanel panel_9 = new JPanel(); // 좌 최하단
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(0, 1140, 290, 380);
		add(panel_9);

		bs[9] = new JButton("버튼10");
		bs[9].setBounds(10, 10, 270, 250);
		panel_9.add(bs[9]);
		bs[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(9), id);
			}
		});

		tas[9] = new JTextArea();
		tas[9].setBackground(Color.GRAY);
		tas[9].setBounds(10, 270, 270, 100);
		panel_9.add(tas[9]);

		JPanel panel_10 = new JPanel(); // 중앙 최하단
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(290, 1140, 290, 380);
		add(panel_10);

		bs[10] = new JButton("버튼11");
		bs[10].setBounds(10, 10, 270, 250);
		panel_10.add(bs[10]);
		bs[10].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(10), id);
			}
		});

		tas[10] = new JTextArea();
		tas[10].setBackground(Color.GRAY);
		tas[10].setBounds(10, 270, 270, 100);
		panel_10.add(tas[10]);

		JPanel panel_11 = new JPanel(); // 우 최하단
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(580, 1140, 290, 380);
		add(panel_11);

		bs[11] = new JButton("버튼12");
		bs[11].setBounds(10, 10, 270, 250);
		panel_11.add(bs[11]);
		bs[11].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarInformation C1 = new BuyCarInformation((CarinfoDTO)list.get(11), id);
			}
		});

		tas[11] = new JTextArea();
		tas[11].setBackground(Color.GRAY);
		tas[11].setBounds(10, 270, 270, 100);
		panel_11.add(tas[11]);

		if (list.size() >= 12) {
			ImageIcon icon = null;
			for (int i = 0; i < bs.length; i++) {
				icon = new ImageIcon(((CarinfoDTO) list.get(i)).getImg());
				Image img = icon.getImage();
				Image newing = img.getScaledInstance(270, 250, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newing);
				bs[i].setIcon(icon);
				tas[i].setText(((CarinfoDTO) list.get(i)).getBrand() + " " + ((CarinfoDTO) list.get(i)).getCname() + " "
						+ ((CarinfoDTO) list.get(i)).getFuel() + "\n" + ((CarinfoDTO) list.get(i)).getPrice() + " "
						+ ((CarinfoDTO) list.get(i)).getTransmission() + " " + ((CarinfoDTO) list.get(i)).getPrice()
						+ "\n" + ((CarinfoDTO) list.get(i)).getType());
			}
		} else {
			ImageIcon icon = null;
			for (int i = 0; i < list.size(); i++) {
				icon = new ImageIcon(((CarinfoDTO) list.get(i)).getImg());
				Image img = icon.getImage();
				Image newing = img.getScaledInstance(270, 250, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newing);
				bs[i].setIcon(icon);
				tas[i].setText(((CarinfoDTO) list.get(i)).getBrand() + " " + ((CarinfoDTO) list.get(i)).getCname() + " "
						+ ((CarinfoDTO) list.get(i)).getFuel() + "\n" + ((CarinfoDTO) list.get(i)).getPrice() + " "
						+ ((CarinfoDTO) list.get(i)).getTransmission() + " " + ((CarinfoDTO) list.get(i)).getPrice()
						+ "\n" + ((CarinfoDTO) list.get(i)).getType());
			}
			for (int i = list.size(); i < 12; i++) {
				bs[i].setIcon(null);
				bs[i].setVisible(false);
				tas[i].setText("비어있음");
				tas[i].setVisible(false);
			}
		}

	}

	

}
