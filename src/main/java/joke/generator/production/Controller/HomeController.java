package joke.generator.production.Controller;


import joke.generator.production.Model.Joke;
import joke.generator.production.Service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    JokeService jokeService;

    @GetMapping("/")
    public String index(Model model){
        Joke joke = jokeService.getRandomJoke();
        System.out.println("joke" + joke);
        model.addAttribute("joke", joke.getJoke());
        return "index.html";
    }
}
