package tacar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO {

	// �������

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String password;

	public ArrayList selectAll() {
		ArrayList list = new ArrayList();
		MemberDTO dto = null;

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
			String sql = "select * from member";
			ps = con.prepareStatement(sql);

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			rs = ps.executeQuery(); // query������ �޾ƿ��� ��(�˻���� ���̺��� �޾ƿ�)

			while (rs.next()) { // ���̺��� ������(�� record��)
				dto = new MemberDTO();
				dto.setId(rs.getString(1));
				dto.setPw(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setBirth(rs.getString(5));
				dto.setGender(rs.getString(6));
				dto.setAddress(rs.getString(7));
				dto.setPhone(rs.getString(8));
				dto.setPwask(rs.getString(9));
				dto.setOwnnered(rs.getString(10));
				dto.setEmail(rs.getString(11));
				dto.setPurpose(rs.getString(12));
				dto.setAdminkey(rs.getString(13));
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

	public MemberDTO select(String id) {
		MemberDTO sdto1 = null;

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
			String sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			rs = ps.executeQuery(); // query������ �޾ƿ��� ��(�˻���� ���̺��� �޾ƿ�)

			if (rs.next()) { // ���̺��� ������(�� record��)
				sdto1 = new MemberDTO();
				sdto1.setId(rs.getString(1));
				sdto1.setPw(rs.getString(2));
				sdto1.setPwcheck(rs.getString(3));
				sdto1.setName(rs.getString(4));
				sdto1.setBirth(rs.getString(5));
				sdto1.setGender(rs.getString(6));
				sdto1.setAddress(rs.getString(7));
				sdto1.setPhone(rs.getString(8));
				sdto1.setPwask(rs.getString(9));
				sdto1.setOwnnered(rs.getString(10));
				sdto1.setEmail(rs.getString(11));
				sdto1.setPurpose(rs.getString(12));
				sdto1.setAdminkey(rs.getString(13));
				sdto1.setBid(rs.getString(14));
				sdto1.setBprice(rs.getString(15));

			} else {
				System.out.println("�˻������ �����ϴ�...");
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
		return sdto1; // dto1 ��ȯ
	}
	
	public void insert(MemberDTO dto) {

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
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getPwcheck());
			ps.setString(4, dto.getName());
			ps.setString(5, dto.getBirth());
			ps.setString(6, dto.getGender());
			ps.setString(7, dto.getAddress());
			ps.setString(8, dto.getPhone());
			ps.setString(9, dto.getPwask());
			ps.setString(10, dto.getOwnnered());
			ps.setString(11, dto.getEmail());
			ps.setString(12, dto.getPurpose());
			ps.setString(13, dto.getAdminkey());
			ps.setString(14, null);
			ps.setString(15, null);

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			ps.executeUpdate();
			System.out.println("4. SQL전송, insert OK!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
	}

	public void update(MemberDTO dto) {

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
			String sql = "update member set pw=?, pwcheck=?, name=?, birth=?, address=?, "
					+ "phone=?, pwask=?, ownnered=?, email=?, purpose=?, adminkey=?"
					+ ", bid =?, bprice=? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getPwcheck());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getBirth());
			ps.setString(5, dto.getAddress());
			ps.setString(6, dto.getPhone());
			ps.setString(7, dto.getPwask());
			ps.setString(8, dto.getOwnnered());
			ps.setString(9, dto.getEmail());
			ps.setString(10, dto.getPurpose());
			ps.setString(11, dto.getAdminkey());
			ps.setString(12, dto.getBid());
			ps.setString(13, dto.getBprice());
			ps.setString(14, dto.getId());

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			ps.executeUpdate();
			System.out.println("4. SQL�� ���� OK!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buyupdate(String bid, String bprice, String sid) {

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
			String sql = "update member set bid=?, bprice=? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bid);
			ps.setString(2, bprice);
			ps.setString(3, sid);

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			ps.executeUpdate();
			System.out.println("4. SQL�� ���� OK!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void delete(MemberDTO dto) {

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
			String sql = "delete from member where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());

			System.out.println("3. SQL�� ���� OK!!!");

			// 4. SQL ����
			ps.executeUpdate();
			System.out.println("4. SQL�� ���� OK!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
