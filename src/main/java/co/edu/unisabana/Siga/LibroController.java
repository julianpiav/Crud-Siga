package co.edu.unisabana.Siga;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static co.edu.unisabana.Siga.CategoriaEnum.*;

@RestController
@RequestMapping("/libreria")

public class LibroController {
    List<LibroDTO> listaLibros;

    LibroDTO libro1 = new LibroDTO(1,"titulo 1","autor 1",COMEDIA,true);
    LibroDTO libro2 = new LibroDTO(2,"titulo 2","autor 2",LINGUISTICO,true);

    public LibroController() {
        this.listaLibros = new ArrayList<>();
        listaLibros.add(libro1);
        listaLibros.add(libro2);

        listaLibros.add(new LibroDTO(3,"titulo 3","autor 1",BIOGRAFIA,true ));
        listaLibros.add(new LibroDTO(4,"titulo 4","autor 4",VIAJE,false ));
        listaLibros.add(new LibroDTO(5,"titulo 5","autor 1",COMEDIA,false ));
        listaLibros.add(new LibroDTO(6,"titulo 6","autor 6",JUVENIL,true ));
        listaLibros.add(new LibroDTO(7,"titulo 7","autor 7",FICCION,false ));
    }

    @GetMapping(path = "/todos")
    public List<LibroDTO> obtenerLibros() {
        return listaLibros;
    }


    @GetMapping(path = "/categoria")
    public List<LibroDTO> obtenerLibrosPorCategoria(@RequestParam CategoriaEnum categoria, @RequestParam int cantidadLibros) {
        List<LibroDTO> busqueda = new ArrayList<>();
        int contador = 0;
        for (LibroDTO libro : listaLibros) {
            if (libro.getCategoria().equals(categoria) && contador < cantidadLibros) {
                busqueda.add(libro);
                contador++;
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/titulo")
    public List<LibroDTO> obtenerLibrosPorAutor(@RequestParam String titulo, @RequestParam int cantidadLibros) {
        List<LibroDTO> busqueda = new ArrayList<>();
        int contador = 0;
        for (LibroDTO libro : listaLibros) {
            if (libro.getTitulo().equals(titulo) && contador < cantidadLibros) {
                busqueda.add(libro);
                contador++;
            }
        }
        return busqueda;
    }
}