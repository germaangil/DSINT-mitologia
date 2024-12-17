package clases;

public abstract class Personaje {

    private final String nombre;
    private Estado estado;
    private boolean esMortal;
    private Ubicacion ubicacion;
    private boolean esHeroe;
    private int ataque;
    
    public Personaje(String nombre, boolean esMortal, Ubicacion ubicacion, int ataque, boolean esHeroe) {
        this.nombre = nombre;
        this.estado = Estado.LIBRE;
        this.esMortal = esMortal;
        this.ubicacion = ubicacion;
        this.ataque = ataque;
        this.esHeroe = esHeroe;
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

    public String getNombre() {
        return nombre;
    }

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int ataque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public boolean isEsHeroe() {
		return esHeroe;
	}

	public void setEsHeroe(boolean esHeroe) {
		this.esHeroe = esHeroe;
	}

	public int getAtaque() {
		return ataque;
	}
	
}
