package me.andreasfreund.schlechtegameengine;

public class GameLoop extends Thread {

	private SchlechteGameEngine engine;

	public GameLoop(SchlechteGameEngine engine) {
		this.engine = engine;
		this.setPriority(MAX_PRIORITY);
	}

	public void run() {
		while (true) {
			engine.getWorld().tick(engine);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
