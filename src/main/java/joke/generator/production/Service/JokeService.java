package joke.generator.production.Service; //comment


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

    public void addNewJoke(Joke joke){
        dataRepository.addNewJoke(joke);
    }

    public void deleteJoke(int jokeid) { dataRepository.deleteJoke(jokeid);}

    public Joke updateJoke(Joke joke){return dataRepository.updateJoke(joke);}

}
