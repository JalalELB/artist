package com.jalalelb.artist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListArtistStatisticContext {

    private Map<Integer, ArtistStatisticContext> artistStatisticContextList;

}
