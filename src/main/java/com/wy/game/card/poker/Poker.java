package com.wy.game.card.poker;
import com.wy.game.card.Card;
import lombok.*;

/**
 * 扑克
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:18 下午
 */
@Data
@Builder
@AllArgsConstructor
public class Poker implements Card<Poker> {
    /**
     * 扑克中最大的点数
     */
    public static final int POKER_MAX_POINT = 13;
    /**
     * 扑克中最小的点数
     */
    public static final int POKER_MIN_POINT = 1;


    /**
     * 花色
     */
    private SuitEnum suit;
    /**
     * 点数
     */
    private int point;

    @Override
    public Poker getInfo() {
        return this;
    }

    @Override
    public int compareTo(Poker o) {
        return this.point - o.point;
    }

    @Override
    public String toString(){
        return suit.picture + point;
    }
}
