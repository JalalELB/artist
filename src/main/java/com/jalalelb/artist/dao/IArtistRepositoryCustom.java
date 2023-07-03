package com.jalalelb.artist.dao;

import javax.persistence.Tuple;
import java.util.List;

public interface IArtistRepositoryCustom {

    /**
     * * return the list of artists grouped by artis_id and years
     *
     * @return List<Tuple>
     */
    public List<Tuple> getArtistStatistics();

}
