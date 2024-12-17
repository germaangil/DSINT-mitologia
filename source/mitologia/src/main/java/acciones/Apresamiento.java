package acciones;

import clases.Animal;
import clases.Personaje;

public class Apresamiento extends Accion {
	public Apresamiento(Personaje apresador, Personaje preso) {
		super(apresador, preso);
	}
	
	public Apresamiento(Personaje apresador, Animal animal) {
		super(apresador, animal);
	}
}
