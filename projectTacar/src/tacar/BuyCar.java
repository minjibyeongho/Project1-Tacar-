package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class BuyCar {

//	JScrollPane sp;
	ArrayList list = new ArrayList();
	ArrayList list2 = new ArrayList();
	
	public BuyCar() {	//로그인 없이 볼 수 있는 창
		System.out.println("buycar : no login!");
		String[] imgs = { "ACCENT.png", "AVANTE.png", "CLIO.png", "CONA.png", "CORANDO.png", "CRUISE.png",
				"GENESIS.png", "IONIC.png", "K3.png", "K5.png", "LACETTI.png", "LOTZE.png", "MALIBU.png", "MORNING.png",
				"PRIDE.png", "QM3.png", "QM5.png", "QM6.png", "RAY.png", "SANTAFE.png", "SM3.png", "SM5.png", "SM6.png",
				"SONATA.png", "SORENTO.png", "SPARK.png", "STONIC.png", "TUCSON.png" };
		String[] types = { "subcompact", "compact", "midsize", "sedan", "suv", "rv" };
		String[] brands = { "hyundai", "samsung", "kia", "chevrolet", "ssanyong", "daewoo", "genesis" };

		CarinfoDAO dao = new CarinfoDAO();
		
		JButton[] buttons = new JButton[6]; // 글씨 관련
		JButton[] buttons1 = new JButton[6]; // 사진 관련

		JFrame f = new JFrame();
		f.setSize(1000, 800);
		
		JScrollPane sp = new JScrollPane();	//scrollpane 객체 생성
		sp.setBounds(109, 0, 873, 652);
//		// scrollpane 스크롤바 위치값 고정		- 조금더 해보고
//		JScrollBar jbar = new JScrollBar();
//		jbar = sp.getVerticalScrollBar();
//		int value = jbar.getMinimum();
//		jbar.setValue(value);
		
		//combobox 선택 전 초기화면 설정
		list2 = dao.selectAll();
		
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
		
		JButton btnNewButton = new JButton("Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame name = new MainFrame();
				f.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(0, 73, 80, 27);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();	//scrollpane관련 패널
		panel_1.setBounds(0, 101, 982, 652);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		
		panel_1.add(sp);	//scrollpane 패널에 얹음

		// 검색조건 설정
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 111, 172);
		panel_1.add(toolBar);
		toolBar.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow = new FlowLayout();
		toolBar.setLayout(flow);

		// 보완사항
		// jbutton에 jtextarea를 씌울 수 있는지 테스트(그 버튼을 클릭하면 해당 정보로 넘어 가도록)
		//

		JComboBox combo1 = new JComboBox(); // brand
		combo1.setSize(100, 50);

		for (int i = 0; i < brands.length; i++) {
			combo1.addItem(brands[i]);
		}

		
		combo1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				list = new ArrayList();
				list2 = new ArrayList();
				ImageIcon icon = null;
				// combobox에서 선택한 인덱스를 가져오게끔 설계
				String a = (String) combo1.getSelectedItem();
				System.out.println(a);

				list = dao.selectAll();
				System.out.println(list);

				for (int i = 0; i < list.size(); i++) {
					if (a.equals(((CarinfoDTO) list.get(i)).getBrand())) {
						list2.add((CarinfoDTO) list.get(i));
					}
				}
				
				sp.setViewportView(new BuyCarPanel(list2));// 스크롤페인 안에 넣을 패널

//				// list2에서 cnum들을 활용하여 
//				for (int j = 0; j < list2.size(); j++) {
//					buttons[j].setText(((CarinfoDTO) list2.get(j)).getBrand() + " "
//							+ ((CarinfoDTO) list2.get(j)).getCname() + " " + ((CarinfoDTO) list2.get(j)).getPrice());
//					icon = new ImageIcon(((CarinfoDTO)list2.get(j)).getImg());
//					buttons1[j].setIcon(icon);
//				}
//				System.out.println(list2.size());
//
//				for (int k = list2.size(); k < 6; k++) {
//					buttons[k].setText("비어있음");
//					buttons1[k].setIcon(null);
//				}

			}
		});

		JComboBox combo2 = new JComboBox(); // type
		combo2.setSize(100, 50);

		for (int j = 0; j < types.length; j++) {
			combo2.addItem(types[j]);
		}
//		
		// combobox를 클릭하면 arraylist를 만들고 그 list를 panel에넘겨서 
		combo2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list = new ArrayList();
				list2 = new ArrayList();
				
				ImageIcon icon = null;
				String a = (String) combo2.getSelectedItem(); // combobox에서 누른 값을 가져옴

				list = dao.selectAll();
				for (int i = 0; i < list.size(); i++) { // equal 메소드를 통해서 항목에 맞는 것만 땡겨온다.
					if (a.equals(((CarinfoDTO) list.get(i)).getType())) {
						list2.add(((CarinfoDTO) list.get(i))); // arraylist에서 get메소드로 가져온 자료는 object타입이기때문에
																// downcasting필요
					}
				}
				
				sp.setViewportView(new BuyCarPanel(list2));// 스크롤페인 안에 넣을 패널

