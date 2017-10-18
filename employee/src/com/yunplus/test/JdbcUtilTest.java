package com.yunplus.test;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import com.yunplus.util.JdbcUtil;

public class JdbcUtilTest {
	 @Test
	 public void test() {
		Connection conn = JdbcUtil.getConnection();
		Assert.assertNotNull(conn);
		}
}
