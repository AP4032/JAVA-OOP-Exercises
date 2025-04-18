import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("نام خود را وارد کنید: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("خوش آمدید، " + player.getName() + "! بیایید بازی حدس کلمه را شروع کنیم.");
        Game game = new Game();
        game.play();
    }
}