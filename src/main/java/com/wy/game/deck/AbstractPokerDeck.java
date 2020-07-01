package com.wy.game.deck;

import com.wy.game.card.poker.Poker;
import com.wy.game.card.poker.SuitEnum;

import static com.wy.game.card.poker.Poker.POKER_MAX_POINT;
import static com.wy.game.card.poker.Poker.POKER_MIN_POINT;

/**
 * 扑克牌堆
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:37 下午
 */
public abstract class AbstractPokerDeck extends AbstractDeck<Poker> {

    /**
     * 初始化牌堆
     */
    @Override
    public void init() {
        for (int i = POKER_MIN_POINT; i <= POKER_MAX_POINT; i++) {
            for (SuitEnum suit : SuitEnum.values()) {
                super.deck.add(new Poker(suit,i));
            }
        }
    }
}
