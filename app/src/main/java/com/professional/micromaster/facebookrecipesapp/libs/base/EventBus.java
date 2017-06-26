package com.professional.micromaster.facebookrecipesapp.libs.base;

/**
 * Created by Roberto on 26/06/17.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
