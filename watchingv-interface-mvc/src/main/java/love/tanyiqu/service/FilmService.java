package love.tanyiqu.service;

import love.tanyiqu.pojo.Film;

import java.util.List;

public interface FilmService {

    // 根据名字查找影片
    List<Film> searchFilms(String filmName);
}
