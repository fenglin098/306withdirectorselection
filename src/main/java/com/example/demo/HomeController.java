package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("directors", directorRepository.findAll());
        return "index";
    }

    //director

    @GetMapping("/add/director")
    public String directorForm(Model model){
        model.addAttribute("director", new Director());
        return "directorform";
    }

    @PostMapping("/processdirector")
    public String processDForm(Director director){
        directorRepository.save(director);
        return "redirect:/";
    }

    @RequestMapping("/detailD/{id]")
    public String show(@PathVariable("id") long id, Model model){
        model.addAttribute("director", directorRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/updateD/{id}")
    public String updateD(@PathVariable("id") long id, Model model){
        model.addAttribute("director", directorRepository.findById(id).get());
        return "directorform";
    }

    @RequestMapping("/deleteD/{id}")
    public String delD(@PathVariable("id") long id){
        directorRepository.deleteById(id);
        return "redirect:/";
    }

    //movies
    @GetMapping("/add/movie")
    public String movieForm(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("directors", directorRepository.findAll());
        return "movieform";
    }

    @PostMapping("/processmovie")
    public String processMForm(Movie movie){
        movieRepository.save(movie);
        return "redirect:/";
    }

    @RequestMapping("/detailM/{id]")
    public String showM(@PathVariable("id") long id, Model model){
        model.addAttribute("movie", directorRepository.findById(id).get());
        return "showM";
    }

    @RequestMapping("/updateM/{id}")
    public String updateM(@PathVariable("id") long id, Model model){
        model.addAttribute("movie", directorRepository.findById(id).get());
        return "movieform";
    }

    @RequestMapping("/deleteM/{id}")
    public String delM(@PathVariable("id") long id){
        movieRepository.deleteById(id);
        return "redirect:/";
    }
}
