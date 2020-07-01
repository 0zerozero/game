package com.wy.game.card;

import com.wy.game.card.poker.Poker;

/**
 * 卡片
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:03 下午
 */
public interface Card<T extends Card<T>> extends Comparable<T> {
    /**
     * 获取卡片信息
     * @return
     */
    T getInfo();

    /**
     * 比较两张卡的大小
     * @param o
     * @return
     */
    @Override
    int compareTo(T o);

}
