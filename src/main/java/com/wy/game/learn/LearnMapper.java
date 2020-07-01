package com.wy.game.learn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wu Yang
 * @version V1.0
 * @date 2020/7/1 7:57 下午
 */
@Repository
public interface LearnMapper extends JpaRepository<Learn,Long> {
    /**
     * 根据名字查询
     * @param name
     * @return
     */
    Learn getByName(String name);
}
