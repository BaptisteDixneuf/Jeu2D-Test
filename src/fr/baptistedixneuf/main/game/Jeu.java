package fr.baptistedixneuf.main.game;

import java.awt.Font;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;




public class Jeu {
	public  Tuile sprite;
	public 	Image image;
	public int[] rgbs;
	public Boutton boutton;
	
	private TrueTypeFont font;
	
	/** Boolean flag on whether AntiAliasing is enabled or not */
	private boolean antiAlias = true;

	public Jeu(){
		String cheminImage= "res/spritesheet.png";	
		int nbTuilesX=16;
		int nbTuilesY=16;
		sprite= new Tuile(cheminImage, nbTuilesX,nbTuilesY);
		image=new Image("res/level_metal.png");
		rgbs= new int[image.largeur*image.hauteur];
		rgbs=image.rgbs;
		boutton =  new Boutton();
		boutton.addButton(300, 200, "res/boutton.png");
		
		
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, antiAlias);
		
	}


	public void rendre(){


		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		/*for(int x=0; x<8; x++){
			for(int y=0; y<8; y++ ){
				sprite.rendre(x, y,x,y,32);
			}
		}*/
		
		for(int i=0; i<rgbs.length; i++){
			int x=i%image.largeur;
			int y=i/image.largeur; 
			if(rgbs[i]==0xFF000000){
				sprite.rendre(0, 0,x,y,32);
			}else if(rgbs[i]==0xFF0026FF){
				sprite.rendre(8, 7,x,y,32);
			}
		}
		
		boutton.Draw();
		font.drawString(200, 50, "Baptiste Dixneuf - jeu 2d", Color.yellow);	
		
		
		

	}



}
