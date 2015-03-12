package me.andreasfreund.schlechtesgame;

import me.andreasfreund.schlechtegameengine.SchlechteGameEngine;
import me.andreasfreund.schlechtegameengine.display.TextureLoader;
import me.andreasfreund.schlechtegameengine.world.*;

public class Ghost extends AI implements Collidable{

	private int testiteration = 0;

	public Ghost() {
		super(TextureLoader.getTextureLoader().fetchSprites("ghost"));
	}
	
	public void tick(SchlechteGameEngine engine) {
		Player player = (Player)engine.getWorld().getByType(Player.class)[0];
		/*switch((int)(Math.random()*4){
		case 0:
			this.setX(this.getX()+1);
			break;
		case 1:
			this.setY(this.getY()+1);
			break;
		case 2:
			this.setX(this.getX()-1);
			break;
		case 3:
			this.setY(this.getY()-1);
			break;
		}*/
		if(this.testiteration <3){
			
		}else if(player.getX()!=this.getX()){
			this.setX(this.getX() + (player.getX()>this.getX()?1:-1));
		}else if(player.getY()!=this.getY()){
			this.setY(this.getY() + (player.getY()>this.getY()?1:-1));
		}else{
			player.setGhost(true);
		}
		this.testiteration++;
		if(this.testiteration>3){
			this.testiteration = 0;
		}
	}

	public boolean getCollidable() {
		return true;
	}

}
