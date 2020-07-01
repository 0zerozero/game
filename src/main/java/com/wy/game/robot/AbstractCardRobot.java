package com.wy.game.robot;

import com.wy.game.card.Card;
import com.wy.game.deck.Deck;
import com.wy.game.ruler.Score;
import com.wy.game.strategy.Strategy;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 5:36 下午
 */
@ToString
public  abstract class AbstractCardRobot<T extends Card<T>> implements CardPlayer<T>{
    /**
     * 手牌
     */
    protected List<Card<T>> cardList = new ArrayList<>();
    /**
     * 策略
     */
    protected Strategy<T, Score<T>> drawStrategy;
    /**
     * 牌堆
     */
    protected Deck<T> deck;
    /**
     * 名字
     */
    protected String name;
    /**
     * 是否停牌
     */
    private boolean over = false;


    @Override
    public void save(CardPlayer<T>... otherRobots) {
        for (CardPlayer<T> otherRobot : otherRobots) {
            drawStrategy.save(deck,this,otherRobot);
        }
    }

    AbstractCardRobot(Strategy<T,Score<T>> drawStrategy,Deck<T> deck,String name){
        this.drawStrategy = drawStrategy;
        this.deck = deck;
        this.name = name;
    }

    @Override
    public void draw(Deck<T> deck) {
        if (!over){
            if (!drawStrategy.stopDraw(deck, this)){
                cardList.add(deck.draw(this));
            }else {
                over = true;
            }
        }
    }

    @Override
    public List<Card<T>> getCardList() {
        return cardList.isEmpty()? cardList : cardList.subList(1,cardList.size());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean over() {
        return over;
    }
}
