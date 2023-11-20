package Dao;

public class UsuarioDaoFactori {

	public static UsuarioDao getUsuarioDao(String type) {
		switch(type) {
		case "mysql" : 
			return new UsuarioDaoMySQL();
		default :
			return new UsuarioDaoMySQL();
		}
			
		
	}
}
