package modelo;

import java.io.Serializable;



public class Usuario implements Serializable {
	private Integer  id;
	private String nombre;
	private String email;
	private String pass;
	





public Usuario() {
	
}

public Usuario(String nombre, String email, String pais) {

	this.nombre = nombre;
	this.email = email;
	this.pass = pais;
}



public Usuario(Integer id, String nombre, String email, String pais) {

	this.id = id;
	this.nombre = nombre;
	this.email = email;
	this.pass = pais;
}



public Integer getId() {
	return id;
}




public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPais() {
	return pass;
}
public void setPais(String pais) {
	this.pass = pais;
}
}
