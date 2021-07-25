package com.zcr.c005.JDBC;

import java.sql.*;

public class JdbcTest {

    private static final String JDBC_URL = "jdbc:h2:mem:DBName;DB_CLOSE_DELAY=-1";
    private static final String DRIVER_CLASS="org.h2.Driver";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS);

        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE USER_INFO(id VARCHAR(5) PRIMARY KEY,name VARCHAR(10))");
        //增
        stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + 123+ "','t1')");
        stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + 456+ "','t2')");
        stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + 789+ "','t3')");
        stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + 10+ "','t4')");
        //删
        stmt.executeUpdate("DELETE FROM USER_INFO WHERE id='789'");
        //改
        stmt.executeUpdate("UPDATE USER_INFO SET name='tt' WHERE id='10'");
        //查
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER_INFO");
        //遍历
        while (rs.next()) {
            System.out.println(rs.getString("id") + "," + rs.getString("name"));
        }
        stmt.close();
        conn.close();



        //////////////////////////////////////////////




    }

}
