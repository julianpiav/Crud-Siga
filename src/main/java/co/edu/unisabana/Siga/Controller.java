package co.edu.unisabana.Siga;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    List<Estudiante> listaEstudiantes;
    public Controller() {
        this.listaEstudiantes = new ArrayList<>();
    }
    @PostMapping(path = "/estudiante/crear")
    public Respuesta crearEstudiante(@RequestBody Estudiante nuevoEstudiante){
        listaEstudiantes.add(nuevoEstudiante);
        return new Respuesta("Estudiante ingresado correctamente");
    }
    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> obtenerEstudiantes(){
        return listaEstudiantes;
    }
    @GetMapping(path = "/estudiantes")
    public List<Estudiante> obtenerEstudiantesPorFacultad(@RequestParam String facultad,@RequestParam int cantidadEstudiantes){
        List<Estudiante> busqueda = new ArrayList<>();
        int contador=0;
        for(Estudiante estudiante : listaEstudiantes){
            if (estudiante.getFacultad().equals(facultad) && contador<cantidadEstudiantes){
                busqueda.add(estudiante);
                contador++;
            }
        }
        return busqueda;
    }

    @PutMapping(path = "/estudiante/actualizar/{codigo}")
    public Respuesta actualizarEstudiante(@PathVariable int codigo, @RequestBody Estudiante estudianteModificado){
        for(Estudiante estudiante : listaEstudiantes){
            if (estudiante.getCodigo()==codigo){
                estudiante.setNombre(estudianteModificado.getNombre());
                estudiante.setSemestre(estudianteModificado.getSemestre());
                estudiante.setFacultad(estudianteModificado.getFacultad());
                estudiante.setPrograma(estudianteModificado.getPrograma());

            }
        }
        return new Respuesta("Estudiante actualizado correctamente");
    }

    @DeleteMapping(path = "/estudiante/eliminar/{codigo}")
    public Respuesta eliminarEstudiante(@PathVariable int codigo){
        listaEstudiantes.removeIf(estudiante -> estudiante.getCodigo() == codigo);
        return new Respuesta("Estudiante borrado correctamente");
    }
}
