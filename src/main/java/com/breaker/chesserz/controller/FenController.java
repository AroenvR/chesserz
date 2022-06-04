package com.breaker.chesserz.controller;

import com.breaker.chesserz.service.FenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FenController {
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final FenService fenService;

    @Autowired
    public FenController(FenService fenService) {
        this.fenService = fenService;
    }

    @GetMapping("fen/board-state")
    public ResponseEntity<?> getBoardState(@RequestParam("white") String address_white, @RequestParam("black") String address_black) {
        logger.info("GET board state was called for white address {} and black address {}.", address_white, address_black);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(fenService.getBoardState(address_white, address_black));

        } catch (ClassNotFoundException ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("fen/create-game")
    public ResponseEntity<?> createGame(@RequestParam("white") String address_white, @RequestParam("black") String address_black) {
        logger.info("Create game was called for white address {} and black address {}.", address_white, address_black);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(fenService.createNewBoard(address_white, address_black));

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("fen/update-board")
    public ResponseEntity<?> updateBoard(@RequestParam("fen") String fen, @RequestParam("white") String address_white, @RequestParam("black") String address_black) {
        logger.info("Updating board state to: {} for white address {} and black address {}.", fen, address_white, address_black);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(fenService.updateBoard(fen, address_white, address_black));

        } catch (ClassNotFoundException ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
