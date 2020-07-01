package com.wy.game.robot;

import com.wy.game.card.Card;
import com.wy.game.deck.Deck;
import com.wy.game.ruler.Score;
import com.wy.game.strategy.Strategy;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 4:10 下午
 */
public interface CardPlayer<T extends Card<T>> extends Score<T> {

    /**
     * 学习
     * @param otherRobots
     */
     void save(CardPlayer<T> ...otherRobots);

    /**
     * 获取得分
     * @return
     */
    @Override
    int score();

    /**
     * 抽牌
     * @param deck
     */
    void draw(Deck<T> deck);

    /**
     * 是否停牌
     * @return
     */
   boolean over();

}
