import java.util.ArrayList;
import java.util.Collection;

public class Profesor {

    private String nombre;
    private ArrayList <Estudiante> estudiantes;

    public Profesor(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public void agregarEstudiantes(Estudiante ... estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            this.agregarEstudiante(estudiante);
        }
    }

    public Estudiante getEstudianteNumero(int indice) {
        return this.estudiantes.get(indice);
    }

    public double getCalificacionDe(Estudiante estudiante) {
        return this.buscarUnEstudiantePorNombre(estudiante.getNombre()).getPrueba().getCalificacion();
    }

    public Estudiante buscarUnEstudiantePorNombre(String nombre) {
        Estudiante estudianteBuscado = null;
        for (Estudiante estudiante: this.estudiantes){
            if(estudiante.getNombre().equals(nombre)){
                estudianteBuscado = estudiante;
            }
        }
        return estudianteBuscado;
    }

    public Collection<? extends Estudiante> buscarCoincidenciaEstudiantePorNombre(String fragmentoDeNombre) {
        ArrayList<Estudiante> coincidencias = new ArrayList<Estudiante>();
        for (Estudiante estudiante: this.estudiantes){
            if(estudiante.getNombre().contains(fragmentoDeNombre)){
                coincidencias.add(estudiante);
            }
        }
        coincidencias.sort(new EstudianteCompare());
        return  coincidencias;
    }

    public void setPruebaALosEstudiantes(Prueba prueba) {
        for (Estudiante estudiante : this.estudiantes) {
            estudiante.setPrueba(prueba, this);
        }
    }

    public String toString() {
        return "Profesor: " + this.nombre + "\n";
    }

}
