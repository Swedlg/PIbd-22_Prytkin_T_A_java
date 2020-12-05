package com.company;

public enum TypeOfCannonsAndBombs {
    First,
    Second,
    Third;

    public static TypeOfCannonsAndBombs getTypeOfCannonsAndBombs(int type) {
        switch (type) {
            case 1:
                return TypeOfCannonsAndBombs.First;
            case 2:
                return TypeOfCannonsAndBombs.Second;
            case 3:
                return TypeOfCannonsAndBombs.Third;
        }
        return null;
    }
}
