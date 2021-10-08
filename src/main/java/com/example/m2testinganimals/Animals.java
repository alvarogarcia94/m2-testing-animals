package com.example.m2testinganimals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animals {


    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String especie;
    private String nombre;
    private String sexo;
    private String FN;
    private double peso;


    //Build
    public Animals(){}

    public Animals(Long id, String especie, String nombre, String sexo, String FN, double peso){
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.sexo = sexo;
        this.FN = FN;
        this.peso = peso;
    }

    //Getter and Setter
    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String isSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFN() {
        return FN;
    }

    public void setFN(String FN) {
        this.FN = FN;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    //2String
    @Override
    public String toString() {
        return "Animales{" +
                "ID='" + id + '\'' +
                "especie='" + especie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", FN='" + FN + '\'' +
                ", peso=" + peso +
                '}';
    }
}
