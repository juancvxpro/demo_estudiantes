package ec.edu.ups.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ups.modelo.Estudiantes.Estudiantes;
import ec.edu.ups.repo.estudiantes.IEstudiantes;

@Service
public class EstudianteService {
	
	@Autowired
	private IEstudiantes repo;

	
	public void registrar (Estudiantes t) {
		
		repo.save(t);
	
	}
	
	public List<Estudiantes> listAll(String filtro){
		
		if(filtro != null) {
			return repo.findAll(filtro);
		}
		
		return repo.findAll();
		
	}
	
	public Estudiantes getEstudiante (String cedula) {
		
		return repo.findById(cedula).get();
	}
	
	
	public void delete (String cedula) {
		
		repo.deleteById (cedula);
		
		
	}
	
}
