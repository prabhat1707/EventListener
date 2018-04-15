package com.trenzlr.eventlistener;

/**
 * Created by prabhat on 15/4/18.
 */

public class DataWrapper<T> {
    private T object;
    private String tag;

    public DataWrapper() {
    }

    DataWrapper(T object, String tag) {
        this.object = object;
        this.tag = tag;
    }

    public DataWrapper(T object) {
        this.object = object;

    }

    public T getObject() {
        return object;
    }

    public String getTag() {
        return tag;
    }
}
