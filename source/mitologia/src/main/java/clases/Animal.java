package clases;

public class Animal extends Obtenible{
	private Estado estado;
    private boolean esMortal;
    
	public Animal(String nombre, Personaje personaje, Ubicacion ubicacion, int ataque) {
		super(nombre, personaje, ubicacion, ataque);
		this.estado = Estado.LIBRE;
		this.esMortal = true;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean isEsMortal() {
		return esMortal;
	}

	public void setEsMortal(boolean esMortal) {
		this.esMortal = esMortal;
	}

}
