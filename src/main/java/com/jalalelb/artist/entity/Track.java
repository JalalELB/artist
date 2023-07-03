package com.jalalelb.artist.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackId;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Album album;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MediaTypeId")
    private MediaType mediaType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenreId")
    private Genre genre;
    private String composer;
    private int bytes;
    private BigDecimal unitPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "play_list_track",
            joinColumns = {
                    @JoinColumn(name = "track_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "play_list_id")
            }
    )
    Set<PlayList> playLists = new HashSet<>();

}
