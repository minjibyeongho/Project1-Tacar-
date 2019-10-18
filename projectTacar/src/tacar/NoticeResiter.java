package tacar;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class NoticeResiter {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JLabel lblTitle;
	private JLabel lblContent;

	public NoticeResiter(String id) {
		Calendar cal = Calendar.getInstance();
		JFrame f = new JFrame();
		f.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(93, 135, 169, 33);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 180, 358, 163);
		f.getContentPane().add(textField_1);

		textField_2 = new JPasswordField();
		textField_2.setEchoChar('*');
		textField_2.setColumns(10);
		textField_2.setBounds(192, 362, 103, 33);
		f.getContentPane().add(textField_2);
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setBounds(131, 362, 57, 33);
		f.getContentPane().add(lblNewLabel);

		lblTitle = new JLabel("TITLE");
		lblTitle.setBounds(14, 135, 77, 33);
		f.getContentPane().add(lblTitle);

		lblContent = new JLabel("CONTENT");
		lblContent.setBounds(14, 227, 77, 33);
		f.getContentPane().add(lblContent);

		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardDTO dto = new BoardDTO();
				BoardDAO dao = new BoardDAO();

				Date today = new Date(0);
				SimpleDateFormat date = new SimpleDateFormat("k:mm:ss");

				String bpw = textField_2.getText();
				String title = textField.getText();
				String content = textField_1.getText();

				dto.setId(id);
				dto.setBpw(bpw);
				dto.setTime(date.format(cal.getTime()));
				dto.setTitle(title);
				dto.setContent(content);
				dto.setNumber(dao.newnum(id) + 1);
				dao.insert(dto);

				int num2 = dao.newnum(id);
				NoticeBoardList name = new NoticeBoardList(id);

				f.setVisible(false);

			}
		});
		btnNewButton.setBounds(374, 368, 77, 27);
		f.getContentPane().add(btnNewButton);

		JButton button = new JButton("목록");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeBoardList name = new NoticeBoardList(id);
				f.setVisible(false);
			}
		});
		button.setBounds(0, 368, 89, 27);
		f.getContentPane().add(button);

		JButton btnNewButton_1 = new JButton("Main");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrameLogIn name = new MainFrameLogIn(id);
				f.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 109, 82, 27);
		f.getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 482, 100);
		f.getContentPane().add(panel);

		JLabel label = new JLabel("TACAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBounds(0, 0, 190, 47);
		panel.add(label);

		f.setSize(500, 500);
		f.setVisible(true);
	}
}
