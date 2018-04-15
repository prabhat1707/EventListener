package com.trenzlr.eventlistener;

/**
 * Created by prabhat on 15/4/18.
 */

public interface Updatable<T> {

    void EventListenerCallback(T objectDataWrapper);
}
