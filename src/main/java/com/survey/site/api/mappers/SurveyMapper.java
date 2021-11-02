package com.survey.site.api.mappers;

import com.survey.site.api.dto.Question;
import com.survey.site.api.dto.Response;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SurveyMapper {
    List<Question> getQuestionsByTemplate(String template);

    List<Response> getResponsesForSurvey(Long surveyId);
}
