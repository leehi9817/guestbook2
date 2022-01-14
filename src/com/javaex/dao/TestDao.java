package com.javaex.dao;

import com.javaex.vo.GuestbookVo;

public class TestDao {

	public static void main(String[] args) {
		
		GuestbookVo guestbookVo = new GuestbookVo("모니카", "1234", "반갑습니다");
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.insert(guestbookVo);
		System.out.println(guestbookVo);
		
	}

}
