package com.wy.game.enums;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:21 下午
 */
public enum Suit {
    /**
     * 梅花
     */
    CLUBS(Color.BLACK,"梅花","♣️"),
    /**
     * 黑桃
     */
    SPADES(Color.BLACK,"黑桃","♠️"),
    /**
     * 方片
     */
    DIAMONDS(Color.RED,"方片","♦️"),
    /**
     * 红桃
     */
    HEARTS(Color.RED,"红桃","♥️")
    ;


    public Color color;

    public String name;

    public String picture;


    Suit(Color color , String name , String picture){

        this.color = color;

        this.name = name;

        this.picture = picture;
    }
}
