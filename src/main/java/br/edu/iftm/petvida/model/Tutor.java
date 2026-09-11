package br.edu.iftm.petvida.model;

public class Tutor {
    int idTutor;
    String nome,telefone;
    
    public Tutor(int idTutor,String nome, String telefone) {
        this.idTutor=idTutor;
        this.nome=nome;
        this.telefone=telefone;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

