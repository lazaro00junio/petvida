package br.edu.iftm.petvida.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;

@Repository
public class AnimalRepository {

    private final JdbcTemplate jdbc;

    public AnimalRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Animal buscarPorId(int id) {
        String sql = """
    SELECT a.id_animal, a.nome AS nome_animal, a.especie, a.idade, 
           t.id_tutor, t.nome AS nome_tutor, t.telefone 
    FROM animal a
    INNER JOIN tutor t ON a.tutor_id_tutor = t.id_tutor
    WHERE a.id_animal = ?
""";

        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            Tutor tutor = new Tutor(
                    rs.getInt("id_tutor"),
                    rs.getString("nome_tutor"),
                    rs.getString("telefone")
            );

            Animal animal = new Animal(
                    rs.getInt("id_animal"),
                    tutor, // Objeto Tutor sendo passado no construtor
                    rs.getString("nome_animal"),
                    rs.getString("especie"),
                    rs.getInt("idade")
            );
            return animal;
        }, id);
    }

    public int contarAnimais() {
        String sql = "SELECT COUNT(*) FROM animal";
        return jdbc.queryForObject(sql, Integer.class);
    }

    public double mediaIdade() {
        String sql = "SELECT AVG(idade) FROM animal";
        Double media = jdbc.queryForObject(sql, Double.class);
        return media != null ? media : 0.0;
    }

    public String animalMaisVelho() {
        String sql = "SELECT nome FROM animal ORDER BY idade DESC LIMIT 1";
        return jdbc.queryForObject(sql, String.class);
    }

    public int contarAnimaisDoTutor(int idTutor) {
        String sql = "SELECT COUNT(*) FROM animal WHERE tutor_id_tutor = ?";
        return jdbc.queryForObject(sql, Integer.class, idTutor);
    }

    public void salvar(Animal animal) {
        String sql = "INSERT INTO animal (id_animal, tutor_id_tutor, nome, especie, idade) VALUES (?, ?, ?, ?, ?)";

        jdbc.update(sql,
                animal.getIdAnimal(),
                animal.getTutor().getIdTutor(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getIdade()
        );
    }
}
