package com.casmogame.engine;
//CASMO GAME ENGİNE UWU OWO
public class Imageanim  extends Image
{
	
	private int animW, animH;
	
	public Imageanim(String path, int tileW, int tileH)
	{
		super(path);
		this.animW = animW;
		this.animH = animH;
	}

	public int getanimW() {
		return animW;
	}

	public void setanimW(int animW) {
		this.animW =animW;
	}

	public int getanimH() {
		return animH;
	}

	public void setTileH(int animH) {
		this.animH = animH;
	}
	

}
