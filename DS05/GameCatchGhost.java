package DataStructure.DS05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static DataStructure.DS05.Game.printPlayersCards;
import static DataStructure.DS05.Game.washCards;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/12
 * Time: 16:34
 * Description: 捉鬼:
 * A-5 20张牌，去掉一张A
 * 五个人依次抓牌，直到把所有的牌都抓光。抓牌期间，一旦出现两张牌点数相同(凑成一对子了)就可以扔掉
 * 正式游戏:
 * 一个回合一个回合进行:
 * 每个人(甲)抽取下家(乙)的一张随机手牌:
 * 1.如果乙的手牌被抽完了。则乙退出游戏
 * 2.甲检查手中有没有凑成一-对，抽成了，还是把- -对扔掉,如果扔掉- -对后 手牌没有了，甲也退出
 * 只到只剩一个人。抓到鬼了
 */
public class GameCatchGhost {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Zebra"));
        players.add(new Player("Pig"));
        players.add(new Player("Dog"));
        players.add(new Player("Cat"));
        players.add(new Player("You"));
        initialiseCards2(cards);  //初始化19张牌，去掉一张A
        washCards(cards);//洗牌
        System.out.println(cards);
        sendCardsToPlayers(players,cards);  //发牌，如果有两张一样的手牌就丢弃
        printPlayersCards(players);  //依次打印所有玩家手中的手牌
        play(players);  //玩捉鬼游戏
        
    }

    private static void sendCardsToPlayers(List<Player> players, List<Card> cards) {
        while(cards.size() > 0){
            for (int i = 0; i < players.size(); i++) {
                if (cards.size() <= 0){  //如果牌发完了，要马上退出才行
                    break;
                }
                Player player = players.get(i);
                Card nextCardToBePutIn = cards.remove(0);
                putCardInOnePlayer(player,nextCardToBePutIn);
            }
        }
    }

    private static void play(List<Player> players) {
        while(players.size() > 1){
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if (player.cards.size() == 0){
                    players.remove(i);
                }
                Random random = new Random();
                Player nextPlayer = players.get(i == players.size()-1 ? 0 : i+1);
                if (nextPlayer.cards.size() == 0){  //如果下一个玩家的手牌为0，不用进行随机数生成，退出即可
                    players.remove(nextPlayer);
                    break;
                }
                int toDrawNextCardPos = random.nextInt(nextPlayer.cards.size());
                Card nextCardtoBePutIn = nextPlayer.cards.get(toDrawNextCardPos);
                putCardInOnePlayer(player,nextCardtoBePutIn);
            }
        }
        System.out.println("恭喜您"+players.get(0).name+"，赢得了胜利，现在他的手牌是"+players.get(0).cards);
    }

    private static void putCardInOnePlayer(Player player,Card nextCardToBePutIn){
        //传入一个玩家，和将要插入这个玩家的手牌，如果有重复，删除重复牌，没重复则插入
        boolean flag = true;
        for (int j = 0; j < player.cards.size(); j++) {
            if (player.cards.get(j).rank == nextCardToBePutIn.rank){
                //如果有重复的卡，那就把那张重复的也删除
                player.cards.remove(j);
                flag = false;  //同时标记，现在这张卡不需要add
                break;
            }
        }
        if (flag){  //flag=true表示没有重复的卡，那就add进去
            player.cards.add(nextCardToBePutIn);
        }

    }

    private static void initialiseCards2(List<Card> cards){
        for (String s : new String[]{"♠","♣","♥","◆"}){
            for (int i = 1; i <= 5 ; i++) {
                cards.add(new Card(s,i));
            }
        }
        cards.remove(0);
    }

}
