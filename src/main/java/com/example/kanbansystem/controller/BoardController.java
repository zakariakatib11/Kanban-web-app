package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.Board;
import com.example.kanbansystem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BoardController {
    @Autowired
    private  BoardService boardService;

    @GetMapping("/boards")
    public List<Board> getAllBoard(){
        return boardService.getAllBoard();
    }
    @GetMapping("boards/{boardName}")
    public Board getBoardByName(@PathVariable("boardName") String boardName){
        return boardService.getBoardByName(boardName);
    }
    @PostMapping("boards")
    public Board saveBoard(@RequestBody Board board){
       return boardService.saveBoard(board);
    }
    @RequestMapping(value = "/boards/{boardId}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteBoardById(@PathVariable("boardId") Long boardId) {

        String result = boardService.deleteBoardById(boardId);

        return result;
    }



}
