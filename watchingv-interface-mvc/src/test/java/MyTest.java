import love.tanyiqu.pojo.Film;
import love.tanyiqu.service.FilmService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void searchFilms() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        FilmService filmService = applicationContext.getBean("filmService-zdzy5", FilmService.class);

        List<Film> films = filmService.searchFilms("你的名字");

//        for (Film film : films) {
//            System.out.println(film);
//        }
    }

}
