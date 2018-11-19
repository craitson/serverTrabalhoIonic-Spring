package br.edu.unidavi.trabalhofinal.Controller;

import br.edu.unidavi.trabalhofinal.Model.Messages;
import br.edu.unidavi.trabalhofinal.Model.Usuario;
import br.edu.unidavi.trabalhofinal.Service.Usuario_Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class Usuarios_Controller {

    @Autowired
    Usuario_Service usuario_service;

    @CrossOrigin()
    @GetMapping("/recoveryMail/{mail}")
    public String recuperaPasswordEmail(@PathVariable String mail) throws Exception {

        Usuario user = usuario_service.returnUsuarioporEmail(mail);

        Messages messages;


        if (user != null) {
            messages = new Messages("Sua nova senha foi enviada para seu e-mail!");
        } else {
            messages = new Messages("Desculpe e-mail não encontrado, tente novamente!");

        }
        Gson gson = new Gson();

        String retorno = gson.toJson(messages);

        return retorno;
    }

    @CrossOrigin()
    @PostMapping(value = "/login")
    public String Autlogin(@RequestBody Usuario usuario) throws ForbiddenException {


        Usuario user = usuario_service.validUserSenha(usuario.getLogin(), usuario.getSenha());


        if (user == null) {

            throw new ForbiddenException("The requested page is forbidden");

        } else {

            Algorithm algorithm = Algorithm.HMAC256("sdfsdff");
            String token = JWT.create()
                    .withClaim("userId", user.getId())
                    .withClaim("createdAt", new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                    .sign(algorithm);

            user.setAcessToken(token);

            Gson g = new Gson();

//            System.out.println(t);


            return g.toJson(user);


//            String retorno = "S5S6D5F1V2DD48EE654E5";
//            Gson g = new Gson();
//
//            return g.toJson(retorno);
        }
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public class ForbiddenException extends Exception {
        public ForbiddenException(String message) {
            super(message);
        }
    }

}
