package ec.edu.ups.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.ups.modelo.Estudiantes.Estudiantes;
import ec.edu.ups.services.EstudianteService;

@RestController
@RequestMapping("/databases")
public class TestController {

	@Autowired
	private EstudianteService estudianteService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{filtro}")
	public List<Estudiantes> verPaginaFront(@PathVariable(name = "filtro") String filtro) {
	
		List<Estudiantes> listaEstudiantes = estudianteService.listAll(filtro);

		return listaEstudiantes;

	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<Estudiantes> verPaginaFront() {
	    String filtro ="";
		List<Estudiantes> listaEstudiantes = estudianteService.listAll(filtro);

		return listaEstudiantes;

	}


	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/ingreso")
	public void registrarEstudiante(@RequestBody Estudiantes estudiante) {

		estudianteService.registrar(estudiante);

	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/actualizar/{cedula}")
	public void actualizarPersona(@PathVariable(name = "cedula") String cedula) {
		try {

			Estudiantes e = new Estudiantes();
			e = estudianteService.getEstudiante(cedula);

			if (e != null) {
				estudianteService.registrar(e);
			}

		} catch (Exception e) {

			System.out.println("ERROR; " + e.getMessage());

		}

	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/estudiante/{cedula}")
	public Estudiantes buscarPersona(@PathVariable(name = "cedula") String cedula) {
		try {

			Estudiantes e = new Estudiantes();
			e = estudianteService.getEstudiante(cedula);
             
			return e;
	
		} catch (Exception e) {

			System.out.println("ERROR; " + e.getMessage());

		}
		return null;

	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/eliminar/{cedula}")
	public void eliminarEstudiante(@PathVariable(name = "cedula") String cedula) {
		
		estudianteService.delete(cedula);
	}

}
