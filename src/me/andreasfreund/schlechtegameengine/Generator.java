package me.andreasfreund.schlechtegameengine;

import me.andreasfreund.schlechtegameengine.world.World;

public interface Generator {
	void generateWorld(World world, SchlechteGameEngine engine);
}