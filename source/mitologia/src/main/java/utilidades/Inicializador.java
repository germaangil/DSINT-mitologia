package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.kie.api.runtime.KieSession;

import acciones.Localizacion;
import acciones.Objetivo;
import acciones.PosesionObtenibleCapacidad;
import clases.*;

public class Inicializador {
	
	public static List<List<?>> insertar(KieSession kSession) {
		
		List<List<?>> lista = new ArrayList<>();
		
		// INSERTAR DIOSES
		Dios zeus = new Dios("Zeus", Ubicacion.OLIMPO);
		Dios poseidon = new Dios("Poseidon", Ubicacion.OLIMPO); 
		Dios atenea = new Dios("Atenea", Ubicacion.OLIMPO); 
		Dios hades = new Dios("Hades", Ubicacion.OLIMPO); 
		Dios hefesto = new Dios("Hefesto", Ubicacion.OLIMPO); 
		Dios grayas = new Dios("Grayas", Ubicacion.CUEVA_GRAYAS); 
		Dios hermes = new Dios("Hermes", Ubicacion.OLIMPO);
		Dios hera = new Dios("Hera", Ubicacion.OLIMPO);
		
		List<Dios> hechosDioses = new ArrayList<>();
    	Collections.addAll(hechosDioses, zeus, poseidon, atenea, hades, hefesto, grayas, hermes, hera);
    	for (int i=0; i<hechosDioses.size(); i++) {
    		kSession.insert(hechosDioses.get(i));
    	}
    	lista.add(hechosDioses);
		
    	// INSERTAR SEMIDIOSES
    	Semidios perseo = new Semidios("Perseo", true, Ubicacion.ARGOS, 30);
    	Semidios aquiles = new Semidios("Aquiles", false, Ubicacion.CUEVA_MEDUSA, 30);
    	Semidios heracles = new Semidios("Heracles", false, Ubicacion.DELFOS, 40);
    	
    	List<Semidios> hechosSemidioses = new ArrayList<>();
    	Collections.addAll(hechosSemidioses, perseo, aquiles, heracles);
    	for (int i=0; i<hechosSemidioses.size(); i++) {
    		kSession.insert(hechosSemidioses.get(i));
    	}
    	lista.add(hechosSemidioses);
    	
    	// INSERTAR HUMANOS
    	Humano andromeda = new Humano("Andromeda", false, Ubicacion.ARGOS, 0);
		Humano casiopea = new Humano("Casiopea", false, Ubicacion.ARGOS, 0);
		Humano danae = new Humano("Danae", false, Ubicacion.ARGOS, 0);
		Humano minos = new Humano("Minos", false, Ubicacion.ISLA_CRETA, 0);
		Humano pasifae = new Humano("Pasifae", false, Ubicacion.ISLA_CRETA, 0);
		Humano dedalo = new Humano("Dedalo", false, Ubicacion.ISLA_CRETA, 0);
		Humano icaro = new Humano("Icaro", false, Ubicacion.ISLA_CRETA, 0);
		Humano teseo = new Humano("Teseo", true, Ubicacion.ATENAS, 20);
		Humano ariadna = new Humano("Ariadna", false, Ubicacion.ISLA_CRETA, 0);
		Humano rey = new Humano("Rey Anfion", false, Ubicacion.DELFOS, 0);
		Humano megara = new Humano("Megara", false, Ubicacion.DELFOS, 0);
		
		List<Humano> hechosHumanos = new ArrayList<>();
		Collections.addAll(hechosHumanos, andromeda, casiopea, danae, minos, pasifae, icaro, dedalo, teseo, ariadna, rey, megara);
		for (int i=0; i<hechosHumanos.size(); i++) {
    		kSession.insert(hechosHumanos.get(i));
    	}
    	lista.add(hechosHumanos);
		
		// INSERTAR CRIATURAS
		Criatura ceto = new Criatura("Ceto", Ubicacion.DESCONOCIDA, 40);
		ceto.setEstado(Estado.PRESO);
		Criatura medusa = new Criatura("Medusa", Ubicacion.CUEVA_MEDUSA, 20);
		Criatura nereidas = new Criatura("Nereidas", Ubicacion.DESCONOCIDA, 0);
		Criatura ninfas = new Criatura("Ninfas", Ubicacion.ISLA_NINFAS, 0);
		Criatura doris = new Criatura("Doris", Ubicacion.DESCONOCIDA, 0);
		Criatura hidra = new Criatura("Hidra", Ubicacion.CUEVA_HIDRA, 0);
		Criatura kraken = new Criatura("Kraken", Ubicacion.CUEVA_KRAKEN, 0);
		
		List<Criatura> hechosCriaturas = new ArrayList<>();
    	Collections.addAll(hechosCriaturas, ceto, medusa, nereidas, ninfas, doris, hidra, kraken);
    	for (int i=0; i<hechosCriaturas.size(); i++) {
    		kSession.insert(hechosCriaturas.get(i));
    	}
    	lista.add(hechosCriaturas);
		
    	// INSERTAR ANIMALES
    	List<Animal> hechosAnimales = new ArrayList<>();
		Animal pegaso = new Animal("Pegaso", null, Ubicacion.DESCONOCIDA, 5);
		Animal toro = new Animal("Toro", poseidon, poseidon.getUbicacion(), 6);
		
		Collections.addAll(hechosAnimales, pegaso, toro);
		for (int i=0; i<hechosAnimales.size(); i++) {
    		kSession.insert(hechosAnimales.get(i));
    	}
    	lista.add(hechosAnimales);
		
		// INSERTAR CAPACIDADES
		Capacidad c1 = Capacidad.INVISIBILIDAD;
		Capacidad c2 = Capacidad.MATAR;
		Capacidad c3 = Capacidad.VUELO;
		Capacidad c4 = Capacidad.ALMACENAMIENTO;
		Capacidad c5 = Capacidad.ESPEJO;
		Capacidad c6 = Capacidad.ESCAPE;
		
		List<Capacidad> hechosCapacidad = new ArrayList<>();
        Collections.addAll(hechosCapacidad, c1, c2, c3, c4, c5, c6);
        for (int i=0; i<hechosCapacidad.size(); i++) {
    		kSession.insert(hechosCapacidad.get(i));
    	}
		lista.add(hechosCapacidad);
		
		// INSERTAR UBICACIONES
        Ubicacion ubi1 = Ubicacion.ARGOS;
        Ubicacion ubi2 = Ubicacion.OLIMPO;
        Ubicacion ubi3 = Ubicacion.CUEVA_CETO;
        Ubicacion ubi4 = Ubicacion.CUEVA_GRAYAS;
        Ubicacion ubi5 = Ubicacion.ISLA_NINFAS;
        Ubicacion ubi6 = Ubicacion.CUEVA_MEDUSA;
        Ubicacion ubi7 = Ubicacion.ATENAS;
        Ubicacion ubi8 = Ubicacion.DESCONOCIDA;
        Ubicacion ubi9 = Ubicacion.MAR_EGEO;
        Ubicacion ubi10 = Ubicacion.ISLA_CRETA;
        Ubicacion ubi11 =  Ubicacion.CUEVA_HIDRA;
        Ubicacion ubi12 =  Ubicacion.CUEVA_KRAKEN;
        Ubicacion ubi13 =  Ubicacion.DELFOS;
		
        List<Ubicacion> hechosUbicaciones = new ArrayList<>();
        Collections.addAll(hechosUbicaciones, ubi1, ubi2, ubi3, ubi4, ubi5, ubi6, ubi7, ubi8, ubi9, ubi10, ubi11, ubi12, ubi13);
        for (int i=0; i<hechosUbicaciones.size(); i++) {
    		kSession.insert(hechosUbicaciones.get(i));
    	}
        
        // INSERTAR OBJETOS
		Objeto zurronMagico = new Objeto("Zurron Magico", ninfas, ninfas.getUbicacion(), 0);
		Objeto sandaliasAladas = new Objeto("Sandalias Aladas",ninfas, ninfas.getUbicacion(), 0);
		Objeto cascoHades = new Objeto("Casco de Hades", hades, hades.getUbicacion(), 0);
		Objeto cabezaMedusa = new Objeto("Cabeza de Medusa", medusa, medusa.getUbicacion(), 30);
		Objeto cabezaCeto = new Objeto("Cabeza de Ceto", ceto, ceto.getUbicacion(), 0);
		Objeto ojodienteGrayas = new Objeto("Ojo/Diente de las Grayas", grayas, grayas.getUbicacion(), 0);
		Objeto hozAcero = new Objeto("Hoz de acero", hermes, hermes.getUbicacion(), 20);
		Objeto espadaIndestructible = new Objeto("Espada indestructible", hefesto, hefesto.getUbicacion(), 65);
		Objeto escudoBronce = new Objeto("Escudo de Bronce", atenea, atenea.getUbicacion(), 0);
		Objeto bridasOro = new Objeto("Bridas de oro", hefesto, hefesto.getUbicacion(), 0);
		Objeto anilloInvisibilidad = new Objeto("Anillo de Invisibilidad",null, Ubicacion.DESCONOCIDA, 0);
		Objeto espejoMano = new Objeto("Espejo de Mano",null, Ubicacion.DESCONOCIDA, 0);
		Objeto conjuroVuelo = new Objeto("Conjuro de Vuelo",null, Ubicacion.DESCONOCIDA, 0);
		Objeto hiloMagico = new Objeto("Hilo magico",ariadna, ariadna.getUbicacion(), 0);
		Objeto espada = new Objeto("Espada de Ariadna",ariadna,ariadna.getUbicacion(),70);
		Objeto vaca = new Objeto("Vaca de madera",pasifae,pasifae.getUbicacion(),0);
		Objeto barco = new Objeto("Barco de Teseo",null,Ubicacion.MAR_EGEO,0);
		Objeto espadaMadera = new Objeto("Espada de Madera",aquiles,aquiles.getUbicacion(),35);
		
		List<Objeto> hechosObjetos = new ArrayList<>();
    	Collections.addAll(hechosObjetos, zurronMagico, sandaliasAladas, cascoHades,
    			cabezaMedusa, cabezaCeto, ojodienteGrayas, hozAcero, espadaIndestructible,
    			escudoBronce, bridasOro, anilloInvisibilidad, espejoMano, conjuroVuelo, hiloMagico, espada, vaca, barco, espadaMadera);
        lista.add(hechosObjetos);
    	
        // INSERTAR CAPACIDADES A OBJETOS
		PosesionObtenibleCapacidad alm1 = new PosesionObtenibleCapacidad(zurronMagico, Capacidad.ALMACENAMIENTO);
		PosesionObtenibleCapacidad esp1 = new PosesionObtenibleCapacidad(espejoMano, Capacidad.ESPEJO);
		PosesionObtenibleCapacidad esc1 = new PosesionObtenibleCapacidad(hiloMagico, Capacidad.ESCAPE);
		PosesionObtenibleCapacidad vue1 = new PosesionObtenibleCapacidad(sandaliasAladas, Capacidad.VUELO);
		PosesionObtenibleCapacidad vue2 = new PosesionObtenibleCapacidad(conjuroVuelo, Capacidad.VUELO);
		PosesionObtenibleCapacidad inv1 = new PosesionObtenibleCapacidad(cascoHades, Capacidad.INVISIBILIDAD);
		PosesionObtenibleCapacidad inv2 = new PosesionObtenibleCapacidad(anilloInvisibilidad, Capacidad.INVISIBILIDAD);
		PosesionObtenibleCapacidad mat1 = new PosesionObtenibleCapacidad(hozAcero, Capacidad.MATAR);
		PosesionObtenibleCapacidad mat2 = new PosesionObtenibleCapacidad(cabezaMedusa, Capacidad.MATAR);
		PosesionObtenibleCapacidad mat3 = new PosesionObtenibleCapacidad(espadaIndestructible, Capacidad.MATAR);
		PosesionObtenibleCapacidad mat4 = new PosesionObtenibleCapacidad(espada, Capacidad.MATAR);
		PosesionObtenibleCapacidad mat5 = new PosesionObtenibleCapacidad(espadaMadera, Capacidad.MATAR);
		
		List<PosesionObtenibleCapacidad> hechosCapacidadObjeto = new ArrayList<>();
        Collections.addAll(hechosCapacidadObjeto, inv1, inv2, mat1, mat2, mat3, mat4, vue1, vue2, alm1, esp1, esc1, mat5);
        for (int i=0; i<hechosCapacidadObjeto.size(); i++) {
    		kSession.insert(hechosCapacidadObjeto.get(i));
    	}
    	
    	// INSERTAR CAPACIDADES A ANIMALES
		List<PosesionObtenibleCapacidad> hechosCapacidadObtenible = new ArrayList<>();
		PosesionObtenibleCapacidad vue = new PosesionObtenibleCapacidad(pegaso, Capacidad.VUELO);
        Collections.addAll(hechosCapacidadObtenible, vue);
        for (int i=0; i<hechosCapacidadObtenible.size(); i++) {
    		kSession.insert(hechosCapacidadObtenible.get(i));
    	}
        
        // INSERTAR LOCALIZACIONES
		Localizacion loc1 = new Localizacion(atenea, grayas);
		Localizacion loc2 = new Localizacion(hermes, grayas);
		Localizacion loc3 = new Localizacion(grayas, ninfas);
		Localizacion loc4 = new Localizacion(rey, hidra);
		
		List<Localizacion> hechosLocalizacion = new ArrayList<>();
		Collections.addAll(hechosLocalizacion, loc1, loc2, loc3, loc4);
		for (int i=0; i<hechosLocalizacion.size(); i++) {
    		kSession.insert(hechosLocalizacion.get(i));
    	}
        
		return lista;
		
	}
	
