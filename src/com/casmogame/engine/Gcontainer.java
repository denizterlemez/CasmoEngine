package com.casmogame.engine;
import java.awt.event.KeyEvent;
//CASMO GAME ENGİNE UWU OWO

import com.casmogame.engine.*;
public class Gcontainer implements Runnable{
	
	private Thread thread;
	private Window window;
	private Renderer renderer;
	private Input input;
	
	private AbstractGame game;
	private boolean running = false;
	private final double UPDATE_CAP = 1.0/120.0; // fps limiti için motor için 120 olarak koyulmuştur daha fazla konulursa dalgalanmalar olabilir
	private int width = 400, height = 400;
	private float scale = 3f;
	private String title = "casmo engine alpha";
	
	
	
	
	
	public  Gcontainer(AbstractGame game)
	{
		this.game = game;
		
	}
	public void start() {
		
		window = new Window(this);
		renderer = new Renderer(this);
		
		input = new Input(this);
		
		thread = new Thread(this);
		thread.run();
		
	}
	
	public void stop() {
		
	}
	
	public void run() {
	
		running = true;
		boolean render = false;
		double firsttime = 0;
		double lasttime =  System.nanoTime() / 1000000000.0;
		double passedtime = 0;
		double unprocessedtime = 0;
		
		double frametime =0;
		int frames = 0;
		int fps = 0;
		
		while(running) {
			render = false;
			firsttime = System.nanoTime() / 1000000000.0;
			passedtime = firsttime - lasttime;
			lasttime =  firsttime;
			unprocessedtime += passedtime;
			frametime += passedtime;
			
			while(unprocessedtime >= UPDATE_CAP) {
				unprocessedtime -= UPDATE_CAP;
				render = true;
				
				game.update(this, (float)UPDATE_CAP);
				
				
				input.update();
				
				if(frametime >= 1.0) {
					frametime = 0;
					fps = frames;
					frames = 0;
					
				}
			}
			if(render) {
				renderer.clear();
				game.render(this, renderer);
				renderer.drawText("FPS:"+ fps, 0, 0,0xff00ffff);// olmasada olur bura
				renderer.drawText("CASMO ENGİNE UWU OWO", 100, 0,0xff00ffff); // olmasada olur bura
				window.update();
				frames++;
				
		
				
			}else {
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
			
			
			
			
		}
		
		
	}
	
	
	public int getWidth() {
		// TODO Auto-generated method stub
		
		return width;
	}
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width = width;
	}
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		this.height = height;
	}
	public float getScale() {
		// TODO Auto-generated method stub
		return scale;
	}
	public void setScale(float scale) {
		// TODO Auto-generated method stub
		this.scale = scale;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
	
	public Window getWindow() {
		// TODO Auto-generated method stub
		return window;
	}
	
	public Input getInput() {
		// TODO Auto-generated method stub
		return input;
	}

}
