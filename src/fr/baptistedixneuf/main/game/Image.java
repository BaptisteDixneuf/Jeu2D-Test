package fr.baptistedixneuf.main.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	public String chemin;
	public int largeur;
	public int hauteur;
	public BufferedImage image;
	public int[] rgbs;
	
	public Image(String chemin) {

		try {
			// get the BufferedImage, using the ImageIO class
			image = ImageIO.read(new File(chemin));
			largeur = image.getWidth();
		    hauteur = image.getHeight();
		    enregistrerPixelsImage();
			  
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void enregistrerPixelsImage(){
		rgbs = new int[largeur*hauteur]; /** on crée l'espace neccessaire */
		image.getRGB(0,0,largeur,hauteur,rgbs,0,largeur);
		
	}



	
}
