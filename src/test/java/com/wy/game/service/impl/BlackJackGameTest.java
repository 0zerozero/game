package com.wy.game.service.impl;

import com.wy.game.BaseTest;
import com.wy.game.bean.Poker;
import com.wy.game.service.Card;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:40 下午
 */
public class BlackJackGameTest extends BaseTest {

    @Autowired
    BlackJackGame game;


    @Test
    public void test(){
        game.init();
        game.Shuffle();
        for (int i = 0; i <52 ; i++) {
            Card<Poker> draw = game.Draw();
            System.out.println(draw);
        }
    }
}