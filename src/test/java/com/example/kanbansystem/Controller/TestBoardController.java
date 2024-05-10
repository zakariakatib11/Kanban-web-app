package com.example.kanbansystem.Controller;
import com.example.kanbansystem.controller.BoardController;
import com.example.kanbansystem.entities.Board;
import com.example.kanbansystem.entities.User;
import com.example.kanbansystem.security.MyuserDetailsService;
import com.example.kanbansystem.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestBoardController {
    @Mock
    private BoardService boardService;
    @InjectMocks
    private BoardController boardController;
    @Mock
    private MyuserDetailsService userService;
    @Test
    public void testGetAllBoards() {
        Board board1 = new Board();
        Board board2 = new Board();
        List<Board> mockBoards = Arrays.asList(board1, board2);
        when(boardService.getAllBoard()).thenReturn(mockBoards);
        ResponseEntity<List<Board>> responseEntity = boardController.getAllBoard();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBoards, responseEntity.getBody());
    }
    @Test
    public void testGetBoardByName() {
        String boardName = "Board 1";
        Board mockBoard = new Board();
        when(boardService.getBoardByName(boardName)).thenReturn(mockBoard);
        ResponseEntity<Board> responseEntity = boardController.getBoardByName(boardName);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBoard, responseEntity.getBody());
    }
    @Test
    public void testGetBoardById() {
        Long boardId = 1L;
        Optional<Board> mockOptionalBoard = Optional.of(new Board());
        when(boardService.getBoardById(boardId)).thenReturn(mockOptionalBoard);
        ResponseEntity<Board> responseEntity = boardController.getBoardById(boardId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockOptionalBoard.get(), responseEntity.getBody());
    }
    @Test
    public void testSaveBoard() {
        Board mockBoard = new Board();
        when(userService.findUserByUsername("admin")).thenReturn(new User());
        when(boardService.saveBoard(any(Board.class))).thenReturn(mockBoard);
        ResponseEntity<Board> responseEntity = boardController.saveBoard(mockBoard);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockBoard, responseEntity.getBody());
    }
    @Test
    public void testDeleteBoardById() {
        Long boardId = 1L;
        String expectedResult = "Deleted";
        when(boardService.deleteBoardById(boardId)).thenReturn(expectedResult);
        ResponseEntity<String> responseEntity = boardController.deleteBoardById(boardId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResult, responseEntity.getBody());
    }
}
