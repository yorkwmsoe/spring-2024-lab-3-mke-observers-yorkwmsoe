/*
 * Course:     SWE 2410
 * Assignment: MKETour
 * Author:     Dr. Yoder and Billy York
 */
package mketour.observers;

import javafx.scene.layout.Pane;

public class OtherMSOELicensePlateObserver extends AbstractLicensePlateObserver {
    public OtherMSOELicensePlateObserver(Pane challengePane) {
        super(challengePane, "MSOE");
    }
}
