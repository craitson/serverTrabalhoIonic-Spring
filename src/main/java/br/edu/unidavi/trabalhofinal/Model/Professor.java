package br.edu.unidavi.trabalhofinal.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "foto", length=99900000)
    private String foto;

    @Column(name = "curriculo")
    @Length(max = 2000)
    private String curriculo;

    @Column(name = "status")
    private boolean status;

    @Column(name = "sync")
    private boolean sync;

    @Column(name = "data_Nascimento")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

}
