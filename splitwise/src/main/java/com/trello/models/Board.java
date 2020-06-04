package com.trello.models;

import com.trello.enums.BoardPrivacyType;
import com.trello.utils.Constants;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Board {
    private final String boardId;
    private String boardName;
    private String boardEmail;
    private BoardPrivacyType boardPrivacy;
    private String boardURL;
    private List<User> boardMembers;
    private List<Problem> boardProblems;

    public Board(String boardName) {
        this.boardId = UUID.randomUUID().toString();
        this.boardName = boardName;
        this.boardEmail = boardName+Constants.EMAIL_POSTFIX;
        this.boardPrivacy = BoardPrivacyType.PUBLIC;
        this.boardURL = Constants.URL_PREFIX+boardId;
        this.boardProblems = new LinkedList<Problem>();
        this.boardMembers = new LinkedList<User>();
    }

    public String getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardEmail() {
        return boardEmail;
    }

    public void setBoardEmail(String boardEmail) {
        this.boardEmail = boardEmail;
    }

    public BoardPrivacyType getBoardPrivacy() {
        return boardPrivacy;
    }

    public void setBoardPrivacy(BoardPrivacyType boardPrivacy) {
        this.boardPrivacy = boardPrivacy;
    }

    public String getBoardURL() {
        return boardURL;
    }

    public void setBoardURL(String boardURL) {
        this.boardURL = boardURL;
    }

    public List<User> getBoardMembers() {
        return boardMembers;
    }

    public void setBoardMembers(List<User> boardMembers) {
        this.boardMembers = boardMembers;
    }

    public List<Problem> getBoardProblems() {
        return boardProblems;
    }

    public void setBoardProblems(List<Problem> boardProblems) {
        this.boardProblems = boardProblems;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId='" + boardId + '\'' +
                ", boardName='" + boardName + '\'' +
                ", boardEmail='" + boardEmail + '\'' +
                ", boardPrivacy=" + boardPrivacy +
                ", boardURL='" + boardURL + '\'' +
                ", boardMembers=" + boardMembers +
                ", boardProblems=" + boardProblems +
                '}';
    }
}