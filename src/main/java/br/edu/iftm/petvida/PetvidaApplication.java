package br.edu.iftm.petvida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;
import br.edu.iftm.petvida.repository.TutorRepository;

@SpringBootApplication
public class PetvidaApplication implements CommandLineRunner {

    // Injeção dos repositórios
    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetvidaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        Tutor tutor1 = new Tutor(178, "Lázaro", "(34) 97878-7878");
        
        tutorRepository.salvar(tutor1);
        System.out.println("Tutor salvo com sucesso!");

        Animal animal1 = new Animal(178, tutor1, "Cachorro", "Cao", 78);

        animalRepository.salvar(animal1);
        System.out.println("Animais salvos com sucesso!");

    }
}