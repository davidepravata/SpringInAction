package util;

public class TitlesVsUsername {

    private String title;
    private String username;

    public TitlesVsUsername(String title, String username) {
        this.title = title;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "TitlesVsUsername{" + "title='" + title + '\'' + ", username='" + username + '\'' + '}';
    }
}
