package shouse.core.controller;

/**
 * Created by Maks on 11.05.2018.
 */
public interface Controller extends Runnable {

    void start();

    void stop();
}
