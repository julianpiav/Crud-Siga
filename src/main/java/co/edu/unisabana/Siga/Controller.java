package co.edu.unisabana.Siga;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    List<Estudiante> listaEstudiantes;
    public Controller() {
        this.listaEstudiantes = new ArrayList<>();
    }
    @PostMapping(path = "/estudiante/crear")
    public void crearEstudiante(@RequestBody Estudiante nuevoEstudiante){
        listaEstudiantes.add(nuevoEstudiante);
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
    public void actualizarEstudiante(@PathVariable int codigo, @RequestBody Estudiante estudianteModificado){
        for(Estudiante estudiante : listaEstudiantes){
            if (estudiante.getCodigo()==codigo){
                listaEstudiantes.replaceAll(a->a!=estudiante ? a:estudianteModificado);
            }
        }
    }

    @DeleteMapping(path = "/estudiante/eliminar/{codigo}")
    public void eliminarEstudiante(@PathVariable int codigo){
        listaEstudiantes.removeIf(estudiante -> estudiante.getCodigo() == codigo);
    }
}
