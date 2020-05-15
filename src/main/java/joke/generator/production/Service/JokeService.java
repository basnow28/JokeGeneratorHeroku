package joke.generator.production.Service;


import joke.generator.production.Model.Joke;
import joke.generator.production.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeService {
    @Autowired
    DataRepository dataRepository;

    public Joke getRandomJoke() {
        return dataRepository.getRandomJoke();
    }
}
