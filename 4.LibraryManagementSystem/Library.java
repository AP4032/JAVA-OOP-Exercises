import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Manga> mangas;

    public Library() {
        this.mangas = new ArrayList<>();
    }

    public void addManga(Manga manga) {
        mangas.add(manga);
    }

    public void removeManga(Manga manga) {
        mangas.remove(manga);
        Print.printTitle("Removed manga: " + manga.getTitle());
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void showMangaList() {
        for (int i=0; i<mangas.size(); i++) {
            Print.printGreenText("" + (i+1));
            Print.printGreenText("- " + mangas.get(i).getTitle() + " (" + mangas.get(i).getAuthor() + ")\n");
        }
    }
}