package com.wy.game.deck;

import com.wy.game.card.Card;
import com.wy.game.ruler.Ruler;

import java.util.List;
import java.util.Map;

/**
 * 牌堆
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 7:56 下午
 */
public interface Deck<T extends Card<T>> extends Ruler {

    /**
     * 初始化牌堆
     */
    void init();

    /**
     * 抽牌
     * @param obj
     * @return
     */
    Card<T> draw(Object obj);

    /**
     * 洗牌
     */
    void shuffle();


    /**
     * 获取所有人的明牌
     * @return
     */
    Map<Object, List<Card<T>>> getVisibleCardListMap();
}
