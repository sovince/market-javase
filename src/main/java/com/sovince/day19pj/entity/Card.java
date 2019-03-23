package com.sovince.day19pj.entity;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:06
 * Description:会员卡：卡号、余额、积分、折扣百分比
 *
 */
public class Card {
    private int cardId;
    private double balance;
    private int score;
    private double discount;

    public Card(int cardId, double balance, int score, double discount) {
        this.cardId = cardId;
        this.balance = balance;
        this.score = score;
        this.discount = discount;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", balance=" + balance +
                ", score=" + score +
                ", discount=" + discount +
                '}';
    }
}
