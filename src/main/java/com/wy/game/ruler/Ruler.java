package com.wy.game.ruler;

import static com.wy.game.ruler.ResultEnum.*;

/**
 * 规则
 * @author Wu Yang
 * @version V1.0
 * @date 2020/6/30 8:53 下午
 */
public interface Ruler{



    /**
     *获胜规则
     * @param a
     * @param b
     * @return >0 a 赢 ,<0 b赢 ，=0平局
     */
    int result(Score a , Score b);

    /**
     * 胜利
     * @param result
     * @return
     */
    static ResultEnum parseResult(int result){

        ResultEnum resultEnum;
        if (result > 0){
            resultEnum = WIN;
        }else if (result == 0){
            resultEnum = DRAW;
        }else {
            //result < 0
            resultEnum = FAIL;
        }

        return resultEnum;
    }

}
