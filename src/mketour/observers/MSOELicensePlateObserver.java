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

public class MSOELicensePlateObserver implements IObserver {

    private static final String CHALLENGE_LABEL = "Challenge: Find all the letters in MSOE\nGoal: MSOE";
    private static final String PROGRESS_LABEL = "Found: ";
    private static final String COMPLETE_LABEL = "MSOE CHALLENGE COMPLETED";
    private final Text progressLabel;
    private String progress;

    private boolean foundM = false;
    private boolean foundS = false;
    private boolean foundO = false;
    private boolean foundE = false;

    public MSOELicensePlateObserver(Pane challengePane) {
        this.progress = "****";
        Node challengeLabel = new Text(CHALLENGE_LABEL);
        this.progressLabel = new Text(PROGRESS_LABEL + progress);
        challengePane.getChildren().add(challengeLabel);
        challengePane.getChildren().add(progressLabel);
        challengePane.getChildren().add(new Text()); // Add a simple node for separation in pane
    }

    @Override
    public IObserver updateObserver(Taggable context) {
        if(!context.toString().contains("Car")) {
            return null;
        }
        foundM = foundM || context.toString().contains("M");
        foundS = foundS || context.toString().contains("S");
        foundO = foundO || context.toString().contains("O");
        foundE = foundE || context.toString().contains("E");

        if(foundM && foundS && foundO && foundE) {
            this.progressLabel.setText(COMPLETE_LABEL);
            return this;
        } else {
            progress = (foundM ? "M" : "*") + (foundS ? "S" : "*") + (foundO ? "O" : "*") + (foundE ? "E" : "*");
            this.progressLabel.setText(PROGRESS_LABEL + progress);
        }
        return null;
    }
}
