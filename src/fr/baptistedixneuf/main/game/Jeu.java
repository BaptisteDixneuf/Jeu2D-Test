package fr.baptistedixneuf.main.game;

import org.lwjgl.opengl.GL11;


public class Jeu {
	public  Tuile sprite;
	public 	Image image;
	public int[] rgbs;

	public Jeu(){
		String cheminImage= "res/images.png";	
		int nbTuilesX=8;
		int nbTuilesY=8;
		sprite= new Tuile(cheminImage, nbTuilesX,nbTuilesY);
		image=new Image("res/images.png");
		rgbs= new int[image.largeur*image.hauteur];
		rgbs=image.rgbs;
		for(int i=0; i<rgbs.length; i++){
			if(rgbs[i]==0xFFff0000){
				System.out.println("couleur rouge");
			}else{
				//System.out.println("autre");
			}
		}
		
	}


	public void rendre(){


		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		for(int x=0; x<8; x++){
			for(int y=0; y<8; y++ ){
				sprite.rendre(x, y,x,y,32);
			}
		}
		
		

	}



}
