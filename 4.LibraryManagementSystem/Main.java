public class Main {

    static Library library = new Library();

    public static void main(String[] args) {

        Print.printTitle("Welcome To the Library");
        systemExplain();
        User user = new User(getUserName());
        library.addManga(new Manga("Attack on Titan","Hajime Isayama"));
        library.addManga(new Manga("Re:Zero kara Hajimeru Isekai Seikatsu","Tappei Nagatsuki"));
        library.addManga(new Manga("Oshi no Ko", "Aka Akasaka"));
        library.addManga(new Manga("Vinland Saga", "Makoto Yukimura"));

        boolean wantsExit = false;
        while (!wantsExit) {
            Print.printTitle("Welcome " + user.getName());
            Print.printGreenText("1- Borrow Manga\n");
            Print.printGreenText("2- Return Manga\n");
            Print.printGreenText("3- Add New Manga\n");
            Print.printGreenText("4- Remove Manga\n");
            Print.printGreenText("5- Exit\n");
            int choice = Input.getIntInput("What's your choice? ");

            switch (choice) {
                case 1:
                    borrowManga(user);
                    break;
                case 2:
                    returnManga(user);
                    break;
                case 3:
                    addManga();
                    break;
                case 4:
                    removeManga();
                    break;
                case 5:
                    Print.printTitle("Exiting program, Sayonara");
                    wantsExit = true;
                    break;
                default:
                    Print.printTitle("Invalid input, try again");
                    break;
            }
        }
    }

    private static String getUserName() {
        System.out.print("What's your name? ");
        return Input.scanner.nextLine();
    }

    private static void systemExplain() {
        String text = """
                ⚫ You can borrow any manga from list
                ⚫ You must return the manga after the specified time
                """;

        Print.printRedText(text);
    }

    private static void borrowManga(User user) {

        boolean isValid = false;
        while (!isValid) {
            Print.printTitle("Borrow Manga");
            library.showMangaList();
            Print.printGreenText("" + (library.getMangas().size()+1));
            Print.printGreenText("- Return Back\n");
            int choice = Input.getIntInput("What's your choice? ");
            if (choice == library.getMangas().size() + 1) return;
            else if (choice > library.getMangas().size() + 1) Print.printTitle("Invalid input, try again");
            else {
                user.borrowManga(library.getMangas().get(choice-1));
                isValid = true;
            }
        }
    }

    private static void returnManga(User user) {
        Print.printTitle("Return manga");
        Print.printGreenText("What is the name of the manga you want to return? ");
        String mangaName = Input.scanner.nextLine();
        for (int i = 0; i< library.getMangas().size(); i++) {
            if (library.getMangas().get(i).getTitle().equals(mangaName) && !library.getMangas().get(i).isAvailable()) {
                user.returnManga(library.getMangas().get(i));
                return;
            }
        }
        Print.printTitle("You did not borrow this manga");
    }

    private static void addManga() {
        Print.printTitle("Add Manga");
        Print.printGreenText("Enter Manga name: ");
        String mangaName = Input.scanner.nextLine();
        Print.printGreenText("Enter author name: ");
        String authorName = Input.scanner.nextLine();
        library.addManga(new Manga(mangaName,authorName));
        Print.printTitle("Added manga: " + mangaName);
    }

    private static void removeManga() {
        Print.printTitle("Remove Manga");
        Print.printGreenText("What is the name of the manga you want to remove? ");
        String mangaName = Input.scanner.nextLine();
        for (int i = 0; i< library.getMangas().size(); i++) {
            if (library.getMangas().get(i).getTitle().equals(mangaName))
                library.removeManga(library.getMangas().get(i));
        }
    }
}
