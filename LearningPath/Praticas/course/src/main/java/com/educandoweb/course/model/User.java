package com.educandoweb.course.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name =  "tb_users")
public class User implements Serializable {
    /*
        A interface Serializable permite que o objeto seja transformado em
        cadeias de bytes. Trafegando pela rede, seja gravado em arquivos, etc
     */
    private static final long serialVersionID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {} // Obrigado a se colocar por conta do Framework

    public User(long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
        /*
            Por padrão, o equals verifica se os objetos ocupam o mesmo endereço
            de memória (igualdade física). Sobrescrevi definindo uma "igualde lógica"
            ao comparar pelo Id.
         */
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
        /*
            Todo objeto tem um hash code  (um int que representa o objeto, como um CPF).

            REGRA: se objetos são iguais pelo equals, devem retornar o mesmo hashCode.

            Como estamos considerando que o que torna objetos iguais ou não é o Id
            (ignorando nome, email, etc), eles tem de retornar o Id como hashCode
            para serem considerados os mesmos.

            Estruturas como o HashMap usam o hashCode
         */
    }
}
