package mketour.observers;

import javafx.scene.layout.Pane;
import mketour.IObserver;
import mketour.Taggable;

public class OtherBusLicensePlateObserver extends AbstractLicensePlateObserver {

    private boolean active;
    public OtherBusLicensePlateObserver(Pane challengePane) {
        super(challengePane, "BUS");
        this.active = false;
        this.challengeLabel.setVisible(false);
        this.progressLabel.setVisible(false);
    }

    @Override
    public IObserver updateObserver(Taggable context) {
        if(context.toString().contains("Bus") && !active) {
            this.active = true;
            this.challengeLabel.setVisible(true);
            this.progressLabel.setVisible(true);
            return null;
        }
        return !this.active ? null : super.updateObserver(context);
    }
}