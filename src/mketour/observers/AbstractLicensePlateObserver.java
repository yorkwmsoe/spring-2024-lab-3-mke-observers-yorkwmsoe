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

import java.util.Arrays;

public abstract class AbstractLicensePlateObserver implements IObserver {

    protected final String CHALLENGE_LABEL;
    protected final String PROGRESS_LABEL = "Found: ";
    protected final String COMPLETE_LABEL;
    protected final Node challengeLabel;
    protected final Text progressLabel;
    private String progress;
    private final String target;
    private final boolean[] lettersFound;

    public AbstractLicensePlateObserver(Pane challengePane, String target) {
        this.CHALLENGE_LABEL = "Challenge: Find all the letters in "+ target + "\nGoal: " + target;
        this.COMPLETE_LABEL = target + " CHALLENGE COMPLETED";
        this.target = target;
        this.lettersFound = new boolean[target.length()];
        char[] stars = new char[target.length()];
        Arrays.fill(lettersFound, false);
        Arrays.fill(stars, '*');
        progress = new String(stars);

        this.challengeLabel = new Text(CHALLENGE_LABEL);
        this.progressLabel = new Text(PROGRESS_LABEL + progress);
        challengePane.getChildren().add(challengeLabel);
        challengePane.getChildren().add(progressLabel);
        challengePane.getChildren().add(new Text()); // Add a simple node for separation in pane
    }

    @Override
    public IObserver updateObserver(Taggable context) {
        return !context.toString().contains("Car") ? null : checkLicensePlateProgress(context);
    }

    private IObserver checkLicensePlateProgress(Taggable context) {
        boolean allTrue = lettersFound[0];
        progress = "";
        for(int i = 0; i < this.target.length(); i++) {
            this.lettersFound[i] = this.lettersFound[i] || context.toString().contains(this.target.charAt(i) + "");
            allTrue = allTrue && lettersFound[i];
            progress = progress.concat(lettersFound[i] ? this.target.charAt(i)+"" : "*");
        }
        if(allTrue) {
            this.progressLabel.setText(COMPLETE_LABEL);
            return this;
        } else {
            this.progressLabel.setText(PROGRESS_LABEL + progress);
            return null;
        }
    }
}