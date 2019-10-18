package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class SellCar {
	private JTextField color;
	private JTextField distance;
	private JTextField year;
	private JTextField location;
	private JTextField price;
	private JTextField namber;
	private JTextField guarantee;
	private JTextField opt;
	int check;

	public SellCar(String id) {
		CarinfoDAO dao = new CarinfoDAO();
		CarinfoDTO sdto = new CarinfoDTO();
		String[] imgs = { "ACCENT.png", "AVANTE.png", "CLIO.png", "CONA.png", "CORANDO.png", "CRUISE.png",
				"GENESIS.png", "IONIC.png", "K3.png", "K5.png", "LACETTI.png", "LOTZE.png", "MALIBU.png", "MORNING.png",
				"PRIDE.png", "QM3.png", "QM5.png", "QM6.png", "RAY.png", "SANTAFE.png", "SM3.png", "SM5.png", "SM6.png",
				"SONATA.png", "SORENTO.png", "SPARK.png", "STONIC.png", "TUCSON.png" };
		String[] types = { "subcompact", "compact", "midsize", "sedan", "suv", "rv" };
		String[] brands = { "hyundai", "samsung", "kia", "chevrolet", "ssanyong", "daewoo", "genesis" };

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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 96, 982, 657);
		panel_1.setLayout(null);
		f.getContentPane().add(panel_1);

		JLabel label_1 = new JLabel("제조사 : ");
		label_1.setFont(new Font("돋움", Font.BOLD, 25));
		label_1.setBounds(585, 12, 124, 31);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("차종 : ");
		label_2.setFont(new Font("돋움", Font.BOLD, 25));
		label_2.setBounds(585, 55, 124, 31);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("차량명 : ");
		label_3.setFont(new Font("돋움", Font.BOLD, 25));
		label_3.setBounds(585, 98, 113, 34);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("가격 : ");
		label_4.setFont(new Font("돋움", Font.BOLD, 25));
		label_4.setBounds(585, 144, 124, 31);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("키로수 : ");
		label_5.setFont(new Font("돋움", Font.BOLD, 25));
		label_5.setBounds(585, 188, 124, 31);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("연식 : ");
		label_6.setFont(new Font("돋움", Font.BOLD, 25));
		label_6.setBounds(585, 233, 124, 28);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("위치 : ");
		label_7.setFont(new Font("돋움", Font.BOLD, 25));
		label_7.setBounds(585, 273, 149, 31);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("색상 : ");
		label_8.setFont(new Font("돋움", Font.BOLD, 25));
		label_8.setBounds(585, 316, 124, 28);
		panel_1.add(label_8);

		JLabel label_9 = new JLabel("연료종류 : ");
		label_9.setFont(new Font("돋움", Font.BOLD, 25));
		label_9.setBounds(585, 358, 149, 31);
		panel_1.add(label_9);

		JLabel label_10 = new JLabel("트랜스미션 : ");
		label_10.setFont(new Font("돋움", Font.BOLD, 25));
		label_10.setBounds(585, 400, 164, 32);
		panel_1.add(label_10);

		JLabel label_11 = new JLabel("옵션 : ");
		label_11.setFont(new Font("돋움", Font.BOLD, 25));
		label_11.setBounds(585, 444, 149, 33);
		panel_1.add(label_11);

		JLabel label_12 = new JLabel("보증기간 : ");
		label_12.setFont(new Font("돋움", Font.BOLD, 25));
		label_12.setBounds(585, 489, 149, 31);
		panel_1.add(label_12);

		JLabel label_13 = new JLabel("차량번호 : ");
		label_13.setFont(new Font("돋움", Font.BOLD, 25));
		label_13.setBounds(585, 529, 149, 31);
		panel_1.add(label_13);

		JButton button = new JButton("사진1");
		button.setBounds(12, 48, 559, 513);
		panel_1.add(button);

		color = new JTextField();
		color.setColumns(10);
		color.setBounds(736, 316, 156, 32);
		panel_1.add(color);

		distance = new JTextField();
		distance.setColumns(10);
		distance.setBounds(736, 188, 156, 32);
		panel_1.add(distance);

		year = new JTextField();
		year.setColumns(10);
		year.setBounds(736, 229, 156, 32);
		panel_1.add(year);

		location = new JTextField();
		location.setColumns(10);
		location.setBounds(736, 272, 156, 32);
		panel_1.add(location);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(736, 143, 156, 32);
		panel_1.add(price);

		namber = new JTextField();
		namber.setColumns(10);
		namber.setBounds(736, 528, 156, 32);
		panel_1.add(namber);

		guarantee = new JTextField();
		guarantee.setColumns(10);
		guarantee.setBounds(736, 485, 156, 32);
		panel_1.add(guarantee);

		opt = new JTextField();
		opt.setColumns(10);
		opt.setBounds(736, 444, 156, 32);
		panel_1.add(opt);

		JComboBox combo_Brand = new JComboBox();
		combo_Brand.setBounds(736, 12, 156, 31);
		panel_1.add(combo_Brand);

		for (int i = 0; i < brands.length; i++) { // 제조사들 combobox에 삽입
			combo_Brand.addItem(brands[i]);
		}

		combo_Brand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JComboBox combo_Type = new JComboBox();
		combo_Type.setBounds(736, 55, 156, 31);
		panel_1.add(combo_Type);

		for (int i = 0; i < types.length; i++) {
			combo_Type.addItem(types[i]);
		}

		combo_Type.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});

		JComboBox combo_Cname = new JComboBox();
		combo_Cname.setBounds(736, 98, 156, 31);
		panel_1.add(combo_Cname);

		for (int i = 0; i < imgs.length; i++) {
			combo_Cname.addItem(imgs[i].substring(0, imgs[i].lastIndexOf(".")));
		}

		combo_Cname.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int a = combo_Cname.getSelectedIndex();
				ImageIcon icon = new ImageIcon(imgs[a]);
				button.setIcon(icon);
			}
		});

		JComboBox combo_Fuel = new JComboBox();
		combo_Fuel.setBounds(736, 358, 156, 31);
		panel_1.add(combo_Fuel);

		combo_Fuel.addItem("gasoline");
		combo_Fuel.addItem("diesel");
		combo_Fuel.addItem("gas");

		combo_Fuel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});

		JComboBox combo_Transmission = new JComboBox();
		combo_Transmission.setBounds(736, 400, 156, 31);
		panel_1.add(combo_Transmission);

		combo_Transmission.addItem("Auto");
		combo_Transmission.addItem("Manual");

		combo_Transmission.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});

		// 프로젝트 보완해야 할 것
		// 차량번호 중복 조회 기능 추가(ㅇ), not null값인 것들 null로 입력되지 못하게 방지
