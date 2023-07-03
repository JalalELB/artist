package com.jalalelb.artist.business.impl;

import com.jalalelb.artist.business.IArtistBusiness;
import com.jalalelb.artist.dao.IArtistRepositoryCustom;
import com.jalalelb.artist.dto.ArtistStatisticContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArtistBusinessImpl implements IArtistBusiness {

    private static Logger logger = LogManager.getLogger(ArtistBusinessImpl.class);

    private IArtistRepositoryCustom artistRepositoryCustom;

    @Autowired
    public ArtistBusinessImpl(IArtistRepositoryCustom artistRepositoryCustom) {
        this.artistRepositoryCustom = artistRepositoryCustom;
    }

    /**
     * return the list of artists and for each of them,
     * the maximum number of consecutive years during which
     * they sold 3 titles or more.
     *
     * @return
     */
    @Override
    public Map<Integer, ArtistStatisticContext> getArtistStatistics() {

        logger.info("################ BUSINESS : getArtistStatistics ################");

        List<ArtistStatisticContext> artistStatisticContextList = new ArrayList<>();
        Map<Integer, ArtistStatisticContext> artistStatisticContextMap = new HashMap<>();
        int maxNumConsecutiveYears = 0;

        List<Tuple> tubpleList = artistRepositoryCustom.getArtistStatistics();

        tubpleList.forEach(tuple -> {

            ArtistStatisticContext artistStatisticContext = new ArtistStatisticContext();

            int artistIdKey = Integer.parseInt(tuple.get("artist_id").toString());

            // If the artist has been treated at least once
            if (artistStatisticContextMap.containsKey(artistIdKey)) {

                artistStatisticContext = artistStatisticContextMap.get(artistIdKey);


                // reading the year and finalMaxNumConsecutiveYears for tests
                int year = Integer.parseInt(tuple.get("annee").toString());
                int finalMaxNumConsecutiveYears = artistStatisticContext.getFinalMaxNumConsecutiveYears();


                // apply incrementation if consecutive case exists
                if (artistStatisticContext.getYear() + 1 == year) {
                    artistStatisticContext.setTmpMaxNumConsecutiveYears(artistStatisticContext.getTmpMaxNumConsecutiveYears() + 1);
                } else {
                    artistStatisticContext.setTmpMaxNumConsecutiveYears(1);
                }


                // set finalMaxNumConsecutiveYears if tmpMaxNumConsecutiveYears is greater to keep the greater max number
                if (artistStatisticContext.getTmpMaxNumConsecutiveYears() > finalMaxNumConsecutiveYears)
                    artistStatisticContext.setFinalMaxNumConsecutiveYears(artistStatisticContext.getTmpMaxNumConsecutiveYears());

                // set the last gotten year
                artistStatisticContext.setYear(year);

                // Update artist's data
                artistStatisticContextMap.replace(artistIdKey, artistStatisticContext);

            } else {

                artistStatisticContext.setArtistId(tuple.get("artist_id").toString());
                artistStatisticContext.setArtistName(tuple.get("artist_name").toString());
                artistStatisticContext.setTmpMaxNumConsecutiveYears(1);
                artistStatisticContext.setFinalMaxNumConsecutiveYears(1);
                artistStatisticContext.setYear(Integer.parseInt(tuple.get("annee").toString()));

                artistStatisticContextMap.put(Integer.parseInt(tuple.get("artist_id").toString()), artistStatisticContext);

            }


        });

        return artistStatisticContextMap;
    }
}
