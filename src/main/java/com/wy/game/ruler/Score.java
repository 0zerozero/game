package com.wy.game.ruler;

import com.wy.game.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * 得分
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 3:46 下午
 */
public interface Score <T extends Card<T>> {
    /**
     * 转化为得分
     * @return
     */
    int score();

    /**
     * 获取手牌
     * @return
     */
    default List<Card<T>> getCardList(){
        return Collections.emptyList();
    }

    /**
     * 获得名字
     * @return
     */
    String getName();
}
