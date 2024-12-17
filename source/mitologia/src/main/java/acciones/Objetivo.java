package acciones;

import clases.Capacidad;
import clases.Obtenible;
import clases.Personaje;

public class Objetivo {
	private int tipoObjetivo;
	private Personaje personaje1;
	private Personaje personaje2;
	private Obtenible obtenible;
	private Capacidad capacidad;
	
	
	public Objetivo(Personaje personaje, Personaje liberado, int tipoObjetivo) {
		this.tipoObjetivo = tipoObjetivo;
		this.personaje1 = personaje;
		this.personaje2 = liberado;
		this.obtenible = null;
		this.capacidad = null;
	}
	
	public Objetivo(Personaje personaje, Obtenible obtenible) {
		this.tipoObjetivo = 2;
		this.personaje1 = personaje;
		this.obtenible = obtenible;
		this.personaje2 = null;
		this.capacidad = null;
	}
	
	public Objetivo(Personaje personaje, Capacidad capacidad) {
		this.tipoObjetivo = 3;
		this.personaje1 = personaje;
		this.capacidad = capacidad;
		this.obtenible = null;
		this.personaje2 = null;
	}
	
	public int getTipoObjetivo() {
		return tipoObjetivo;
	}

	public void setTipoObjetivo(int tipoObjetivo) {
		this.tipoObjetivo = tipoObjetivo;
	}

	public Personaje getPersonaje1() {
		return personaje1;
	}

	public void setPersonaje1(Personaje personaje1) {
		this.personaje1 = personaje1;
	}

	public Personaje getPersonaje2() {
		return personaje2;
	}

	public void setPersonaje2(Personaje personaje2) {
		this.personaje2 = personaje2;
	}

	public Obtenible getObtenible() {
		return obtenible;
	}

	public void setObtenible(Obtenible obtenible) {
		this.obtenible = obtenible;
	}

	public Capacidad getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}
	
}
