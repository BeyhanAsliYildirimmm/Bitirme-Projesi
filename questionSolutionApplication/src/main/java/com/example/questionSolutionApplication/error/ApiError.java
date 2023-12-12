package com.example.questionSolutionApplication.error;

import lombok.Data;

@Data
public class ApiError {
    public ApiError(String status, String path, String massage, Integer id) {
        this.status = status;
        this.path = path;
        this.massage = massage;
        this.id = id;
    }
    private String status;
    private String path;
    private String massage;
    private Integer id;
}
