package br.edu.unidavi.trabalhofinal.Service;

import br.edu.unidavi.trabalhofinal.Model.Usuario;
import br.edu.unidavi.trabalhofinal.Repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Usuario_Service {

    @Autowired
    Usuario_Repository usuario_repository;

    public Usuario returnUsuarioporEmail(String mail) {
        return usuario_repository.findByEmail(mail);
    }

    public Usuario validUserSenha(String login, String senha) {
        return usuario_repository.findByLoginAndSenha(login, senha);
    }
}
