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

    public void addNewJoke(String joke_text){
        dataRepository.addNewJoke(joke_text);
    }

    public String deleteJoke(int joke_id) { return dataRepository.deleteJoke(joke_id);} //string?


    public Joke updateJoke(Joke joke){return dataRepository.updateJoke(joke);}

}
