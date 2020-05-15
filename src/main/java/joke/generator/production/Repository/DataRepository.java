package joke.generator.production.Repository;


import joke.generator.production.Model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Random;

@Repository
public class DataRepository {
    @Autowired
    JdbcTemplate template;

    public Joke getRandomJoke() {
        String sql = "SELECT * from jokes";
        RowMapper<Joke> rowMapper = new BeanPropertyRowMapper<>(Joke.class);
        List<Joke> jokes = template.query(sql, rowMapper);
        System.out.println(jokes.toString());
        return selectRandomJoke(jokes);
    }

    private Joke selectRandomJoke(List<Joke> jokes){
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
    }
}
