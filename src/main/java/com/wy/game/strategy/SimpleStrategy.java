package com.wy.game.strategy;

import com.wy.game.learn.Learn;
import com.wy.game.learn.LearnMapper;
import com.wy.game.card.poker.Poker;
import com.wy.game.deck.Deck;
import com.wy.game.ruler.ResultEnum;
import com.wy.game.ruler.Ruler;
import com.wy.game.ruler.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 8:14 下午
 */
@Service
public class SimpleStrategy implements Strategy<Poker,Score<Poker>> {

    @Autowired
    private LearnMapper mapper;

    private Double bestPoint;

    @Override
    public boolean stopDraw(Deck<Poker> deck, Score<Poker> robot) {
           this.bestPoint = mapper.getByName(getName()).getBestPoint();
        return robot.score() >= bestPoint;
    }

    @Override
    public void save(Deck<Poker> deck, Score<Poker> own, Score<Poker> other) {
        simpleLearn(deck,own,other);
    }

    public void simpleLearn(Deck<Poker> deck, Score<Poker> own, Score<Poker> other){
        int result = deck.result(own, other);
        ResultEnum resultEnum = Ruler.parseResult(result);
        Learn learn = mapper.getByName(own.getName());
        learn = learn == null ? new Learn() : learn;
        learn.setName(own.getName());
        switch (resultEnum){
            case WIN:
                learn.setWinTimes(learn.getWinTimes()+1);
                learn.winRate();
                break;
            case DRAW:
                break;
            case FAIL:
                double bestPoint = learn.getBestPoint();
                bestPoint =bestPoint + (other.score() - own.score())/10.0;
                learn.setBestPoint(bestPoint);
                learn.setFailTime(learn.getFailTime()+1);
                learn.winRate();
            default:
        }
        mapper.save(learn);
    }

    @Override
    public String getName() {
        return "简单策略";
    }

    public void setBestPoint() {
        this.bestPoint = mapper.getByName(getName()).getBestPoint();
    }
}
