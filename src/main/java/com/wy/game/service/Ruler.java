package com.wy.game.service;

import java.util.List;

/**
 * 规则
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:53 下午
 */
public interface Ruler<T> {
    /**
     *获胜规则
     * @param a
     * @param b
     * @return >0 a 赢 ,<0 b赢 ，=0平局
     */
    int win(List<T> a , List<T> b);
}
