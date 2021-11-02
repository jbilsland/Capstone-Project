package com.survey.site.api.mappers;

import com.survey.site.api.dto.DbSurvey;
import com.survey.site.api.dto.Question;
import com.survey.site.api.dto.Response;
import com.survey.site.api.dto.Survey;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SurveyMapper {
    List<Question> getQuestionsByTemplate(String template);

    List<Response> getResponsesForSurvey(Long surveyId);

    Long createSurvey(DbSurvey dbSurvey);

   // List<Survey> getAllSurveys();


}
