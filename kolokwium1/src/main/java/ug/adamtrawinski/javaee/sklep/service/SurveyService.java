package ug.adamtrawinski.javaee.sklep.service;

import ug.adamtrawinski.javaee.sklep.domain.Survey;

import java.util.HashMap;
import java.util.Map;

public class SurveyService {
    private Map<String, Survey> db = new HashMap<String, Survey>();

    public Map<String, Survey> getAllSurveys() {
        return db;
    }

    public void add(String id, Survey survey) {
        db.put(id, survey);
    }
}
