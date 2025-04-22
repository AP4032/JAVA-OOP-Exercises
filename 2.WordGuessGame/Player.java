import java.util.ArrayList;

public class Player {

    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<Integer> points = new ArrayList<>();
public void oneplayer(String name) {
    names.add(name);
}
public void multiplayer(String name) {
    names.add(name);

}
public void shownames(){
    System.out.println(names);
}
}