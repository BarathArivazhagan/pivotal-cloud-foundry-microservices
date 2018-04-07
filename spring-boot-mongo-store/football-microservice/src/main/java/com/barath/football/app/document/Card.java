package com.barath.football.app.document;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by barath on 18/03/18.
 */
public class Card {

    @Field(value = "CARDTYPE")
    private CardType cardType;

    @Field(value = "HC")
    private  int homeCardsShown;

    @Field(value = "AC")
    private int awayCardsShown;


    public enum CardType{
        RED,YELLOW
    }

    @PersistenceConstructor
    public Card(CardType cardType, int homeCardsShown, int awayCardsShown) {
        this.cardType = cardType;
        this.homeCardsShown = homeCardsShown;
        this.awayCardsShown = awayCardsShown;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getHomeCardsShown() {
        return homeCardsShown;
    }

    public void setHomeCardsShown(int homeCardsShown) {
        this.homeCardsShown = homeCardsShown;
    }

    public int getAwayCardsShown() {
        return awayCardsShown;
    }

    public void setAwayCardsShown(int awayCardsShown) {
        this.awayCardsShown = awayCardsShown;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType +
                ", homeCardsShown=" + homeCardsShown +
                ", awayCardsShown=" + awayCardsShown +
                '}';
    }
}
