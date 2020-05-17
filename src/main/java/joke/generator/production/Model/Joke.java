package joke.generator.production.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Joke {
    @Id
    private int joke_id;
    public String joke_text;

    public int getJoke_id() {
        return joke_id;
    }

    public void setJoke_id(int joke_id) {
        this.joke_id = joke_id;
    }

    public String getJoke_text() {
        return joke_text;
    }

    public void setJoke_text(String joke_text) {
        this.joke_text = joke_text;
    }
}
