/*
 * Course:     SWE 2410
 * Assignment: MKETour
 * Author:     Dr. Yoder and Billy York
 */
package mketour.observers;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import mketour.IObserver;
import mketour.Taggable;

public class BusLicensePlateObserver implements IObserver {

    private static final String CHALLENGE_LABEL = "Challenge: Find all the letters in BUS\nGoal: BUS";
    private static final String PROGRESS_LABEL = "Found: ";
    private static final String COMPLETE_LABEL = "BUS CHALLENGE COMPLETED";
    private final Node challengeLabel;
    private final Text progressLabel;
    private String progress;
    private boolean active = false;
    private boolean foundB = false;
    private boolean foundU = false;
    private boolean foundS = false;

    public BusLicensePlateObserver(Pane challengePane) {
        this.progress = "***";
        this.challengeLabel = new Text(CHALLENGE_LABEL);
        this.progressLabel = new Text(PROGRESS_LABEL + progress);
        this.challengeLabel.setVisible(false);
        this.progressLabel.setVisible(false);
        challengePane.getChildren().add(challengeLabel);
        challengePane.getChildren().add(progressLabel);
    }

    @Override
    public IObserver updateObserver(Taggable context) {
        if (context.toString().contains("Bus") && !active) {
            this.active = true;
            this.challengeLabel.setVisible(true);
            this.progressLabel.setVisible(true);
            return null;
        }
        if (!active || !context.toString().contains("Car")) {
            return null;
        }
        foundB = foundB || context.toString().contains("B");
        foundU = foundU || context.toString().contains("U");
        foundS = foundS || context.toString().contains("S");

        if(foundB && foundU && foundS) {
            this.progressLabel.setText(COMPLETE_LABEL);
            return this;
        } else {
            progress = (foundB ? "B" : "*") + (foundU ? "U" : "*") + (foundS ? "S" : "*");
            this.progressLabel.setText(PROGRESS_LABEL + progress);
        }
        return null;
    }
}
