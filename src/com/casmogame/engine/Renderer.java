package com.casmogame.engine;

import com.casmogame.engine.*;

import com.casmogame.engine.Font;
import com.casmogame.engine.Image;

import java.awt.font.*;
import java.awt.*;
//CASMO GAME ENGİNE UWU OWO



import java.awt.image.DataBufferInt;

public class Renderer {
	private int pw,ph;
	private int[] p;
	private Font font = Font.STANDARD;
	
	
	public Renderer(Gcontainer gc) {
		
		pw = gc.getWidth();
		ph = gc.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
		
		
	}
	
	public void clear() { // bu kodun amacı drawImage ve fonksiyonundaki bug ı düzeltmek içindir sadece 1 resmin oluşturulması içindir çünkü wasd movement gibi olaylarda biz çizim oyunu gibi hep etrafta duruyor
		for(int i = 0; i < p.length; i++) 
		{
			p[i]  = 0;
			
		}
	}
	
	
	public void setPixel(int x,int y, int value)
	{
		if((x < 0 || x >= pw ||y < 0 || y >= ph) || value == 0xffff00ff )
		{
			return;
		}
		
		p[x+y * pw] = value;
		
		
	}
	
	
	public void drawText(String text , int offX, int offY, int color)
	{
		
		Image fontImage = font.getFontImage();
		text = text.toUpperCase();
		int offset = 0;
		
		for(int i = 0; i < text.length(); i++)
		{
			int unicode = text.codePointAt(i) -32;
			
			for ( int y = 0; y < fontImage.getH(); y++)
			{
				for(int x = 0; x < font.getWidths()[unicode]; x++)
				{
					
					if(font.getFontImage().getP()[(x+font.getOffsets()[unicode]) + y *font.getFontImage().getW()] == 0xffffffff)
					{
						setPixel(x+offX+offset, y+offY, color);
					}
					
				}
			}
			offset += font.getWidths()[unicode];
			
			
		}
	
		
		
	}
	
	

	
	
	public void drawImage(Image image, int offX, int offY)
	{
		
		
		if(offX < -image.getW()) return;
		if(offY < -image.getH()) return;
		if(offX >= pw) return;
		if(offY >=  ph) return;
		
		
	
		
		
		
		int newX = 0;
		int newY = 0;
		
		int newWidth = image.getW();
		int newHeight = image.getH();
		
		
		if(offX < -newWidth) return;
		if(offY < -newHeight) return;
		if(offX >= pw) return;
		if(offY >=  ph) return;
		
		
		
	
		
		
		
		
		if(offX <0){newX -= offX;}
		if(offY <0){newY -= offY;}
			
		
		
		
		
		if(newWidth + offX >= pw ){newWidth -= newWidth + offX - pw;}
		if(newHeight + offY >= ph ){newHeight -= newHeight + offY - ph;}
		
		
		for(int y = newY; y < newHeight; y++)
		{
			for(int x = newX; x < newWidth; x++)
			{
				setPixel(x+ offX,y+offY, image.getP()[x+y * image.getW()]);
				
			}
		}
	}
	
    public void drawImageTile(Imageanim image, int offX, int offY, int tileX,int tileY)
    {
    	
    	
		if(offX < -image.getanimW()) return;
		if(offY < -image.getanimH()) return;
		if(offX >= pw) return;
		if(offY >=  ph) return;
		
    	
		
		
		int newX = 0;
		int newY = 0;
		
		int newWidth = image.getanimW();
		int newHeight = image.getanimH();
		if(offX < -newWidth) return;
		if(offY < -newHeight) return;
		if(offX >= pw) return;
		if(offY >=  ph) return;
	
		
		
		
		
	
		
		
		
		
		if(offX <0)
		{
			newX -= offX;
		}
		
		if(offY <0)
		{
			newY -= offY;
			
		}
			
		
		
		
		
		
		if(newWidth + offX >= pw )
		{
			newWidth -= newWidth + offX - pw;
		
		}
		if(newHeight + offX >= ph )
		{
			newHeight -= newHeight + offY - ph;
			
		}
		
		
		for(int y = newY; y < newHeight; y++)
		{
			for(int x = newX; x < newWidth; x++)
			{
				setPixel(x+ offX,y+offY, image.getP()[(x+ tileX * image.getanimW())+ (y + tileY * image.getanimH()) * image.getW()]); 
				/*
				 bir bug var ekranın windowun width ve height ve scale in çarpımı sonucu oluşan değerden daha fazlabir değer çıkıyor bu %10 olasılıkla olur bu durumu
				 düzeltmek için width ve height veya scale i arttırın. veya azaltın.
				 */
				
			}
		}
    }

}
