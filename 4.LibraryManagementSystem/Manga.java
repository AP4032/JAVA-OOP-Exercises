public class Manga {
    private String title;
    private String author;
    private boolean isAvailable;

    public Manga(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowManga() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    public void returnManga() {
        isAvailable = true;
    }

    public String getAuthor() {
        return author;
    }
}
