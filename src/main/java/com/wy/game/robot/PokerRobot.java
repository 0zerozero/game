package com.wy.game.robot;

import com.wy.game.card.Card;
import com.wy.game.deck.Deck;
import com.wy.game.ruler.Score;
import com.wy.game.strategy.Strategy;
import com.wy.game.card.poker.Poker;

/**
 * 打牌机器
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:17 下午
 */

public class PokerRobot extends AbstractCardRobot<Poker> {


    public PokerRobot(Strategy<Poker, Score<Poker>> drawStrategy, Deck<Poker> deck, String name) {
        super(drawStrategy, deck, name);
    }
    @Override
    public int score() {
        return super.cardList.stream().map(Card::getInfo).mapToInt(Poker::getPoint).sum();
    }
}
