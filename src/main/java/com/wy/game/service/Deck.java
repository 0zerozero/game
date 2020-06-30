package com.wy.game.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 牌堆
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 7:56 下午
 */
public interface Deck<T> {


    /**
     * 初始化牌堆
     */
    void init();
    /**
     * 抽牌
     * @return
     */
    Card<T> draw();

    /**
     * 洗牌
     */
    void shuffle();
}
