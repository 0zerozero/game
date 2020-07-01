package com.wy.game.deck;

import com.wy.game.card.Card;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 扑克牌堆抽象类
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:26 下午
 */
public abstract class AbstractDeck<T extends Card<T>> implements Deck<T>{

    /**
     * 牌堆
     */
    protected LinkedList<Card<T>> deck = new LinkedList<>();
    /**
     * 所有人的名牌
     */
    protected  Map<Object, List<Card<T>>> visibleCardListMap = new HashMap<>();
    /**
     * 随机源
     */
    private final Random random = new Random();


    public AbstractDeck(){
        init();
        shuffle();
    }

    /**
     * 初始化牌堆
     */
    @Override
    abstract public void init();

    /**
     * 洗牌
     */
    @Override
    public void shuffle() {
        deck = deck.stream().sorted((a,b)->random.nextInt(1000)).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * 返回所有人的明牌
     * @return
     */
    @Override
    public Map<Object, List<Card<T>>>getVisibleCardListMap() {
        return visibleCardListMap;
    }
}
