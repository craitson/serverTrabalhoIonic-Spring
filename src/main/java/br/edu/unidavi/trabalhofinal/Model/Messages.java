package br.edu.unidavi.trabalhofinal.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Messages {

    public Messages(String message) {
        this.message = message;
    }

    private String message;


}
