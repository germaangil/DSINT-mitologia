package acciones;

import clases.Capacidad;
import clases.Obtenible;
import clases.Personaje;

public abstract class PosesionCapacidad {
	private Personaje personaje;
	private Obtenible obtenible;
	private Capacidad capacidad;
	
	public PosesionCapacidad(Personaje personaje, Capacidad capacidad) {
		this.personaje = personaje;
		this.obtenible = null;
		this.capacidad = capacidad;
	}

	public PosesionCapacidad(Obtenible obtenible, Capacidad capacidad) {
		this.personaje = null;
		this.obtenible = obtenible;
		this.capacidad = capacidad;
	}

	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
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
