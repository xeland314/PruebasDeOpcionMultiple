public class Estudiante {

    private String nombre;
    private Prueba prueba;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrueba(Prueba prueba, Object profesor) {
        if(profesor instanceof Profesor) {
            this.prueba = prueba;
        } else {
            System.out.println("¡Usted no tiene autorización para agregar una prueba!");
        }
    }

    public Prueba getPrueba() {
        return this.prueba;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void responderALaPreguntaNumero(int indice, Respuesta respuesta) {
        this.prueba.responderALaPreguntaNumero(indice, respuesta);
    }

    public void finalizarPrueba() {
        this.prueba.finalizarPrueba();
    }

    @Override 
    public String toString() {
        return "Nombre del estudiante: " + this.nombre;
    }

}
