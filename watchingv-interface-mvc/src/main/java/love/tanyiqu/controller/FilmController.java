package love.tanyiqu.controller;

import love.tanyiqu.pojo.Film;
import love.tanyiqu.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {

    FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Film> search() {
        List<Film> films = filmService.searchFilms("你的名字");

        for (Film film : films) {
            System.out.println(film);
        }

        return films;
    }
}
