package com.jalalelb.artist.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArtistStatisticContext {

    @JsonIgnore
    private int tmpMaxNumConsecutiveYears;
    @JsonIgnore
    private String artistId;
    private String artistName;
    private int finalMaxNumConsecutiveYears;
    @JsonIgnore
    private int year;

}
