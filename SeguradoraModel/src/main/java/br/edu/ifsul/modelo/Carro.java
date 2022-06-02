/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "carro")
public class Carro implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A placa não pode ser em branco")
    @Length(max = 10, message = "A placa não pode ter mais que {max} caracteres")
    @Column(name = "placa", length = 10, nullable = false)
    private String placa;
    
    @NotBlank(message = "O renavam não pode ser em branco")
    @Length(max = 15, message = "O renavam não pode ter mais que {max} caracteres")
    @Column(name = "renavam", length = 15, nullable = false)
    private String renavam;
    
    @NotBlank(message = "O modelo não pode ser em branco")
    @Length(max = 50, message = "O modelo não pode ter mais que {max} caracteres")
    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;
    
    @NotBlank(message = "A fabricante não pode ser em branco")
    @Length(max = 50, message = "A fabricante não pode ter mais que {max} caracteres")
    @Column(name = "fabricante", length = 50, nullable = false)
    private String fabricante;
    
    @Min(value = 0, message = "O ano de fabricação não pode ser negativo")
    @NotNull(message = "O ano de fabricação deve ser informado")
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;
    
    @Min(value = 0, message = "O ano do modelo não pode ser negativo")
    @NotNull(message = "O ano do modelo deve ser informado")
    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    ///Muitos para muitos
    @ManyToMany
    @JoinTable(name = "acessorios_carro",
            joinColumns = 
                    @JoinColumn(name = "carro_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "acessorios_id", referencedColumnName = "id", nullable = false)
            )
    private Set<Acessorios> acessorios = new HashSet<>();
    
    public Carro() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Set<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
}
