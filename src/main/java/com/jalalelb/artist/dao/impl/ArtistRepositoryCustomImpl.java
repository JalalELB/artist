package com.jalalelb.artist.dao.impl;

import com.jalalelb.artist.dao.IArtistRepositoryCustom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.util.List;

@Service
public class ArtistRepositoryCustomImpl implements IArtistRepositoryCustom {

    private static Logger logger = LogManager.getLogger(ArtistRepositoryCustomImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${statistic.artists.query}")
    private String statisticArtistsQuery;

    /**
     * return the list of artists grouped by artis_id and years
     *
     * @return
     */
    @Override
    public List<Tuple> getArtistStatistics() {

        logger.info("################ DAO : getArtistStatistics ################");

        List<Tuple> tupleList = entityManager.createNativeQuery(statisticArtistsQuery, Tuple.class)
                .getResultList();

        return tupleList;
    }

}
