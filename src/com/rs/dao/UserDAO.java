package com.rs.dao;

import java.sql.*;

public class UserDAO {

	
	public static Connection getConnection() {
		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","abeg");
			
		}catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static int save(String name,String acc,String email,String pass,String country) {
		Connection conn=UserDAO.getConnection();
		int status = 0;
		try {	
            String query = "insert into atm (full_name, acc_no, email, pass,country,balance) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query ,Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString( 1,name);
            preparedStatement.setString( 2, acc);
            preparedStatement.setString( 3, email);
            preparedStatement.setString( 4, pass);
            preparedStatement.setString( 5, country);
            preparedStatement.setInt(6,0);
            status= preparedStatement.executeUpdate();
            
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return status;
	}
	public static String getName(int id) {
		Connection conn=UserDAO.getConnection();
		String name = "";
		try {	
            String query = "select * from atm where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()) {
				name=rs.getString("full_name");
			}
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return name;
	}
	public static String getPass(int id) {
		Connection conn=UserDAO.getConnection();
		String pass = "";
		try {	
            String query = "select * from atm where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()) {
				pass=rs.getString("pass");
			}
            rs.close();
            preparedStatement.close();
            conn.close();
                                                                                                                                                                                                                                                                                                                                                                                                           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return pass;
	}
	public static String getAccNo(int id) {
		Connection conn=UserDAO.getConnection();
		String acc = "";
		try {	
            String query = "select * from atm where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()) {
				acc=rs.getString("acc_no");
			}
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return acc;
	}
	public static int getBalance(int id) {
		Connection conn=UserDAO.getConnection();
		int balance=0;
		try {	
            String query = "select * from atm where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()) {
				balance=rs.getInt("balance");
			}
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return balance;
	}
	public static void updateBalance(int id,int amount) {
		Connection conn=UserDAO.getConnection();
		
		try {	
            String query = "update atm set balance=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public static int getId() {
		int maxID = 0;
		Connection conn=UserDAO.getConnection();
		Statement s2;
		try {
			s2 = conn.createStatement();
			s2.execute("SELECT MAX(id) FROM atm");   
			
			ResultSet rs2 = s2.getResultSet(); // 
			while ( rs2.next() ){
			  maxID = rs2.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return maxID;
	}
}
