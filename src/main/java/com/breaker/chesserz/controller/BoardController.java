package com.breaker.chesserz.controller;

import com.breaker.chesserz.dto.MoveDTO;
import com.breaker.chesserz.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("board-state")
    public ResponseEntity<?> getBoardState() {
        logger.info("GET board state was called.");

        try {
            return ResponseEntity.status(HttpStatus.OK).body("Hi!");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/create-game")
    public ResponseEntity<?> createGame(@RequestParam("white") String address_white, @RequestParam("black") String address_black) {
        logger.info("POST create game was called.");

        try {
            boardService.createNewBoard(address_white, address_black);
            return ResponseEntity.status(HttpStatus.CREATED).body("Game was created for {} as White and {} as Black.");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/move")
    public ResponseEntity<?> movePiece(@RequestBody MoveDTO moveDTO) {
        logger.info("Moving a piece was called.");

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(boardService.makeMove(moveDTO));

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
