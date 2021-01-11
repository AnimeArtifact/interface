package love.tanyiqu.service.impl;

import love.tanyiqu.pojo.Episode;
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

    // 维护一个filmList，在多线程中使用
    private List<Film> filmList = new ArrayList<>();


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


        for (Element element : elements) {
            Film film = new Film();
            film.setFilmName(element.select("a").first().text());
            film.setFilmUrl(HOST_URL + element.select("a").first().attr("href"));
            film.setType(element.select("span.xing_vb5").text());
            filmList.add(film);
        }

        // 抓取封面
        class GetCover implements Runnable {
            // 记录 抓取的第几个film的封面
            int num;

            public GetCover(int num) {
                this.num = num;
            }

            // 抓取封面
            private String getCover(String url) {
                // 下载源码
                String html;
                try {
                    html = HtmlUtil.getHtmlPost(url, new HashMap<>());
                } catch (IOException e) {
                    return "";
                }

                Document doc = Jsoup.parse(html);

                Element img = doc.select("div.vodImg .lazy").first();
                return img.attr("src");
            }

            public void run() {
                // 抓取
                String cover = getCover(filmList.get(num).getFilmUrl());
                // 赋值
                filmList.get(num).setFilmCover(cover);
            }
        }

        // 分别抓取封面
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < filmList.size(); i++) {
            Thread thread = new Thread(new GetCover(i));
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return filmList;
    }


    @Override
    public List<Episode> getEpisodes(String filmUrl) {
        // 获取html
        String html;
        try {
            html = HtmlUtil.getHtmlPost(filmUrl, new HashMap<>());
        } catch (IOException e) {
            return new ArrayList<>();
        }

        Document doc = Jsoup.parse(html);

        Elements elements = doc.getElementById("play_1").select("li");

        List<Episode> episodeList = new ArrayList<>();
        for (Element element : elements) {
            Episode episode = new Episode();
            String[] strings = element.text().split("\\$");
            episode.setEpisodeName(strings[0]);
            episode.setEpisodeUrl(strings[1]);
            episodeList.add(episode);
        }

        return episodeList;
    }

    @Override
    public List<Episode> getEpisodes(Film film) {
        return getEpisodes(film.getFilmUrl());
    }


    @Test
    public void test_searchFilms() {
        List<Film> filmList = searchFilms("魔法少女伊莉雅");
        for (Film film : filmList) {
            System.out.println(film);
        }
    }

    @Test
    public void test_getEpisodes() {
        List<Episode> episodeList = getEpisodes("http://www.zuidazy4.com/?m=vod-detail-id-74998.html");
        for (Episode episode : episodeList) {
            System.out.println(episode);
        }
    }

}
