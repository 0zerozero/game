package com.wy.game.service.impl;

import com.wy.game.bean.Poker;
import com.wy.game.service.AbstractPokerDeck;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:10 下午
 */
@Service
public class BlackJackGame extends AbstractPokerDeck {

    private static final int BAST_POINT = 21;

    @Override
    public int win(List<Poker> a, List<Poker> b) {
        Integer mySum = a.stream().map(Poker::getPoint).reduce(0, Integer::sum);
        Integer youSum = b.stream().map(Poker::getPoint).reduce(0, Integer::sum);
        if (youSum - mySum == 0 ){
            return 0;
        }else {
            if (youSum == BAST_POINT){
                return -1;
            }else if(mySum == BAST_POINT){
                return 1;
            }else if (youSum < BAST_POINT && mySum <BAST_POINT){
                return mySum-youSum;
            }else {
                return youSum - mySum;
            }
        }
    }
}
