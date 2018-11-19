package br.edu.unidavi.trabalhofinal.Repository;

import br.edu.unidavi.trabalhofinal.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Professor_Repository extends JpaRepository<Professor, Long> {

    List<Professor> findAll();

    List<Professor> findAllBySync(boolean sync);

    Professor findProfessorById(Long id);

    boolean existsById(Long id);

}