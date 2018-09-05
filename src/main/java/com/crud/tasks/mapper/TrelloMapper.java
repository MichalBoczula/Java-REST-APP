package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class TrelloMapper {
    public List<TrelloBoard> mapToBoard(final List<TrelloBoardDto> trelloBoards) {
        return trelloBoards != null ?
                trelloBoards.stream()
                        .map(trelloBoard ->
                                new TrelloBoard(
                                        trelloBoard.getId(),
                                        trelloBoard.getName(),
                                        mapToList(trelloBoard.getLists())
                                )
                        ).collect(Collectors.toList())
                : new ArrayList<>();
    }

    public List<TrelloBoardDto> mapToBoardDto(final List<TrelloBoard> trelloBoards) {
        return trelloBoards != null ?
                trelloBoards.stream()
                        .map(trelloBoard ->
                                new TrelloBoardDto(
                                        trelloBoard.getId(),
                                        trelloBoard.getName(),
                                        mapToListDto(trelloBoard.getLists())
                                )
                        ).collect(toList())
                : new ArrayList<>();
    }

    public List<TrelloList> mapToList(final List<TrelloListDto> trelloListDto) {
        return trelloListDto != null ?
                trelloListDto.stream()
                        .map(trelloList ->
                                new TrelloList(
                                        trelloList.getId(),
                                        trelloList.getName(),
                                        trelloList.isClosed()
                                )
                        ).collect(toList())
                : new ArrayList<>();
    }

    public List<TrelloListDto> mapToListDto(List<TrelloList> lists) {
        return lists != null ?
                lists.stream()
                        .map(trelloList ->
                                new TrelloListDto(
                                        trelloList.getId(),
                                        trelloList.getName(),
                                        trelloList.isClosed()
                                )
                        )
                        .collect(toList())
                : new ArrayList<>();
    }

    public TrelloCard mapToCard(final TrelloCardDto trelloCardDto) {
        return trelloCardDto != null ?
                new TrelloCard(
                        trelloCardDto.getName(),
                        trelloCardDto.getDescription(),
                        trelloCardDto.getPos(),
                        trelloCardDto.getListId()
                )
                : new TrelloCard(
                "",
                "",
                "",
                "");
    }

    public TrelloCardDto mapToCardDto(final TrelloCard trelloCard) {
        return trelloCard != null ?
                new TrelloCardDto(
                        trelloCard.getName(),
                        trelloCard.getDescription(),
                        trelloCard.getPos(),
                        trelloCard.getListId())
                : new TrelloCardDto(
                "",
                "",
                "",
                "");
    }
}
