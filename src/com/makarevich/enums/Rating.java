package com.makarevich.enums;

/**
 * Created by j on 19.10.16.
 */
public enum Rating {
    ONE_STAR, TWO_STAR, THREE_STAR, FOUR_STAR, FIVE_STAR;

    public int getRating(){
        switch (this){
            case ONE_STAR:
                return 1;
            case TWO_STAR:
                return 2;
            case THREE_STAR:
                return 3;
            case FOUR_STAR:
                return 4;
            case FIVE_STAR:
                return 5;
            default:
                return 0;
        }
    }
}
