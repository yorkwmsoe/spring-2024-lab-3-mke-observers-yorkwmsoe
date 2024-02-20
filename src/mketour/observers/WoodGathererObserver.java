/*
 * Course:     SWE 2410
 * Assignment: MKETour
 * Author:     Dr. Yoder and Billy York
 */
package mketour.observers;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import mketour.CityMap;
import mketour.IObserver;
import mketour.Taggable;
import mketour.actors.MobileEntity;

public class WoodGathererObserver implements IObserver {

    private static final String CHALLENGE_LABEL = "Challenge: Find art";
    private static final String ARTWORK_RESOURCE = "img/wood-gatherer.png";

    private static final String ARTWORK_LABEL = "Artistic works found:";
    private final Node challengeLabel;
    private final Node artworLabel;
    private final ImageView artworkView;

    private final Taggable correctContext;

    public WoodGathererObserver(Pane challengePane, Taggable correctContext) {
        this.correctContext = correctContext;
        this.challengeLabel = new Text(CHALLENGE_LABEL);
        this.artworLabel = new Text(ARTWORK_LABEL);
        Image artwork = new Image(CityMap.class.getResource(ARTWORK_RESOURCE).toString());
        artworkView = new ImageView(artwork);
        artworkView.setPreserveRatio(true);
        artworkView.setFitHeight(MobileEntity.HEIGHT);
        artworkView.setVisible(false);
        challengePane.getChildren().add(challengeLabel);
        challengePane.getChildren().add(artworLabel);
        challengePane.getChildren().add(artworkView);
        challengePane.getChildren().add(new Text()); // Add a simple node for separation in pane
    }

    /**
     *
     * @param context The object that caused the observer to be notified
     * @return This instance if it has completed its task, so it can be removed, or null if the wrong context notified it.
     */
    @Override
    public IObserver updateObserver(Taggable context) {
        if(context.equals(correctContext)){
            artworkView.setVisible(true);
            return this;
        }
        return null;
    }
}
