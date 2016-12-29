package com.baraksoft.com.penkiossekundes.services;

import android.widget.TextView;

import java.util.Random;

/**
 * @author Laurynas
 * @since 2016-12-29
 */
public class QuestionsService {
    private final String questionStart;
    private final String[] questions;
    private final String questionerStart;

    public QuestionsService(String[] questions, String questionStart, String questionerStart) {
        this.questions = questions;
        this.questionStart = questionStart;
        this.questionerStart = questionerStart;
    }

    private String getNextQuestion() {
        int questionsSize = questions.length;
        Random random = new Random();
        int index = random.nextInt(questionsSize);      //random.nextInt(max - min + 1) + min;
        return questionStart.concat(questions[index]);
    }

    private String getNextQuestioner() {
        return questionerStart.concat("Tūzas");
    }

    public void prepareQuestionFields(TextView question, TextView questioner) {
        question.setText(getNextQuestion());
        questioner.setText(getNextQuestioner());
    }
}
