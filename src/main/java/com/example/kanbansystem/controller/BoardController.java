package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.Board;
import com.example.kanbansystem.entities.Task;
import com.example.kanbansystem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getAllBoard() {
        List<Board> boards = boardService.getAllBoard();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }
    @GetMapping("boards/{boardName}")
    public ResponseEntity<Board> getBoardByName(@PathVariable("boardName") String boardName) {
        Board board = boardService.getBoardByName(boardName);
        if (board != null) {
            return new ResponseEntity<>(board, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/boardsId/{boardId}")
    public ResponseEntity<Board> getBoardById(@PathVariable("boardId") Long boardId) {
        Optional<Board> board = boardService.getBoardById(boardId);
        if (board.isPresent()) {
            return new ResponseEntity<>(board.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("boards")
    public ResponseEntity<Board> saveBoard(@RequestBody Board board) {
        Board savedBoard = boardService.saveBoard(board);
        return new ResponseEntity<>(savedBoard, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/boardsDeleted/{boardId}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public ResponseEntity<String> deleteBoardById(@PathVariable("boardId") Long boardId) {
        String result = boardService.deleteBoardById(boardId);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
