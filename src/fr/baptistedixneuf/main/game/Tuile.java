package fr.baptistedixneuf.main.game;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Tuile {

	private Texture texture;
	private float nbTuilesX;
	private float nbTuilesY;

	public Tuile(String chemin,float nbTuilesX,float nbTuilesY ) {

		try {
			// load texture from PNG file
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(chemin));
			
			
			
			System.out.println("Texture loaded: "+texture);
			System.out.println(">> Image width: "+texture.getImageWidth());
			System.out.println(">> Image height: "+texture.getImageHeight());
			System.out.println(">> Texture ID: "+texture.getTextureID());
		} catch (IOException e) {
			System.out.println("Prob image");
			e.printStackTrace();
		}
		
		this.nbTuilesX=nbTuilesX;
		this.nbTuilesY=nbTuilesY;
		
	}

	/**
	 * Charger une tuile d'une image
	 * 
	 */
	public void rendre(int xTuile, int yTuile, int xPlacement, int YPlacement, int taille) {
		float tailleTuileX= 1/nbTuilesX;
		float tailleTuileY= 1/nbTuilesY;
		int tailleTuileAffichageLargeurHauteur=taille;
		Color.white.bind();
		texture.bind(); 

		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(0+xTuile*tailleTuileX,0+yTuile*tailleTuileY);
		GL11.glVertex2f(0+xPlacement*tailleTuileAffichageLargeurHauteur,0+YPlacement*tailleTuileAffichageLargeurHauteur);

		GL11.glTexCoord2f(0+xTuile*tailleTuileX,tailleTuileY+yTuile*tailleTuileY);
		GL11.glVertex2f(0+xPlacement*tailleTuileAffichageLargeurHauteur,tailleTuileAffichageLargeurHauteur+YPlacement*tailleTuileAffichageLargeurHauteur);

		GL11.glTexCoord2f(tailleTuileX+xTuile*tailleTuileX,tailleTuileY+yTuile*tailleTuileY);
		GL11.glVertex2f(tailleTuileAffichageLargeurHauteur+xPlacement*tailleTuileAffichageLargeurHauteur,tailleTuileAffichageLargeurHauteur+YPlacement*tailleTuileAffichageLargeurHauteur);

		GL11.glTexCoord2f(tailleTuileX+xTuile*tailleTuileX,0+yTuile*tailleTuileY);
		GL11.glVertex2f(tailleTuileAffichageLargeurHauteur+xPlacement*tailleTuileAffichageLargeurHauteur,0+YPlacement*tailleTuileAffichageLargeurHauteur);

		GL11.glEnd();
	}
}
