/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author joseh
 */
@Entity
@Table(name = "corretor")
public class Corretor extends Pessoa implements Serializable {
    
    @Min(value = 0, message = "O percentual de comissão não pode ser negativo")
    @NotNull(message = "O percentual de comissão deve ser informado")
    @Column(name = "percentual_comissao", nullable = false, columnDefinition = "decimal(5,2)")
    private Double percentualComissao;
    
    @NotBlank(message = "O nome de usuário não pode ser em branco")
    @Length(max = 30, message = "O nome de usuário não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 30, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 10, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 10, nullable = false)
    private String senha;
    
    public Corretor() {
        
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
