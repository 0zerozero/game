package com.wy.game.bean;

import com.wy.game.service.Card;
import com.wy.game.service.Deck;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 打牌机器
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:17 下午
 */
@Data
@ToString
@NoArgsConstructor
public class Robot<T> {


    private List<Card<T>> cardList = new ArrayList<>();

    private String name;

    public Robot(String name){
        this.name = name;
    }

    public void draw(Deck<T> deck){
        cardList.add(deck.draw());
    }

    private List<Card<T>> getVisibleCardList(){
        if (cardList.size() >1){
            return cardList.subList(1,cardList.size());
        }
        return null;
    }

}
