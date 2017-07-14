package com.hanbit.member.service;

import java.util.List;

import com.hanbit.member.domain.MemberBean;

public interface MemberService {
	public String addMember(MemberBean bean);
	public List<MemberBean> list();
	public List<MemberBean> findByName(String name);
	public MemberBean findById(String id);
	public int count();
	public String modify(MemberBean bean);//update와 같은 뜻
	public String remove(String id);//delete와 같은 뜻
}
