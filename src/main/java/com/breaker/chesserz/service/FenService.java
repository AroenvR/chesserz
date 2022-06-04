package com.breaker.chesserz.service;

import com.breaker.chesserz.board.FenBoard;
import com.breaker.chesserz.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FenService {
    private final Logger logger = LoggerFactory.getLogger(FenService.class);

    private final List<FenBoard> chessBoards = new ArrayList<>();

    public FenService() {
    }

    public String createNewBoard(String address_white, String address_black) throws InstanceAlreadyExistsException {
        Optional<FenBoard> optionalBoard = findBoardByAddresses(address_white, address_black);
        if (optionalBoard.isPresent()) throw new InstanceAlreadyExistsException("Board already exists.");

        FenBoard board = new FenBoard(address_white, address_black);
        chessBoards.add(board);

        logger.info("New chess board was created for {} and {}.", address_white, address_black);

        return board.getBoardState();
    }

    public String updateBoard(String boardState, String address_white, String address_black) throws ClassNotFoundException {
        FenBoard board = getBoardByAddresses(address_white, address_black);

        board.setBoardState(boardState);

        return board.getBoardState();
    }

    public String getBoardState(String address_white, String address_black) throws ClassNotFoundException {
        FenBoard board = getBoardByAddresses(address_white, address_black);

        return board.getBoardState();
    }

    private Optional<FenBoard> findBoardByAddresses(String address_white, String address_black) {
        for (FenBoard board : chessBoards) {
            if (board.getAddressWhite().equals(address_white) && board.getAddressBlack().equals(address_black)) {
                return Optional.of(board);
            }
        }
        return Optional.empty();
    }

    private FenBoard getBoardByAddresses(String address_white, String address_black) throws ClassNotFoundException {
        Optional<FenBoard> optionalBoard = findBoardByAddresses(address_white, address_black);

        if (optionalBoard.isEmpty()) throw new ClassNotFoundException("Board not found.");

        return optionalBoard.get();
    }

}
