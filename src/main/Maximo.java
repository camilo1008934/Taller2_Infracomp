package main;

public class Maximo {
	private int cont, maximo, nThreads;
	public Maximo (int numT) {
		nThreads = numT;
		cont=0;
		maximo=0;
	}
	
	public synchronized boolean anotar (int n) {
		if (n>maximo) maximo =n;
		
		return (++cont == nThreads)? true: false;
	}
}	
