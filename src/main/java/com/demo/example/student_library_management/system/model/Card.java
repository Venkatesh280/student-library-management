package com.demo.example.student_library_management.system.model;


import com.demo.example.student_library_management.system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
@Data
@AllArgsConstructor //paramaetrized constructor
@NoArgsConstructor //default constructor
public class Card {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="card_status",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;// active,ACTIVE,ACtive,aCtive,

    @Column(name="create_date",nullable = false)
    @CreationTimestamp // it automatically adds date and time when card it created
    private Date cardDate;

    @Column(name="update_date",nullable = false)
    @UpdateTimestamp // it automatically updates date and time when card is updated
    private  Date updateDate;
}
