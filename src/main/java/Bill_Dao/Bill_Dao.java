package Bill_Dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Bill;

public interface Bill_Dao {

	public void insert(Bill bill) throws SQLException;
		public Bill select (int id);
		public List < Bill > selectAll();
		public void delete(int id) throws SQLException;
		public void update(Bill bill) throws SQLException;
}
