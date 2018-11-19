package br.edu.unidavi.trabalhofinal.Service;

import br.edu.unidavi.trabalhofinal.Model.Professor;
import br.edu.unidavi.trabalhofinal.Model.Usuario;
import br.edu.unidavi.trabalhofinal.Repository.Professor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Professor_Service {

    @Autowired
    Professor_Repository professor_repository;

    public List<Professor> getAllProfessores() {
        return professor_repository.findAllBySync(false);
    }

    public Professor getProfessor(Long codigo) {
        return professor_repository.findProfessorById(codigo);
    }

    public Professor salvarProfessor(Professor professor) throws Exception {
        return professor_repository.save(professor);
    }

    public void excluir(Long id) {
        professor_repository.deleteById(id);
    }

    public boolean existe(Long id) {
        return professor_repository.existsById(id);
    }
}
