package acciones;

import clases.Animal;
import clases.Personaje;

public abstract class TratoPersonaje {
	protected Personaje personaje1;
	protected Personaje personaje2;
	protected Animal animal;
	
	public TratoPersonaje(Personaje personaje1, Personaje personaje2) {
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
	}
	
	public TratoPersonaje(Personaje personaje1, Animal animal) {
		this.personaje1 = personaje1;
		this.animal = animal;
	}

	public Personaje getPersonaje1() {
		return personaje1;
	}
	public void setPersonaje1(Personaje personaje) {
		this.personaje1 = personaje;
	}
	public Personaje getPersonaje2() {
		return personaje2;
	}
	public void setPersonaje2(Personaje amigo) {
		this.personaje2 = amigo;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
