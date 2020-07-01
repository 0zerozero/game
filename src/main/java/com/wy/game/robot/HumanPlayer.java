package com.wy.game.robot;

import com.wy.game.card.Card;
import com.wy.game.card.poker.Poker;
import com.wy.game.deck.Deck;
import com.wy.game.ruler.Score;
import com.wy.game.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 9:23 下午
 */
public class HumanPlayer implements CardPlayer<Poker> {

    /**
     * 牌堆
     */
    protected Deck<Poker> deck;
    /**
     * 手牌
     */
    private List<Card<Poker>> cardList = new ArrayList<>();
    /**
     * 是否停牌
     */
    private boolean over = false;
    /**
     *
     */
    private String name;
    /**
     * 策略
     */
    private Strategy<Poker,Score<Poker>> drawStrategy;


    public HumanPlayer( Deck<Poker> deck,String name,Strategy<Poker,Score<Poker>> drawStrategy){
        this.deck =deck;
        this.name = name;
        this.drawStrategy =drawStrategy;
    }


    @Override
    public void save(CardPlayer<Poker>... otherRobots) {
        for (CardPlayer<Poker> otherRobot : otherRobots) {
            drawStrategy.save(deck,this,otherRobot);
        }
    }

    @Override
    public int score() {
        return cardList.stream().map(Card::getInfo).mapToInt(Poker::getPoint).sum();
    }

    @Override
    public void draw(Deck<Poker> deck) {
        if (!drawStrategy.stopDraw(deck, this)){
            cardList.add(deck.draw(this));
        }else {
            over = true;
        }
    }

    @Override
    public boolean over() {
       return over;
    }

    @Override
    public List<Card<Poker>> getCardList() {
        return cardList;
    }

    @Override
    public String getName() {
        return name;
    }
}
