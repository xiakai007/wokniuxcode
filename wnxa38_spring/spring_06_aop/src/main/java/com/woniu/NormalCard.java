package com.woniu;

public class NormalCard implements Card {
    @Override
    public int saveMoney(int money) {
        System.out.println("普通卡充值");
        if(money<0){
            throw new RuntimeException("金额不能为负");
        }
        return money>10?(int)(money*1.1):money;
    }
}
