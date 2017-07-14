package com.hanbit.member.daoImpl;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.constants.DB;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;
import java.sql.*;//sql문 전체를 나타내는것 * all의 의미
public class MemberDAOImpl implements MemberDAO{
	public MemberDAOImpl(){
		try {
			Class.forName(DB.DRIVER);//생성자로 Class.forName를 만들었기 때문에 아래 메소드의 Class.forName를 모두 삭제
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER Load Fail");
			e.printStackTrace();
		}
	}
	@Override
	public int insertMember(MemberBean bean) {
		int rs=0;
		try {
			//INSERT INTO Member () VALUES() Member의 () 생략가능 순서대로 들어가기 때문
			String sql=String.format("INSERT INTO %s VALUES('%s','%s','%s','%s',SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_USER,DB.MEMBER_PASS,DB.MEMBER_SSN);
			rs = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD).createStatement().executeUpdate(sql);//connection을 copy해서 rs에 보내는 의미
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dao rs: "+rs);
		return rs;
	}
	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean>list=new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD).createStatement().executeQuery(
			String.format("SELECT * FROM %s", DB.TABLE_MEMBER));
			MemberBean member = null;
			while(rs.next()){//값이 여러개라서 if 아닌 while 을 사용한다
				member= new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_USER));
				member.setPassWord(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegDate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MemberBean> selectName(String name) {
		List<MemberBean>list=new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s WHERE %s = '%s'",DB.TABLE_MEMBER,DB.MEMBER_USER,name));
			MemberBean member = null;
			while(rs.next()){
				member=new MemberBean();
				member.setName(rs.getString(DB.MEMBER_USER));
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPassWord(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegDate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD);//Driver에 연결(connection)
			Statement stmt = conn.createStatement();//빈종이 statement 를 만들어 보낸다
			String sql = "SELECT * FROM Member WHERE id='"+id+"'";
			ResultSet rs =stmt.executeQuery(sql);//sql문을 받을 떄는 resultset 사용
			if(rs.next()){
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_USER));
				member.setPassWord(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegDate(rs.getString(DB.MEMBER_REGDATE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	@Override
	public int count() {
		int count = 0;
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT COUNT(*) AS %s FROM %s", "count",DB.TABLE_MEMBER));//count는 getter라서 ResultSet
			if(rs.next()){
				count = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int update(MemberBean bean) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD).createStatement().executeUpdate("");
					String.format("%s", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public int delete(String id) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD).createStatement().executeUpdate("");
					String.format("%s", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
