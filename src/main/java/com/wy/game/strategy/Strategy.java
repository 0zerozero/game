package com.wy.game.strategy;

import com.wy.game.card.Card;
import com.wy.game.deck.Deck;
import com.wy.game.ruler.Score;


/**
 * 抽牌与学习策略
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:50 下午
 */
public interface Strategy<T extends Card<T> ,S extends Score<T>> {
    /**
     * 停止抽牌的策略
     * @param deck
     * @param robot
     * @return
     */
    boolean stopDraw(Deck<T> deck , Score<T> robot);

    /**
     * 存储结果/学习
     * @param deck
     * @param own
     * @param other
     */
    void save(Deck<T>  deck ,S own,S other);

    /**
     * 策略名
     * @return
     */
    String getName();
}
