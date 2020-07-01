package com.wy.game.deck;

import com.wy.game.card.Card;
import com.wy.game.card.poker.Poker;
import com.wy.game.ruler.Score;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:10 下午
 */
@Service
public class BlackJackGame extends AbstractPokerDeck {

    private static final int BAST_POINT = 21;

    @Override
    public int result(Score a, Score b) {
        int mySum = a.score();
        int youSum = b.score();
        if (youSum - mySum == 0 ){
            return 0;
        }else {
            if (youSum == BAST_POINT){
                return -1;
            }else if(mySum == BAST_POINT){
                return 1;
            }else if (youSum < BAST_POINT && mySum <BAST_POINT){
                return mySum - youSum;
            }else {
                return youSum - mySum;
            }
        }
    }

    @Override
    public Card<Poker> draw(Object obj) {
        List<Card<Poker>> cards = visibleCardListMap.getOrDefault(obj, Collections.emptyList());
        Card<Poker> card = deck.pop();
        if (!cards.isEmpty()){
            cards.add(card);
        }
        return card;
    }
}
