package com.wy.game.learn;

import lombok.*;

import javax.persistence.*;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:59 下午
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_learn")
public class Learn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    /**
     * 名字
     */
    @Column(unique = true)
    String name;
    /**
     * 估值
     */
    @Column
    double estimate;
    /**
     * 最佳点数
     */
    @Column
    double bestPoint;
    /**
     * 失败次数
     */
    int winTimes;
    /**
     * 胜利次数
     */
    int failTime;

    /**
     * 胜率
     */
    double winRate;

    public void winRate(){
        winRate = winTimes/(winTimes+failTime+0.0) * 100;
    }

}
