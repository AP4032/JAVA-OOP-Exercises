import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreSystem {
    private Map<String, Player> players;

    public ScoreSystem() {
        players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        players.putIfAbsent(player.getName(), player);
    }

    public Player getPlayer(String name) {
        return players.get(name);
    }

    public void updateScore(String playerName, int points) {
        Player player = players.get(playerName);
        if (player != null) {
            player.addScore(points);
        }
    }

    public List<Player> getTopPlayers(int count) {
        return players.values().stream()
                .sorted(Comparator.comparingInt(Player::getScore).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public void displayLeaderboard() {
        System.out.println("\n----- Leaderboard -----");
        getTopPlayers(5).forEach(System.out::println);
    }
}