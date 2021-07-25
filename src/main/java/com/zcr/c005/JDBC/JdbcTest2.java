package com.zcr.c005.JDBC;

import java.sql.*;

public class JdbcTest2 {

    private static final String JDBC_URL = "jdbc:h2:mem:DBName;DB_CLOSE_DELAY=-1";
    private static final String DRIVER_CLASS="org.h2.Driver";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS);

        Connection conn = null;
        PreparedStatement ptmt = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            conn.setAutoCommit(false);
            String createSql ="CREATE TABLE USER_INFO(id VARCHAR(5) PRIMARY KEY,name VARCHAR(10))";
            ptmt = conn.prepareStatement(createSql);
            ptmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.rollback();
        }finally {
            ptmt.close();
            conn.close();
        }


        Connection conn1 = null;
        String insterSql ="INSERT INTO USER_INFO VALUES(" + "?,?"+")";
        PreparedStatement ptmtInsert = null;
        try {
            conn1 = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            conn1.setAutoCommit(false);
            ptmtInsert = conn1.prepareStatement(insterSql);
            ptmtInsert.setInt(1,111);
            ptmtInsert.setString(2,"aaa");
            ptmtInsert.addBatch();
            ptmtInsert.setInt(1,222);
            ptmtInsert.setString(2,"bbb");
            ptmtInsert.addBatch();
            ptmtInsert.setInt(1,3);
            ptmtInsert.setString(2,"c");
            ptmtInsert.addBatch();
            ptmtInsert.executeBatch();
            conn1.commit();

        } catch (SQLException throwables) {
            try {
                conn1.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            try {
                ptmtInsert.close();
                conn1.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        Connection conn2 = null;
        String SlelctSql ="SELECT * FROM USER_INFO";
        PreparedStatement ptmtSelect = null;
        try {
            conn2 = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            conn2.setAutoCommit(false);
            ptmtSelect = conn2.prepareStatement(SlelctSql);
            ResultSet rs = ptmtSelect.executeQuery();
            //遍历
            while (rs.next()) {
                System.out.println(rs.getString("id") + "," + rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                ptmtSelect.close();
                conn2.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }




        

    }

}
