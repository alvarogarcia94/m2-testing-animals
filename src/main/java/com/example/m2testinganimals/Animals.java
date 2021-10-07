package com.example.m2testinganimals;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Animals {


    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String especie;
    private String nombre;
    private String sexo;
    private String FN;
    private double peso;


    //Build
    public Animals(){}

    public Animals(String especie, String nombre, String sexo, String FN, double peso){
        this.especie = especie;
        this.nombre = nombre;
        this.sexo = sexo;
        this.FN = FN;
        this.peso = peso;
    }

    //Getter and Setter
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
                "especie='" + especie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", FN='" + FN + '\'' +
                ", peso=" + peso +
                '}';
    }
}
