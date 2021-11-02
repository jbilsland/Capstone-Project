package com.survey.site.api.controller;

import com.survey.site.api.dto.Question;
import com.survey.site.api.dto.Response;
import com.survey.site.api.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SurveyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/getQuestionsByTemplate")
    public List<Question> getQuestions(@RequestParam("templateName") String templateName){
        LOGGER.info("Get questions for template {}", templateName);
        return surveyService.getQuestionsByTemplate(templateName);
    }

    @GetMapping("/getSurveyResponses")
    public List<Response> getResponses(@RequestParam("surveyId") Long surveyId) {
        return surveyService.getResponsesForSurvey(surveyId);
    }

    //TODO: Make endpoint to get all surveys when user clicks on "Take Survey"

    //TODO: Make endpoint to save user answers to questions into the responses table

    //TODO: Make an endpoint to insert into suveyAll name and description
}
