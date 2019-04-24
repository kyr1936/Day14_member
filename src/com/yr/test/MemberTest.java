package com.yr.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.yr.util.DBConnect;

public class MemberTest {

	@Test
	public void test() {
		try {
			Connection con = DBConnect.getConnect();
			assertNotNull(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
