package com.jalalelb.artist.controler;

import com.jalalelb.artist.business.IArtistBusiness;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

//@ApiOperation("API for Artist Project")
@RestController
@RequestMapping("ws")
public class RestArtistControler {

    private IArtistBusiness artistBusiness;

    @Autowired
    public RestArtistControler(IArtistBusiness artistBusiness) {
        this.artistBusiness = artistBusiness;
    }

//    @ApiOperation("Get artists list with the maximum number of consecutive years solding more than 2 titles")
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getArtists() {
        return ok().body(artistBusiness.getArtistStatistics());
    }
}
