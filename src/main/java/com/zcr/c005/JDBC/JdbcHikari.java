package com.zcr.c005.JDBC;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class JdbcHikari {

    private static final String JDBC_URL = "jdbc:h2:mem:DBName;DB_CLOSE_DELAY=-1";
    private static final String DRIVER_CLASS="org.h2.Driver";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setDriverClassName(DRIVER_CLASS);

        HikariDataSource ds = new HikariDataSource(config);

        Connection conn0 = null;
        Statement stmt = null;
        try {
            conn0 = ds.getConnection();
            stmt = conn0.createStatement();
            stmt.execute("CREATE TABLE USER_INFO(id VARCHAR(5) PRIMARY KEY,name VARCHAR(10))");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            stmt.close();
        }


        //增
        Connection conn1 = null;
        Statement stmtIntert = null;
        try {
            conn1 = ds.getConnection();
            stmtIntert = conn1.createStatement();
            stmtIntert.executeUpdate("INSERT INTO USER_INFO VALUES('" + 123+ "','t1')");
            stmtIntert.executeUpdate("INSERT INTO USER_INFO VALUES('" + 456+ "','t2')");
            stmtIntert.executeUpdate("INSERT INTO USER_INFO VALUES('" + 789+ "','t3')");
            stmtIntert.executeUpdate("INSERT INTO USER_INFO VALUES('" + 10+ "','t4')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            stmtIntert.close();
        }



        //删
        Connection conn2 = null;
        Statement stmtdel = null;
        try {
            conn2 = ds.getConnection();
            stmtdel = conn2.createStatement();
            stmtdel.executeUpdate("DELETE FROM USER_INFO WHERE id='789'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            stmtdel.close();
        }


        //改
        Connection conn3 = null;
        Statement stmtUp = null;
        try {
            conn3 = ds.getConnection();
            stmtUp = conn3.createStatement();
            stmtUp.executeUpdate("UPDATE USER_INFO SET name='tt' WHERE id='10'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            stmtUp.close();
        }

        Connection conn4 = null;
        Statement stmtSelect = null;
        try {
            conn4 = ds.getConnection();
            stmtSelect = conn4.createStatement();
            ResultSet rs = stmtSelect.executeQuery("SELECT * FROM USER_INFO");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "," + rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            stmtUp.close();
        }


    }

}
