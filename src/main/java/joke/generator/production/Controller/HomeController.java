package joke.generator.production.Controller;


import joke.generator.production.Model.Joke;
import joke.generator.production.Service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    JokeService jokeService;

    @GetMapping("/")
    public String index(Model model){
        Joke joke = jokeService.getRandomJoke();
        model.addAttribute("joke", joke);
        return "index.html";
    }
    @RequestMapping(value = "/generateNewJoke")
    public String generateNewJoke(Model model){
        Joke joke = jokeService.getRandomJoke();
        model.addAttribute("joke", joke); //!!!!!!!!!!!!!!!!!!!!!!!
        return "index.html";
    }
    @GetMapping("/addNewJoke") //?????????????????????????????????????????????????????//
    String addNewJoke(Model model){
        model.addAttribute("newJokeAdded", "New joke added :)");
        return "index.html";
    }

    @PostMapping("/addNewJoke")
    public String addNewJoke(@RequestParam String joke_text){
        jokeService.addNewJoke(joke_text);
        return "redirect:/";
    }

    @GetMapping("/deleteJoke/{joke.joke_id}")
    public String deleteJoke(@PathVariable("joke.joke_id") int joke_id, Model model) {
        String response = jokeService.deleteJoke(joke_id);
        model.addAttribute("response", response);
        Joke joke = jokeService.getRandomJoke();
        model.addAttribute("joke", joke);
        return "redirect:/";
    }

    @PostMapping("/updateJoke")
    public String updateJoke(@ModelAttribute Joke joke){
        jokeService.updateJoke(joke);
        return "index.html";
    }
}
