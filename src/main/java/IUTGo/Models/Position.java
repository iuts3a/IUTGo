package IUTGo.Models;

import java.time.Instant;

/**
 * Class IUTGo.Models.Position
 * @author vnahi
 * @project IUTGo
 */

public class Position {

    private Long id;
    private double lat;
    private double lng;
    private Instant created;

    /**
     * Instantiates a new Position.
     */
    public Position() {}

    /**
     * Instantiates a new Position.
     * @param lat the lat
     * @param lng the lng
     */
    public Position(final double lat, final double lng) {
        this.lat = lat;
        this.lng = lng;
        this.created = Instant.now();
    }

    /**
     * Gets created.
     * @return the created
     */
    public Instant getCreated() {
        return created;
    }

    /**
     * Gets id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets lat.
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets lat.
     * @param lat the lat
     */
    public void setLat(final double lat) {
        this.lat = lat;
    }

    /**
     * Gets lng.
     * @return the lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets lng.
     * @param lng the lng
     */
    public void setLng(final double lng) {
        this.lng = lng;
    }

    /**
     * Sets created.
     * @param created the created
     */
    public void setCreated(final Instant created) {
        this.created = created;
    }

    /**
     * Distance double.
     * @param o the o
     * @return the double
     */
    public double distance(Position o) {
        double theta = lng - o.lng;
        double dist = Math.sin(deg2rad(lat)) * Math.sin(deg2rad(o.lat)) + Math.cos(deg2rad(lat)) * Math.cos(deg2rad(o.lat)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Position)) { return false; }
        Position position = (Position) o;
        return getId() != null ? getId().equals(position.getId()) : position.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
