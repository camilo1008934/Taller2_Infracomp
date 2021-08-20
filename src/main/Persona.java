package main;

public class Persona extends Thread{
	private int id, direccion;
	private Pasarela pasarela;
	
	public Persona(int idP, int direccionP, Pasarela pasarelaP) {
		id=idP;
		direccion = direccionP;
		pasarela=pasarelaP;
	}
	public int darDireccion(){
		return direccion;
	}
	
	public int darId(){
		return id;
	}
	
	public void run() {
		pasarela.entrar(this);
		pasarela.caminar(this);
		pasarela.salir(this);
	}
	
}
