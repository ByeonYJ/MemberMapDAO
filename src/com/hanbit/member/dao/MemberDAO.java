package com.hanbit.member.dao;
import java.util.List;
import com.hanbit.member.domain.MemberBean;
public interface MemberDAO {
	public int insertMember(MemberBean bean);//나중에 DB에서 insert Query문을 만든다
	public List<MemberBean> selectAll();
	public List<MemberBean> selectName(String name); // DB에서*
	public MemberBean selectById(String id);
	public int count();
	public int update(MemberBean bean);
	public int delete(String id);
}
