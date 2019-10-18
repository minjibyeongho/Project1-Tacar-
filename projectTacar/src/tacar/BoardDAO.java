package tacar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BoardDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String password;

	int num;

	BoardDTO dto = new BoardDTO();
	
	public void update(BoardDTO dto) {

		// 1. ����̹� ����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			// 2. DB����(DB��, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			// 3. SQL ����
			String sql = "update board set reply = ? where number = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getReply());
			ps.setInt(2, dto.getNumber());

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			ps.executeUpdate();
			System.out.println("4. SQL�� ���� OK!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public ArrayList selectAll() {
	
			ArrayList list = new ArrayList();
			BoardDTO dto = null;
	

		// 1. ����̹� ����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			// 2. DB����(DB��, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			String sql = "select * from board order by number desc;";
			ps = con.prepareStatement(sql);

			System.out.println("3. SQL�� ���� OK!!!");

			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new BoardDTO();
				dto.setId(rs.getString(1));
				dto.setBpw(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setTime(rs.getString(5));
				dto.setNumber(rs.getInt(6));
				dto.setReply(rs.getString(7));

				list.add(dto);

			}
			System.out.println("4. SQL�� ���� OK!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int newnum(String id) { // 최근 기재된 게시글 번호찾기
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			String sql = "SELECT MAX(number) FROM board;";
			ps = con.prepareStatement(sql);

			System.out.println("3. SQL�� ���� OK!!!");

			rs = ps.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

	public void check(String id) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");
			int num2 = 1;
			while (true) {
				String sql = "select * from board where number = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, num2);
				System.out.println("3. SQL�� ���� OK!!!");

				rs = ps.executeQuery(); // query������ �޾ƿ��� ��(�˻���� ���̺��� �޾ƿ�)
				if (rs.next()) { // ���̺��� ������(�� record��)
					num2++;

				} else {
					NoticeBoardList name = new NoticeBoardList(id);
					break;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public BoardDTO select(BoardDTO dto) {

		// 1. ����̹� ����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			// 2. DB����(DB��, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			// 3. SQL ����
			String sql = "select * from board where number = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getNumber());

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			rs = ps.executeQuery(); // query������ �޾ƿ��� ��(�˻���� ���̺��� �޾ƿ�)
			if (rs.next()) { // ���̺��� ������(�� record��)
				dto.setId(rs.getString(1));
				dto.setBpw(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setTime(rs.getString(5));
				dto.setNumber(rs.getInt(6));
				dto.setReply(rs.getString(7));

			} else {
				dto = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto; // dto1 ��ȯ
	}

	public BoardDTO search(int num) { // 글 번호를 입력받아 게시글 DTO반환

		BoardDTO dto = new BoardDTO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			String sql = "select * from board where number = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);

			System.out.println("3. SQL�� ���� OK!!!");

			rs = ps.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setBpw(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setTime(rs.getString(5));
				dto.setNumber(rs.getInt(6));
				dto.setReply(rs.getString(7));
				

			} else {
				dto = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto; // dto1 ��ȯ
	}

	public void insert(BoardDTO dto) {

		// 1. ����̹� ����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			// 3. SQL ����
			String sql = "insert into board values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getBpw());
			ps.setString(3, dto.getTitle());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getTime());
			ps.setInt(6, dto.getNumber());
			ps.setString(7, dto.getReply());
			System.out.println("3. SQL�� ���� OK!!!");

			ps.executeUpdate();
			System.out.println("4. SQL전송, insert OK!!!");

			JOptionPane.showMessageDialog(null, "작성이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(BoardDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. ����̹� ���� OK!!!");

			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";

			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB���� OK!!!");

			String sql = "delete from board where number=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getNumber());
			System.out.println("4. SQL전송, insert OK!!!");

			JOptionPane.showMessageDialog(null, "삭제 완료");
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
