package practice.crud.dto;

import lombok.Getter;
import practice.crud.domain.Board;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {
    private int id;
    private String title;
    private String content;
    private String hashtag;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.hashtag = entity.getHashtag();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
    }
}
