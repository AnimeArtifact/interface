package love.tanyiqu.pojo;

import java.util.List;

@SuppressWarnings("unused")
public class Film {
    // 影片名
    private String filmName;

    // 影片链接
    private String filmUrl;

    // 影片封面
    private String filmCover;

    // 影片的集数列表
    private List<Episode> episodeList;

    public Film() {
    }

    public Film(String filmName, String filmUrl, String filmCover, List<Episode> episodeList) {
        this.filmName = filmName;
        this.filmUrl = filmUrl;
        this.filmCover = filmCover;
        this.episodeList = episodeList;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmUrl() {
        return filmUrl;
    }

    public void setFilmUrl(String filmUrl) {
        this.filmUrl = filmUrl;
    }

    public String getFilmCover() {
        return filmCover;
    }

    public void setFilmCover(String filmCover) {
        this.filmCover = filmCover;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", filmUrl='" + filmUrl + '\'' +
                ", filmCover='" + filmCover + '\'' +
                ", episodeList=" + episodeList +
                '}';
    }
}
