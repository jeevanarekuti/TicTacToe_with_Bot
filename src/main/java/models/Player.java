package main.java.models;

import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);

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

    public void makeMove(Board board){
        //Input row and col
        //Check for Validations, if we can make move there
        int row = scanner.nextInt();
        int col = scanner.nextInt();
    }

}