//		jcombobox : 제조사, 차종, 차량명, 연료종류, 트랜스미션, 보증기간
//		(제조사 - 차종 - 차량명 나오게끔)
//		jtextfiled : 가격, 키로수, 위치, 색상, 옵션, 차량번호
		//-----------------------------------------
		// 로그인이 되어 있으면 팔기에 바로 들어갈 수 있게, 로그인이 안되어 있으면 로그인 창이 뜨게끔 연결(필수)
		// 팔기에 등록 시 등록번호를 부여하여 mainframe에서 그 등록번호를 통해서 자료를 땡기게끔
		// 이미지를 등록할 수 있으면 등록할 수 있게 연결
		// TextField 값을 수정하지 못하도록

		JButton btnNewButton = new JButton("등록");	//등록 중복검사까지 완료
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CarinfoDTO dto = new CarinfoDTO();
				dto.setBrand(brands[combo_Brand.getSelectedIndex()]);
				dto.setType(types[combo_Type.getSelectedIndex()]);
				dto.setPrice(price.getText());
				dto.setDistance(distance.getText());
				dto.setYear(year.getText());
				dto.setLocation(location.getText());
				dto.setColor(color.getText());
				dto.setFuel((String) combo_Fuel.getSelectedItem());
				dto.setTransmission((String) combo_Transmission.getSelectedItem());
				dto.setOpt(opt.getText());
				dto.setGuarantee(guarantee.getText());
				dto.setNamber(namber.getText());
				dto.setCname((String) combo_Cname.getSelectedItem());
				dto.setImg(imgs[combo_Cname.getSelectedIndex()]);
				dto.setCid(id);

				int n = dao.NewCnum() + 1;
				dto.setCnum(n);

				if (namber.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "중복검사를 해주세요!");
					return;
				} else {
					if (check == 1) {	// check가 1일 때 중복검사 통과한 것
						try {
							dao.insert(dto);

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "");
						}

					} else {
						JOptionPane.showMessageDialog(null, "중복검사를 해주세요!");
					}
				}

			}
		});
		btnNewButton.setFont(new Font("돋움", Font.BOLD, 20));
		btnNewButton.setBounds(585, 614, 88, 31);
		panel_1.add(btnNewButton);

		JButton button_1 = new JButton("이전");	//이전(완료)
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});

		button_1.setFont(new Font("돋움", Font.BOLD, 20));
		button_1.setBounds(880, 614, 88, 31);
		panel_1.add(button_1);

		JButton button_2 = new JButton("수정");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// id를 검색해서 올린 판매글이 몇건인지를 가져오고 선택해서 그 글에 대한 정보를 수정할 수 있게끔 연동
				// select이용해서 dto에 정보를 불러와서 각 textfield에 나타내게 한 후에 수정한 값들을 저장하게끔 + 수정하지 못하는 값들을
				// 지정해보기!
				CarinfoDTO dto = new CarinfoDTO();

				dto.setBrand(brands[combo_Brand.getSelectedIndex()]);
				dto.setType(types[combo_Type.getSelectedIndex()]);
				dto.setPrice(price.getText());
				dto.setDistance(distance.getText());
				dto.setYear(year.getText());
				dto.setLocation(location.getText());
				dto.setColor(color.getText());
				dto.setFuel((String) combo_Fuel.getSelectedItem());
				dto.setTransmission((String) combo_Transmission.getSelectedItem());
				dto.setOpt(opt.getText());
				dto.setGuarantee(guarantee.getText());
				dto.setNamber(namber.getText());
				dto.setCname((String) combo_Cname.getSelectedItem());

				System.out.println();
				dto.setImg(imgs[combo_Cname.getSelectedIndex()]);
				// 차량정보를 수정할 수 없게끔

				dao.update(dto);
				JOptionPane.showMessageDialog(null, namber.getText() + "차량의 정보가 수정되었습니다!");

			}
		});

		button_2.setFont(new Font("돋움", Font.BOLD, 20));
		button_2.setBounds(778, 614, 88, 31);
		panel_1.add(button_2);
		
		//조회 시 없는 조건에 대하여 에러 발생시킴
		JButton button_3 = new JButton("조회");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// id를 검색해서 올린 판매글이 몇건인지를 가져오고 선택해서 그 글에 대한 정보를 수정할 수 있게끔 연동
				String snamber = JOptionPane.showInputDialog("차 번호 입력");
				// select이용해서 dto에 정보를 불러와서 각 textfield에 나타내게 한 후에 수정한 값들을 저장하게끔 + 수정하지 못하는 값들을
				// 지정해보기!
				CarinfoDTO dto = new CarinfoDTO();
				try {
					dto = dao.select(snamber);
					combo_Brand.setSelectedItem(dto.getBrand());	// selecteditem 무엇인지 확인(완료)
					combo_Type.setSelectedItem(dto.getType());
					price.setText(dto.getPrice());
					distance.setText(dto.getDistance());
					year.setText(dto.getYear());
					location.setText(dto.getLocation());
					color.setText(dto.getColor());
					combo_Fuel.setSelectedItem(dto.getFuel());
					combo_Transmission.setSelectedItem(dto.getTransmission());
					opt.setText(dto.getOpt());
					guarantee.setText(dto.getGuarantee());
					namber.setText(dto.getNamber());
					namber.setEditable(false); // namber부분이 잠기는지 확인
					combo_Cname.setSelectedItem(dto.getCname());
					
					ImageIcon icon = new ImageIcon(dto.getImg());
					System.out.println(dto.getImg());
					button.setIcon(icon);
					
					JOptionPane.showMessageDialog(null, snamber + "차량의 정보가 조회되었습니다!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "차량번호를 확인해주세요!");
				}


			}
		});
		button_3.setFont(new Font("돋움", Font.BOLD, 20));
		button_3.setBounds(687, 614, 88, 31);
		panel_1.add(button_3);

		JButton btnNewButton_1 = new JButton("중복검사");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CarinfoDTO dto = new CarinfoDTO();

				// 입력 안했을 때(중복검사 해주세요), 중복값이 있을 때, 중복값이 없을 때
				dto = dao.select(namber.getText());
				if (dto == null) {
					if (namber.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "중복검사를 해주세요!");
						check = 0;
					} else {
						JOptionPane.showMessageDialog(null, "사용가능한 번호입니다!");
						check = 1;
					}

				} else {
					JOptionPane.showMessageDialog(null, "이미 있는 차량번호 입니다!");
					check = 0;
				}

			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_1.setBounds(894, 529, 88, 31);
		panel_1.add(btnNewButton_1);

		f.setVisible(true);

	}
}
