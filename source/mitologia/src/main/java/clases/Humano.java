package clases;

public class Humano extends Personaje{
	public Humano(String nombre, boolean esHeroe, Ubicacion ubicacion, int ataque) {
		super(nombre, true, ubicacion, ataque, esHeroe);
	}
}
