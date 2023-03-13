package practice.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.crud.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
