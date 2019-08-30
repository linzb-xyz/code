/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */
/*

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class JumpFloorII {

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().JumpFloorII(3));
    }
    public int JumpFloorII(int target) {
        if(target == 1 || target == 0)
            return 1;

        int res = 0;
        for (int i = target; i > 0; i--) {
            res += JumpFloorII(target -i);
        }
        return res;
    }
}
