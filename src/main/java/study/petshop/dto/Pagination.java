package study.petshop.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagination {
    private int pageNum; // 현재 페이지 넘버
    private Long totalItems; // 총 아이템 수
    private int rows; // 한 번에 표시되는 아이템 수
}