package tacar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CustomerCenter {
	private JTextField title;
	private JTextField date;
	private JTextField content;

	public CustomerCenter() { // 생성자호출
		JFrame f = new JFrame();

//		f.setSize(980, 890);
		f.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 962, 643);
		panel.setLayout(null); // panel도 jframe과 같이 layout 지정이 가능하고 default로 mgr로 되어있음(mgr이 뭔지는 모르겠음;;)
		f.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9 : ");
		lblNewLabel.setFont(new Font("궁서", Font.BOLD, 30));
		lblNewLabel.setBounds(14, 12, 173, 50);
		panel.add(lblNewLabel);

		title = new JTextField();
		title.setFont(new Font("굴림", Font.PLAIN, 25));
		title.setBounds(186, 12, 740, 50);
		panel.add(title);
		title.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC791\uC131\uC77C\uC2DC : ");
		lblNewLabel_1.setFont(new Font("궁서", Font.BOLD, 30));
		lblNewLabel_1.setBounds(14, 77, 173, 50);
		panel.add(lblNewLabel_1);

		date = new JTextField();
		date.setFont(new Font("굴림", Font.PLAIN, 25));
		date.setBounds(186, 74, 740, 50);
		panel.add(date);
		date.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\uB0B4\uC6A9");
		lblNewLabel_2.setFont(new Font("궁서", Font.BOLD, 30));
		lblNewLabel_2.setBounds(14, 139, 131, 50);
		panel.add(lblNewLabel_2);

		content = new JTextField();
		content.setBounds(14, 189, 912, 366);
		panel.add(content);
		content.setColumns(10);

		JButton save = new JButton("\uC800\uC7A5\uD558\uAE30");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter file = new FileWriter(title.getText() + ".txt"); // fileWriter 객체 생성

					file.write("제목 : " + title.getText() + "\n");
					file.write("작성날짜 : " + date.getText() + "\n");
					file.write("내용\n" + content.getText() + "\n");

					JOptionPane.showMessageDialog(null, "저장완료!!");
					file.close(); // fileWriter 객체를 닫아줌

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		save.setBounds(14, 567, 165, 50);
		panel.add(save);
		f.setBounds(0, 100, 980, 690);

		f.setVisible(true);

	}
}
