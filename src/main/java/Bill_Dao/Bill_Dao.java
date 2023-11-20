package Bill_Dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Usuario;

public interface Bill_Dao {

	public void insert(Usuario usuario) throws SQLException;
		public Usuario select (int id);
		public List < Usuario > selectAll();
		public void delete(int id) throws SQLException;
		public void update(Usuario usuario) throws SQLException;
}
