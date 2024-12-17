package utilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kie.api.runtime.KieSession;

import acciones.*;
import clases.*;
import javafx.util.Pair;

public class Interprete {
	
	public static List<String> leerArchivo(String archivo) {
    	List<String> lineas;
    	try {
            // Lee todas las lineas
            lineas = Files.readAllLines(Paths.get(archivo));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
        return lineas;
    }
	
	public static String[] inicializadorFicherosEntrada(String escenarios) {
		String[] ficherosEntrada = new String[8];
    	ficherosEntrada[0]=escenarios+"/Escenario.F3-1.txt";
    	ficherosEntrada[1]=escenarios+"/Escenario.F3-2.txt";
    	ficherosEntrada[2]=escenarios+"/Escenario.F3-3.txt";
    	ficherosEntrada[3]=escenarios+"/Escenario.F3-4.txt";
    	ficherosEntrada[4]=escenarios+"/Escenario.F3-5.txt";
    	ficherosEntrada[5]=escenarios+"/Escenario.F3-6.txt";
    	ficherosEntrada[6]=escenarios+"/Escenario.F3-7.txt";
    	ficherosEntrada[7]=escenarios+"/Escenario.F3-8.txt";
    	return ficherosEntrada;
	}
	
	public static String[] inicializadorFicherosSalida(String soluciones) {
		String[] ficherosSalida = new String[8];
    	ficherosSalida[0]=soluciones+"/Escenario.F3-1.Respuesta.txt";
    	ficherosSalida[1]=soluciones+"/Escenario.F3-2.Respuesta.txt";
    	ficherosSalida[2]=soluciones+"/Escenario.F3-3.Respuesta.txt";
    	ficherosSalida[3]=soluciones+"/Escenario.F3-4.Respuesta.txt";
    	ficherosSalida[4]=soluciones+"/Escenario.F3-5.Respuesta.txt";
    	ficherosSalida[5]=soluciones+"/Escenario.F3-6.Respuesta.txt";
    	ficherosSalida[6]=soluciones+"/Escenario.F3-7.Respuesta.txt";
    	ficherosSalida[7]=soluciones+"/Escenario.F3-8.Respuesta.txt";
    	return ficherosSalida;
	}
	
	public static Pair<Integer, String[]> detectaPregunta(String pregunta) {
		int opcion = 0;
		String[] arg = new String[4]; 
		
		String patron1 = "¿Puede (\\w+) liberar a (\\w+)\\?";
        String patron2 = "¿Puede (\\w+) tener (?!Capacidad)([\\w\\s]+)\\?";
        String patron3 = "¿Puede (\\w+) tener Capacidad (\\w+)\\?";
        String patron4 = "¿Puede (\\w+), (\\w+) o (\\w+) liberar a (\\w+)\\?";
        String patron5 = "¿Puede (\\w+) matar a (\\w+)\\?";
        
        Pattern pattern1 = Pattern.compile(patron1);
        Matcher matcher1 = pattern1.matcher(pregunta);
        Pattern pattern2 = Pattern.compile(patron2);
        Matcher matcher2 = pattern2.matcher(pregunta);
        Pattern pattern3 = Pattern.compile(patron3);
        Matcher matcher3 = pattern3.matcher(pregunta);
        Pattern pattern4 = Pattern.compile(patron4);
        Matcher matcher4 = pattern4.matcher(pregunta);
        Pattern pattern5 = Pattern.compile(patron5);
        Matcher matcher5 = pattern5.matcher(pregunta);
        
        if (matcher1.find()) {
        	arg[0] = matcher1.group(1);
        	arg[1] = matcher1.group(2);
            opcion = 1;
            
        } else if (matcher2.find()) {
        	arg[0] = matcher2.group(1);
        	arg[1] = matcher2.group(2);
            opcion = 2;
            
        } else if (matcher3.find()) {
        	arg[0] = matcher3.group(1);
        	arg[1] = matcher3.group(2).toUpperCase();
            opcion = 3;
            
		} else if (matcher4.find()) {
	    	arg[0] = matcher4.group(1);
	    	arg[1] = matcher4.group(2);
	    	arg[2] = matcher4.group(3);
	    	arg[3] = matcher4.group(4);
	        opcion = 5;
        
		} else if (matcher5.find()) {
	    	arg[0] = matcher5.group(1);
	    	arg[1] = matcher5.group(2);
	        opcion = 4;
		}
        Pair<Integer, String[]> dupla = new Pair<>(opcion, arg);
		return dupla;
	}
	
	public static Favor nuevoFavor(String personaje, String dios, List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Criatura> hechosCriaturas) {
	    Dios d = null;
	    Personaje p = null;
	    for (int j=0;j<hechosDioses.size();j++) {
	    	if (hechosDioses.get(j).getNombre().equals(dios)) {
	    		d = hechosDioses.get(j);
	    	}
	    }
	    for (int j=0;j<hechosSemidioses.size();j++) {
	    	if (hechosSemidioses.get(j).getNombre().equals(personaje)) {
	    		p = hechosSemidioses.get(j);
	    	}
	    }
	    if (p==null) {
	        for (int j=0;j<hechosHumanos.size();j++) {
	        	if (hechosHumanos.get(j).getNombre().equals(personaje)) {
	        		p = hechosHumanos.get(j);
	        	}
	        }
	    }
	    if (p==null) {
	        for (int j=0;j<hechosCriaturas.size();j++) {
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje)) {
	        		p = hechosCriaturas.get(j);
	        	}
	        }
	    }
	    return new Favor(d,p);
	}
	
	public static Enojo nuevoEnojo(String personaje, String dios, List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Criatura> hechosCriaturas) {
		Dios d = null;
	    Personaje p = null;
	    for (int j=0;j<hechosDioses.size();j++) {
	    	if (hechosDioses.get(j).getNombre().equals(dios)) {
	    		d = hechosDioses.get(j);
	    	}
	    }
	    for (int j=0;j<hechosSemidioses.size();j++) {
	    	if (hechosSemidioses.get(j).getNombre().equals(personaje)) {
	    		p = hechosSemidioses.get(j);
	    	}
	    }
	    if (p==null) {
	        for (int j=0;j<hechosHumanos.size();j++) {
	        	if (hechosHumanos.get(j).getNombre().equals(personaje)) {
	        		p = hechosHumanos.get(j);
	        	}
	        }
	    }
	    if (p==null) {
	        for (int j=0;j<hechosCriaturas.size();j++) {
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje)) {
	        		p = hechosCriaturas.get(j);
	        	}
	        }
	    }
	    return new Enojo(d,p);
	}
	
	public static void asignarPertenencias(String personaje, String objeto, List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Criatura> hechosCriaturas, 
			List<Objeto> hechosObjetos, List<Animal> hechosAnimales) {
		Personaje p = null;
		for (int j=0;j<hechosDioses.size();j++) {
	    	if (hechosDioses.get(j).getNombre().equals(personaje)) {
	    		p = hechosDioses.get(j);
	    	}
	    }
	    if (p==null) {
	    	for (int j=0;j<hechosSemidioses.size();j++) {
	        	if (hechosSemidioses.get(j).getNombre().equals(personaje)) {
	        		p = hechosSemidioses.get(j);
	        	}
	    }
	    }
	    if (p==null) {
	        for (int j=0;j<hechosHumanos.size();j++) {
	        	if (hechosHumanos.get(j).getNombre().equals(personaje)) {
	        		p = hechosHumanos.get(j);
	        	}
	        }
	    }
	    if (p==null) {
	        for (int j=0;j<hechosCriaturas.size();j++) {
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje)) {
	        		p = hechosCriaturas.get(j);
	        	}
	        }
	    }
	    
	    for (int j=0;j<hechosObjetos.size();j++) {
	    	if (hechosObjetos.get(j).getNombre().equals(objeto)) {
	    		hechosObjetos.get(j).setPersonaje(p);
	    	}
	    }
	    
	    for (int j=0;j<hechosAnimales.size();j++) {
	    	if (hechosAnimales.get(j).getNombre().equals(objeto)) {
	    		hechosAnimales.get(j).setPersonaje(p);
	    	}
	    }
	}
	
	public static void quitarPertenencias(String personaje, String objeto, List<Objeto> hechosObjetos) {
		
	    for (int j=0;j<hechosObjetos.size();j++) {
	    	if(hechosObjetos.get(j).getNombre().equals(objeto) && hechosObjetos.get(j).getPersonaje()!=null) {
	    		if (hechosObjetos.get(j).getPersonaje().getNombre().equals(personaje)) {
		    		hechosObjetos.get(j).setPersonaje(null);
		    		hechosObjetos.get(j).setUbicacion(Ubicacion.DESCONOCIDA);
		    	}
	    	}	
	    }
	}
	
	public static Apresamiento nuevoApresamiento(String personaje1, String personaje2, List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Criatura> hechosCriaturas, 
			List<Animal> hechosAnimales) {
		Personaje p1 = null;
	    Personaje p2 = null;
	    Animal animal = null;
	    
	    for (int j=0;j<hechosDioses.size();j++) {
	    	if (hechosDioses.get(j).getNombre().equals(personaje1)) {
	    		p1 = hechosDioses.get(j);
	    	}
	    }
	    for (int j=0;j<hechosSemidioses.size();j++) {
	    	if (hechosSemidioses.get(j).getNombre().equals(personaje1)) {
	    		p1 = hechosSemidioses.get(j);
	    	}
	    	if (hechosSemidioses.get(j).getNombre().equals(personaje2)) {
	    		p2 = hechosSemidioses.get(j);
	    	}
	    }
	    if (p1==null || p2==null) {
	        for (int j=0;j<hechosHumanos.size();j++) {
	        	if (hechosHumanos.get(j).getNombre().equals(personaje1)) {
	        		p1 = hechosHumanos.get(j);
	        	}
	        	if (hechosHumanos.get(j).getNombre().equals(personaje2)) {
	        		p2 = hechosHumanos.get(j);
	        	}
	        }
	    }
	    if (p1==null || p2==null) {
	        for (int j=0;j<hechosCriaturas.size();j++) {
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje1)) {
	        		p1 = hechosCriaturas.get(j);
	        	}
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje2)) {
	        		p2 = hechosCriaturas.get(j);
	        	}
	        }
	    }
	    if (p2==null) {
	    	for (int j=0;j<hechosAnimales.size();j++) {
	        	if (hechosAnimales.get(j).getNombre().equals(personaje2)) {
	        		animal = hechosAnimales.get(j);
	        		return new Apresamiento(p1, animal);
	        	}
	        }
	    }
	    
	    return new Apresamiento(p1,p2);
	}
	
	public static Enemistad nuevaEnemistad(String personaje1, String personaje2, List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Criatura> hechosCriaturas, 
			List<Animal> hechosAnimales) {
		Personaje p1 = null;
	    Personaje p2 = null;
	    
	    for (int j=0;j<hechosDioses.size();j++) {
	    	if (hechosDioses.get(j).getNombre().equals(personaje1)) {
	    		p1 = hechosDioses.get(j);
	    	}
	    }
	    for (int j=0;j<hechosSemidioses.size();j++) {
	    	if (hechosSemidioses.get(j).getNombre().equals(personaje1)) {
	    		p1 = hechosSemidioses.get(j);
	    	}
	    	if (hechosSemidioses.get(j).getNombre().equals(personaje2)) {
	    		p2 = hechosSemidioses.get(j);
	    	}
	    }
	    if (p1==null || p2==null) {
	        for (int j=0;j<hechosHumanos.size();j++) {
	        	if (hechosHumanos.get(j).getNombre().equals(personaje1)) {
	        		p1 = hechosHumanos.get(j);
	        	}
	        	if (hechosHumanos.get(j).getNombre().equals(personaje2)) {
	        		p2 = hechosHumanos.get(j);
	        	}
	        }
	    }
	    if (p1==null || p2==null) {
	        for (int j=0;j<hechosCriaturas.size();j++) {
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje1)) {
	        		p1 = hechosCriaturas.get(j);
	        	}
	        	if (hechosCriaturas.get(j).getNombre().equals(personaje2)) {
	        		p2 = hechosCriaturas.get(j);
	        	}
	        }
	    }
	    return new Enemistad(p1,p2);
	}
	
	public static void aplicarCondiciones(List<Dios> hechosDioses, 
			List<Semidios> hechosSemidioses, List<Humano> hechosHumanos, List<Criatura> hechosCriaturas, 
			List<Objeto> hechosObjetos, List<Animal> hechosAnimales, KieSession kSession, 
			List<String> entrada) {
		
		String patron4 = "(\\w+) tiene el favor de (\\w+)";
     	String patron5 = "(\\w+) tiene el enojo de (\\w+)";
     	String patron6 = "(\\w+) no tiene el favor de (\\w+)";
     	String patron7 = "(\\w+) no tiene ([\\w\\s]+)";
     	String patron8 = "(\\w+) tiene ([\\w\\s]+)";
     	String patron9 = "(\\w+) apresa (\\w+)";
     	String patron10 = "(\\w+) esta enemistado con (\\w+)";
     	
     	Pattern pattern4 = Pattern.compile(patron4);
        Pattern pattern5 = Pattern.compile(patron5);
        Pattern pattern6 = Pattern.compile(patron6);
        Pattern pattern7 = Pattern.compile(patron7);
        Pattern pattern8 = Pattern.compile(patron8);
        Pattern pattern9 = Pattern.compile(patron9);
        Pattern pattern10 = Pattern.compile(patron10);
         
        for (int i=2;i<entrada.size();i++) {
        	String condicion = entrada.get(i);
     		Matcher matcher4 = pattern4.matcher(condicion);
     		Matcher matcher5 = pattern5.matcher(condicion);
     		Matcher matcher6 = pattern6.matcher(condicion);
     		Matcher matcher7 = pattern7.matcher(condicion);
     		Matcher matcher8 = pattern8.matcher(condicion);
     		Matcher matcher9 = pattern9.matcher(condicion);
     		Matcher matcher10 = pattern10.matcher(condicion);
     		
     		if (matcher4.find()) {
                 String personaje = matcher4.group(1);
                 String dios = matcher4.group(2);
                 Favor fav = Interprete.nuevoFavor(personaje, dios, hechosDioses, hechosSemidioses, 
                 		hechosHumanos, hechosCriaturas);
                 kSession.insert(fav);
                 
             } else if (matcher5.find()) {
             	 String personaje = matcher5.group(1);
                 String dios = matcher5.group(2);
                 Enojo eno = Interprete.nuevoEnojo(personaje, dios, hechosDioses, hechosSemidioses, 
                 		hechosHumanos, hechosCriaturas);
                 kSession.insert(eno);
                 
             } else if (matcher6.find()) {
            	
                 
             } else if (matcher7.find()) {
            	 String personaje = matcher7.group(1);
                 String objeto = matcher7.group(2);
                 Interprete.quitarPertenencias(personaje, objeto, hechosObjetos);
                 
             } else if (matcher8.find()) {
             	 String personaje = matcher8.group(1);
                 String objeto = matcher8.group(2);
                 Interprete.asignarPertenencias(personaje, objeto, hechosDioses, hechosSemidioses,
                 		hechosHumanos, hechosCriaturas, hechosObjetos, hechosAnimales);
                 
             } else if (matcher9.find()) {
             	 String personaje1 = matcher9.group(1);
                 String personaje2 = matcher9.group(2);
             	 Apresamiento apr2 = Interprete.nuevoApresamiento(personaje1, personaje2, hechosDioses, 
             			hechosSemidioses, hechosHumanos, hechosCriaturas, hechosAnimales);
             	kSession.insert(apr2);
             	
             } else if (matcher10.find()) {
             	 String personaje1 = matcher10.group(1);
                 String personaje2 = matcher10.group(2);
             	 Enemistad ene1 = Interprete.nuevaEnemistad(personaje1, personaje2, hechosDioses, 
             			hechosSemidioses, hechosHumanos, hechosCriaturas, hechosAnimales);
             	kSession.insert(ene1);
                 
             } else {
            	 System.out.println("Condicion mal formulada o no contemplada");
             }
     	}
        
        // Los objetos se insertan ahora porque han podido ser modificados durante las condiciones
        for (int i=0; i<hechosObjetos.size(); i++) {
    		kSession.insert(hechosObjetos.get(i));
    	}
	}
	
}