package com.breaker.chesserz.board;

public class FenBoard {

    private final String address_white;
    private final String address_black;

    private String boardState;

    public FenBoard(String whitePlayer, String blackPlayer) {
        address_white = whitePlayer;
        address_black = blackPlayer;
        this.boardState = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    }

    public String getAddressWhite() {
        return address_white;
    }

    public String getAddressBlack() {
        return address_black;
    }

    public String getBoardState() {
        return boardState;
    }

    public void setBoardState(String boardState) {
        this.boardState = boardState;
    }

}
