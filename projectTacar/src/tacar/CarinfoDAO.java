package tacar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CarinfoDAO {

	ResultSet rs;
	PreparedStatement ps;
	Connection con;
	String url;
	String user;
	String password;

	
	// 등록된 게시글 번호 최대값 가져오는 메소드 만들기
	public int NewCnum() {
		CarinfoDTO dto = new CarinfoDTO();
		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "select max(cnum) from carinfo";
			ps = con.prepareStatement(sql);

			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 OK!!!");

			// 5. 테이블 결과 처리
			if (rs.next()) {
				dto = new CarinfoDTO();
				int cnum = rs.getInt(1);
				dto.setCnum(cnum);
			
			}else {
				System.out.println("검색 결과가 없습니다!!ㅠㅠㅠㅠㅠㅠ");
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
		} // finally End
		return dto.getCnum();
		
	}	
	
	public ArrayList selectAll() {
		ArrayList list = new ArrayList();
		CarinfoDTO dto = null;

		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "select * from carinfo";
			ps = con.prepareStatement(sql);

			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 OK!!!");

			// 5. 테이블 결과 처리
			while (rs.next()) {
				dto = new CarinfoDTO(); // dto객체 생성
				String brand = rs.getString(1);
				String type = rs.getString(2);
				String price = rs.getString(3);
				String distance = rs.getString(4);
				String year = rs.getString(5);
				String location = rs.getString(6);
				String color = rs.getString(7);
				String fuel = rs.getString(8);
				String transmission = rs.getString(9);
				String opt = rs.getString(10);
				String guarantee = rs.getString(11);
				String namber = rs.getString(12);
				String cname = rs.getString(13);
				String img = rs.getString(14);
				String cid = rs.getString(16);

				dto.setBrand(brand);
				dto.setType(type);
				dto.setPrice(price);
				dto.setDistance(distance);
				dto.setYear(year);
				dto.setLocation(location);
				dto.setColor(color);
				dto.setFuel(fuel);
				dto.setTransmission(transmission);
				dto.setOpt(opt);
				dto.setGuarantee(guarantee);
				dto.setNamber(namber);
				dto.setCname(cname);
				dto.setImg(img);
				dto.setCid(cid);

				list.add(dto); // dto객체를 받아와서 list에 삽입

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
		} // finally End

		return list;
	}

	public CarinfoDTO select(String namber) {
		CarinfoDTO dto = null;

		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "select * from carinfo where namber = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, namber);

			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 OK!!!");

			// 5. 테이블 결과 처리
			if (rs.next()) {
				dto = new CarinfoDTO(); // dto객체 생성
				rs.getString(1);
				String brand = rs.getString(1);
				String type = rs.getString(2);
				String price = rs.getString(3);
				String distance = rs.getString(4);
				String year = rs.getString(5);
				String location = rs.getString(6);
				String color = rs.getString(7);
				String fuel = rs.getString(8);
				String transmission = rs.getString(9);
				String opt = rs.getString(10);
				String guarantee = rs.getString(11);
				String cname = rs.getString(13);
				String img = rs.getString(14);
				int cnum = rs.getInt(15);
				String cid = rs.getString(16);

				dto.setBrand(brand);
				dto.setType(type);
				dto.setPrice(price);
				dto.setDistance(distance);
				dto.setYear(year);
				dto.setLocation(location);
				dto.setColor(color);
				dto.setFuel(fuel);
				dto.setTransmission(transmission);
				dto.setOpt(opt);
				dto.setGuarantee(guarantee);
				dto.setNamber(namber);
				dto.setCname(cname);
				dto.setImg(img);
				dto.setCnum(cnum);
				dto.setCid(cid);

			} else {
				JOptionPane.showMessageDialog(null, "검색결과가 없습니다!");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally End

		return dto;

	}// Select End

	public CarinfoDTO selectPrice(String cid) {
		System.out.println("-----test cid----");
		System.out.println(cid);
		CarinfoDTO dto = null;

		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "select * from carinfo where cid = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cid);

			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 OK!!!");

			// 5. 테이블 결과 처리
			if (rs.next()) {
				dto = new CarinfoDTO(); // dto객체 생성
				String brand = rs.getString(1);
				String type = rs.getString(2);
				String price = rs.getString(3);
				String distance = rs.getString(4);
				String year = rs.getString(5);
				String location = rs.getString(6);
				String color = rs.getString(7);
				String fuel = rs.getString(8);
				String transmission = rs.getString(9);
				String opt = rs.getString(10);
				String guarantee = rs.getString(11);
				String namber = rs.getString(12);
				String cname = rs.getString(13);
				String img = rs.getString(14);
				int cnum = rs.getInt(15);

				dto.setBrand(brand);
				dto.setType(type);
				dto.setPrice(price);
				dto.setDistance(distance);
				dto.setYear(year);
				dto.setLocation(location);
				dto.setColor(color);
				dto.setFuel(fuel);
				dto.setTransmission(transmission);
				dto.setOpt(opt);
				dto.setGuarantee(guarantee);
				dto.setNamber(namber);
				dto.setCname(cname);
				dto.setImg(img);
				dto.setCnum(cnum);
				dto.setCid(cid);

			} else {
				JOptionPane.showMessageDialog(null, "검색결과가 없습니다!");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally End

		return dto;

	}// Select End

	
	public void delete(String namber) {
		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "delete from carinfo where namber = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, namber);

			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 OK!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally End
	}// Delete End

	public void update(CarinfoDTO dto) {
		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "update carinfo set brand=?, type=?, price=?, distance=?, year=?,location=?,"
					+ "color=?, fuel=?, transmission=?, opt=?, guarantee=?, cname=?, img=? where namber=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBrand());
			ps.setString(2, dto.getType());
			ps.setString(3, dto.getPrice());
			ps.setString(4, dto.getDistance());
			ps.setString(5, dto.getYear());
			ps.setString(6, dto.getLocation());
			ps.setString(7, dto.getColor());
			ps.setString(8, dto.getFuel());
			ps.setString(9, dto.getTransmission());
			ps.setString(10, dto.getOpt());
			ps.setString(11, dto.getGuarantee());
			ps.setString(12, dto.getCname());
			ps.setString(13, dto.getImg());
			ps.setString(14, dto.getNamber());
			//cnum을 넣어야할지 말아야할지

			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 OK!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally End
	}// Update End

	public void insert(CarinfoDTO dto) {

		// 1. 드라이버 연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 연결 OK!!!");

			// 2. DB연결(DB명, id, pw)
			url = "jdbc:mysql://localhost:3306/tacar";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("2. DB연결 OK!!!");

			// 3. SQL문 결정
			String sql = "insert into carinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBrand());
			ps.setString(2, dto.getType());
			ps.setString(3, dto.getPrice());
			ps.setString(4, dto.getDistance());
			ps.setString(5, dto.getYear());
			ps.setString(6, dto.getLocation());
			ps.setString(7, dto.getColor());
			ps.setString(8, dto.getFuel());
			ps.setString(9, dto.getTransmission());
			ps.setString(10, dto.getOpt());
			ps.setString(11, dto.getGuarantee());
			ps.setString(12, dto.getNamber());
			ps.setString(13, dto.getCname());
			ps.setString(14, dto.getImg());
			ps.setInt(15, dto.getCnum());	//cnum이 DB에서 최대 cnum값에서 +1해서 넣게끔 만들어주는게 필요
			ps.setString(16, dto.getCid());
			
			System.out.println("3. SQL문 결정 OK!!!");

			// 4. SQL문 전송
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 OK!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally End
	}// insert End



}
