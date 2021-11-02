package com.survey.site.api.service;

import com.survey.site.api.dto.CreateSurveyResponse;
import com.survey.site.api.dto.DbSurvey;
import com.survey.site.api.dto.Question;
import com.survey.site.api.dto.Response;
import com.survey.site.api.mappers.SurveyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SurveyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyService.class);
    @Autowired
    private SurveyMapper mapper;

    public List<Question> getQuestionsByTemplate(String template) {
        List<Question> questions = mapper.getQuestionsByTemplate(template);
        LOGGER.info("Got questions: {}", questions);
        return questions;
    }

    public List<Response> getResponsesForSurvey(Long surveyId) {
        return mapper.getResponsesForSurvey(surveyId);
    }

    public CreateSurveyResponse createSurvey(DbSurvey dbSurvey) {
        mapper.createSurvey(dbSurvey);
        return new CreateSurveyResponse().id(dbSurvey.getId());
    }


}
