package mketour;

import javafx.geometry.Point2D;
import mketour.actors.MobileEntity;

/**
 * Simple interface for all taggable objects.
 *
 * The CityMap uses this class to simplify collision detection.  See the CityMap's taggedBy method.
 */
public interface Taggable {

    /**
     * @param location The location to check
     * @return true if this object was tagged by touching that location
     */
    boolean isTagged(Point2D location);

    /**
     * Respond to being tagged. This method is called when the object is tagged.
     * @param entity The entity performing the tagging.
     */
    void taggedBy(MobileEntity entity);
}
