package me.andreasfreund.schlechtegameengine;

public class GameLoop extends Thread {

	private SchlechteGameEngine engine;

	public GameLoop(SchlechteGameEngine engine) {
		this.engine = engine;
		this.setPriority(MAX_PRIORITY);
	}

	public void run() {
		long prevtime;
		while (true) {
			prevtime = System.currentTimeMillis();
			engine.getWorld().tick(engine);
			try {
				Thread.sleep(50 - System.currentTimeMillis() + prevtime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
