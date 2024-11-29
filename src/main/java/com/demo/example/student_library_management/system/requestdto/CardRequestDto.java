package com.demo.example.student_library_management.system.requestdto;

import com.demo.example.student_library_management.system.enums.CardStatus;
import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Data
public class CardRequestDto {

    private CardStatus cardStatus;// active,ACTIVE,ACtive,aCtive,
     private int studentId;

}
