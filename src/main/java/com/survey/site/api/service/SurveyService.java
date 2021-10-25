package com.survey.site.api.service;

import com.survey.site.api.mappers.SurveyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyService.class);
    @Autowired
    private SurveyMapper mapper;

    public void handle(){}
}
