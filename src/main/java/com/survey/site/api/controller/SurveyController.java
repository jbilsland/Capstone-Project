package com.survey.site.api.controller;

import com.survey.site.api.dto.*;
import com.survey.site.api.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/createSurvey", produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateSurveyResponse createSurvey(@RequestBody DbSurvey dbSurvey) {
        return surveyService.createSurvey(dbSurvey);
    }

//    @GetMapping("/getAllSurveys")
//    public List<Survey> getAllSurveys() {
//
//    }

    //TODO: Make endpoint to get all surveys when user clicks on "Take Survey"

    //TODO: Make endpoint to save user answers to questions into the responses table

    //TODO: Make an endpoint to insert into suveyAll name and description
}
