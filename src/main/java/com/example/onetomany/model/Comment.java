package com.example.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="comment", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "c_rfid", referencedColumnName = "id")
    private Post post;
}
