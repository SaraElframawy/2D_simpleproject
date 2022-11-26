import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int panel_WIDTH=500;
    final int panel_HIEGHT=500;
    Image anime;
    Image backgroundImage;
    Timer timer;
    int xVelocity=2;
    int yVelocity=1;
    int x =0;
    int y =0;

    MyPanel(){
        this.setPreferredSize(new Dimension(panel_WIDTH,panel_HIEGHT));
        this.setBackground(Color.BLACK);
        anime = new ImageIcon("anime.jpg").getImage();
        backgroundImage = new ImageIcon("spacee.jpg").getImage();
        timer = new Timer(10,this); //referring to action listener interface
        timer.start();

    }
    public void paint (Graphics g){
        super.paint(g); //background to black
        Graphics2D g2D= (Graphics2D) g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(anime,x,y,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x>=panel_WIDTH-anime.getWidth(null) || x<0){
            xVelocity=xVelocity*-1;
        }
      /*  if(x<=0){
            xVelocity=xVelocity+1;
        }*/


           x=x+xVelocity;
        if(y>panel_HIEGHT-anime.getHeight(null)|| y<0){
            yVelocity=yVelocity*-1;

        }
        y=y+yVelocity;
        repaint();//will recall the paint method

    }
}
