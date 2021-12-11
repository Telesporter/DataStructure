package DataStructure.DS05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/10
 * Time: 20:11
 * Description: No Description
 */
public class Game {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Zebra"));
        players.add(new Player("Pig"));
        players.add(new Player("Dog"));
        players.add(new Player("You"));
        initialiseCards(cards);  //初始化52张手牌
        sendCardsToPlayers(players,cards);  //将手牌分别发给不同的玩家，每人13张
        printPlayersCards(players);  //依次打印所有玩家手中的手牌

        play_DeathBlackPeach(players);  //游戏：谁有黑桃♠1他就炸了

        takeCardFromNextPlayer(players); //每名玩家依次从下一名玩家那里抽牌
        printPlayersCards(players);  //依次打印所有玩家手中的手牌

        play_DeathBlackPeach(players);  //游戏：谁有黑桃♠1他就炸了

        System.out.println(cards);  //打印牌库中剩余的牌
    }



    private static void takeCardFromNextPlayer(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Player nextPlayer = players.get(i == players.size()-1 ? 0 : i+1);
            player.cards.add(nextPlayer.cards.remove(0));
        }

    }

    private static void play_DeathBlackPeach(List<Player> players) {
        for (Player player : players) {
            for (Card playercard : player.cards) {
                if (playercard.equals(new Card("♠",1))){
                    System.out.printf("玩家%s有黑桃1,判定为死亡\n",player.name);
                }
            }
        }
    }

    public static void printPlayersCards(List<Player> players) {
        for (Player player : players) {
            System.out.printf("玩家[%s]的手牌是：",player.name);
            System.out.println(player.cards);
        }
    }

    public static void sendCardsToPlayers(List<Player> players, List<Card> cards) {
        for (Player player : players) {
            for (int i = 0; i < 13; i++) {
                Card card = cards.remove(0);
                player.cards.add(card);
            }
        }
    }


    public static void initialiseCards(List<Card> cards){
        for (String s : new String[]{"♣","♠","♥","◆"}){
            for (int i = 1; i <= 13 ; i++) {
                cards.add(new Card(s,i));
            }
        }
    }
}
