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

    private static final String ARTWORK_RESOURCE = "img/wood-gatherer.png";

    private static final String ARTWORK_LABEL = "Artistic works found:";

    private final Pane challengePane;
    private final Node label;
    private final ImageView artworkView;

    private final Taggable correctContext;

    public WoodGathererObserver(Pane challengePane, Taggable correctContext) {
        this.challengePane = challengePane;
        this.correctContext = correctContext;
        label = new Text(ARTWORK_LABEL);
        Image artwork = new Image(CityMap.class.getResource(ARTWORK_RESOURCE).toString());
        artworkView = new ImageView(artwork);
        artworkView.setPreserveRatio(true);
        artworkView.setFitHeight(MobileEntity.HEIGHT);
    }

    /**
     *
     * @param context The object that caused the observer to be notified
     * @return This instance if it has completed its task, so it can be removed, or null if the wrong context notified it.
     */
    @Override
    public IObserver updateObserver(Taggable context) {
        if(context.equals(correctContext)){
            challengePane.getChildren().add(label);
            challengePane.getChildren().add(artworkView);
            return this;
        }
        return null;
    }
}
