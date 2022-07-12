package ec.edu.ups.repo.estudiantes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.ups.modelo.Estudiantes.Estudiantes;


public interface IEstudiantes extends JpaRepository<Estudiantes, String>{
	
	@Query("SELECT p FROM Estudiantes p WHERE p.nombre LIKE %?1%"
			+ " OR p.apellido LIKE %?1%"
			+ " OR p.cedula LIKE %?1%"
			+ " OR p.curso LIKE %?1%")
	 public List<Estudiantes> findAll (String filtro);

}
