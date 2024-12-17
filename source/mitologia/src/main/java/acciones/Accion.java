package acciones;

import java.util.HashSet;
import java.util.Set;

import clases.Animal;
import clases.Obtenible;
import clases.Personaje;

public abstract class Accion {
	protected Personaje personaje1;
	protected Personaje personaje2;
	protected Animal animal;
	protected Obtenible obtenible1;
	protected Obtenible obtenible2;
	protected Localizacion loc;
	protected Set<Personaje> combatientes;
	protected Personaje vencedor;
	protected int ataque1;
	protected int ataque2;
	
	public Accion(Personaje personaje1, Personaje personaje2) {
		super();
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
		this.combatientes = new HashSet<Personaje>();
		this.combatientes.add(personaje1);
		this.combatientes.add(personaje2);
		this.ataque1 = personaje1.ataque();
		this.ataque2 = personaje2.ataque();
		if (this.ataque1 > this.ataque2) {
			this.vencedor=personaje1;
		} else this.vencedor=personaje2;
	}

	public Accion(Personaje personaje1, Animal animal) {
		super();
		this.personaje1 = personaje1;
		this.animal = animal;
	}

	public Accion(Personaje ladron, Personaje victima, Obtenible obtenible) {
		this.personaje1 = ladron;
		this.personaje2 = victima;
		this.obtenible1 = obtenible;
	}
	
	public Accion(Personaje personaje1, Personaje personaje2, Obtenible obtenible1, Obtenible obtenible2) {
		super();
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
		this.obtenible1 = obtenible1;
		this.obtenible2 = obtenible2;
	}

	public Accion(Personaje personaje1, Personaje personaje2, Obtenible obtenible1, Localizacion loc) {
		super();
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
		this.obtenible1 = obtenible1;
		this.loc = loc;
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

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Obtenible getObtenible1() {
		return obtenible1;
	}

	public void setObtenible1(Obtenible obtenible1) {
		this.obtenible1 = obtenible1;
	}

	public Obtenible getObtenible2() {
		return obtenible2;
	}

	public void setObtenible2(Obtenible obtenible2) {
		this.obtenible2 = obtenible2;
	}

	public Localizacion getLoc() {
		return loc;
	}

	public void setLoc(Localizacion loc) {
		this.loc = loc;
	}
	
	public Set<Personaje> getCombatientes() {
		return combatientes;
	}

	public void setCombatientes(Set<Personaje> combatientes) {
		this.combatientes = combatientes;
	}

	public Personaje getVencedor() {
		return vencedor;
	}

	public void setVencedor(Personaje vencedor) {
		this.vencedor = vencedor;
	}

	public int getAtaque1() {
		return ataque1;
	}

	public void setAtaque1(int ataque1) {
		this.ataque1 = ataque1;
	}

	public int getAtaque2() {
		return ataque2;
	}

	public void setAtaque2(int ataque2) {
		this.ataque2 = ataque2;
	}
}
