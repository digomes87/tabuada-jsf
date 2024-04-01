/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

/**
 *
 * @author Diego
 */
import java.util.Date;

public class Prova {
    private int numeroMatricula;
    private String nomeAluno;
    private Date dataProva;
    private double nota;

    // Construtor
    public Prova(int numeroMatricula, String nomeAluno, Date dataProva, double nota) {
        this.numeroMatricula = numeroMatricula;
        this.nomeAluno = nomeAluno;
        this.dataProva = dataProva;
        this.nota = nota;
    }

    // Getters e Setters
    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // Método equals para comparar dois objetos Prova
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prova prova = (Prova) obj;
        return numeroMatricula == prova.numeroMatricula;
    }

    // Método hashCode para gerar um código hash para o objeto Prova
    @Override
    public int hashCode() {
        return Integer.hashCode(numeroMatricula);
    }
}

