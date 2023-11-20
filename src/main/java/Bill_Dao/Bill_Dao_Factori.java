package Bill_Dao;

public class Bill_Dao_Factori {

	public static Bill_Dao getUsuarioDao(String type) {
		switch(type) {
		case "mysql" : 
			return new Bill_Dao_MySQL();
		default :
			return new Bill_Dao_MySQL();
		}
			
		
	}
}
