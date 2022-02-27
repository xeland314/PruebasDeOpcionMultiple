import java.util.ArrayList;
import java.util.Collections;

public class Prueba {

    private String nombre;
    private ArrayList <Pregunta> preguntas;
    private boolean estado;

    public Prueba(String nombre) {
        this.nombre = nombre; 
        this.preguntas = new ArrayList<>();
        this.estado = false;
    }
    
    public void responderALaPreguntaNumero(int indice, Respuesta respuesta) {
        this.preguntas.get(indice).setRespuesta(respuesta);
    }

    protected void agregarPreguntaPor(Pregunta pregunta, Object profesor) {
        if(profesor instanceof Profesor) {
            this.preguntas.add(pregunta);
        } else {
            System.out.println("¡Usted no tiene autorización para agregar preguntas!");
        }
    }

    protected void agregarPreguntasPor(Object profesor,Pregunta ... preguntas) {
        if(profesor instanceof Profesor) {
            Collections.addAll(this.preguntas, preguntas);
        } else {
            System.out.println("¡Usted no tiene autorización para agregar preguntas!");
        }
    }

    protected void eliminarPregunta(int indice, Object profesor) {
        if(profesor instanceof Profesor) {
            this.preguntas.remove(indice);
        } else {
            System.out.println("¡Usted no tiene autorización para eliminar preguntas!");
        }
    }

    public void finalizarPrueba() {
        this.estado = true;
    }

    public boolean haFinalizado() {
        return this.estado;
    }

    private int contarPreguntasCorrectas() {
        int numeroDePreguntasCorrectas = 0;
        for (Pregunta pregunta : this.preguntas) {
            if(pregunta.esCorrecta()){
                numeroDePreguntasCorrectas++;
            }
        }
        return numeroDePreguntasCorrectas;
    }

    protected double getCalificacion() {
        if(!this.haFinalizado()){
            return 0;
        }
        return 10.0 * this.contarPreguntasCorrectas() / this.preguntas.size();
    }

    public String toString() {
        String preguntas = "";
        for (Pregunta pregunta : this.preguntas) {
            preguntas += pregunta.toString();
        }
        return this.nombre + "\n" 
        + "Número de preguntas: " + this.preguntas.size() + "\n" 
        + preguntas;
    }

}
