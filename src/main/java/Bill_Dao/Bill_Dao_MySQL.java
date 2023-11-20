package Bill_Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Bill;
import util.ConexionMySQL;

public class Bill_Dao_MySQL implements Bill_Dao{
	private ConexionMySQL conexion;
	private static final String INSERT_BILL_SQL = "INSERT INTO bill(id,date_bill,user_id,value,type,observation) VALUE(?,?,?,?,?,?);";
	private static final String DELETE_BILL_SQL = "DELETE FROM bill WHERE id = ?;";
	/*private static final String UPDATE_BILL_SQL = "UPDATE bill SET id=?, date_bill=?,	user_id=?, 	value=?, type=?, observation=?, WHERE id =?;";*/
	private static final String SELECT_BILL_BY_ID = "SELECT * FROM bill WHERE id=?;";
	private static final String SELECT_ALL_BILL = "SELECT * FROM bill; ";
	
	public Bill_Dao_MySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert (Bill bill) throws SQLException{
		
		System.out.println(bill);
		try {
		
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(INSERT_BILL_SQL);
			
			preparedStatement.setLong(1, bill.getDate_bill());
		
			preparedStatement.setString(5, bill.getObservation());
			
			preparedStatement.setLong(3, (long) bill.getValue());
			
			conexion.execute();
		}catch(SQLException e) {
			e.printStackTrace();	
		} 
	}
	
	public void delete (int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(DELETE_BILL_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		}catch(SQLException e ) {
			
		}
		
	}
	/*
	public void update (Bill bill) throws SQLException  {
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(UPDATE_BILL_SQL);
			preparedStatement.setString(1, bill.getObservation());
			/*preparedStatement.setString(2, bill.getEmail());
			preparedStatement.setString(3, bill.getPais());
			preparedStatement.setInt(4,bill.getId());	
			conexion.execute();
		}catch(SQLException e) {
			
		}
	}
	
	*/
	
	public List<Bill> selectAll() {
		List<Bill>bill = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_BILL);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int id = rs.getInt("id");
				int date_bill = rs.getInt("date_bill");
				int user_id = rs.getInt("user_id");
				double value = rs.getDouble("value");
				String pais = rs.getString("pais");
				int type = rs.getInt("type");
				String observation = rs.getString("observation");
				
				bill.add(new Bill(date_bill,observation,value));
			}
			
		}catch(SQLException e) {
			
		}
		return bill;
	}
	
	
	public Bill select(int id) {
		Bill bill=null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_BILL_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int date_bill = rs.getInt("date_bill");
				String observation = rs.getString("observation");
				double value = rs.getDouble("value");
				
				bill  = new Bill(date_bill,observation,value);
			}
			
		}catch(SQLException e) {
			
		}
		return bill;
		
	}
	
	
	
	
	
	

}
