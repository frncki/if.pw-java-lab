package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Prostokat {

    private List<BufferedImage> obrazy = new ArrayList<BufferedImage>();

    private int xPos = 50;
	private int yPos = 50;
    private int width = 20;
    private int height = 20;
    private int vX = 10;
    private int vY = 5;
    private Color color = Color.BLACK;
    private boolean gif = false;
    private int i = 0;

    public void setObrazy(List<BufferedImage> obrazy)
    {
        this.obrazy = obrazy;
        this.gif = true;

    }
    
    public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public int getvX() {
        return vX;
    }

    public int getvY() {
        return vY;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }


	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void paint(Graphics g){
        if(gif)
        {
            g.drawImage(obrazy.get(i),xPos, yPos, null);
            if (i<7) i++;
            if (i==7) i=0;
        }
        else
        {
          g.setColor(getColor());
          g.fillRect(xPos,yPos,getWidth(),getHeight());
        }

    }

}
