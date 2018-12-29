import com.orsonpdf.PDFGraphics2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LinePDF {

    private int xPos = 50;
	private int yPos = 50;
    private int xEnd = 20;
    private int yEnd = 20;
    
    LinePDF(int x, int y, int w, int h){
    	xPos = x;
    	yPos = y;
    	xEnd = w;
    	yEnd = h;
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

    public int getXEnd(){
        return xEnd;
    } 

    public int getYEnd(){ return yEnd; }

	public void setWidth(int width) {
		this.xEnd = width;
	}

	public void setHeight(int height) {
		this.yEnd = height;
	}

	public void paint(Graphics g) throws IOException {
        g.setColor(Color.BLACK);
        g.drawLine(xPos,yPos,getXEnd(),getYEnd());
        BufferedImage img=ImageIO.read(new File("images/duck.jpg"));
        g.drawImage(img, 100, 200, null);
    }

}
