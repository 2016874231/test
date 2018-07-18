package com.lingnan.usersys.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.usermar.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermar.view.IndexFrame;

public class DBUtilTest {

	@Test
	public void testGetConnection() {
		IndexFrame ifr = new IndexFrame();
		ifr.show();
	}

}
