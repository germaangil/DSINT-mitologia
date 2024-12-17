package com.sample;

import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import clases.*;
import utilidades.*;

public class DroolsTest {

    public static final void main(String[] args) {
    	
    	String escenarios="data/escenarios";
    	String soluciones="data/soluciones";
    	if (args.length>=1) escenarios= args[0];
    	if (args.length>=2) soluciones= args[1];
    	 
    	String[] ficherosEntrada = Interprete.inicializadorFicherosEntrada(escenarios);
    	String[] ficherosSalida = Interprete.inicializadorFicherosSalida(soluciones);
    	for(int n=0 ; n<ficherosEntrada.length ; n++) {
    		List<String> entrada = Interprete.leerArchivo(ficherosEntrada[n]);
        	int opcion = 0;
        	String arg1 = "";
        	String arg2 = "";
        	String arg3 = "";
        	String arg4 = "";
    	
	    	try {
	            // load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-rules");
	        	KieRuntimeLogger audit = ks.getLoggers().newFileLogger(kSession,"../milog.log");
	        	
	        	// Inicializamos la base de hechos
	        	List<List<?>> lista = Inicializador.insertar(kSession);
	        	@SuppressWarnings("unchecked")
	        	List<Dios> hechosDioses = (List<Dios>) lista.get(0);
	        	@SuppressWarnings("unchecked")
				List<Semidios> hechosSemidioses = (List<Semidios>) lista.get(1);
	        	@SuppressWarnings("unchecked")
				List<Humano> hechosHumanos = (List<Humano>) lista.get(2);
	        	@SuppressWarnings("unchecked")
				List<Criatura> hechosCriaturas = (List<Criatura>) lista.get(3);
	        	@SuppressWarnings("unchecked")
				List<Animal> hechosAnimales = (List<Animal>) lista.get(4);
	        	@SuppressWarnings("unchecked")
				List<Capacidad> hechosCapacidad = (List<Capacidad>) lista.get(5);
	        	@SuppressWarnings("unchecked")
				List<Objeto> hechosObjetos = (List<Objeto>) lista.get(6);
	        	 
	            // Analizamos la pregunta del fichero de entrada. Nos quedamos con el tipo de pregunta y con sus argumentos.
	            String pregunta = entrada.get(0);
	            opcion = Interprete.detectaPregunta(pregunta).getKey();
	            if(opcion==0) System.out.println("Pregunta mal formulada o no contemplada");
	            arg1 = Interprete.detectaPregunta(pregunta).getValue()[0];		
	            arg2 = Interprete.detectaPregunta(pregunta).getValue()[1];
	            if(opcion==5) {
	            	arg3 = Interprete.detectaPregunta(pregunta).getValue()[2];		
		            arg4 = Interprete.detectaPregunta(pregunta).getValue()[3];
	            }
	            
	            // Insertamos la condicion de parada de la base del conocimiento
	            Inicializador.insertaObjetivo(opcion, arg1, arg2, arg3, arg4, hechosDioses, hechosSemidioses, 
	            		hechosHumanos, hechosObjetos, hechosCriaturas, hechosCapacidad, hechosAnimales, kSession);
	        	
	            // Aplicamos las condiciones
	            Interprete.aplicarCondiciones(hechosDioses, hechosSemidioses, hechosHumanos, 
	            		hechosCriaturas, hechosObjetos, hechosAnimales, kSession, entrada);
	            // Se ejecutan las reglas
	            Impresor.ejecutaReglas(ficherosSalida[n], opcion, arg1, arg2, arg3, arg4, kSession);
	            
	            audit.close();
	            
	        } catch (Throwable t) {
	            System.err.println("Se ha producido un error inesperado.");
	            t.printStackTrace();
	        }
    	}
    }
}