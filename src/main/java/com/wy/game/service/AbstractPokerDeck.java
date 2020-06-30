package com.wy.game.service;

import com.wy.game.bean.Poker;
import com.wy.game.enums.Suit;
import com.wy.game.service.AbstractDeck;
import com.wy.game.service.Ruler;

import java.util.List;

import static com.wy.game.bean.Poker.POKER_MAX_POINT;
import static com.wy.game.bean.Poker.POKER_MIN_POINT;

/**
 * 扑克牌堆
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:37 下午
 */
public abstract class AbstractPokerDeck extends AbstractDeck<Poker> implements Ruler<Poker> {

    /**
     * 初始化牌堆
     */
    @Override
    public void init() {
        for (int i = POKER_MIN_POINT; i <= POKER_MAX_POINT; i++) {
            for (Suit suit : Suit.values()) {
                super.deck.add(new Poker(suit,i));
            }
        }
    }

    @Override
    abstract public int win(List<Poker> a, List<Poker> b);
}
