package DataStructure.DS05;

import java.util.*;

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
        washCards(cards);//洗牌
        sendCardsToPlayers(players,cards);  //将手牌分别发给不同的玩家，每人13张
        printPlayersCards(players);  //依次打印所有玩家手中的手牌

        play_DeathBlackPeach(players);  //游戏：谁有黑桃♠1他就赢了
        zebraExchangeBlackPeachFromOthers(players);
        //如果zebra没有黑桃A，就把自己的第一张手牌和其他人手里的黑桃A偷换

        takeCardFromNextPlayer(players); //每名玩家依次从下一名玩家那里抽牌
        printPlayersCards(players);  //依次打印所有玩家手中的手牌

        play_DeathBlackPeach(players);  //游戏：谁有黑桃♠1他就赢了

        System.out.println(cards);  //打印牌库中剩余的牌
    }

    public static void washCards(List<Card> cards) {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int toExchange = random.nextInt(cards.size());
            Card tempCard = cards.get(i);
            cards.set(i,cards.get(toExchange));
            cards.set(toExchange,tempCard);
        }
    }

    private static void zebraExchangeBlackPeachFromOthers(List<Player> players) {
        if (players.get(0).cards.contains(new Card("♠",1))){  //Zebra有黑桃A
            return;
        }
        Player zebra = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            int blackPeachPos = player.cards.indexOf(new Card("♠",1));
            if (blackPeachPos != -1){
                player.cards.set(blackPeachPos,zebra.cards.get(0));
                zebra.cards.set(0,new Card("♠",1));
            }

        }
    }


    private static void takeCardFromNextPlayer(List<Player> players) {
        Random random = new Random();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Player nextPlayer = players.get(i == players.size()-1 ? 0 : i+1);
            int toDrawNextCard = random.nextInt(nextPlayer.cards.size());
            player.cards.add(nextPlayer.cards.remove(toDrawNextCard));
        }

    }

    private static void play_DeathBlackPeach(List<Player> players) {
        for (Player player : players) {
            for (Card playercard : player.cards) {
                if (playercard.equals(new Card("♠",1))){
                    System.out.printf("恭喜玩家%s有黑桃1,获得了胜利\n",player.name);
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
