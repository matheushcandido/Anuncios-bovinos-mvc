package Insetec.TCC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

    
@Entity
@Table(name= "anuncio")
public class Anuncio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "registro")
    private int registro;

    @Column(name = "proprietario")
    private String proprietario;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "raca")
    private String raca;

    @Column(name = "racaPaterna")
    private String racaPaterna;

    @Column(name = "racaMaterna")
    private String racaMaterna;

    @Column(name = "observacao")
    private String observacao;

    @Lob
    @Column(name = "image")
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getRacaPaterna() {
        return racaPaterna;
    }

    public void setRacaPaterna(String racaPaterna) {
        this.racaPaterna = racaPaterna;
    }

    public String getRacaMaterna() {
        return racaMaterna;
    }

    public void setRacaMaterna(String racaMaterna) {
        this.racaMaterna = racaMaterna;
    }

}
