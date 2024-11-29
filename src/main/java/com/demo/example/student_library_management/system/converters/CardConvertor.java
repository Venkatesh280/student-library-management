package com.demo.example.student_library_management.system.converters;

import com.demo.example.student_library_management.system.model.Card;
import com.demo.example.student_library_management.system.requestdto.CardRequestDto;

public class CardConvertor {

    public static Card convertCarRequestDtoIntoCard(CardRequestDto cardRequestDto) {
        Card card = Card.builder()
                .cardStatus(cardRequestDto.getCardStatus())
                .build();
        return card;
    }
}
