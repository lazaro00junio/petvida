package br.edu.iftm.petvida.model;

public class Animal {
    private int idAnimal;
    
    
    private Tutor tutor; 
    
    private String nome;
    private String especie;
    
    private int idade; 
    
    public Animal(int idAnimal, Tutor tutor, String nome, String especie, int idade) {
        this.idAnimal = idAnimal;
        this.tutor = tutor;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }

    // Getters e Setters
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    // O Getter agora retorna um objeto Tutor, permitindo fazer: animal.getTutor().getIdTutor()
    public Tutor getTutor() {
        return tutor;
    }

    // O Setter agora recebe um objeto Tutor
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}