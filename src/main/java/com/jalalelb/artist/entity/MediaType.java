package com.jalalelb.artist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mediaTypeId;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mediaType")
    private List<Track> tracks;

}
