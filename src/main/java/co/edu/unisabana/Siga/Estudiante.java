package co.edu.unisabana.Siga;

import java.util.Objects;

public class Estudiante {
    private String nombre;
    private int codigo;
    private int semestre;

    private String facultad;
    private String Programa;

    public Estudiante(String nombre, int semestre, String facultad, String Programa) {
        this.codigo= (int) (Math.random() * 1000);
        this.nombre = nombre;
        this.semestre = semestre;
        this.facultad = facultad;
        this.Programa = Programa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setPrograma(String programa) {
        this.Programa = programa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
