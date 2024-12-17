package acciones;

import clases.Animal;
import clases.Personaje;

public class Amistad extends TratoPersonaje {	
	public Amistad(Personaje personaje, Personaje amigo) {
		super(personaje, amigo);
	}
	
	public Amistad(Personaje personaje, Animal animal) {
		super(personaje, animal);
	}
}
