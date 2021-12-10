package DataStructure.DS05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/10
 * Time: 20:24
 * Description: No Description
 */
public class Player {
    String name;
    List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
}
