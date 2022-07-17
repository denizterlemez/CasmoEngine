package com.casmogame.game;
//CASMO GAME ENGİNE UWU OWO
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.casmogame.engine.*;

import java.awt.event.KeyEvent;


public class Game extends AbstractGame{
	
	// burdaki bazı komutlar boştur. //* olanlar boştur kendinzi gelip değiştirceginzidir
	
	private Imageanim image;//*
	
	
	private SoundClip clip;//*

	
	
	private Input input;//*

	
	
	
	public Game() {
		
		image = new Imageanim("res/xd.png", 120,80);//*
		clip = new SoundClip("res/31.wav");//*
		clip.setVolume(6);//*
		
		
		
	} 
	
	
	@Override
	public void update(Gcontainer gc,float dt) {
		
		if(gc.getInput().isKeyDown(KeyEvent.VK_A))//*
		{//*
			clip.play();//*
		}//*
		
		
		
	
		
		gecis += dt * 10;
		
		if(gecis > 3)
		{
			gecis = 0;
		}
		
	}
	
	float gecis = 0;
	
	@Override
	public void render(Gcontainer gc,Renderer r) {
		int a = 64;//*
		
		
		r.drawImageTile(image, gc.getInput().getMouseX() -12  , gc.getInput().getMouseY() -24, (int)gecis,0);//*
		
	
		
		
		

	}
		
		
		
		
	
	
	public static void main(String args[]) throws IOException {
		// TODO Auto-generated catch block

		

		Gcontainer gc = new Gcontainer(new Game());
		gc.start();
	}

	
	
}
