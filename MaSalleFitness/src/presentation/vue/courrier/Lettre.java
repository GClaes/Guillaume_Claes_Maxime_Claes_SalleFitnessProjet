package presentation.vue.courrier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Lettre {
    private int posX;
    private int posY;
    private boolean visible = true;
    private Image image;


    public Lettre(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        try{
            image = ImageIO.read(new File("enveloppe.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void avancer(){
        posX+= 30;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean isVisible(){
        return visible;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public Image getImage() {
        return image;
    }
}
