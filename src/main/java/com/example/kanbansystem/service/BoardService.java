package com.example.kanbansystem.service;

import com.example.kanbansystem.Repository.BoardRepository;
import com.example.kanbansystem.entities.Board;
import com.example.kanbansystem.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public Board getBoardByName(String name) {
        return boardRepository.findBoardByName(name);
    }
    public List<Board> getAllBoard(){
        return boardRepository.findAll();
    }
    public Board saveBoard(Board board){
        return boardRepository.save(board);
    }
    public String deleteBoardById(Long id){
        boardRepository.deleteById(id);
        return "Board with id "+id+" deleted successfully!";
    }
    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }



}
