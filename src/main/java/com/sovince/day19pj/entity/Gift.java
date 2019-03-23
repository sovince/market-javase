package com.sovince.day19pj.entity;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:05
 * Description:积分小礼品：礼品编号、名称、所需积分数
 */
public class Gift {
    private int giftId;
    private String name;
    private int score;


    public Gift(int giftId, String name, int score) {
        this.giftId = giftId;
        this.name = name;
        this.score = score;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "giftId=" + giftId +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
