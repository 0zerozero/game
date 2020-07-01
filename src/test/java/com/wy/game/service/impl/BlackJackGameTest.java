package com.wy.game.service.impl;

import com.wy.game.BaseTest;
import com.wy.game.card.poker.Poker;
import com.wy.game.card.Card;
import com.wy.game.deck.BlackJackGame;
import com.wy.game.robot.HumanPlayer;
import com.wy.game.robot.PokerRobot;
import com.wy.game.ruler.Ruler;
import com.wy.game.strategy.HumanStrategy;
import com.wy.game.strategy.SimpleStrategy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:40 下午
 */
public class BlackJackGameTest extends BaseTest {

    @Autowired
    BlackJackGame game;
    @Autowired
    SimpleStrategy simpleStrategy;
    @Autowired
    HumanStrategy humanStrategy;


    @Test
    public void test(){
           Scanner scanner = new Scanner(System.in);
        do{
            game.init();
            game.shuffle();
            HumanPlayer wy = new HumanPlayer(game,"吴洋",humanStrategy);
            PokerRobot pokerRobot = new PokerRobot(simpleStrategy,game,simpleStrategy.getName());
            while (!pokerRobot.over() || !wy.over()){
                pokerRobot.draw(game);
                System.out.println(String.format("机器人：%s",pokerRobot.getCardList()));
                System.out.println(String.format("我自己：%s，点数%d",wy.getCardList(),wy.score()));
                if (!wy.over()){
                    wy.draw(game);
                }
                for (int i = 0; i < 20; i++) {
                    System.out.println();
                }
            }
            System.out.println( String.format("机器人：%d ，我：%d，%s",pokerRobot.score(),wy.score(), Ruler.parseResult(game.result(wy,pokerRobot))));
            pokerRobot.save(wy);
            wy.save(pokerRobot);
            System.out.println("是否继续？");
        }while (!scanner.next().equals("n"));
    }

}