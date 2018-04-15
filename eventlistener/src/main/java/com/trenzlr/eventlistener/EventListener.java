package com.trenzlr.eventlistener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prabhat on 15/4/18.
 */

public class EventListener {
    private static final EventListener ourInstance = new EventListener();
    private Object dataBean = null;
    private String tag = null;
    private List<Updatable> listeners = new ArrayList<>();

    private EventListener() {
    }

    public static EventListener getInstance() {
        return ourInstance;
    }

    public void post(Object dataBean, String tag) {
        this.dataBean = dataBean;
        this.tag = tag;
        addListener();
    }


    public void post(String tag) {
        this.tag = tag;
        addListener();
    }

    public void post() {
        addListener();
    }

    public void registerListener(Updatable listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unregisterListener(Updatable listener) {
        if (listener != null && listeners.contains(listener)) {
            listeners.remove(listeners.indexOf(listener));
        }
    }

    @SuppressWarnings("unchecked")
    private void addListener() {
        for (Updatable listener : listeners) {
            try {
                listener.EventListenerCallback(new DataWrapper<>(dataBean, tag));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
