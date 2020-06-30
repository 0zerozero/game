package com.wy.game.service;

import com.wy.game.bean.Poker;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 扑克牌堆抽象类
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:26 下午
 */
public abstract class AbstractDeck<T> implements Deck<T>{

    protected LinkedList<Card<T>> deck = new LinkedList<>();

    private final Random random = new Random();

    /**
     * 初始化牌堆
     */
    @Override
    abstract public void init();

    /**
     * 抽牌
     * @return
     */
    @Override
    public Card<T> draw() {
        return deck.pop();
    }

    /**
     * 洗牌
     */
    @Override
    public void shuffle() {
        deck = deck.stream().sorted((a,b)->random.nextInt()).collect(Collectors.toCollection(LinkedList::new));
    }
}
