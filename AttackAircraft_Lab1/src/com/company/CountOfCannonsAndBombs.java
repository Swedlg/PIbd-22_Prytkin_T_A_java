package com.company;

public enum CountOfCannonsAndBombs {
    Two,
    Four,
    Six;

    /**
     * Вернуть значение количества
     * @param count количество в ште
     * @return значение количества
     */
    public static CountOfCannonsAndBombs getCountOfCannonsAbdBox(int count){
        switch(count){
            case 2:
                return CountOfCannonsAndBombs.Two;
            case 4:
                return CountOfCannonsAndBombs.Four;
            case 6:
                return CountOfCannonsAndBombs.Six;
        }
        return null;
    }
}
