package com.yr.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.yr.input.MemberInput;
import com.yr.member.MemberDAO;
import com.yr.member.MemberDTO;
import com.yr.view.MemberView;

public class MemberControl {

	public void start() throws Exception {
		MemberInput mi = new MemberInput();
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		MemberView mv = new MemberView();
		Scanner sc = new Scanner(System.in);
		boolean check = true;

		while(check) {
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 탈퇴");
			System.out.println("3. 회원 정보 검색");
			System.out.println("4. 회원 전체 정보");
			System.out.println("5. 종    료");
			int select = sc.nextInt();
			switch(select) {
			case 1: 
				dto = mi.setMember();
				int result = dao.insert(dto);
				String message = "등록실패";
				if(result>0) {
					message = "등록 성공";
				}
				mv.view(message);
				break;
			case 2:
				String id = mi.setNum("탈퇴");
				result = dao.delete(id);
				if(result>0) {
					message = "탈퇴되었습니다";
				} else message = "탈퇴실패";
				mv.view(message);

				break;
			case 3:
				id = mi.setNum("검색");
				dto = dao.searchId(id);
				if(dto!=null) {
					mv.view(dto);
				} else {
					message = "번호가 없습니다";
					mv.view(message);
				}
				break;
			case 4:
				ArrayList<MemberDTO> ar = dao.selectList();
				mv.view(ar);
				break;
			default : System.out.println("종료합니다");
			check=!check;
			}
		}
	}
}