package com.hanbit.member.controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;
public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean bean = null;
		List<MemberBean> temp = new ArrayList<MemberBean>();
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DELETE};//버튼 만든 클래스를 불러온다
		while(true){
			switch ((Butt)JOptionPane.showInputDialog(
					null,//frame
					"MEMBER ADMIN",//frame title
					"SELECT MENU",//order
					JOptionPane.QUESTION_MESSAGE,//type
					null,//icon
					buttons,//Array of choices
					buttons[1]//default
					)){
			case EXIT:
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case ADD:
				String[] arr = JOptionPane.showInputDialog("ID/Name/PassWord/SSN").split("/");
				bean = new MemberBean(); 
				bean.setId(arr[0]);
				bean.setName(arr[1]);
				bean.setPassWord(arr[2]);
				bean.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, service.addMember(bean));
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, "리스트보기"+service.list());
				break;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("Name")));
				break;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, service.findById(JOptionPane.showInputDialog("ID").toString()));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, "Count값: "+ service.count());
				break;
			case UPDATE:
				bean = new MemberBean();
				bean.setId(JOptionPane.showInputDialog("Input Login ID"));
				bean.setName(JOptionPane.showInputDialog("Input Name"));
				bean.setSsn(JOptionPane.showInputDialog("Input SSN"));
				bean.setPassWord(JOptionPane.showInputDialog("Input PW"));
				service.modify(bean);
				JOptionPane.showMessageDialog(null, "Update Ssucess");
				break;
			case DELETE:
			  /*
				String id = "";
				bean.setId(id);
			  */
				service.remove(JOptionPane.showInputDialog("ID"));
				JOptionPane.showMessageDialog(null, "Delete Ssucess");
				break;
			}
		}
	}
}
