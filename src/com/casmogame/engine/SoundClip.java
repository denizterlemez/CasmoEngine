package com.casmogame.engine;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//CASMO GAME ENGİNE UWU OWO

public class SoundClip {
	
	private Clip clip;
	private FloatControl gainControl;
	
	
	public SoundClip(String path)
	{
		
			InputStream audioSrc;
			try {
				audioSrc = new FileInputStream(path);
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				
				AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn);
				AudioFormat baseFormat= ais.getFormat();
				AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
						                                   baseFormat.getSampleRate(),
						                                   16,
						                                   baseFormat.getChannels(),
						                                   baseFormat.getChannels() * 2,
						                                   baseFormat.getSampleRate(),
						                                   
						
						                                   false);
				
				
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais);
			
			clip = AudioSystem.getClip();
			clip.open(dais);
			gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
	}
	
	public void play()
	{
		if(clip == null)
			return;
		
		stop();
		clip.setFramePosition(0);
		while(!clip.isRunning())
		{
			clip.start();
		}
	}
	public void stop()
	{
		
		if(clip.isRunning())
			clip.stop();
		
	}
	public void close() // kapatma fonksiyonu background musicden başak bir müziğe geçmek için kullanılabilir
	{
		stop();
		clip.drain();
		clip.close();
	}
	public void loop() // adı üstünde döngüye sarmak amaç şu bir backgroudn song u hep loop a sokmak
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
	public void setVolume(float value) // ses şiddeti için -20 ile 6 arası bir değer girilmeli.
	{
		gainControl.setValue(value);
	}
	
	public boolean isRunning() // bu bir true false dır amaç sesin çalıştıgını kontrol etmektir
	{
		return clip.isRunning();
	}
	

}
