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
@CrossOrigin //Allows UI to consume these endpoints
public class SurveyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/getQuestionsByTemplate") //Todo? get from survey id instead?
    public List<Question> getQuestions(@RequestParam("templateName") String templateName){
        LOGGER.info("Get questions for template {}", templateName);
        return surveyService.getQuestionsByTemplate(templateName);
    }

    @GetMapping("/getSurveyResponses")
    public List<Response> getResponses(@RequestParam("surveyId") Long surveyId) {
        return surveyService.getResponsesForSurvey(surveyId);
    }

    @PostMapping(value = "/createSurvey")
    public CreateSurveyResponse createSurvey(@RequestBody DbSurvey dbSurvey) {
        LOGGER.info("Creating survey with request: {}", dbSurvey);
        CreateSurveyResponse response = surveyService.createSurvey(dbSurvey);
        LOGGER.info("Created survey: {}", response);
        return response;
    }

    @GetMapping("/getALlSurveyNames")
    public List<String> getALlSurveyNames() {
        LOGGER.info("Retrieving all survey names");
        return surveyService.getSurveyNames();
    }

//    @GetMapping("/getAllSurveys")
//    public List<Survey> getAllSurveys() {
//
//    }

    //TODO: Make endpoint to get all surveys when user clicks on "Take Survey"

    //TODO: Make endpoint to save user answers to questions into the responses table
}
