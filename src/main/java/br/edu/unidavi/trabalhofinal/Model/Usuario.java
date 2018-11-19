package br.edu.unidavi.trabalhofinal.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "nome")
    private String nome;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "senha")
    private String senha;

    private String acessToken;

}
