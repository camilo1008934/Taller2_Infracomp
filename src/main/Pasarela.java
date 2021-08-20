package main;

public class Pasarela extends Thread{
	
	private static int caminando = -1;
	private int izq, der;
	
	public Pasarela() {
		izq=0;
		der=0;
	}
	
	public synchronized void entrar(Persona persona) {
		
		System.out.println("La persona "+persona.darId() + " esta en la cola de la direccion " + persona.darDireccion());
		while (Pasarela.darCaminando() != persona.darDireccion() && Pasarela.darCaminando() != -1 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("La persona "+persona.darId() + " entro en la direccion " + persona.darDireccion());
		if (persona.darDireccion() ==0) {
			izq++;
		}else {
			der++;
		}
		
	}
	
	public void caminar(Persona persona) {
		System.out.println("La persona "+persona.darId() + " esta caminando en la direccion "+ persona.darDireccion());
		Pasarela.cambiarCaminando (persona.darDireccion());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public synchronized void salir(Persona persona) {
		System.out.println("La persona "+persona.darId() + " salio en la direccion "+ persona.darDireccion());
		if (persona.darDireccion() ==0) {
			izq--;
		}else {
			der--;
		}
		
		
		if (this.Total() == 0) {
			Pasarela.cambiarCaminando(-1);
		}
		notifyAll();
		
	}
	
	public static void cambiarCaminando (int caminandoP) {
		Pasarela.caminando = caminandoP;
	}
	
	public static int darCaminando() {
		return Pasarela.caminando;
	}
	
	public int personasIzq() {
		return izq;
	}
	
	public int personasDer() {
		return der;
	}
	
	public int Total() {
		return izq+der;
	}

}
