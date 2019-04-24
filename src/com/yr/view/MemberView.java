package com.yr.view;

import java.util.ArrayList;

import com.yr.member.MemberDTO;

public class MemberView {
	
	public void view(String message) {
		System.out.println(message);
	}
	
	public void view(MemberDTO dto) {
		System.out.println("id : " + dto.getId());
		System.out.println("pw : " + dto.getPw());
		System.out.println("name : " + dto.getName());
		System.out.println("age : " + dto.getAge());
		System.out.println("birth : " + dto.getBirth());	
		System.out.println("====================");
	}
	
	public void view(ArrayList<MemberDTO> ar) {
		for(MemberDTO dto : ar) {
			this.view(dto);
		}
	}
	
	
	
	
}