	public static void insertaObjetivo(int opcion, String arg1, String arg2, String arg3, String arg4, List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Objeto> hechosObjetos, 
			List<Criatura> hechosCriaturas, List<Capacidad> hechosCapacidad, List<Animal> hechosAnimales,
			KieSession kSession) {
		if (opcion==1) {
        	Personaje p1 = null;
    	    Personaje p2 = null;
    	    
    	    for (int j=0;j<hechosDioses.size();j++) {
    	    	if (hechosDioses.get(j).getNombre().equals(arg1)) {
    	    		p1 = hechosDioses.get(j);
    	    	}
    	    	if (hechosDioses.get(j).getNombre().equals(arg2)) {
	        		p2 = hechosDioses.get(j);
	        	}
    	    }
    	    for (int j=0;j<hechosSemidioses.size();j++) {
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg1)) {
    	    		p1 = hechosSemidioses.get(j);
    	    	}
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg2)) {
    	    		p2 = hechosSemidioses.get(j);
    	    	}
    	    }
    	    if (p1==null || p2==null) {
    	        for (int j=0;j<hechosHumanos.size();j++) {
    	        	if (hechosHumanos.get(j).getNombre().equals(arg1)) {
    	        		p1 = hechosHumanos.get(j);
    	        	}
    	        	if (hechosHumanos.get(j).getNombre().equals(arg2)) {
    	        		p2 = hechosHumanos.get(j);
    	        	}
    	        }
    	    }
    	    if (p1==null || p2==null) {
    	        for (int j=0;j<hechosCriaturas.size();j++) {
    	        	if (hechosCriaturas.get(j).getNombre().equals(arg1)) {
    	        		p1 = hechosCriaturas.get(j);
    	        	}
    	        	if (hechosCriaturas.get(j).getNombre().equals(arg2)) {
    	        		p2 = hechosCriaturas.get(j);
    	        	}
    	        }
    	    }
    
    	    kSession.insert(new Objetivo(p1,p2,1));
    	    
        } else if (opcion==2) {
        	
        	Personaje p = null;
        	Obtenible ob = null;
    		for (int j=0;j<hechosDioses.size();j++) {
    	    	if (hechosDioses.get(j).getNombre().equals(arg1)) {
    	    		p = hechosDioses.get(j);
    	    	}
    	    }
    	    if (p==null) {
    	    	for (int j=0;j<hechosSemidioses.size();j++) {
    	        	if (hechosSemidioses.get(j).getNombre().equals(arg1)) {
    	        		p = hechosSemidioses.get(j);
    	        	}
    	    }
    	    }
    	    if (p==null) {
    	        for (int j=0;j<hechosHumanos.size();j++) {
    	        	if (hechosHumanos.get(j).getNombre().equals(arg1)) {
    	        		p = hechosHumanos.get(j);
    	        	}
    	        }
    	    }
    	    if (p==null) {
    	        for (int j=0;j<hechosCriaturas.size();j++) {
    	        	if (hechosCriaturas.get(j).getNombre().equals(arg1)) {
    	        		p = hechosCriaturas.get(j);
    	        	}
    	        }
    	    }
    	    for (int j=0;j<hechosObjetos.size();j++) {
    	    	if (hechosObjetos.get(j).getNombre().equals(arg2)) {
    	    		ob = hechosObjetos.get(j);
    	    	}
    	    }
    	    
    	    for (int j=0;j<hechosAnimales.size();j++) {
    	    	if (hechosAnimales.get(j).getNombre().equals(arg2)) {
    	    		ob = hechosAnimales.get(j);
    	    	}
    	    }
    	    
    	    kSession.insert(new Objetivo(p,ob));
            
        } else if (opcion==3) {
        	
        	Personaje p = null;
        	Capacidad c = null;
    		for (int j=0;j<hechosDioses.size();j++) {
    	    	if (hechosDioses.get(j).getNombre().equals(arg1)) {
    	    		p = hechosDioses.get(j);
    	    	}
    	    }
    	    if (p==null) {
    	    	for (int j=0;j<hechosSemidioses.size();j++) {
    	        	if (hechosSemidioses.get(j).getNombre().equals(arg1)) {
    	        		p = hechosSemidioses.get(j);
    	        	}
    	    }
    	    }
    	    if (p==null) {
    	        for (int j=0;j<hechosHumanos.size();j++) {
    	        	if (hechosHumanos.get(j).getNombre().equals(arg1)) {
    	        		p = hechosHumanos.get(j);
    	        	}
    	        }
    	    }
    	    if (p==null) {
    	        for (int j=0;j<hechosCriaturas.size();j++) {
    	        	if (hechosCriaturas.get(j).getNombre().equals(arg1)) {
    	        		p = hechosCriaturas.get(j);
    	        	}
    	        }
    	    }
        	
    	    for (int j=0;j<hechosCapacidad.size();j++) {
    	    	if (hechosCapacidad.get(j).toString().equals(arg2)) {
    	    		c = hechosCapacidad.get(j);
    	    	}
    	    }
    	    
    	    kSession.insert(new Objetivo(p,c));
    	    
        }
        else if (opcion==4) {
        	Personaje p1 = null;
    	    Personaje p2 = null;
    	    
    	    for (int j=0;j<hechosDioses.size();j++) {
    	    	if (hechosDioses.get(j).getNombre().equals(arg1)) {
    	    		p1 = hechosDioses.get(j);
    	    	}
    	    	if (hechosDioses.get(j).getNombre().equals(arg2)) {
	        		p2 = hechosDioses.get(j);
	        	}
    	    }
    	    for (int j=0;j<hechosSemidioses.size();j++) {
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg1)) {
    	    		p1 = hechosSemidioses.get(j);
    	    	}
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg2)) {
    	    		p2 = hechosSemidioses.get(j);
    	    	}
    	    }
    	    if (p1==null || p2==null) {
    	        for (int j=0;j<hechosHumanos.size();j++) {
    	        	if (hechosHumanos.get(j).getNombre().equals(arg1)) {
    	        		p1 = hechosHumanos.get(j);
    	        	}
    	        	if (hechosHumanos.get(j).getNombre().equals(arg2)) {
    	        		p2 = hechosHumanos.get(j);
    	        	}
    	        }
    	    }
    	    if (p1==null || p2==null) {
    	        for (int j=0;j<hechosCriaturas.size();j++) {
    	        	if (hechosCriaturas.get(j).getNombre().equals(arg1)) {
    	        		p1 = hechosCriaturas.get(j);
    	        	}
    	        	if (hechosCriaturas.get(j).getNombre().equals(arg2)) {
    	        		p2 = hechosCriaturas.get(j);
    	        	}
    	        }
    	    }
    
    	    kSession.insert(new Objetivo(p1,p2,4));
    	    
        }
        else if (opcion==5) {
        	Personaje p1 = null;
    	    Personaje p2 = null;
    	    Personaje p3 = null;
    	    Personaje p4 = null;
    	    
    	    for (int j=0;j<hechosDioses.size();j++) {
    	    	if (hechosDioses.get(j).getNombre().equals(arg1)) {
    	    		p1 = hechosDioses.get(j);
    	    	}
    	    	if (hechosDioses.get(j).getNombre().equals(arg2)) {
	        		p2 = hechosDioses.get(j);
	        	}
    	    	if (hechosDioses.get(j).getNombre().equals(arg3)) {
	        		p3 = hechosDioses.get(j);
	        	}
    	    	if (hechosDioses.get(j).getNombre().equals(arg4)) {
	        		p4 = hechosDioses.get(j);
	        	}
    	    }
    	    for (int j=0;j<hechosSemidioses.size();j++) {
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg1)) {
    	    		p1 = hechosSemidioses.get(j);
    	    	}
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg2)) {
    	    		p2 = hechosSemidioses.get(j);
    	    	}
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg3)) {
    	    		p3 = hechosSemidioses.get(j);
    	    	}
    	    	if (hechosSemidioses.get(j).getNombre().equals(arg4)) {
    	    		p4 = hechosSemidioses.get(j);
    	    	}
    	    }
    	    for (int j=0;j<hechosHumanos.size();j++) {
    	    	if (hechosHumanos.get(j).getNombre().equals(arg1)) {
    	        	p1 = hechosHumanos.get(j);
    	        }
    	        if (hechosHumanos.get(j).getNombre().equals(arg2)) {
    	        	p2 = hechosHumanos.get(j);
    	        }
    	        if (hechosHumanos.get(j).getNombre().equals(arg3)) {
    	        	p3 = hechosHumanos.get(j);
    	        }
    	        if (hechosHumanos.get(j).getNombre().equals(arg4)) {
    	        	p4 = hechosHumanos.get(j);
    	        }
    	    }
    	    for (int j=0;j<hechosCriaturas.size();j++) {
    	        if (hechosCriaturas.get(j).getNombre().equals(arg1)) {
    	        	p1 = hechosCriaturas.get(j);
    	        }
    	        if (hechosCriaturas.get(j).getNombre().equals(arg2)) {
    	        	p2 = hechosCriaturas.get(j);
    	        }
    	        if (hechosCriaturas.get(j).getNombre().equals(arg3)) {
    	        	p3 = hechosCriaturas.get(j);
    	        }
    	        if (hechosCriaturas.get(j).getNombre().equals(arg4)) {
    	        	p4 = hechosCriaturas.get(j);
    	        }
    	    }
    
    	    kSession.insert(new Objetivo(p1,p4,1));
    	    kSession.insert(new Objetivo(p2,p4,1));
    	    kSession.insert(new Objetivo(p3,p4,1));
        }
	}
}
