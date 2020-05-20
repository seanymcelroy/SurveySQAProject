import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(value = BlockJUnit4ClassRunner.class)
public class SurveyTest {

    Controller c = new Controller();
    String endofYearSurveyName = "End of year survey";

    //SUrvey creation
    @Test
    public void getControllerInstance(){
        Controller controllerObj = new Controller();

        assertTrue("Create controller object", controllerObj instanceof Controller);
    }


    //Test to create empty survey object
    @Test
    public void getEmptySurveyInstance(){
        Survey emptySurvey = c.createEmptySurvey();
        assertTrue("Create empty Survey object", emptySurvey instanceof Survey);
    }

    @Test
    public void createSurveyWithName(){

        Survey surveyWithName = c.createSurveyWithName(endofYearSurveyName);

        assertEquals(endofYearSurveyName, surveyWithName.getSurveyName());

    }

    //Test adding 2 questions
    @Test
    public void addQuestionsToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addQuestionsToSurvey(endOfYearSurvey, listOfQuestions);

        int numOfQuestionsInSUrvey = endOfYearSurvey.getSurveyQuestions().size();

        assertEquals(2, numOfQuestionsInSUrvey);

    }

    //Test adding 11 questions over the limit of survey 10
    @Test(expected = IndexOutOfBoundsException.class)
    public void add11QuestionToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        listOfQuestions.put(3, "How badly are you struggling to come up with questions?");
        listOfQuestions.put(4, "The projects user experience?");
        listOfQuestions.put(5, "The projects responsiveness?");
        listOfQuestions.put(6, "How likely will you respond to another survey?");
        listOfQuestions.put(7, "How has your performance improved over the year?");
        listOfQuestions.put(8, "Did you make a lot of friends?");
        listOfQuestions.put(9, "How did your task estimation improve?");
        listOfQuestions.put(10, "How did your code reviewing improve?");
        listOfQuestions.put(11, "How did your Team version controls improve?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addQuestionsToSurvey(endOfYearSurvey, listOfQuestions);
    }

    //BoundaryCases
    @Test
    public void add10QuestionToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        listOfQuestions.put(3, "How badly are you struggling to come up with questions?");
        listOfQuestions.put(4, "The projects user experience?");
        listOfQuestions.put(5, "The projects responsiveness?");
        listOfQuestions.put(6, "How likely will you respond to another survey?");
        listOfQuestions.put(7, "How has your performance improved over the year?");
        listOfQuestions.put(8, "Did you make a lot of friends?");
        listOfQuestions.put(9, "How did your task estimation improve?");
        listOfQuestions.put(10, "How did your code reviewing improve?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addQuestionsToSurvey(endOfYearSurvey, listOfQuestions);

        int numOfQuestionsInSUrvey = endOfYearSurvey.getSurveyQuestions().size();

        assertEquals(10, numOfQuestionsInSUrvey);

    }


    @Test
    public void addSurveyToSurveyCollection(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        Survey startOfYearSurvey = c.createSurveyWithName("Start of year survey");

        c.addSurveyToList(endOfYearSurvey);
        c.addSurveyToList(startOfYearSurvey);

        int numberOfSurveys = c.getSurveyList().size();

        assertEquals(2, numberOfSurveys);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewSurveyWithExistingName(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addSurveyToList(endOfYearSurvey);

        Survey endofYearImposterSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addSurveyToList(endofYearImposterSurvey);
    }


    //End of Survey Creation


    //Survey Response

    @Test
    public void createSurveyResponse(){
        SurveyResponse emptySurveyResponse = c.createEmptySurveyResponse();

        assertTrue("create Empty Survey Response", emptySurveyResponse instanceof SurveyResponse);
    }

    @Test
    public void addAnswersToSurveyResponse(){
        SurveyResponse surveyResponse = c.createEmptySurveyResponse();

        HashMap<Integer, Integer> surveyAnswers = new HashMap<>();
        surveyAnswers.put(1, 2);
        surveyAnswers.put(2, 4);

        c.addAnswerToSurveyResponse(surveyResponse, surveyAnswers);

        int numberOfSurveyAnswers= surveyResponse.getSurveyAnswers().size();
        assertEquals(2, numberOfSurveyAnswers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInvalidResponseAnswer(){
        SurveyResponse surveyResponse = c.createEmptySurveyResponse();

        HashMap<Integer, Integer> surveyAnswers = new HashMap<>();
        surveyAnswers.put(2, 6);

        c.addAnswerToSurveyResponse(surveyResponse, surveyAnswers);

    }

    @Test
    public void addSurveyResponseToSurvey(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        SurveyResponse endOfYearSurveyResponse = c.createEmptySurveyResponse();

        c.addSurveyResponseToSurvey(endOfYearSurvey, endOfYearSurveyResponse);

        int numOfSurveyResponses = endOfYearSurvey.getSurveyResponses().size();

        assertEquals(1, numOfSurveyResponses);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDifferentNumOfAnswersToQuestions(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");

        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        SurveyResponse endOfYearSurveyResponse = c.createEmptySurveyResponse();
        HashMap<Integer, Integer> surveyAnswers = new HashMap<>();
        surveyAnswers.put(1, 2);
        endOfYearSurveyResponse.addAnswersToResponse(surveyAnswers);

        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse);


    }


    //Viewing survey

    //Return collection of survey
    @Test
    public void testViewAllSurveys(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        Survey startOfYearSurvey = c.createSurveyWithName("startOfYearSurvey");

        List<Survey> surveyList = new ArrayList<>();
        surveyList.add(endOfYearSurvey);
        surveyList.add(startOfYearSurvey);

        c.addSurveyToList(endOfYearSurvey);
        c.addSurveyToList(startOfYearSurvey);

        assertEquals(surveyList, c.getSurveyList());
    }

    @Test
    public void findSurveyByNameTest(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        Survey startOfYearSurvey = c.createSurveyWithName("startOfYearSurvey");

        c.addSurveyToList(endOfYearSurvey);
        c.addSurveyToList(startOfYearSurvey);

        Survey surveyFoundByName = c.findSurveyByName(endofYearSurveyName);

        assertEquals(endOfYearSurvey, surveyFoundByName);

    }


    @Test(expected = NullPointerException.class)
    public void findSurveyByNameThatDoesntExist(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addSurveyToList(endOfYearSurvey);
        Survey surveyFoundByName = c.findSurveyByName("turkey");

    }

    @Test
    public void getAllResponsesToSurvey(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();

        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);

        //
        List localSurveyResponses = new ArrayList();
        localSurveyResponses.add(endOfYearSurveyResponse1);
        localSurveyResponses.add(endOfYearSurveyResponse2);


        assertEquals(localSurveyResponses, endOfYearSurvey.getSurveyResponses());
    }


    // Survey Statistics

    //Average score of particular survey
    @Test
    public void testAverageSurveyScore(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);


        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
       endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);

        assertEquals(3.5,c.calculateSurveyAverage(endOfYearSurvey), 0.0);
    }


    //Survey Question Statistics
    //Standard deviation for whole population
    //there is a different formula for sample population
    @Test
    public void testCalculateStandardDeviation(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);

        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);


        assertEquals(1.5, c.calculateSurveyStdDeviation(endOfYearSurvey), 0.0);
    }

    @Test
    public void testCalculateStandardDeviationMultipleQuestions(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        survey1Answers.put(2, 3);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 4);
        survey2Answers.put(2, 5);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        SurveyResponse endOfYearSurveyResponse3 = new SurveyResponse();
        HashMap<Integer, Integer> survey3Answers = new HashMap<>();
        survey3Answers.put(1, 1);
        survey3Answers.put(2, 2);
        endOfYearSurveyResponse3.addAnswersToResponse(survey3Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse3);


        assertEquals(1.3437096247164249, c.calculateSurveyStdDeviation(endOfYearSurvey), 0.0);
    }


    @Test
    public void testMinimumScoreForSurvey(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);

        assertEquals(2, c.getSurveyMinimumScore(endOfYearSurvey));


    }

    @Test
    public void testMaximumScoreForSurvey(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);

        assertEquals(5, c.getSurveyMaximumScore(endOfYearSurvey));


    }

    @Test
    public void getQuestionAverageScore(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        survey1Answers.put(2,4);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        survey2Answers.put(2,1);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);


        assertEquals(3.5,  c.getSurveyQuestionAnswerAverage(endOfYearSurvey, 1), 0.0);
    }


    @Test
    public void testQuestionStandardDeviation(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        survey1Answers.put(2,4);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        survey2Answers.put(2,5);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);

        assertEquals(1.5, c.getSurveyQuestionAnswerStdDeviation(endOfYearSurvey, 1), 0.0);
    }


    @Test
    public void testQuestionMinAnswer(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        survey1Answers.put(2,4);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        survey2Answers.put(2,3);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);
        //

        assertEquals(3,c.getQuestionMinAnswer(endOfYearSurvey, 2));
    }


    @Test
    public void testQuestionMaxAnswer(){
        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        //Responses
        SurveyResponse endOfYearSurveyResponse1 = new SurveyResponse();
        HashMap<Integer, Integer> survey1Answers = new HashMap<>();
        survey1Answers.put(1, 2);
        survey1Answers.put(2,4);
        endOfYearSurveyResponse1.addAnswersToResponse(survey1Answers);
        ///
        SurveyResponse endOfYearSurveyResponse2 = new SurveyResponse();
        HashMap<Integer, Integer> survey2Answers = new HashMap<>();
        survey2Answers.put(1, 5);
        survey2Answers.put(2,3);
        endOfYearSurveyResponse2.addAnswersToResponse(survey2Answers);
        ///
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse1);
        endOfYearSurvey.addSurveyResponse(endOfYearSurveyResponse2);
        //

        assertEquals(4,c.getQuestionMaxAnswer(endOfYearSurvey, 2));
    }


}