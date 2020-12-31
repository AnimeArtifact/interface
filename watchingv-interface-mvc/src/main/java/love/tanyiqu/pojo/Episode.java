package love.tanyiqu.pojo;

@SuppressWarnings("unused")
public class Episode {
    private String episodeName;
    private String episodeUrl;

    public Episode() {
    }

    public Episode(String episodeName, String episodeUrl) {
        this.episodeName = episodeName;
        this.episodeUrl = episodeUrl;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getEpisodeUrl() {
        return episodeUrl;
    }

    public void setEpisodeUrl(String episodeUrl) {
        this.episodeUrl = episodeUrl;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodeName='" + episodeName + '\'' +
                ", episodeUrl='" + episodeUrl + '\'' +
                '}';
    }
}
