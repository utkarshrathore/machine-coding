package com.trello.services.impl;

import com.trello.enums.BoardPrivacyType;
import com.trello.models.Board;
import com.trello.models.Problem;
import com.trello.models.Task;
import com.trello.models.User;
import com.trello.services.TrelloService;

import java.util.HashMap;
import java.util.Objects;

public class TrelloServiceImpl implements TrelloService {
    private HashMap<String, User> userMap;
    private HashMap<String, Board> boardMap;
    private HashMap<String, Problem> problemMap;
    private HashMap<String, Task> taskMap;

    public TrelloServiceImpl() {
        userMap = new HashMap();
        boardMap = new HashMap();
        problemMap = new HashMap();
        taskMap = new HashMap();
    }

    public String createUser(String userName, String userEmail) {
        User user = new User(userName, userEmail);
        userMap.put(user.getId(), user);
        return user.getId();
    }

    public String createBoard(String boardName) {
        Board board = new Board(boardName);
        boardMap.put(board.getBoardId(), board);
        return board.getBoardId();
    }

    public void showBoard(final String boardId) {
        Board board = boardMap.getOrDefault(boardId, null);
        if(Objects.nonNull(board)) {
            System.out.println(board);
        }
    }

    public void setBoardName(String boardId, String newName) {
        Board board = boardMap.getOrDefault(boardId, null);
        if(Objects.nonNull(board)) {
            board.setBoardName(newName);
        }
    }

    public void setBoardPrivacy(String boardId, BoardPrivacyType newPrivacy) {
        Board board = boardMap.getOrDefault(boardId, null);
        if(Objects.nonNull(board)) {
            board.setBoardPrivacy(newPrivacy);
        }
    }

    public void addMemberToBoard(String boardId, String userId) {
        User user = userMap.getOrDefault(userId, null);
        Board board = boardMap.getOrDefault(boardId, null);
        if(user != null && board != null) {
            board.getBoardMembers().add(user);
        }
    }

    private void deleteTask(Task task) {
        if(task != null) {
            taskMap.remove(task.getId());
        }

        for(Problem p : problemMap.values()) {
            for(Task t : p.getTasks()) {
                if(t==task) {
                    p.getTasks().remove(t);
                }
            }
        }
    }

    private void deleteProblem(Problem problem) {
        for(Task task: problem.getTasks()) {
            deleteTask(task);
        }

        for(Board b : boardMap.values()) {
            for(Problem p : b.getBoardProblems()) {
                if(p==problem) {
                    b.getBoardProblems().remove(p);
                }
            }
        }
    }

    public void deleteBoard(String boardId) {
        Board board = boardMap.getOrDefault(boardId, null);
        if(board == null) {
            return;
        }

        for(Problem problem : board.getBoardProblems()) {
            deleteProblem(problem);
        }

        boardMap.remove(boardId);
    }

    public String createList(String boardId, String listName) {
        Problem problem = new Problem(listName);
        Board board = boardMap.getOrDefault(boardId, null);
        if(board!=null) {
            board.getBoardProblems().add(problem);
            problem.setBoardId(boardId);
        }

        return problem.getId();
    }

    public void showList(String listId) {
        Problem problem = problemMap.getOrDefault(listId, null);
        if (Objects.nonNull(problem)) {
            System.out.println(problem);
        }
    }

    public void deleteList(String listId) {
        Problem problem = problemMap.getOrDefault(listId, null);
        if (Objects.nonNull(problem)) {
            deleteProblem(problem);
        }
    }

    public String createCard(String cardName, String listId) {
        Task task = new Task(cardName);
        task.setProblemId(listId);
        taskMap.put(task.getId(), task);
        return task.getId();
    }

    public void updateCardName(String cardId, String newCardName) {
        Task task = taskMap.getOrDefault(cardId, null);
        if(task!=null) {
            task.setName(newCardName);
        }
    }

    public void updateCardDescription(String cardId, String newCardDescription) {
        Task task = taskMap.getOrDefault(cardId, null);
        if(task!=null) {
            task.setDescription(newCardDescription);
        }
    }

    public void assignCard(String cardId, String userId) {
        Task task = taskMap.getOrDefault(cardId, null);
        User user = userMap.getOrDefault(userId, null);
        if(task!=null && user!=null) {
            task.setAssignedUser(userId);
        }
    }

    public void unassignCard(String cardId) {
        Task task = taskMap.getOrDefault(cardId, null);
        if(task!=null) {
            task.setAssignedUser(null);
        }
    }

    public void moveCard(String cardId, String newListId) {
        Problem newProblem = problemMap.getOrDefault(newListId, null);
        Task task = taskMap.getOrDefault(cardId, null);
        Problem problem = problemMap.getOrDefault(task.getProblemId(), null);
        if(problem!=null && newProblem!=null &&  problem.getBoardId()==newProblem.getBoardId()) {
            problem.getTasks().remove(task);
            newProblem.getTasks().add(task);
            task.setProblemId(newListId);
        }
    }

    public void deleteCard(String cardId) {
        Task task = taskMap.getOrDefault(cardId, null);
        if (task == null) {
            return;
        }
        taskMap.remove(cardId);
        String problemId = task.getProblemId();
        Problem problem = problemMap.getOrDefault(problemId, null);
        problem.getTasks().remove(task);
    }


    public void showCard(String cardId) {
        Task task = taskMap.getOrDefault(cardId, null);
        if (task != null) {
            System.out.println(task);
        }
    }
}