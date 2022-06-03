package com.breaker.chesserz.board;

import com.breaker.chesserz.game.Type;

public class ChessBoard {

    private String address_white;
    private String address_black;

    String[][] boardState = new String[8][8];

    /**
     * Constructor for ChessBoard
     * Initializes the board with the starting positions of the pieces
     * @param whitePlayer - the address of the player who is white
     * @param blackPlayer - the address of the player who is black
     */
    public ChessBoard(String whitePlayer, String blackPlayer) {
        address_white = whitePlayer;
        address_black = blackPlayer;

        // Set the initial board state
        boardState[0][0] = Type.ROOK.toString();
        boardState[0][1] = Type.KNIGHT.toString();
        boardState[0][2] = Type.BISHOP.toString();
        boardState[0][3] = Type.QUEEN.toString();
        boardState[0][4] = Type.KING.toString();
        boardState[0][5] = Type.BISHOP.toString();
        boardState[0][6] = Type.KNIGHT.toString();
        boardState[0][7] = Type.ROOK.toString();

        boardState[1][0] = Type.PAWN.toString();
        boardState[1][1] = Type.PAWN.toString();
        boardState[1][2] = Type.PAWN.toString();
        boardState[1][3] = Type.PAWN.toString();
        boardState[1][4] = Type.PAWN.toString();
        boardState[1][5] = Type.PAWN.toString();
        boardState[1][6] = Type.PAWN.toString();
        boardState[1][7] = Type.PAWN.toString();

        boardState[6][0] = Type.PAWN.toString();
        boardState[6][1] = Type.PAWN.toString();
        boardState[6][2] = Type.PAWN.toString();
        boardState[6][3] = Type.PAWN.toString();
        boardState[6][4] = Type.PAWN.toString();
        boardState[6][5] = Type.PAWN.toString();
        boardState[6][6] = Type.PAWN.toString();
        boardState[6][7] = Type.PAWN.toString();

        boardState[7][0] = Type.ROOK.toString();
        boardState[7][1] = Type.KNIGHT.toString();
        boardState[7][2] = Type.BISHOP.toString();
        boardState[7][3] = Type.QUEEN.toString();
        boardState[7][4] = Type.KING.toString();
        boardState[7][5] = Type.BISHOP.toString();
        boardState[7][6] = Type.KNIGHT.toString();
        boardState[7][7] = Type.ROOK.toString();

    }

    /**
     * Move a piece from one location to another
     * @param fromX The x coordinate of the piece to move
     * @param fromY The y coordinate of the piece to move
     * @param toX The x coordinate of the destination
     * @param toY The y coordinate of the destination
     */
    public void movePiece(int fromX, int fromY, int toX, int toY) {
        String piece = boardState[fromX][fromY];
        boardState[toX][toY] = piece;
        boardState[fromX][fromY] = null;
    }

    // Print the board state to the console
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(boardState[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String getAddress_white() {
        return address_white;
    }

    public void setAddress_white(String address_white) {
        this.address_white = address_white;
    }

    public String getAddress_black() {
        return address_black;
    }

    public void setAddress_black(String address_black) {
        this.address_black = address_black;
    }

}