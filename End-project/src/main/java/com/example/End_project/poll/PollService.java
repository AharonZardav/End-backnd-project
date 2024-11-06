package com.example.End_project.poll;

import com.example.End_project.poll.Model.Poll;
import com.example.End_project.poll.Model.PollResponse;
import com.example.End_project.poll.Repository.PollRepository;
import com.example.End_project.question.Question;
import com.example.End_project.question.QuestionFeignClient;
import com.example.End_project.user.UserFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private QuestionFeignClient questionFeignClient;

    public Poll sendAnswer(Poll poll){
        //BAD_REQUEST
        if (poll.getUserId() == null || poll.getQuestionId() == null || poll.getAnswer() == null){
            System.out.println("PollService say: It's impossible to send answer without all the poll details: (user_id, question_id, answer)");
            return null;
        }

        //NOT_FOUND
        //check if the user register
        if(!checkIfUserExistHelper(poll.getUserId())){
            return null;
        }

        //NOT_FOUND
        //check if the question exist
        if (!checkIfQuestionExistHelper(poll.getQuestionId())){
            return null;
        }

        if (!validateAnswer(poll.getAnswer())){
            System.out.println("PollService say: Answer must be one of the following: a, b, c, or d");
            return null;
        }

        //BAD_REQUEST
        if (pollRepository.getByUserIdAndQuestionId(poll) != null){
            System.out.println("PollService say: You can't answer twice on same question!");
            return null;
        }
        return pollRepository.sendNewAnswer(poll);
    }

    public PollResponse getAnswersCountByQuestion(int questionId){
        try {
            if (!checkIfQuestionExistHelper(questionId)){
                return null;
            }
            PollResponse pollResponse = new PollResponse(questionId);
            List<Map<String, Object>> answers = pollRepository.getAnswersCountsByQuestionId(questionId);
            for (Map<String, Object> answerMap : answers) {
                String answer = (String) answerMap.get("ANSWER");
                int count = ((Number) answerMap.get("COUNT")).intValue();

                switch (answer) {
                    case "a":
                        pollResponse.setCountA(count);
                        break;
                    case "b":
                        pollResponse.setCountB(count);
                        break;
                    case "c":
                        pollResponse.setCountC(count);
                        break;
                    case "d":
                        pollResponse.setCountD(count);
                        break;
                }
            };
//            System.out.println("pollResponse: "+ pollResponse);
            return pollResponse;
        }
        catch (Exception E){
            return null;
        }
    }

    public Integer getSumOfAnswersOnQuestion(int questionId){
        try {
            if (!checkIfQuestionExistHelper(questionId)){
                return null;
            }
            return pollRepository.getCountOfUsersAnswersOnThisQuestion(questionId);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Map<String, Object>> getUserAnswers(int userId){
        try {
            if (!checkIfUserExistHelper(userId)){
                return null;
            }
            return pollRepository.getUserAnswers(userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getSumOfAnswersByUser(int userId){
        try {
            if (!checkIfUserExistHelper(userId)){
                return null;
            }
            return pollRepository.getSumOfAnswersByUser(userId);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //test
//    public List<PollResponse> getAllQuestionsWithAnswersCount(){
//        try {
//            List<Integer> AllQuestionsId = getAllQuestionsId();
//            Map<String ,PollResponse> pollResponses = new HashMap<>();
//
//            for (int questionId : AllQuestionsId){
//                PollResponse pollResponseAsJson = getAnswersCountByQuestion(questionId);
//                pollResponses.add(pollResponseAsJson);
//            }
////            System.out.println(pollResponses);
//            return pollResponses;
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    public List<PollResponse> getAllQuestionsWithAnswersCount(){
        try {
            List<Integer> allQuestionsId = getAllQuestionsId();
            List<PollResponse> allQuestionsAnswersCount = new ArrayList<>();
            for (int questionId : allQuestionsId){
                allQuestionsAnswersCount.add(getAnswersCountByQuestion(questionId));
            }
            return allQuestionsAnswersCount;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean checkIfQuestionExistHelper(int questionId){
        try {
            if(questionFeignClient.getQuestion(questionId) == null){
                return false;
            }
        } catch (FeignException e) {
            return false;
        }
        return true;
    }

    public Boolean checkIfUserExistHelper(int userId){
        try {
            if(userFeignClient.getUser(userId) == null){
                return false;
            }
        } catch (FeignException e) {
            return false;
        }
        return true;
    }

    public List<Integer> getAllQuestionsId(){
        try {
            List<Question> allQuestions = questionFeignClient.getAllQuestions();
            List<Integer> allQuestionsId = new ArrayList<>();
            for (Question question : allQuestions){
                allQuestionsId.add(question.getId());
            }
            return allQuestionsId;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean validateAnswer(String answer) {
        if (answer.matches("[abcd]")) {
            return true;
        }
        return false;
    }

//    public String convertToJson(PollResponse pollResponse){
//        return  "\n[" +
//                "\n    {" +
//                "\n        \"ANSWER\": \"a\", " +
//                "\n        \"COUNT\": " + pollResponse.getCountA() +
//                "\n    }," +
//                "\n    {" +
//                "\n        \"ANSWER\": \"b\", " +
//                "\n        \"COUNT\": " + pollResponse.getCountB() +
//                "\n    }," +
//                "\n    {" +
//                "\n        \"ANSWER\": \"c\", " +
//                "\n        \"COUNT\": " + pollResponse.getCountC() +
//                "\n    }," +
//                "\n    {" +
//                "\n        \"ANSWER\": \"d\", " +
//                "\n        \"COUNT\": " + pollResponse.getCountD() +
//                "\n    }" +
//                "\n]";
//    }

//    public Poll getAnswer(Poll poll){
//        return pollRepository.getByUserIdAndQuestionId(poll);
//    }
}
