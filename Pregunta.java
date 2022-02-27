import java.util.ArrayList;
import java.util.Collections;

public class Pregunta {

    private String enunciado;
    private Solucion solucion;
    private ArrayList <Opcion> opciones;
    private Respuesta respuesta;

    public Pregunta(String enunciado, Solucion solucion, Opcion ... opciones) {
        this.enunciado = enunciado;
        this.solucion = solucion;
        this.opciones = new ArrayList<>();
        Collections.addAll(this.opciones, opciones);
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public boolean esCorrecta() {
        if(this.respuesta == null) {
            return false;
        }
        return this.respuesta.compareTo(solucion) == 0;
    }

    public void mostrarRespuestaConAutorizacionDe(Object profesor) {
        if(profesor instanceof Profesor) {
            System.out.println(solucion.toString());
        } else {
            System.out.println("¡Usted no tiene autorización para ver la respuesta!");
        }
    }

    @Override 
    public String toString(){
        String opciones = "";
        for (Opcion opcion : this.opciones) {
            opciones += "\t- " + opcion.toString() + "\n";
        }
        return "Enunciado: " + enunciado + "\n" + opciones;
    }
    
}
