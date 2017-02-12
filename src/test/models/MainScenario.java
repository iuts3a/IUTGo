package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.Admin;
import IUTGo.Models.Users.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 Created by Antoine on 07/02/2017.
 */
public class MainScenario {
    private Admin adminTest;
    private User userTest,participanTest;
    private Coordinates coordTest;

    @Before
    public void setUp () throws Exception
    {
        adminTest = new Admin("WAYNE", "Bruce","Batman", "bruce.wayne@mail.fr", "motdepasse", coordTest);
        coordTest = new Coordinates(1, 1, "Paris");
        userTest = new User("WAYNE", "Bruce", "Batman","bruce.wayne@mail.fr", "motdepasse", coordTest);
        participanTest = new User("kent", "Clark", "Superman","clark.kent@mail.fr", "motdepasse", coordTest);
    }

    @Test
    public void Scenario () throws Exception {
        // En tant qu'utilisateur je veux suggérer l'ajout d'un Point d'interet
        assertEquals(true,  userTest.suggestPointInteret("Casino",PointInterestType.MUSEUM,5,coordTest));

        //En tant qu'administrateur je veux valider l'ajout d'un Point d'interet
        assertEquals(true,  adminTest.validatePointInterest("Casino"));

        //En tant qu'utilisateur je veux créer un roadTrip
        assertEquals(true,  userTest.createRoadTrip("EnglandRT"));

        //En tant qu'utilisateur je veux ajouter un Point d'interet au roadTrip
        assertEquals(true, userTest.addPointInteretToRoadTrip("EnglandRT","Buffalo","Voyage pour faire le tour des coins touristique de l'Angleterre",PointInterestType.RESTAURANT,10,coordTest));

        // En tant qu'utilisateur je veux commenter un Point d'interet
        assertEquals(true, userTest.commentPointInteret("Buffalo","Génial",4));

        //En tant qu'administrateur je veux changer le prix d'un Point d'interet
        assertEquals(true,adminTest.changePricePointInterest ("Buffalo", 15));
        assertEquals(15,PointInterest.read().get("Buffalo"));

        //En tant qu'utilisateur je souhaite pouvoir ajouter un road trip à mes favoris.
        assertEquals(true,userTest.addRoadTripToFavorite("EnglandRT"));

        //En tant qu'utilisateur je souhaite voir le prix d'un road trip.
        assertEquals(15,userTest.getRoadTripPrice("EnglandRT"));

        //En tant qu'utilisateur je souhaite  voir les road trip en fonction de leurs scores.
        assertEquals(true,userTest.getRoadTripByScore(4));

        //En tant qu'utilisateur je souhaite pouvoir supprimer un point d'interet à mon road trip.
        assertEquals(true,userTest.deletePointInteretFromRoadTrip("Buffalo","EnglandRT"));

        //En tant qu'utilisateur je souhaite pouvoir supprimer un road trip.
        assertEquals(true,userTest.deleteRoadTrip("EnglandRT"));

        //En tant qu'administrateur je souhaite pouvoir supprimer un point d'interet.
        assertEquals(true,adminTest.deletePointInterest("Buffalo"));


    }

}