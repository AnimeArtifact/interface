package love.tanyiqu.service;

import love.tanyiqu.pojo.Episode;
import love.tanyiqu.pojo.Film;

import java.util.List;

public interface FilmService {

    // 根据名字查找影片
    List<Film> searchFilms(String filmName);

    // 获取Film的所有集数
    List<Episode> getEpisodes(Film film);

    // 根据filmUrl获取所有集数
    List<Episode> getEpisodes(String filmUrl);

}
