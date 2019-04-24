package com.yr.input;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.yr.member.MemberDTO;



public class MemberInput {

	public MemberDTO setMember() {
		Scanner sc = new Scanner(System.in);
		MemberDTO dto = new MemberDTO();
		
		System.out.println("id 입력");
		dto.setId(sc.next());
		System.out.println("pw 입력");
		dto.setPw(sc.next());
		System.out.println("name 입력");
		dto.setName(sc.next());
		System.out.println("age 입력");
		dto.setAge(sc.nextInt());
		System.out.println("birth 입력");
		dto.setBirth(Date.valueOf(sc.next()));
		
		
		return dto;
		
	}
	public String setNum(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println(str + " 할 id를 입력하세요");
		String id = sc.next();
		
		return id;
	}
}
