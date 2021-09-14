package com.ControlRun;

import com.google.inject.Key;
import com.google.inject.Provides;
import javax.inject.Inject;
import java.awt.event.KeyEvent;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.client.input.KeyListener;


public class ControlButtonListener implements KeyListener
{
    @Inject
    private Client client;

    int runState;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown())
        {
            runState = client.getVarpValue(173);
            if (runState == 1)
                e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
