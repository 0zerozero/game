package com.wy.game.strategy;

import com.wy.game.card.poker.Poker;
import com.wy.game.deck.Deck;
import com.wy.game.learn.LearnMapper;
import com.wy.game.ruler.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 *
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 8:41 下午
 */
@Service
public class HumanStrategy implements Strategy<Poker,Score<Poker>>{
    
    @Autowired
    LearnMapper mapper;
    @Autowired 
    SimpleStrategy simpleStrategy;
    
    @Override
    public boolean stopDraw(Deck<Poker> deck, Score<Poker> robot) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input == 1;
    }

    @Override
    public void save(Deck<Poker> deck, Score<Poker> own, Score<Poker> other) {
        simpleStrategy.simpleLearn(deck,own,other);
    }

    @Override
    public String getName() {
        return "手工操作";
    }
    
}
