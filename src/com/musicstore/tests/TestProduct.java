package com.musicstore.tests;

import static org.junit.Assert.assertEquals;
import java.util.*;

import com.musicstore.domain.ProductMusicRecord;
import com.musicstore.domain.ProductPickup;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;
import com.musicstore.utils.RecordType;
import org.junit.Test;


public class TestProduct {

    //Todo: needs exception for stock<0
    @Test
    public void testProducts(){

        ProductPickup pick1 = new ProductPickup(
                1,
                "ProjectT1",
                2000.0,
                15,
                PickupOperatingMechanismType.Manual,
                PickupDriverType.DirectDrive
        );

        System.out.println(pick1.toString());

        ProductMusicRecord vinyl1 = new ProductMusicRecord(
                2,
                "channelOrange",
                200.0,
                15,
                RecordType.Vinyl
        );

        System.out.println(vinyl1.toString());

        vinyl1.addTrack("Sierra Leone",2*60+28);
        vinyl1.addTrack("Lost",3*60+54);
        vinyl1.addTrack("Pyramids",4*60+22);

        vinyl1.showAllTracks();
        vinyl1.showTotalDuration();

        vinyl1.deleteTrack("Lost");
        vinyl1.editTrack("Pyramids","Sweet Life");

        //Temp Array
        ArrayList<String> testTracks = new ArrayList<String>();
        testTracks.add("Sierra Leone");
        testTracks.add("Sweet Life");

        assertEquals(testTracks, vinyl1.getTracks());
        assertEquals(644, vinyl1.getDuration());


    }

}
