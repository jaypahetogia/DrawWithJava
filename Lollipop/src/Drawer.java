import ecs100.*;
import java.awt.Color;

public class Drawer {
	public static final double HOUSE_WD = 46;
	public static final double x = 5;
	public static final double y =3;
	public static final double size = 1;
	public static final double stick = 2;
	/** Constructor: Set up interface */
	public Drawer() {
		UI.addButton("Draw it", this::drawLots);
		UI.addButton("Draw custom", this::drawCustom);
		UI.addButton("Draw Street", this::drawStreet);
		UI.setMouseListener(this::jam);
		UI.setWindowSize(20, 20);
	}	
	public void jam(String yes, double x, double y) {
		Color rc = new Color((int)(Math.random()*(1<<24)));
		this.drawHouse(x, y, x, rc);
	
	}
	public void drawStreet() {
		this.drawHouse(50,400, 50 + Math.random()*70, Color.red);
		this.drawHouse(100,400, 50 + Math.random()*70, Color.blue);
		this.drawHouse(150,400, 50 + Math.random()*70, Color.pink);
		this.drawHouse(200,400, 50 + Math.random()*70, Color.magenta);
		this.drawHouse(250,400, 50 + Math.random()*70, Color.cyan);
		this.drawHouse(300,400, 50 + Math.random()*70, Color.green);
		this.drawHouse(350,400, 50 + Math.random()*70, Color.orange);
		this.drawHouse(400,400, 50 + Math.random()*70, Color.magenta);
		this.drawHouse(450,400, 50 + Math.random()*70, Color.red);
		this.drawHouse(500,400, 50 + Math.random()*70, Color.blue);
	}	
	public void drawHouse(double mid, double bot, double ht, Color mack) {
		double left = mid - HOUSE_WD/2.0;
		double right = mid + HOUSE_WD/2.0;
		double top = bot - ht;
		double tip = top - HOUSE_WD*0.7;
		UI.setColor(mack);
		UI.drawRect(left, top, HOUSE_WD, ht);
		UI.drawLine(left, top, mid, tip);
		UI.drawLine(right, top, mid, tip);
		//draw windows
		double winL = mid - HOUSE_WD*0.25;
		double winR = mid + HOUSE_WD*0.25;
		double winWd = HOUSE_WD*0.33;
		double lev1 = bot - ht*0.25;
		double lev2 = bot - ht*0.75;
		this.drawWindow(winL, lev1, winWd);
		this.drawWindow(winR, lev1, winWd);
		this.drawWindow(winL, lev2, winWd);
		this.drawWindow(winR, lev2, winWd);
		//draw garden
		this.drawLollipop(left, bot, 8, 20, Color.red);
		this.drawLollipop(left+10, bot, 8, 20, Color.blue);
		this.drawLollipop(left+20, bot, 8, 20, Color.yellow);
		this.drawLollipop(left+30, bot, 8, 20, Color.green);
		this.drawLollipop(left+40, bot, 8, 20, Color.magenta);
		
	}
	public void drawWindow(double midX, double midY, double sz) {
		double rad = sz/2;
		UI.drawRect(midX-rad, midY-rad, sz, sz);
		UI.drawLine(midX-rad, midY, midX+rad, midY);
		UI.drawLine(midX, midY-rad, midX, midY+rad);
	}
	public void drawCustom() {
		double x = UI.askDouble("line width");
		double y = UI.askDouble("height");
		double size = UI.askDouble("size");
		double stick = UI.askDouble("stick");
		this.drawLollipop(x, y, size, stick, null);
	}
	public void drawLots() {
		this.drawLollipop(30, 400, 8, 20, Color.red);
		this.drawLollipop(50, 400, 40, 90, Color.blue);
		this.drawLollipop(400, 400, 90, 70, Color.orange);
	}
	public void drawLollipop(double x, double y, double size, double stick, Color mack) {
		UI.setColor(Color.black);
		UI.setLineWidth(1);//set line width to 10
		UI.drawLine(x, y, x, y + stick);// draw line (300,200) to (300,400)
		UI.setLineWidth(1);// set line width to 
		UI.setColor(mack);// set colour to red
		UI.fillOval(x-size/2, y-size/2, size, size);// fill oval at  (260, 160) that is 80x80
	}
	
	public static void main(String[] args) {
		UI.initialise();
		new Drawer();
	}
}
