package tacar;

public class MemberDTO {

	// ������� 13��
	private String id;
	private String pw;
	private String pwcheck;
	private String name;
	private String birth;
	private String gender;
	private String address;
	private String phone;
	private String pwask;
	private String ownnered;
	private String email;
	private String purpose;
	private String adminkey;
	private String bid;
	private String bprice;
	
	//���� ���������(q�� ����, a�� �亯 ������)
	private String q1;
	private String q2;
	private String a1;
	private String a2;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBprice() {
		return bprice;
	}

	public void setBprice(String bprice) {
		this.bprice = bprice;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPwcheck() {
		return pwcheck;
	}

	public void setPwcheck(String pwcheck) {
		this.pwcheck = pwcheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String brith) {
		this.birth = brith;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwask() {
		return pwask;
	}

	public void setPwask(String pwask) {
		this.pwask = pwask;
	}

	public String getOwnnered() {
		return ownnered;
	}

	public void setOwnnered(String ownnered) {
		this.ownnered = ownnered;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAdminkey() {
		return adminkey;
	}

	public void setAdminkey(String adminkey) {
		this.adminkey = adminkey;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", pwcheck=" + pwcheck + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", pwask=" + pwask
				+ ", ownnered=" + ownnered + ", email=" + email + ", purpose=" + purpose + ", adminkey=" + adminkey
				+ ", bid=" + bid + ", bprice=" + bprice + ", q1=" + q1 + ", q2=" + q2 + ", a1=" + a1 + ", a2=" + a2
				+ "]";
	}
		
}