//				for (int j = 0; j < list2.size(); j++) { // list2에 있는 내용들을 buttons에 가져오기
//					buttons[j].setText(((CarinfoDTO) list2.get(j)).getBrand() + " "
//							+ ((CarinfoDTO) list2.get(j)).getCname() + " " + ((CarinfoDTO) list2.get(j)).getPrice());
//					icon = new ImageIcon(((CarinfoDTO)list2.get(j)).getImg());
//					buttons1[j].setIcon(icon);
//				}
//
//				for (int k = list2.size(); k < 6; k++) {
//					buttons[k].setText("비어있음");
//					buttons1[k].setIcon(null);
//				}

			}
		});

		JComboBox combo3 = new JComboBox(); // cname
		combo3.setSize(100, 50);

		for (int i = 0; i < imgs.length; i++) {
			combo3.addItem(imgs[i].substring(0, imgs[i].lastIndexOf(".")));
		}
		
		combo3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list = new ArrayList();
				list2 = new ArrayList();
				
				ImageIcon icon = null;
				String a = (String) combo3.getSelectedItem(); // combobox에서 누른 값을 가져옴

				list = dao.selectAll();
				for (int i = 0; i < list.size(); i++) { // equal 메소드를 통해서 항목에 맞는 것만 땡겨온다.
					if (a.equals(((CarinfoDTO) list.get(i)).getCname())) {
						list2.add(((CarinfoDTO) list.get(i))); // arraylist에서 get메소드로 가져온 자료는 object타입이기때문에
																// downcasting필요
					}
				}
				
				sp.setViewportView(new BuyCarPanel(list2));// 스크롤페인 안에 넣을 패널

//				for (int j = 0; j < list2.size(); j++) { // list2에 있는 내용들을 buttons에 가져오기
//					buttons[j].setText(((CarinfoDTO) list2.get(j)).getBrand() + " "
//							+ ((CarinfoDTO) list2.get(j)).getCname() + " " + ((CarinfoDTO) list2.get(j)).getPrice());
//					icon = new ImageIcon(((CarinfoDTO)list2.get(j)).getImg());
//					buttons1[j].setIcon(icon);
//				}
//
//				for (int k = list2.size(); k < 6; k++) {
//					buttons[k].setText("비어있음");
//					buttons1[k].setIcon(null);
//				}

			}
		});

		toolBar.add(combo1);
		toolBar.add(combo2);
		toolBar.add(combo3);



		

		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);// 세로스크롤 항상 보이기

		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);// 가로스크롤 보이지 않게 하기

		sp.setViewportView(new BuyCarPanel(list2));// 스크롤페인 안에 넣을 패널

		f.setVisible(true);
	}
	
	public BuyCar(String id) {	//본인 id를 가지고 오는 것
		System.out.println("buycar : id!!");
		String[] imgs = { "ACCENT.png", "AVANTE.png", "CLIO.png", "CONA.png", "CORANDO.png", "CRUISE.png",
				"GENESIS.png", "IONIC.png", "K3.png", "K5.png", "LACETTI.png", "LOTZE.png", "MALIBU.png", "MORNING.png",
				"PRIDE.png", "QM3.png", "QM5.png", "QM6.png", "RAY.png", "SANTAFE.png", "SM3.png", "SM5.png", "SM6.png",
				"SONATA.png", "SORENTO.png", "SPARK.png", "STONIC.png", "TUCSON.png" };
		String[] types = { "subcompact", "compact", "midsize", "sedan", "suv", "rv" };
		String[] brands = { "hyundai", "samsung", "kia", "chevrolet", "ssanyong", "daewoo", "genesis" };

		CarinfoDAO dao = new CarinfoDAO();
		
		JButton[] buttons = new JButton[6]; // 글씨 관련
		JButton[] buttons1 = new JButton[6]; // 사진 관련

		JFrame f = new JFrame();
		f.setSize(1000, 800);
		
		JScrollPane sp = new JScrollPane();	//scrollpane 객체 생성
		sp.setBounds(109, 0, 873, 652);
//		// scrollpane 스크롤바 위치값 고정		- 조금더 해보고
//		JScrollBar jbar = new JScrollBar();
//		jbar = sp.getVerticalScrollBar();
//		int value = jbar.getMinimum();
//		jbar.setValue(value);
		
		//combobox 선택 전 초기화면 설정
		list2 = dao.selectAll();
		
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
		
		JButton btnNewButton = new JButton("Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrameLogIn name = new MainFrameLogIn(id);
				f.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(0, 73, 80, 27);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();	//scrollpane관련 패널
		panel_1.setBounds(0, 101, 982, 652);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		
		panel_1.add(sp);	//scrollpane 패널에 얹음

		// 검색조건 설정
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 111, 172);
		panel_1.add(toolBar);
		toolBar.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow = new FlowLayout();
		toolBar.setLayout(flow);

		// 보완사항
		// jbutton에 jtextarea를 씌울 수 있는지 테스트(그 버튼을 클릭하면 해당 정보로 넘어 가도록)
		//

		JComboBox combo1 = new JComboBox(); // brand
		combo1.setSize(100, 50);

		for (int i = 0; i < brands.length; i++) {
			combo1.addItem(brands[i]);
		}

		
		combo1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				list = new ArrayList();
				list2 = new ArrayList();
				ImageIcon icon = null;
				// combobox에서 선택한 인덱스를 가져오게끔 설계
				String a = (String) combo1.getSelectedItem();
				System.out.println(a);

				list = dao.selectAll();
				System.out.println(list);

				for (int i = 0; i < list.size(); i++) {
					if (a.equals(((CarinfoDTO) list.get(i)).getBrand())) {
						list2.add((CarinfoDTO) list.get(i));
					}
				}
				
				sp.setViewportView(new BuyCarPanel(list2, id));// 스크롤페인 안에 넣을 패널

//				// list2에서 cnum들을 활용하여 
//				for (int j = 0; j < list2.size(); j++) {
//					buttons[j].setText(((CarinfoDTO) list2.get(j)).getBrand() + " "
//							+ ((CarinfoDTO) list2.get(j)).getCname() + " " + ((CarinfoDTO) list2.get(j)).getPrice());
//					icon = new ImageIcon(((CarinfoDTO)list2.get(j)).getImg());
//					buttons1[j].setIcon(icon);
//				}
//				System.out.println(list2.size());
//
//				for (int k = list2.size(); k < 6; k++) {
//					buttons[k].setText("비어있음");
//					buttons1[k].setIcon(null);
//				}

			}
		});

		JComboBox combo2 = new JComboBox(); // type
		combo2.setSize(100, 50);

		for (int j = 0; j < types.length; j++) {
			combo2.addItem(types[j]);
		}
