package love.tanyiqu.pojo;

@SuppressWarnings("unused")
public class Film {
    // 影片名
    private String filmName;

    // 影片链接
    private String filmUrl;

    // 类型
    private String type;

    // 影片封面
    private String filmCover;

    public Film() {
        this.type = "类型";
    }

    public Film(String filmName, String filmUrl, String type, String filmCover) {
        this.filmName = filmName;
        this.filmUrl = filmUrl;
        this.type = type;
        this.filmCover = filmCover;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", filmUrl='" + filmUrl + '\'' +
                ", type='" + type + '\'' +
                ", filmCover='" + filmCover + '\'' +
                '}';
    }
}
