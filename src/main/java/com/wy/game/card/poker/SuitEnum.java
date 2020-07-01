package com.wy.game.card.poker;

import static com.wy.game.card.poker.ColorEnum.BLACK;
import static com.wy.game.card.poker.ColorEnum.RED;

/**
 * 花色枚举
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:21 下午
 */
public enum SuitEnum {
    /**
     * 梅花
     */
    CLUBS(BLACK,"梅花","♣️"),
    /**
     * 黑桃
     */
    SPADES(BLACK,"黑桃","♠️"),
    /**
     * 方片
     */
    DIAMONDS(RED,"方片","♦️"),
    /**
     * 红桃
     */
    HEARTS(RED,"红桃","♥️")
    ;

    /**
     * 颜色
     */
    public ColorEnum color;
    /**
     * 名字
     */
    public String name;
    /**
     * 图标
     */
    public String picture;


    SuitEnum(ColorEnum color , String name , String picture){

        this.color = color;

        this.name = name;

        this.picture = picture;
    }
}
