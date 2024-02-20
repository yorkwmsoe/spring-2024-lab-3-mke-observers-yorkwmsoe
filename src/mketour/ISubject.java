package mketour;

import java.util.HashSet;
import java.util.Set;

public abstract class ISubject {
    protected final Set<IObserver> observers;

    public ISubject() {
        this.observers = new HashSet<>();
    }

    public void attach(IObserver observer) {
        this.observers.add(observer);
    }

    public void detach(IObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(Taggable context) {
        for(IObserver observer : observers) {
            observer.updateObserver(context);
        }
    }
}
