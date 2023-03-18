package practice.crud.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.crud.domain.Board;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private String hashtag;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public BoardDto(int id, String title, String content, String hashtag, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public Board toEntity(){
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .hashtag(hashtag)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
