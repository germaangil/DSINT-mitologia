package acciones;

import clases.Animal;
import clases.Personaje;

public class Enamoramiento extends TratoPersonaje {
	
	public Enamoramiento(Personaje enamorado1, Personaje enamorado2) {
		super(enamorado1, enamorado2);
	}
	
	public Enamoramiento(Personaje enamorado1, Animal animal) {
		super(enamorado1, animal);
	}
}
