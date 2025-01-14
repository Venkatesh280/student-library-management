package com.demo.example.student_library_management.system.model;


import com.demo.example.student_library_management.system.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@Data
@AllArgsConstructor //paramaetrized constructor
@NoArgsConstructor //default constructor
@Builder
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

    @JsonBackReference
    @OneToOne
    @JoinColumn // its joins the primary key of student table as foreign key in card table
    private Student student;

    @JsonManagedReference
    @OneToMany(mappedBy = "card",cascade=CascadeType.ALL)
    private List<Book> bookIssuedToCard=new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "card",cascade=CascadeType.ALL)
    private List<Transaction> transactionForCard=new ArrayList<>();
}
