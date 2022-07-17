package com.casmogame.engine;
//CASMO GAME ENGİNE UWU OWO
public class Font {
	
	public static final Font STANDARD = new Font("res/standard.png");
	
	
	private Image fontImage;
	private int[] offsets;
	private int[] widths;
	

	public Font(String path)
	{
		fontImage = new Image(path);
		offsets = new int[273];
		widths = new int[273];
		
		int unicode = 0;
		
		for(int i = 0; i < fontImage.getW(); i++)
		{
			if(fontImage.getP()[i] == 0xff0000ff) // fontsheet in backgroundını silmek için kullanılmıştır
			{
				offsets[unicode] = i;
			}
			
			if(fontImage.getP()[i] == 0xffffff00)
			{
				widths[unicode] = i - offsets[unicode];
				unicode++;
			}
			
			
		}
		
		
		
	}


	public Image getFontImage() {
		// TODO Auto-generated catch block
		return fontImage;
	}


	public void setFontImage(Image fontImage) {
		// TODO Auto-generated catch block
		this.fontImage = fontImage;
	}


	public int[] getOffsets() {
		// TODO Auto-generated catch block
		return offsets;
	}


	public void setOffsets(int[] offsets) {
		// TODO Auto-generated catch block
		this.offsets = offsets;
	}


	public int[] getWidths() {
		// TODO Auto-generated catch block
		return widths;
	}


	public void setWidths(int[] widths) {
		// TODO Auto-generated catch block
		this.widths = widths;
	}

}
