public class Respuesta implements Comparable<Respuesta>{

    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    @Override
    public String toString() {
        return this.respuesta;
    }

    @Override
    public int compareTo(Respuesta otraRespuesta) {
        return this.respuesta.compareTo(otraRespuesta.getRespuesta());
    }

}
