package acciones;

import clases.Animal;
import clases.Personaje;

public class Asesinato extends Accion {
	public Asesinato(Personaje asesino, Personaje victima) {
		super(asesino, victima);
	}
	
	public Asesinato(Personaje asesino, Animal animal) {
		super(asesino, animal);
	}
}
