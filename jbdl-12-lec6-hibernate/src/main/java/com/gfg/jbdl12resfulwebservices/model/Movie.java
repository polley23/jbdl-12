package com.gfg.jbdl12resfulwebservices.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    private String movieName;
    @Column(name = "genres")
    private String genre;
    private String language;
    @ManyToMany(mappedBy = "movieList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cast> castList;
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<Award> awards;
    @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rating rating;
}

//Many to many
//Many to One
//One to One