package utilidades;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.runtime.KieSession;

public class Impresor {
	
	public static void ejecutaReglas(String ficheroSalida, int opcion, String arg1, String arg2, String arg3, String arg4, KieSession kSession) {
		try {
			PrintStream originalOut = System.out;
			PrintStream out = new PrintStream(ficheroSalida);
	    	System.setOut(out);
	    	
	        kSession.fireAllRules();
	        
	        String filePath = ficheroSalida;
	
	        List<String> lineas = Files.readAllLines(Paths.get(filePath));
	        if(opcion==1) {
	        	if (lineas.get(lineas.size()-1).startsWith(arg1+" libera a "+arg2)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
		            lineasAEscribir.add(0, "Si, "+arg1+" puede liberar a "+arg2+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
		        else {
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            	writer.write("No, no hay forma de que " + arg1 + " pueda liberar a " + arg2 + ".");
		            }
		        }
	        }

	        else if(opcion==2) {
	        	if (lineas.get(lineas.size()-1).startsWith(arg1+" obtiene el objeto "+arg2)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
	        		lineasAEscribir.add(0, "Si, "+arg1+" puede obtener el objeto "+arg2+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
		        else {
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            	writer.write("No, no hay forma de que "+arg1+" pueda obtener el objeto "+arg2+".");
		            }
		        }
	        }

	        else if (opcion==3){
	        	if (lineas.get(lineas.size()-1).startsWith(arg1+" obtiene la capacidad de "+arg2)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
	        		lineasAEscribir.add(0, "Si, "+arg1+" puede tener la Capacidad "+arg2+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
		        else {
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            	 writer.write("No, no hay forma de que "+arg1+" pueda tener la Capacidad "+arg2+".");
		            }
		        }
	        }
	        
	        if(opcion==4) {
	        	if (lineas.get(lineas.size()-1).startsWith(arg1+" mata a "+arg2)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
		            lineasAEscribir.add(0, "Si, "+arg1+" puede matar a "+arg2+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
		        else {
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            	writer.write("No, no hay forma de que " + arg1 + " pueda matar a " + arg2 + ".");
		            }
		        }
	        }
	        
	        else if(opcion==5) {
	        	if (lineas.get(lineas.size()-1).startsWith(arg1+" libera a "+arg4)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
		            lineasAEscribir.add(0, "Si, de los 3 heroes, es "+arg1+" el que puede liberar a "+arg4+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
	        	else if (lineas.get(lineas.size()-1).startsWith(arg2+" libera a "+arg4)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
		            lineasAEscribir.add(0, "Si, de los 3 heroes, es "+arg2+" el que puede liberar a "+arg4+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
	        	else if (lineas.get(lineas.size()-1).startsWith(arg3+" libera a "+arg4)) {
	        		List<String> lineasAEscribir = new LinkedList<String>();
		            lineasAEscribir.add(0, "Si, de los 3 heroes, es "+arg3+" el que puede liberar a "+arg4+" debido a que:");
		            lineasAEscribir.addAll(lineas);
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		                for (String linea : lineasAEscribir) {
		                	writer.write(linea);
		                    writer.newLine();
		                 }
		            }
	            }
		        else {
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            	writer.write("No, no hay forma de que "+arg1+", "+ arg2+" o "+arg3+" pueda liberar a "+arg4+".");
		            }
		        }
	        }
	        
	        out.close();
	        System.setOut(originalOut);
	        
        
	    } catch (FileNotFoundException e) {
	        System.err.println("Error: El archivo no fue encontrado.");
	        e.printStackTrace();
	    } catch (Throwable t) {
	        System.err.println("Se ha producido un error inesperado.");
	        t.printStackTrace();
	    }
	}
}
