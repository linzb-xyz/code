/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class JumpFloor {

    public int JumpFloor(int target) {
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;

        int[] jump = new int[target+1];
        jump[1] = 1;
        jump[2] = 2;


        for (int i = 3; i < target + 1; i++) {
            jump[i] = jump[i-1] + jump[i-2];
        }
        return jump[target];

    }

    public int JumpFloor1(int target) {
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;

        return JumpFloor1(target-1)+JumpFloor1(target-2);

    }
}
