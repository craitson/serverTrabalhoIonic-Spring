package br.edu.unidavi.trabalhofinal.Controller;

import br.edu.unidavi.trabalhofinal.Model.Professor;
import br.edu.unidavi.trabalhofinal.Service.Professor_Service;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Professores_Controller {

    @Autowired
    Professor_Service professor_service;

    @CrossOrigin()
    @GetMapping("/professores")
    public String getProfessores() throws Exception {

        List<Professor> lista = professor_service.getAllProfessores();

        Gson gson = new Gson();

        for (Professor prof : lista) {
            prof.setSync(true);
            professor_service.salvarProfessor(prof);
        }


        String retorno = gson.toJson(lista);

        return retorno;
    }

    @CrossOrigin()
    @GetMapping("/professor/{codigo}")
    public String getProfessor(@PathVariable Long codigo) throws Exception {

        //List<Professor> lista = professor_service.getAllProfessores();

        Professor prof = professor_service.getProfessor(codigo);

        Gson gson = new Gson();

        return gson.toJson(prof);

    }

    @CrossOrigin()
    @PostMapping(value = "/professorNovo")
    public boolean criaProfessor(@RequestBody Professor professor) throws Exception {

        //seta false para a sincronização pegar os novas dados
        professor.setSync(false);

        Professor prof = professor_service.salvarProfessor(professor);

        if (professor != null) {
            return true;
        } else {
            return false;
        }

    }

    @CrossOrigin()
    @DeleteMapping(value = "/deleteProf/{codigo}")
    public Professor deleteProfessor(@PathVariable Long codigo) throws Exception {

        professor_service.excluir(codigo);

        Professor prof;

        return prof = professor_service.getProfessor(codigo);
        //return !professor_service.existe(codigo);

    }

}
