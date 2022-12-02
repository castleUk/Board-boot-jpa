package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardService {
  
  @Autowired
  private BoardRepository boardRepository;

  public void write(Board board){
    boardRepository.save(board);
  }

  public Page<Board> boardList(Pageable pageable){
    return boardRepository.findAll(pageable);
  }

  public Board boardView(Integer id){
    return boardRepository.findById(id).get();
  }

  public void boardDelete(Integer id){
    boardRepository.deleteById(id);
  }

  public Page<Board> boardSearchList(String SearchKeyword,Pageable pageable){
    return boardRepository.findByTitleContaining(SearchKeyword, pageable);
}
}
