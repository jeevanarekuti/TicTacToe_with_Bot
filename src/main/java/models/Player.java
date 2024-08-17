package main.java.models;

import java.util.Scanner;

public class Player {


    protected String name;
    protected Character symbol;

    public Player(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public Move makeMove(Board board){
        //Input row and col
        //Check for Validations, if we can make move there
        Scanner scanner = new Scanner(System.in);
        System.out.println(getName() + "'s turn, give row and col");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        Cell cell = board.setPlayer(this,row,col);
        return new Move(cell, this);
    }

}
