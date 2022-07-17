package com.casmogame.engine;
//CASMO GAME ENGİNE UWU OWO
import com.casmogame.engine.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener,MouseListener,MouseMotionListener,MouseWheelListener{
	
	private Gcontainer gc;
	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keyslast = new boolean[NUM_KEYS];
	
	private final int NUM_BUTTONS = 5;
	private boolean[] buttons = new boolean[NUM_BUTTONS];
	private boolean[] buttonslast = new boolean[NUM_BUTTONS];
	
	private int mouseX , mouseY;
	private int scroll;
	
	public Input(Gcontainer gc) {
		this.gc = gc;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseWheelListener(this);
		
	}
	
	public void update() {
		scroll =  0; // mouse tekerliginin inputunu almak içindir taa buna kadar yaptık
		for ( int i = 0; i < NUM_KEYS; i++) {
			keyslast[i] = keys[i];
		}
		for ( int i = 0; i < NUM_BUTTONS; i++) {
			buttonslast[i] = buttons[i];
		}
	}
	
	public boolean isKey(int keyCode) {
		return keys[keyCode];
	}
	
	public boolean isKeyUp (int keyCode) {
		return !keys[keyCode] && keyslast[keyCode];
	}
	
	public boolean isKeyDown (int keyCode) {
		return keys[keyCode] && !keyslast[keyCode];
	}
	
	
	
	public boolean isButton (int button) {
		return buttons[button];
	}
	
	public boolean isButtonUp (int button) {
		return !buttons[button] && buttonslast[button];
	}
	
	public boolean isButtonDown (int button) {
		return buttons[button] && !buttonslast[button];
	}
	

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		scroll = e.getWheelRotation();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY()/gc.getScale());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY()/gc.getScale());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
		
	}

	public int getMouseX() {
		// TODO Auto-generated method stub
		return mouseX;
	}

	public int getMouseY() {
		// TODO Auto-generated method stub
		return mouseY;
	}

	public int getScroll() {
		// TODO Auto-generated method stub
		return scroll;
	}

}
