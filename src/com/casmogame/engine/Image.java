package com.casmogame.engine;
//CASMO GAME ENGİNE UWU OWO

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
	
	private int w,h;
	private int[] p;
	
	public Image(String path) {
		BufferedImage image = null;
		
		
		
		try {
			image = ImageIO.read(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		w = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0, 0, w, h, null, 0, w);
		
		image.flush();
		
		
	}

	public int getW() {
		// TODO Auto-generated method stub
		return w;
	}

	public void setW(int w) {
		// TODO Auto-generated method stub
		this.w = w;
	}


	public void setH(int h) {
		// TODO Auto-generated method stub
		this.h = h;
	}

	public int[] getP() {
		// TODO Auto-generated method stub
		return p;
	}

	public void setP(int[] p) {
		// TODO Auto-generated method stub
		this.p = p;
	}

	public int getH() {
		// TODO Auto-generated method stub
		return h;
	}

}
