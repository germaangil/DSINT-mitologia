package clases;

public abstract class Obtenible {
	private String nombre;
	private Personaje personaje;
	private Ubicacion ubicacion;
	private int ataque;
	
	public Obtenible(String nombre, Personaje personaje, Ubicacion ubicacion, int ataque) {
		this.nombre=nombre;
		this.personaje=personaje;
		this.ubicacion = ubicacion;
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
}
