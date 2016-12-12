package com.daniels.harry.assignment.viewmodel;

import android.databinding.BindingAdapter;
import android.location.Location;
import android.widget.ImageView;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.daniels.harry.assignment.R;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.Objects;

@JsonObject
public class FavouriteTeamViewModel implements SortedListAdapter.ViewModel {

    public FavouriteTeamViewModel() {

    }

    public void calculateDetails()
    {
        if (prevFixture != null)
        {
            if (Objects.equals(prevFixture.getHomeTeamName(), name))
            {
                prevFixture.setOppositionName(prevFixture.getAwayTeamName());
                prevFixture.setLocation("Home");
                prevFixture.setAway(false);
            }
            else
            {
                prevFixture.setOppositionName(prevFixture.getHomeTeamName());
                prevFixture.setLocation("Away");
                prevFixture.setAway(true);
            }
        }

        if (nextFixture != null)
        {
            if (Objects.equals(nextFixture.getHomeTeamName(), name))
            {
                nextFixture.setOppositionName(nextFixture.getAwayTeamName());
                nextFixture.setLocation("Home");
                nextFixture.setAway(false);
            }
            else
            {
                nextFixture.setOppositionName(nextFixture.getHomeTeamName());
                nextFixture.setLocation("Away");
                nextFixture.setAway(true);
            }
        }
    }

    @BindingAdapter({"bind:crestUrl"})
    public static void loadCrest(ImageView view, String crestUrl) {
        Picasso.with(view.getContext())
                .load(crestUrl)
                .placeholder(R.drawable.icon_team)
                .into(view);
    }

    @JsonField(name = "Name")
    private String name;

    @JsonField(name = "Latitude")
    private double latitude;

    @JsonField(name = "Longitude")
    private double longitude;

    @JsonField(name = "Ground")
    private String ground;

    @JsonField(name = "CrestURL")
    private String crestUrl;

    private float distance;

    private double userLatitude;
    private double userLongitude;

    private String position;
    private String points;
    private String wins;
    private String draws;
    private String losses;

    private FixtureViewModel prevFixture;
    private FixtureViewModel nextFixture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public float getDistance() {
        float[] distances = new float[1];
        Location.distanceBetween(getLatitude(), getLongitude(), getUserLatitude(), getUserLongitude(), distances);
        setDistance(distances[0]);
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        String returnPosition;

        switch (position)
        {
            case "1" :
                returnPosition = "1st";
                break;
            case "2" :
                returnPosition = "2nd";
                break;
            case "3" :
                returnPosition = "3rd";
                break;
            default :
                returnPosition = position + "th";
                break;
        }

        this.position = returnPosition;
    }

    public FixtureViewModel getPrevFixture() {
        return prevFixture;
    }

    public void setPrevFixture(FixtureViewModel prevFixture) {
        this.prevFixture = prevFixture;
    }

    public FixtureViewModel getNextFixture() {
        return nextFixture;
    }

    public void setNextFixture(FixtureViewModel nextFixture) {
        this.nextFixture = nextFixture;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }
}
