package love.tanyiqu.service.impl;

import love.tanyiqu.pojo.Film;
import love.tanyiqu.service.FilmService;
import love.tanyiqu.util.HtmlUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 最大资源网 的 接口实现类
 */
public class FilmService_zdzy5 implements FilmService {

    // 域名
    private static final String HOST_URL = "http://www.zuidazy4.com";

    // 请求连接
    private static final String REQUEST_URL = "http://www.zuidazy4.com/index.php?m=vod-search";

    @Override
    public List<Film> searchFilms(String filmName) {
        // 下载源码
        HashMap<String, String> params = new HashMap<>();
        params.put("submit", "search");
        params.put("wd", filmName);
        String html;
        try {
            html = HtmlUtil.getHtmlPost(REQUEST_URL, params);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        // 解析
        Document doc = Jsoup.parse(html);

        // 获取每项
        Elements elements = doc.select("div.xing_vb ul li");
        // 去掉第一个和最后一个
        elements.remove(0);
        elements.remove(elements.size() - 1);

        List<Film> filmList = new ArrayList<>();
        for (Element element : elements) {
            System.out.println(element);
            Film film = new Film();
            film.setFilmName(element.select("a").first().text());
            film.setFilmUrl(HOST_URL + element.select("a").first().attr("href"));
            film.setType(element.select("span.xing_vb5").text());
            filmList.add(film);
        }

        return filmList;
    }


    // 抓取封面
    private String getCover(String url) {
        return "";
    }


    @Test
    public void test_searchFilms() {
        List<Film> filmList = searchFilms("胜者");

        for (Film film : filmList) {
            System.out.println(film);
        }
    }

}
