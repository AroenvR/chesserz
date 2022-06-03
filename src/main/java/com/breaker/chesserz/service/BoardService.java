package com.breaker.chesserz.service;

import com.breaker.chesserz.board.ChessBoard;
import com.breaker.chesserz.dto.MoveDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class BoardService {
    private final Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final List<ChessBoard> chessBoards = new ArrayList<>();

    public BoardService() {
    }

    public void createNewBoard(String address_white, String address_black) {
        ChessBoard chessBoard = new ChessBoard(address_white, address_black);
        chessBoards.add(chessBoard);

        logger.info("New chess board was created for {} and {}.", address_white, address_black);
        logger.info("Amount of games created: {}.", chessBoards.size());
    }

    public String makeMove(MoveDTO moveDTO) {
        logger.info("Making a move.");

        System.out.println(moveDTO.toString());

        handleMove(moveDTO.getFrom(), moveDTO.getTo());

        return "foo";
    }

    private void handleMove(String from, String to) {
        try {
            String[] fromSplit = from.split("");
            String[] toSplit = to.split("");

            int fromX = Integer.parseInt(fromSplit[1]) - 1;
            int fromY = StringToInt(fromSplit[0]);
            int toX = Integer.parseInt(toSplit[1]) - 1;
            int toY = StringToInt(toSplit[0]);
            chessBoards.get(0).movePiece(fromX, fromY, toX, toY); //TODO: get chessboard by address combination

            chessBoards.get(0).printBoard();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    private int StringToInt(String toTransform) throws Exception {
        switch (toTransform) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            default:
                throw new Exception("Invalid input");
       }
    }
}
