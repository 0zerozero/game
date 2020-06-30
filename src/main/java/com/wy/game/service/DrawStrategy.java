package com.wy.game.service;

import com.wy.game.bean.Learn;

import java.util.List;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:50 下午
 */
public interface DrawStrategy<T> {
    /**
     * 停止抽牌的策略
     * @param other
     * @param own
     * @return
     */
    boolean stopDraw(List<List<Card<T>>> other,List<Card<T>> own);

    /**
     * 学习
     * @param other
     * @param own
     * @param result
     */
    void learn(List<List<Card<T>>> other,List<Card<T>> own,int result);
}
