package DataStructure.DS05;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/10
 * Time: 20:07
 * Description: No Description
 */
public class Card {
    String suit;  //花色
    int rank;     //大小

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Card)){
            return false;
        }
        Card card = (Card)obj;
        return this.suit.equals(card.suit) && this.rank == card.rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",suit,rank);  //注意一下这种输出方式
    }
}
