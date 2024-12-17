package acciones;

import clases.Obtenible;
import clases.Personaje;

public class Intercambio extends Accion {
	public Intercambio(Personaje personaje1, Personaje personaje2, Obtenible obtenible1, Obtenible obtenible2) {
		super(personaje1, personaje2, obtenible1, obtenible2);
	}
	
	public Intercambio(Personaje personaje1, Personaje personaje2, Obtenible obtenible1, Localizacion loc) {
		super(personaje1, personaje2, obtenible1, loc);
	}
}
