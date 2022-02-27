import java.util.Comparator;

public class EstudianteCompare implements Comparator<Estudiante>{

    @Override
    public int compare(Estudiante estudiante1, Estudiante estudiante2) {
        return estudiante1.getNombre().compareTo(estudiante2.getNombre());
    }

}