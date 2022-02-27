public class Main {

    public static void main(String[] args) {
        
        Profesor miProfe = new Profesor("Alfonso");

        miProfe.agregarEstudiantes(
            new Estudiante("Rafa"), new Estudiante("Alex"),
            new Estudiante("Darmy"), new Estudiante("Mateo"), 
            new Estudiante("Danna"), new Estudiante("Karol")
        );

        Prueba pruebaFinal = new Prueba("Prueba Semestral 1");
        pruebaFinal.agregarPreguntasPor(miProfe,
        new Pregunta(
            "¿Cuántos es 2+2?", new Solucion("4"),
            new Opcion("1"), new Opcion("2"), 
            new Opcion("3"), new Opcion("4") 
        ), new Pregunta(
            "¿Cuál es la capital de Ecuador?", new Solucion("Quito"),
            new Opcion("Guayaquil"), new Opcion("Cuenca"),
            new Opcion("Galápagos"), new Opcion("Quito"),
            new Opcion("Santa Elena")
        ), new Pregunta(
            "¿En qué año se descubrió América?", new Solucion("1492"),
            new Opcion("Nunca fue descubierto."), 
            new Opcion("1456"), new Opcion("1492"), new Opcion("1508")
        )
        );

        System.out.println(pruebaFinal.toString());

        miProfe.setPruebaALosEstudiantes(pruebaFinal);

        Estudiante estudiante = miProfe.getEstudianteNumero(0);
        estudiante.responderALaPreguntaNumero(0, new Respuesta("4"));
        estudiante.responderALaPreguntaNumero(1, new Respuesta("Quito"));
        estudiante.responderALaPreguntaNumero(2, new Respuesta("1456"));
        estudiante.finalizarPrueba();

        System.out.println(
            "Nota de " + estudiante.getNombre() + " es: " +
            miProfe.getCalificacionDe(estudiante)
        );
        

    }

}