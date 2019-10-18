package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class BuyCarInformation {
	private JTextField color;
	private JTextField brand;
	private JTextField type;
	private JTextField cname;
	private JTextField price;
	private JTextField distance;
	private JTextField year;
	private JTextField location;
	private JTextField fuel;
	private JTextField transmission;
	private JTextField opt;
	private JTextField guarantee;
	private JTextField namber;

	public BuyCarInformation(CarinfoDTO dto) {	//dto안에 차량 판매자 id 들어있음(cid)
		System.out.println("NO!!!!");
		String[] imgs = { "ACCENT.png", "AVANTE.png", "CLIO.png", "CONA.png", "CORANDO.png", "CRUISE.png",
				"GENESIS.png", "IONIC.png", "K3.png", "K5.png", "LACETTI.png", "LOTZE.png", "MALIBU.png", "MORNING.png",
				"PRIDE.png", "QM3.png", "QM5.png", "QM6.png", "RAY.png", "SANTAFE.png", "SM3.png", "SM5.png", "SM6.png",
				"SONATA.png", "SORENTO.png", "SPARK.png", "STONIC.png", "TUCSON.png" };
		String[] types = { "subcompact", "compact", "midsize", "sedan", "suv", "rv" };
		String[] brands = { "hyundai", "samsung", "kia", "chevrolet", "ssanyong", "daewoo", "genesis" };

		if(dto.getNamber().equals(MainFrame.recent1) || dto.getNamber().equals(MainFrame.recent2) || dto.getNamber().equals(MainFrame.recent3)) { 
			
		} else { 
			MainFrame.recent3 = MainFrame.recent2;
			MainFrame.recent2 = MainFrame.recent1;
			MainFrame.recent1 = dto.getNamber();
		}
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

		JButton picture = new JButton("사진1");
		picture.setBounds(12, 12, 559, 513);
		panel_1.add(picture);

		color = new JTextField();
		color.setColumns(10);
		color.setBounds(736, 316, 230, 32);
		panel_1.add(color);


		JButton btnNewButton = new JButton("판매자정보");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB에 등록된 아이디로 판매자 정보 출력( 판매 등록 시 아이디가 들어갈 수 있게끔 )
				// 가져온 dto에는 판매자의 dto정보가 담겨있음.
				SellCarOwner sco1 = new SellCarOwner(dto.getCid());


			}
		});
		
		btnNewButton.setFont(new Font("돋움", Font.BOLD, 20));
		btnNewButton.setBounds(747, 606, 150, 30);
		panel_1.add(btnNewButton);
		
