package study.petshop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {
    private String code;
    private String message;


    public ErrorInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }
}