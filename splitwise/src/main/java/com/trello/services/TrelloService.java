package com.trello.services;

import com.trello.enums.BoardPrivacyType;

public interface TrelloService {
    String createUser(String userName, String userEmail);

    String createBoard(String boardName);
    void showBoard(String boardId);
    void setBoardName(String boardId, String newName);
    void setBoardPrivacy(String boardId, BoardPrivacyType newPrivacy);
    void addMemberToBoard(String boardId, String userId);
    void deleteBoard(String boardId);

    String createList(String boardId, String listName);
    void showList(String listId);
    void deleteList(String listId);

    String createCard(String cardName, String listId);
    void updateCardName(String cardId, String newCardName);
    void updateCardDescription(String cardId, String newCardDescription);
    void assignCard(String cardId, String userId);
    void unassignCard(String cardId);
    void moveCard(String cardId, String newListId);
    void deleteCard(String cardId);
    void showCard(String cardId);
}
