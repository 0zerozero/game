package com.wy.game.bean;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 9:59 下午
 */
@Data
@Entity(name = "t_learn")
@ToString
public class Learn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    Double estimate;

    @Column
    Integer bestPoint;

}