//		//조회 시 없는 조건에 대하여 에러 발생시킴
//		JButton button_3 = new JButton("구매요청");
//		button_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//
//			}
//		});
//		button_3.setFont(new Font("돋움", Font.BOLD, 20));
//		button_3.setBounds(585, 606, 150, 30);
//		panel_1.add(button_3);
		
		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(736, 12, 230, 32);
		panel_1.add(brand);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(736, 58, 230, 32);
		panel_1.add(type);
		
		cname = new JTextField();
		cname.setColumns(10);
		cname.setBounds(736, 98, 230, 32);
		panel_1.add(cname);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(736, 144, 230, 32);
		panel_1.add(price);
		
		distance = new JTextField();
		distance.setColumns(10);
		distance.setBounds(736, 188, 230, 32);
		panel_1.add(distance);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(736, 229, 230, 32);
		panel_1.add(year);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(736, 272, 230, 32);
		panel_1.add(location);
		
		fuel = new JTextField();
		fuel.setColumns(10);
		fuel.setBounds(736, 358, 230, 32);
		panel_1.add(fuel);
		
		transmission = new JTextField();
		transmission.setColumns(10);
		transmission.setBounds(736, 400, 230, 32);
		panel_1.add(transmission);
		
		opt = new JTextField();
		opt.setColumns(10);
		opt.setBounds(736, 444, 230, 32);
		panel_1.add(opt);
		
		guarantee = new JTextField();
		guarantee.setColumns(10);
		guarantee.setBounds(736, 488, 230, 32);
		panel_1.add(guarantee);
		
		namber = new JTextField();
		namber.setColumns(10);
		namber.setBounds(736, 529, 230, 32);
		panel_1.add(namber);

		// 버튼에사진 가져오기
		ImageIcon icon = new ImageIcon(dto.getImg());
		Image img = icon.getImage();
		Image newing = img.getScaledInstance(559, 513, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newing);
		picture.setIcon(icon);
		
		//각 자료 가져오기
		brand.setText(dto.getBrand());
		brand.setEditable(false);
		type.setText(dto.getType());
		type.setEditable(false);
		cname.setText(dto.getCname());
		cname.setEditable(false);
		price.setText(dto.getPrice());
		price.setEditable(false);
		distance.setText(dto.getDistance());
		distance.setEditable(false);
		color.setText(dto.getColor());
		color.setEditable(false);
		//나머지 editable 작성
		year.setText(dto.getYear());
		year.setEditable(false);
		location.setText(dto.getLocation());
		location.setEditable(false);
		fuel.setText(dto.getFuel());
		fuel.setEditable(false);
		transmission.setText(dto.getTransmission());
		transmission.setEditable(false);
		opt.setText(dto.getOpt());
		opt.setEditable(false);
		guarantee.setText(dto.getGuarantee());
		guarantee.setEditable(false);
		namber.setText(dto.getNamber());
		namber.setEditable(false);
		
		
		
		
		f.setVisible(true);

	}

	public BuyCarInformation(CarinfoDTO dto, String id) {	//dto안에 차량 판매자 id 들어있음(cid), 구매예정자 id 가져옴
		System.out.println("OK!!!");
		String[] imgs = { "ACCENT.png", "AVANTE.png", "CLIO.png", "CONA.png", "CORANDO.png", "CRUISE.png",
				"GENESIS.png", "IONIC.png", "K3.png", "K5.png", "LACETTI.png", "LOTZE.png", "MALIBU.png", "MORNING.png",
				"PRIDE.png", "QM3.png", "QM5.png", "QM6.png", "RAY.png", "SANTAFE.png", "SM3.png", "SM5.png", "SM6.png",
				"SONATA.png", "SORENTO.png", "SPARK.png", "STONIC.png", "TUCSON.png" };
		String[] types = { "subcompact", "compact", "midsize", "sedan", "suv", "rv" };
		String[] brands = { "hyundai", "samsung", "kia", "chevrolet", "ssanyong", "daewoo", "genesis" };

		
		if(dto.getNamber().equals(MainFrame.recent1) || dto.getNamber().equals(MainFrame.recent2) || dto.getNamber().equals(MainFrame.recent3)) { 
			
		} else { 
			MainFrame.recent3 = MainFrame.recent2;
			MainFrame.recent2 = MainFrame.recent1;
			MainFrame.recent1 = dto.getNamber();
		}
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

		JButton picture = new JButton("사진1");
		picture.setBounds(12, 12, 559, 513);
		panel_1.add(picture);

		color = new JTextField();
		color.setColumns(10);
		color.setBounds(736, 316, 230, 32);
		panel_1.add(color);


		JButton btnNewButton = new JButton("판매자정보");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB에 등록된 아이디로 판매자 정보 출력( 판매 등록 시 아이디가 들어갈 수 있게끔 )
				// 가져온 dto에는 판매자의 dto정보가 담겨있음.
				SellCarOwner sco1 = new SellCarOwner(dto.getCid());
			}
		});
		
		btnNewButton.setFont(new Font("돋움", Font.BOLD, 20));
		btnNewButton.setBounds(747, 606, 150, 30);
		panel_1.add(btnNewButton);
		
		//조회 시 없는 조건에 대하여 에러 발생시킴
		JButton button_3 = new JButton("구매요청");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "판매가 :" + dto.getPrice());
				String bprice = JOptionPane.showInputDialog("구매 희망가격 입력 : ");
				MemberDAO mdao = new MemberDAO();
				mdao.buyupdate(id, bprice, dto.getCid());


			}
		});
		button_3.setFont(new Font("돋움", Font.BOLD, 20));
		button_3.setBounds(585, 606, 150, 30);
		panel_1.add(button_3);
		
		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(736, 12, 230, 32);
		panel_1.add(brand);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(736, 58, 230, 32);
		panel_1.add(type);
		
		cname = new JTextField();
		cname.setColumns(10);
		cname.setBounds(736, 98, 230, 32);
		panel_1.add(cname);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(736, 144, 230, 32);
		panel_1.add(price);
		
		distance = new JTextField();
		distance.setColumns(10);
		distance.setBounds(736, 188, 230, 32);
		panel_1.add(distance);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(736, 229, 230, 32);
		panel_1.add(year);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(736, 272, 230, 32);
		panel_1.add(location);
		
		fuel = new JTextField();
		fuel.setColumns(10);
		fuel.setBounds(736, 358, 230, 32);
		panel_1.add(fuel);
		
		transmission = new JTextField();
		transmission.setColumns(10);
		transmission.setBounds(736, 400, 230, 32);
		panel_1.add(transmission);
		
		opt = new JTextField();
		opt.setColumns(10);
		opt.setBounds(736, 444, 230, 32);
		panel_1.add(opt);
		
		guarantee = new JTextField();
		guarantee.setColumns(10);
		guarantee.setBounds(736, 488, 230, 32);
		panel_1.add(guarantee);
		
		namber = new JTextField();
		namber.setColumns(10);
		namber.setBounds(736, 529, 230, 32);
		panel_1.add(namber);

		// 버튼에사진 가져오기
		ImageIcon icon = new ImageIcon(dto.getImg());
		Image img = icon.getImage();
		Image newing = img.getScaledInstance(559, 513, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newing);
		picture.setIcon(icon);
		
		//각 자료 가져오기
		brand.setText(dto.getBrand());
		brand.setEditable(false);
		type.setText(dto.getType());
		type.setEditable(false);
		cname.setText(dto.getCname());
		cname.setEditable(false);
		price.setText(dto.getPrice());
		price.setEditable(false);
		distance.setText(dto.getDistance());
		distance.setEditable(false);
		color.setText(dto.getColor());
		color.setEditable(false);
		//나머지 editable 작성
		year.setText(dto.getYear());
		year.setEditable(false);
		location.setText(dto.getLocation());
		location.setEditable(false);
		fuel.setText(dto.getFuel());
		fuel.setEditable(false);
		transmission.setText(dto.getTransmission());
		transmission.setEditable(false);
		opt.setText(dto.getOpt());
		opt.setEditable(false);
		guarantee.setText(dto.getGuarantee());
		guarantee.setEditable(false);
		namber.setText(dto.getNamber());
		namber.setEditable(false);
		
		
		
		
		f.setVisible(true);

	}


}
