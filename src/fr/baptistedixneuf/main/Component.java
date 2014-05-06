package fr.baptistedixneuf.main;




import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;





import fr.baptistedixneuf.main.game.Jeu;





public class Component {

	public boolean AffichageFenetre = false;
	public static String title = "Baptiste Dixneuf Jeu 2D";
	public static int largeur=1024;
	public static int hauteur=640;
	public Jeu jeu;


	DisplayMode mode = new DisplayMode(largeur, hauteur);

	public  Component(){
		try {
			Display.setDisplayMode(new DisplayMode(largeur,hauteur));
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		initGL(largeur,hauteur);
		jeu= new Jeu();

	}

	public void demarer(){
		AffichageFenetre=true;
		boucleAffichage();
	}


	public void boucleAffichage(){
		while(AffichageFenetre){
			if(Display.isCloseRequested()){
				arreter();
			}

			rendre();
			Display.update();
		}
		fermer();
	}

	private void rendre(){

		jeu.rendre();
		

	}

	private void initGL(int largeur, int hauteur) {

		GL11.glEnable(GL11.GL_TEXTURE_2D);               

		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          

		// enable alpha blending
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0,0,largeur,hauteur);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, largeur, hauteur, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);


	}



	public void arreter(){
		AffichageFenetre=false;
	}

	public void fermer(){
		Display.destroy();
		System.exit(0);
	}



}
