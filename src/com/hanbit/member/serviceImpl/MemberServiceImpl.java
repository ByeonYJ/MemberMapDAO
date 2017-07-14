package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;
	Map<String,MemberBean> map;
	MemberBean member;
	int count;//count를 instance variable로 만드는 곳
	public MemberServiceImpl() {
		member = new MemberBean();
		list=new ArrayList<MemberBean>();//아래의 count와 다르다 그냥 문자 x,d,count 등등
	}
	@Override
	public String addMember(MemberBean bean) {
	  /*String msg = "";
		MemberDAO dao = new MemberDAOImpl();
        int rs =dao.insertMember(bean);
		if(rs==1){//return이 1이면 성공,0이면 실패
			msg = "등록성공";
		}else{
			msg = "등록실패";
		}*/
		return (new MemberDAOImpl().insertMember(bean)==1)?"등록성공":"등록실패";
	}
	@Override
	public List<MemberBean> list() {
/*		List<MemberBean>list = new ArrayList<>();
		Set<String>keys=map.keySet();
		for(String s:keys){
			list.add(map.get(s));
		}*/
		return new MemberDAOImpl().selectAll();
	}

	@Override//수정중
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp=new ArrayList<MemberBean>();
/*		for(MemberBean mem:list){
			if(name.equals(mem.getName())){
				temp.add(map.get(mem));
			}
		}*/
		MemberDAO dao = new MemberDAOImpl();
		temp = dao.selectName(name);
		return temp;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		MemberDAO dao = new MemberDAOImpl();//select 객체를 가져오는 것
		member=dao.selectById(id);
		return member;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return new MemberDAOImpl().count();//회원수를 한번에 count 해주는것
	}

	@Override
	public String modify(MemberBean bean) {
		String msg = "";
		findById(bean.getId()).setName(bean.getName());//아이디로 받아서 이름을 바꿔준다
		findById(bean.getId()).setSsn(bean.getSsn());//아이디로 받아서 주민번호를 바꿔준다
		findById(bean.getId()).setPassWord(bean.getPassWord());//아이디로 받아서 비밀번호를 바꿔준다
		return msg;
	}

	@Override
	public String remove(String id) {
		String msg = "";
		for(MemberBean mem:list){
			if(id.equals(mem.getId())){
				list.remove(mem);
			}
		}
		return msg;
	}
}
