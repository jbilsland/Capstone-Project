package com.survey.site.api.dto;

public class SubmitAnswersResponse {
    private Long id;

    public SubmitAnswersResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}