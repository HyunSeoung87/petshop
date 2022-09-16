package study.petshop.dto;

import lombok.Data;

@Data
public class CommonResponse<T> {

    private boolean success;
    private T data;
    private Pagination pagination;
    private ErrorInfo errorInfo;


    public CommonResponse(boolean success, T data, Pagination pagination, ErrorInfo errorInfo) {
        this.success = success;
        this.data = data;
        this.pagination = pagination;
        this.errorInfo = errorInfo;
    }

    public static <T> CommonResponse success(T data, Pagination pagination) {
        return new CommonResponse<T>(true,data,pagination,null);
    }

    public static <T> CommonResponse error (ErrorInfo errorInfo) {
        return new CommonResponse<>(false, null,null,errorInfo);
    }
}