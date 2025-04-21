public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void borrowManga(Manga manga) {
        if (manga.isAvailable()) {
            manga.borrowManga();
            Print.printTitle(name + " borrowed the Manga: " + manga.getTitle());
        } else {
            Print.printTitle("Sorry, this manga is already borrowed.");
        }
    }

    public void returnManga(Manga manga) {
        manga.returnManga();
        Print.printTitle(name + " returned the manga: " + manga.getTitle());
    }

    public String getName() {
        return name;
    }
}