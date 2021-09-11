package com.ControlRun;

import com.google.inject.Key;
import com.google.inject.Provides;
import javax.inject.Inject;

import jdk.nashorn.internal.runtime.options.Options;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


@Slf4j
@PluginDescriptor(
	name = "Old Control Run"
)
public class ControlRunPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ControlButtonListener controlButtonListener;

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(controlButtonListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(controlButtonListener);
	}

}
