package joke.generator.production.Controller;


import joke.generator.production.Model.Joke;
import joke.generator.production.Service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    JokeService jokeService;

    @GetMapping("/")
    public String index(Model model){
        Joke joke = jokeService.getRandomJoke();
        model.addAttribute("joke", joke.getJoke_text());
        return "index.html";
    }
    @RequestMapping(value = "/generateNewJoke")
    public String generateNewJoke(Model model){
        Joke joke = jokeService.getRandomJoke();
        model.addAttribute("joke", joke.getJoke_text());
        return "index.html";
    }

    @GetMapping("/addNewJoke")
    String addNewJoke(Model model){
        model.addAttribute("newJokeAdded", "New joke added :)");
        return "index.html";
    }

    @PostMapping("/addNewJoke")
    public String addNewJoke(@ModelAttribute Joke joke){
        jokeService.addNewJoke(joke);
        return "redirect:/";
    }

    @PostMapping("/deleteJoke")
    public String deleteJoke(@ModelAttribute Joke joke){
        jokeService.deleteJoke(joke);
        return "index.html";
    }
}
