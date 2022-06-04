package com.breaker.chesserz.board;

import com.breaker.chesserz.game.Type;

import java.util.Optional;

public class ChessBoard {

    private final String address_white;
    private final String address_black;

    private boolean white_turn;

    private boolean white_has_castled;
    private boolean black_has_castled;



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

        this.white_turn = true;

        this.white_has_castled = false;
        this.black_has_castled = false;

        // Set the initial board state
        // Black pieces
        boardState[6][0] = Type.p.toString();
        boardState[6][1] = Type.p.toString();
        boardState[6][2] = Type.p.toString();
        boardState[6][3] = Type.p.toString();
        boardState[6][4] = Type.p.toString();
        boardState[6][5] = Type.p.toString();
        boardState[6][6] = Type.p.toString();
        boardState[6][7] = Type.p.toString();

        boardState[7][0] = Type.r.toString();
        boardState[7][1] = Type.n.toString();
        boardState[7][2] = Type.b.toString();
        boardState[7][3] = Type.q.toString();
        boardState[7][4] = Type.k.toString();
        boardState[7][5] = Type.b.toString();
        boardState[7][6] = Type.n.toString();
        boardState[7][7] = Type.r.toString();

        // White pieces
        boardState[0][0] = Type.R.toString();
        boardState[0][1] = Type.N.toString();
        boardState[0][2] = Type.B.toString();
        boardState[0][3] = Type.Q.toString();
        boardState[0][4] = Type.K.toString();
        boardState[0][5] = Type.B.toString();
        boardState[0][6] = Type.N.toString();
        boardState[0][7] = Type.R.toString();

        boardState[1][0] = Type.P.toString();
        boardState[1][1] = Type.P.toString();
        boardState[1][2] = Type.P.toString();
        boardState[1][3] = Type.P.toString();
        boardState[1][4] = Type.P.toString();
        boardState[1][5] = Type.P.toString();
        boardState[1][6] = Type.P.toString();
        boardState[1][7] = Type.P.toString();

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

    /**
     * Return String representation of the board using FEN notation
     * @return String representation of the board using FEN notation
     */
    public String getFEN() {
        StringBuilder sb = new StringBuilder();

        // I is the vertical axis, J is the horizontal axis
        int emptySquares = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Optional<String> optionalPiece = Optional.ofNullable(boardState[i][j]);

                if (optionalPiece.isEmpty()) {
                    emptySquares++;
                    continue;
                }

                if (emptySquares > 0) {
                    sb.append(emptySquares);
                    emptySquares = 0;
                }

                sb.append(boardState[i][j]);
            }
            if (emptySquares > 0) {
                sb.append(emptySquares);
                emptySquares = 0;
            }
            sb.append("/");
        }
        sb.deleteCharAt(sb.length() - 1);

        // Splitting the string and reversing the order, so it marches chess.js' notation.
        String[] rows = sb.toString().split("/");
        sb = new StringBuilder();

        for (int i = rows.length - 1; i >= 0; i--) {
            sb.append(rows[i]);
            if (i > 0) {
                sb.append("/");
            }
        }

        if (white_turn) {
            sb.append(" w ");
        } else {
            sb.append(" b ");
        }

        return sb.toString();
    }

    public String getAddress_white() {
        return address_white;
    }

    public String getAddress_black() {
        return address_black;
    }

    public boolean isWhite_turn() {
        return white_turn;
    }

    public void setWhite_turn(boolean white_turn) {
        this.white_turn = white_turn;
    }

}