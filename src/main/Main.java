package main;

public class Main {
	public static void main(String[] args) {
		Pasarela pasarela = new Pasarela ();
		for  (int i=0; i<5; i++) {
			double random = Math.random();
			if (random > 0.5) {random =1;} else {random = 0;}
			new Persona(i, (int) random, pasarela).start();
		}
	}
}