//		
		// combobox를 클릭하면 arraylist를 만들고 그 list를 panel에넘겨서 
		combo2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list = new ArrayList();
				list2 = new ArrayList();
				
				ImageIcon icon = null;
				String a = (String) combo2.getSelectedItem(); // combobox에서 누른 값을 가져옴

				list = dao.selectAll();
				for (int i = 0; i < list.size(); i++) { // equal 메소드를 통해서 항목에 맞는 것만 땡겨온다.
					if (a.equals(((CarinfoDTO) list.get(i)).getType())) {
						list2.add(((CarinfoDTO) list.get(i))); // arraylist에서 get메소드로 가져온 자료는 object타입이기때문에
																// downcasting필요
					}
				}
				
				sp.setViewportView(new BuyCarPanel(list2, id));// 스크롤페인 안에 넣을 패널

//				for (int j = 0; j < list2.size(); j++) { // list2에 있는 내용들을 buttons에 가져오기
//					buttons[j].setText(((CarinfoDTO) list2.get(j)).getBrand() + " "
//							+ ((CarinfoDTO) list2.get(j)).getCname() + " " + ((CarinfoDTO) list2.get(j)).getPrice());
//					icon = new ImageIcon(((CarinfoDTO)list2.get(j)).getImg());
//					buttons1[j].setIcon(icon);
//				}
//
//				for (int k = list2.size(); k < 6; k++) {
//					buttons[k].setText("비어있음");
//					buttons1[k].setIcon(null);
//				}

			}
		});

		JComboBox combo3 = new JComboBox(); // cname
		combo3.setSize(100, 50);

		for (int i = 0; i < imgs.length; i++) {
			combo3.addItem(imgs[i].substring(0, imgs[i].lastIndexOf(".")));
		}
		
		combo3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list = new ArrayList();
				list2 = new ArrayList();
				
				ImageIcon icon = null;
				String a = (String) combo3.getSelectedItem(); // combobox에서 누른 값을 가져옴

				list = dao.selectAll();
				for (int i = 0; i < list.size(); i++) { // equal 메소드를 통해서 항목에 맞는 것만 땡겨온다.
					if (a.equals(((CarinfoDTO) list.get(i)).getCname())) {
						list2.add(((CarinfoDTO) list.get(i))); // arraylist에서 get메소드로 가져온 자료는 object타입이기때문에
																// downcasting필요
					}
				}
				
				sp.setViewportView(new BuyCarPanel(list2, id));// 스크롤페인 안에 넣을 패널

//				for (int j = 0; j < list2.size(); j++) { // list2에 있는 내용들을 buttons에 가져오기
//					buttons[j].setText(((CarinfoDTO) list2.get(j)).getBrand() + " "
//							+ ((CarinfoDTO) list2.get(j)).getCname() + " " + ((CarinfoDTO) list2.get(j)).getPrice());
//					icon = new ImageIcon(((CarinfoDTO)list2.get(j)).getImg());
//					buttons1[j].setIcon(icon);
//				}
//
//				for (int k = list2.size(); k < 6; k++) {
//					buttons[k].setText("비어있음");
//					buttons1[k].setIcon(null);
//				}

			}
		});

		toolBar.add(combo1);
		toolBar.add(combo2);
		toolBar.add(combo3);



		

		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);// 세로스크롤 항상 보이기

		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);// 가로스크롤 보이지 않게 하기

		sp.setViewportView(new BuyCarPanel(list2, id));// 스크롤페인 안에 넣을 패널

		f.setVisible(true);
	}
	
}