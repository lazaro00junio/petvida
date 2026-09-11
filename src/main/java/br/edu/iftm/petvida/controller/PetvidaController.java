package br.edu.iftm.petvida.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;

@Controller
public class PetvidaController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/ficha_78")
    public String ficha(Model model) {
        Animal animal = animalRepository.buscarPorId(178);
        
        model.addAttribute("nomeAnimal", animal.getNome());
        model.addAttribute("especieAnimal", animal.getEspecie());
        model.addAttribute("idadeAnimal", animal.getIdade());
        model.addAttribute("nomeTutor", animal.getTutor().getNome());
        model.addAttribute("telefoneTutor", animal.getTutor().getTelefone());
        
        return "ficha";
    }

    @GetMapping("/tutor_78")
    public String tutor(Model model) {
        Animal animal = animalRepository.buscarPorId(178);
        Tutor tutor = animal.getTutor();
        
        int qtdAnimais = animalRepository.contarAnimaisDoTutor(tutor.getIdTutor());
        
        model.addAttribute("nomeTutor", tutor.getNome());
        model.addAttribute("telefoneTutor", tutor.getTelefone());
        model.addAttribute("qtdAnimais", qtdAnimais);
        
        return "tutor";
    }

    @GetMapping("/resumo_78")
    public String resumo(Model model) {
        int totalAnimais = animalRepository.contarAnimais();
        
        double media = animalRepository.mediaIdade();
        String mediaFormatada = String.format("%.2f", media);
        
        String animalMaisVelho = animalRepository.animalMaisVelho();
        
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatador);

        model.addAttribute("totalAnimais", totalAnimais);
        model.addAttribute("mediaIdade", mediaFormatada);
        model.addAttribute("animalMaisVelho", animalMaisVelho);
        model.addAttribute("dataHoraGeracao", dataHoraFormatada);
        
        return "resumo";
    }
}