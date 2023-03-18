package practice.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import practice.crud.domain.Board;
import practice.crud.dto.BoardDto;
import practice.crud.repository.BoardRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    // @RequiredArgsConstructor 어노테이션을 이용해서 생성자를 만들어줌
    private final BoardRepository boardRepository;

    /**
     * Create
     */
    public void create(Board board){
        boardRepository.save(board);
    }

    /**
     * List
     * 게시글 id의 내림차순으로 정렬
     */
    public List<Board> getList(){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * READ
     */
    public Board detail(int id){
        return boardRepository.findById(id).orElse(null);
    }

    /**
     * UPDATE
     */
    public void update(Board board){
        BoardDto boardDto = new BoardDto();
        board.setCreatedAt(boardDto.getModifiedAt());
        boardRepository.save(board);
    }

    /**
     * DELETE
     */
    public void delete(int id){
        boardRepository.deleteById(id);
    }


}
