package com.jalalelb.artist.business;

import com.jalalelb.artist.dto.ArtistStatisticContext;

import java.util.Map;

public interface IArtistBusiness {

    /**
     * return the list of artists and for each of them,
     * the maximum number of consecutive years during which
     * they sold 3 titles or more.
     *
     * @return ArtistStatisticContext
     */
    public Map<Integer, ArtistStatisticContext> getArtistStatistics();

}
