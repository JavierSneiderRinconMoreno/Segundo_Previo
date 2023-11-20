package Bill_Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import modelo.Bill;
import util.ConexionMySQL;

public class Bill_Dao_MySQL implements Bill_Dao {
	private ConexionMySQL conexion;
	private static final String INSERT_BILL_SQL = "INSERT INTO bill(id,date_bill,user_id,value,type,observation) VALUE(?,?,?,?,?,?);";
	private static final String DELETE_BILL_SQL = "DELETE FROM bill WHERE id = ?;";
	private static final String UPDATE_BILL_SQL = "UPDATE bill SET id=?, date_bill=?,	user_id=?, 	value=?, type=?, observation=?, WHERE id =?;";
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
	
	public void update (Usuario usuario) throws SQLException  {
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(UPDATE_BILL_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4,usuario.getId());			
			conexion.execute();
		}catch(SQLException e) {
			
		}
	}
	
	public List<Usuario> selectAll() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_BILL);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id,nombre,email,pais));
			}
			
		}catch(SQLException e) {
			
		}
		return usuarios;
		
	}
	
	
	public Usuario select(int id) {
		Usuario usuario=null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_BILL_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuario  = new Usuario(id,nombre,email,pais);
			}
			
		}catch(SQLException e) {
			
		}
		return usuario;
		
	}

	@Override
	public void insert(Usuario usuario) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
