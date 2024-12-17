package acciones;

import clases.Animal;
import clases.Personaje;

public class Enemistad extends TratoPersonaje {
	
	public Enemistad(Personaje personaje, Personaje enemigo) {
		super(personaje, enemigo);
	}
	
	public Enemistad(Personaje personaje, Animal animal) {
		super(personaje, animal);
	}
}
