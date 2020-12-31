package love.tanyiqu.service.impl;

import love.tanyiqu.pojo.Film;
import love.tanyiqu.service.FilmService;
import love.tanyiqu.util.HtmlUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大资源网 的 接口实现类
 */
public class FilmService_zdzy5 implements FilmService {

    private static final String url = "http://www.zuidazy4.com/index.php?m=vod-search";

    @Override
    public List<Film> searchFilms(String filmName) {
        
        return null;
    }


    // 抓取封面
    private String getCover() {
        return "";
    }

    @Test
    public void test(){

    }

}
