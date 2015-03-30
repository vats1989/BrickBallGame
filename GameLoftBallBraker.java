
/*


bitwise use for hardware implementation and using it we can perform 
fast calculation and also it consumes less memory..
Java's bitwise operators operate on individual bits of integer 
(int and long) values. If an operand is shorter than an int, 
it is promoted to int before doing the operations.
It helps to know how integers are represented in binary. 
For example the decimal number 3 is represented as 11 in binary 
and the decimal number 5 is represented as 101 in binary. 
Negative integers are store in two's complement form. 
For example, -4 is 1111 1111 1111 1111 1111 1111 1111 1100.



A class that implements Runnable is not a thread and just a class. 
For a Runnable to become a Thread, You need to create an instance of 
Thread and passing itself in as the target.

In most cases, the Runnable interface should be used if you are only 
planning to override the run() method and no other Thread methods. 
This is important because classes should not be subclassed unless the 
programmer intends on modifying or enhancing the fundamental behavior of the class.

When there is a need to extend a superclass, implementing the 
Runnable interface is more appropriate than using the Thread class. 
Because we can extend another class while implementing Runnable 
interface to make a thread. But if we just extend the Thread class 
we can't inherit from any other class.

 A Java Thread controls the main path of execution in an application. 
 When you invoke the Java Virtual Machine with the java command, 
 it creates an implicit thread in which to execute the main() method. 
 The Thread class provides a mechanism for the first thread to start-up 
 other threads to run in parallel with it.

The Runnable interface defines a type of class that can be run by a thread. 
The only method it requires is run(), which makes the interface very easy to 
fulfil by extending existing classes. A runnable class may have custom 
constructors and any number of other methods for configuration and manipulation.


*/


import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

/*
Class for Start window 
*/


class StartWindow extends JFrame implements Runnable,KeyListener
{
int x,y,x1,y1,bll,brickscore=0;
JPanel p1,p2,p3,p4;
Font f;
JFrame jf;
Label ballbrick,start,help,exit;
JLabel img1,img2,name,paddle,ball,liferemain,score;
Thread t;
JLabel[] balllife=new JLabel[3];
ImageIcon icon;
StartWindow(String s,int bl)
{
t=new Thread(this); ///Thread for moving of ball
bll=bl;
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); ///getting screen size
x=dim.width;  /// width of screen
y=dim.height; /// height of screen

x1=x/2; y1=3*y/4;	/// set size of start window

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

this.setTitle(s);
this.setLayout(null);
this.setLocation(x/4,y/8);
this.setSize(x1,y1);
this.setResizable(false);
this.setBackground(Color.DARK_GRAY);

/// panel of start window

p1=new JPanel();
p1.setLayout(null);
p1.setBounds(0,0,x1,y1);
p1.setBackground(Color.DARK_GRAY);

/// panel p2 ,p3 ,p4 are for next window

p2=new JPanel();
p2.setLayout(null);
p2.setBounds(5,5,x1-15,y1/10);
p2.setBackground(Color.DARK_GRAY);
p2.setVisible(false);

p3=new JPanel();
p3.setLayout(null);
p3.setBounds(5,y1/10,x1-15,y1/2+y1/4);
p3.setBackground(Color.GRAY);
p3.setVisible(false);

p4=new JPanel();
p4.setLayout(null);
p4.setBounds(5,y1/2+y1/5+10,x1-15,y1-15);
p4.setBackground(Color.DARK_GRAY);
p4.setVisible(false);

/// Main label in start window

f=new Font("Arial",Font.BOLD,25);
ballbrick=new Label("WELCOME TO BALL BRAKER",Label.CENTER);	
ballbrick.setFont(f);									
ballbrick.setForeground(Color.white);
ballbrick.setBounds(0,y1/12,x1-6,20);	

///Start game label

start=new Label("START GAME",Label.CENTER);
start.setFont(f);
start.setForeground(Color.RED);
start.setBounds(0,y1/6,x1-6,20);
start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

///Help game label.

help=new Label("HELP",Label.CENTER);
help.setFont(f);
help.setForeground(Color.RED);
help.setBounds(0,y1/4,x1-6,20);
help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

///Exit Label for exit game

exit=new Label("EXIT GAME",Label.CENTER);
exit.setFont(f);
exit.setForeground(Color.RED);
exit.setBounds(0,y1/3,x1-6,20);
exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

/// Icon of Big Puddle

icon=new ImageIcon("Picture1.png");
img1=new JLabel(icon);
img1.setBounds(20,270,40,35);
p1.add(img1);

/// Label of Big Puddle

name=new JLabel("BIG PUDDLE");
name.setBounds(80,263,100,50);
name.setForeground(Color.white);
p1.add(name);

/// Icon of Small Puddle

icon=new ImageIcon("Picture2.png");
img1=new JLabel(icon);
img1.setBounds(20,310,40,35);
p1.add(img1);

///Label of Small Puddle

name=new JLabel("SMALL PUDDLE");
name.setBounds(80,303,100,50);
name.setForeground(Color.white);
p1.add(name);

/// Icon of Mega Ball

icon=new ImageIcon("Picture3.png");
img1=new JLabel(icon);
img1.setBounds(20,350,40,35);
p1.add(img1);

/// Label of Mega Ball

name=new JLabel("MEGA BALL");
name.setBounds(80,343,100,50);
name.setForeground(Color.white);
p1.add(name);

/// Icon of Bomb

icon=new ImageIcon("Picture4.png");
img1=new JLabel(icon);
img1.setBounds(20,390,40,35);
p1.add(img1);

/// Label of Bomb

name=new JLabel("BOMB");
name.setBounds(80,383,100,50);
name.setForeground(Color.white);
p1.add(name);

/// Icon of Weapon

icon=new ImageIcon("Picture5.png");
img1=new JLabel(icon);
img1.setBounds(20,430,40,35);
p1.add(img1);

/// Label of weapon

name=new JLabel("WEAPON");
name.setBounds(80,423,100,50);
name.setForeground(Color.white);
p1.add(name);

p1.add(ballbrick);p1.add(start);p1.add(help);p1.add(exit);

/// Image of puddle

icon=new ImageIcon("s1.png");
paddle=new JLabel(icon);
paddle.setBounds(((x1-10)/2)-30,(3*(y1+5)/4)-30,65,30);
p3.add(paddle);
addKeyListener(this);

/// Image of Ball

icon=new ImageIcon("megaball.png");
ball=new JLabel(icon);
ball.setBounds((x1-10)/2-5,(3*(y1+5)/4)-43,25,25);
p3.add(ball);

/// Image of 3 balls which indicate no of life remainings.

icon=new ImageIcon("Picture3.png");

/// Label of score

score=new JLabel("SCORE : ");
score.setBounds(x1/10-50,y1/10-45,300,30);
score.setFont(f);
score.setForeground(Color.red);
p2.add(score);

/// Label of life remaining

liferemain=new JLabel("LIFE REMAINING :");
liferemain.setBounds(x1/10+150,y1/10-45,220,30);
liferemain.setFont(f);
liferemain.setForeground(Color.red);
liferemain.setVisible(true);
p2.add(liferemain);

for(int l=0;l<3;l++)
{
balllife[l]=new JLabel(icon);
balllife[l].setBounds(x1/2+120+(l*50),y1/10-45,50,35);
p2.add(balllife[l]);
}

this.add(p1);this.add(p2);this.add(p3);this.add(p4);
jf=this;
start.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
p1.setVisible(false);
p2.setVisible(true);
p3.setVisible(true);
p4.setVisible(true);
BallMovement bm=new BallMovement(jf,p2,p3,p4,x1,y1,paddle,ball,score,balllife,bll,0,brickscore);
}
});  

help.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{

Help b=new Help(x1,y1);
b.setLocation(x/4,y/8);
b.setSize(x1,y1);
b.setResizable(false);
b.setVisible(true);
}
});  

exit.addMouseListener(new MouseAdapter()   //clicked, entered,exited,pressed,released
{
public void mouseClicked(MouseEvent me)
{System.exit(0);
}
});  
t.start();
}
public void keyPressed(KeyEvent ke)
{
Dimension dd=paddle.getSize();
int keycode = ke.getKeyCode();
if (keycode == KeyEvent.VK_LEFT) 		/// Move The Puddle in Left Direction.
	{
	int pos=paddle.getX();     // for special keys --use their virtual key codes
		if(pos<10)
		{}
		else
		pos-=40;
	paddle.setBounds(pos,(3*(y1+5)/4)-30,dd.width,30);  
	} 
	else if (keycode == KeyEvent.VK_RIGHT) 	/// Move The Puddle in Right Direction.
	{
	int pos=paddle.getX();
		if((pos+dd.width)>(x1-25)-10)
		{}
		else
		pos+=40;
	paddle.setBounds(pos,(3*(y1+5)/4)-30,dd.width,30); 
	} 
	else if (keycode == KeyEvent.VK_SPACE) 
	{
		
	}
	else if (keycode == KeyEvent.VK_ENTER) 		/// Enter Key 
	{
	}
}
public void keyReleased(KeyEvent ke) 
{}   
public void keyTyped(KeyEvent ke) 
{}

	public void run()
	{

	/// Movement of Ball in Start Window
	
			int dx=10,dy=500,dp=1,dq=-1;
			icon=new ImageIcon("megaball.png");	
			f=new Font("Arial",Font.BOLD,25);
			img1=new JLabel(icon);
			p1.add(img1);
			img1.setVisible(true);
			
			while(true)
			{
				if(dx<6)
				dp=-dp;
				if(dx>=x1-10)
				dp=-dp;
				if(dy<6)
				dq=-dq;
				if(dy>=y1-30)
				dq=-dq;
				
				dx=dx+dp;
				dy=dy+dq;
				
				img1.setBounds(dx,dy,25,25);
				try
				{Thread.sleep(5);}
				catch(Exception e){}
			}

	}
}

/*
BallMovement is Thread class

*/

class BallMovement implements Runnable
{
Thread t;
JFrame jf;
Font f;
Dimension d;
Boolean enable=true;
JPanel p2,p3,p4; 
int x1,y1,dx,dy,dp=1,dq=-1,st=0,count=0,p=0,q=0,fp,fq,len=10,wid=10,blife,brokenbrick=0,stop=1;
JLabel paddle,ball,ready,score,gameover;
Label bullet,complete;
Label[] brick=new Label[80];
int brickx[]=new int[80];
int bricky[]=new int[80];
JLabel[] balllife=new JLabel[3];
int brickscore=0,blen,bwid,paddlex,paddley,finish=0,plen,pwid,slp=5,speed=5,gun=0,bulletx,bullety;
BallMovement(JFrame jf,JPanel p2,JPanel p3,JPanel p4,int x1,int y1,JLabel pad,JLabel b,JLabel s,JLabel[] life,int bll,int st,int brickscore)
{
t=new Thread(this);
this.jf=jf;
this.p2=p2;
this.p3=p3;
this.p4=p4;
this.x1=x1;
this.y1=y1;
this.st=st;
blife=bll;
score=s;
this.brickscore=brickscore;
balllife=life;
paddle=pad;
ball=b;

/// Get the Size of P3 main Panel

d=p3.getSize();

f=new Font("Arial",Font.BOLD,25);

/// Get ready label

ready=new JLabel("GET READY");
ready.setBounds(x1/2-80,y1/2-30,200,30);
ready.setFont(f);
ready.setForeground(Color.yellow);

/// Bullet Lable

bullet=new Label();									
bullet.setBackground(Color.white);					
bullet.setBounds(paddle.getX()+32,paddle.getY(),2,3);
bullet.setVisible(false);							
p3.add(bullet);

///  Game Over Label

gameover=new JLabel("GAME OVER");
gameover.setBounds(x1/2-80,y1/2-30,200,30);
gameover.setFont(f);
gameover.setForeground(Color.yellow);
gameover.setVisible(false);

/// Game Complete Label

complete=new Label("GAME COMPLETE",Label.CENTER);
complete.setFont(f);										
complete.setBounds(x1/2-50,y1/2-30,250,30);
complete.setForeground(Color.yellow);
complete.setVisible(false);


p3.removeAll();
p3.validate();
p3.repaint();
p3.add(paddle);
p3.add(ball);
p3.add(ready);
p3.add(gameover);
p2.add(score);
gamestage(st);

for(int l=0;l<3;l++)
{
p2.add(balllife[l]);
}

p3.setVisible(true);
p2.setVisible(true);
p4.setVisible(true);
if(stop==1)
t.start();     ///      Ball Thread Start

}


void gamestage(int st)
{
if(st==0)
{
speed=10;
brickpattern1();		 ///  Stage 1 Start
}
if(st==1)
{speed=9;
brickpattern2();         ///  Stage 2 start
}
if(st==2)
{
speed=8;
brickpattern3();  		 ///  Stage 3 start
}
if(st==3)
{
speed=7;
brickpattern4();
}
}

void brickpattern1()		 ///   BrickStructure in Stage 1
{
int abc[]={2,6,10,12,12,10,6,2};
int i=0;
while(i<8)
{
	for(int j=0;j<abc[i]/2;j++)
	{
	brick[count]=new Label();
	brick[count].setBounds(((d.width-10)/2)+5+(45*j),30+(23*i),40,15);
	brick[count].setBackground(Color.yellow);
	p3.add(brick[count++]);
	}
	
	for(int j=0;j<abc[i]/2;j++)
	{
	brick[count]=new Label();
	brick[count].setBounds(((d.width-10)/2)-(45*(j+1)),30+(23*i),40,15);
	brick[count].setBackground(Color.yellow);
	p3.add(brick[count++]);
	}
i++;
}
}


void brickpattern2()  	 ///   BrickStructure in Stage 2
{

for(int i=0;i<6;i++)
{
	for(int j=0;j<6;j++)
	{
	brick[count]=new Label();
	brick[count].setBounds(((d.width-10)/2-20)-(45*(j+1)),30+(23*i),40,15);
	brick[count].setBackground(Color.yellow);
	p3.add(brick[count++]);
	}
}


for(int i=0;i<6;i++)
{
	for(int j=0;j<6;j++)
	{
	brick[count]=new Label();
	brick[count].setBounds(((d.width-10)/2)+(45*(j+1)),30+(23*i),40,15);
	brick[count].setBackground(Color.yellow);
	p3.add(brick[count++]);
	}
}
	
}

void brickpattern4()		 ///   BrickStructure in Stage 4
{
int a[][]={{0,0},{0,1},{0,3},{0,4},{0,5},{0,7},{0,8},{0,9},{0,11},{0,12},{0,13},
			{1,0},{1,4},{1,7},{1,9},{1,11},{1,13},
			{2,0},{2,4},{2,7},{2,9},{2,11},{2,13},
			{3,0},{3,1},{3,4},{3,7},{3,8},{3,9},{3,11},{3,12},
			{4,1},{4,4},{4,7},{4,9},{4,11},{4,13},
			{5,1},{5,4},{5,7},{5,9},{5,11},{5,13},
			{6,0},{6,1},{6,4},{6,7},{6,9},{6,11},{6,13},
			{8,0},{8,1},{8,2},{8,3},{8,4},{8,5},{8,6},{8,7},{8,8},{8,9},{8,10},{8,11},{8,12},{8,13},
			{9,0},{9,1},{9,2},{9,3},{9,4},{9,5},{9,6},{9,7},{9,8},{9,9},{9,10},{9,11},{9,12},{9,13}};

int i=0;
while(i<a.length)
{
brick[count]=new Label();
brick[count].setBounds(21+(42*a[i][1]),25+(20*a[i][0]),40,15);

if(a[i][0]>7)
{
if(a[i][1]%2==0)
brick[count].setBackground(Color.gray);
else
brick[count].setBackground(Color.blue);
}
else
brick[count].setBackground(Color.orange);

p3.add(brick[count++]);
i++;
}
}

void brickpattern3()		///   BrickStructure in Stage 3
{
int i=0;
	while(i<4)
	{
		for(int j=0;j<7;j++)
		{
		brick[count]=new Label();
		brick[count].setBounds(30+(j*80),18+(i*46),40,15);
			if(i%2==0)
			{
			if(j%2==0)
			brick[count].setBackground(Color.orange);
			else
			brick[count].setBackground(Color.blue);
			}
			else
			{
			if(j%2!=0)
			brick[count].setBackground(Color.orange);
			else
			brick[count].setBackground(Color.blue);
			}
		p3.add(brick[count++]);
		}
		for(int j=0;j<7;j++)
		{
		brick[count]=new Label();
		brick[count].setBounds(70+(80*j),41+(i*46),40,15);
			if(i%2==0)
			{
			if(j%2==0)
			brick[count].setBackground(Color.orange);
			else
			brick[count].setBackground(Color.blue);
			}
			else
			{
			if(j%2!=0)
			brick[count].setBackground(Color.orange);
			else
			brick[count].setBackground(Color.blue);
			}
		p3.add(brick[count++]);
		}
	 i++;
	}
}


void initialdraw()
{
p=(x1-10)/2-5;           ///  position of Ball X  
q=3*(y1+5)/4-43;		 ///  position of Ball y
fp=p;                    ///  old position of Ball x
fq=q;                    ///  old position of Ball y

paddle.setBounds(((x1-10)/2)-30,(3*(y1+5)/4)-30,65,30);
p3.add(paddle);

ball.setIcon(new ImageIcon("megaball.png"));
ball.setBounds(p,q,25,25);

}

	void ballposition()
	{

		for(int i=0;i<count;i++)
		{
			brickx[i]=brick[i].getX();
			bricky[i]=brick[i].getY();
		}
		
		dx=d.width/2;
		dy=d.height-35;

		
		while(true)
		{
		Icon ballimage=ball.getIcon();      /// Getting Image of Ball everytime
		Icon paddleimage=paddle.getIcon();  /// Getting Image of Puddle everytime
		Dimension pd=paddle.getSize();      /// Puddle Dimension
		Dimension bd=ball.getSize();  		/// Ball Dimension
		blen=bd.width;						/// Ball Length	
		bwid=bd.height;						/// Ball Height
		plen=pd.width;						/// Puddle Length
		pwid=pd.height;						/// Puddle Height
		
		
		paddlex=paddle.getX();				/// Puddle X position
		paddley=paddle.getY();				/// Puddle Y position
		
			dx=dx+dp;						/// 	Increment in Ball X
			dy=dy+dq;						///	    Increment in Ball Y
			
/// IF puddle is GunStriker 			
			
if(paddleimage.toString().equals((new ImageIcon("gunstricker.png")).toString()))
{
bulletx=paddle.getX()+32;
gun=1;
}
else
{
gun=0;
bullet.setVisible(false);
p3.remove(bullet);
}			

if(gun==1)
{
bulletx=bullet.getX(); 				/// X Co-Ordinate of Bullet
bullety=bullet.getY();				/// Y Co-Ordinate of Bullet
	if(bullety<=5)
	{
	bulletx=paddle.getX()+32;
	bullety=paddley-10;
	}
	else
	bullety=bullety-3;
bullet.setBounds(bulletx,bullety,2,3);
bullet.setBackground(Color.white);
p3.add(bullet);
bullet.setVisible(true);
}

		///  Condition for Left Wall
				if(dx<5)
				{
				dx=5;
				dp=-dp;
				}
				
		///  Condition for Right Wall
		
				if(dx>=x1-25)
				{
				dx=x1-25;
				dp=-dp;
				}
				
		///	 Condition for Top Wall

		
				if(dy<y1/10-y1/12)
				{
				dy=y1/10-y1/12;
				dq=-dq;
				}
				
		/// When Ball move Downwars and Touches Puddle
		/// Divide Puddle in 5 parts.
		
if(dy+bwid>=paddley+5)
{
	if((dx+blen)>(paddlex-2) && dx<(paddlex+pd.width+3))
	{
		if(dx<paddlex+(pwid/5))  	///	 Condition When Ball touch Leftmost part of Puddle and How Change its Direction
		{	dp=-3;dq=-1;}
		else if(dx<paddlex+(2*pwid/5))  ///  Condition When Ball touch 2nd part of Puddle and How Change its Direction
		{
			if(dp==3)
			{	dp=1;dq=-1;}
			else if(dp==2)
			{	dp=1;dq=-2;}
			else if(dp==1)
			{
				if(dq==1)
				{	dp=1;dq=-2;}
				else
				{	dp=-1;dq=-2;}
			}
			else if(dp==-1)
			{
				if(dq==2)
				{	dp=-1;dq=-1;}
				else
				{	dp=-2;dq=-1;}
			}
			else if(dp==-2 || dp==-3)
			{	dp=-3;dq=-1;}
		}
		else if(dx<paddlex+(3*pwid/5))   /// Condition When Ball touch 3rd part of Puddle and How Change its Direction
		{	dq=-dq;	}
		else if(dx<paddlex+(4*pwid/5))   /// Condition When Ball touch 4th part of Puddle and How Change its Direction
		{
			if(dp==-3)
			{	dp=-1;dq=-1;}
			else if(dp==-2)
			{	dp=-1;dq=-2;}
			else if(dp==-1)
			{
				if(dq==1)
				{	dp=-1;dq=-2;}
				else
				{	dp=1;dq=-2;}
			}
			else if(dp==1)
			{
				if(dq==2)
				{	dp=1;dq=-1;}
				else
				{	dp=2;dq=-1;}
			}
			else if(dp==2 || dp==3)
			{	dp=3;dq=-1;}
		}
		else						/// Condition When Ball touch 5th part of Puddle and How Change its Direction
		{	dp=3;dq=-1;}
}

      /// When Ball touch the Floor
	  
else if(dy+bwid>paddley+30)
				{			
				ball.setIcon(new ImageIcon("megaball.png"));
				paddle.setIcon(new ImageIcon("s1.png"));
				paddle.setBounds(((x1-10)/2)-30,(3*(y1+5)/4)-30,65,30);
				dy=fq;
				dx=fp;
				dp=1; dq=-1;
				balllife[3-blife].setVisible(false);
				
				try
				{	Thread.sleep(1000); }
				catch(Exception e)
				{}
	blife--;					/// Decrement in Life
		if(blife==0)
		{
		gameover.setVisible(true);
		finish=1;   
		try
		{
			Thread.sleep(2000);
			startagain();				/// Starting of Start Window
			stop();					/// Thread stop here
		}
		catch(Exception e)
		{}
	return;
		}
				
	}
}				

	/// when Ball touch a brick

for(int i=0;i<count;i++) 
{

	/// If puddle is Gun stricker
	
	if(gun==1)
	{
		if((bulletx>=brickx[i] && bulletx<=brickx[i]+40) && bullety<=bricky[i]+15 &&((brick[i].getBackground())!=Color.black))
		{
		brokenbrick++;
		brickscore=brickscore+20;
		score.setText("SCORE"+"  :  "+brickscore);
		brick[i].setBackground(Color.black);		
		p3.remove(brick[i]);
		bulletx=paddle.getX()+32;
		bullety=paddley-10;
		bullet.setBounds(bulletx,bulletx,2,3);
		bullet.setBackground(Color.black);
		p3.remove(bullet);
		}
	}

	if((dx+blen>=brickx[i] && dx<=brickx[i]+40)&&(dy+bwid>=bricky[i] && dy<=bricky[i]+15)&&((brick[i].getBackground())!=Color.black))	
	{	
	
	///Calling of Power Class which generate power randomly
	
		int randompower=(int)(Math.random()*3);
		if(randompower==1)
		{
		PowerClass power=new PowerClass(jf,p3,brick[i],paddle,ball,x1,y1);
		}
		if(ballimage.toString().equals((new ImageIcon("megaball.png")).toString()))
		{
		
		///  Condition for Changing direction of Ball when touch the brick
		
			if(dx+blen>brickx[i] && dx<brickx[i]+40)
			{
				dq=-dq;
			}
			else if(dy+bwid>bricky[i] && dy<bricky[i]+15)
			{
				dp=-dp;
			}
			else
			{
				dp=-dp;
				dq=-dq;
			}
		}
			
			brokenbrick++;
			brickscore=brickscore+25;					/// Increment in Score
			score.setText("SCORE"+"  :  "+brickscore);
			brick[i].setBackground(Color.black);		
			p3.remove(brick[i]);	
	}	
}	
				
	/// IF ALL THE BRICKS ARE BROKEN.			
				
if(brokenbrick==count)	
{
st++;
	try
	{Thread.sleep(1000);}
	catch(Exception e)
	{}
stop=1;
return;
}				
				ball.setBounds(dx,dy,35,30);
				try
				{Thread.sleep(speed);}
				catch(Exception e){}		
		}
}

	/// Starting of Start Window
	
void startagain()
{
if(finish==1)
{
finish=0;
	try
	{
	Thread.sleep(5);
	}
	catch(Exception e)
	{}
jf.dispose();
StartWindow w=new StartWindow("Ball Braker By Vatsal Sevak",3);
w.setVisible(true);
return;
}
}	
	
	void stop()
	{
	enable=false;
	}
	
public void run()
{
	stop=0;
		try
		{
			ready.setVisible(true);
			initialdraw();
			Thread.sleep(1000);
			ready.setVisible(false);
		}
		catch(Exception e)
	{}
	while(enable)
	{	
	
		if(stop==1 && st<4)
		{		
			BallMovement bm=new BallMovement(jf,p2,p3,p4,x1,y1,paddle,ball,score,balllife,blife,st,brickscore);
			return;
		}
		if(st>4)
		{
		p3.removeAll();
		p3.validate();
		p3.repaint();
		p3.add(complete);
		complete.setVisible(true);
			try
			{
			Thread.sleep(3000);
			}
			catch(Exception e)
			{}
		jf.dispose();
		StartWindow w=new StartWindow("Ball Braker By Vatsal Sevak",3);
		w.setVisible(true);
		return;
		}
		ballposition();			/// Maintain Position of Ball in Panel
	}
}	
}

/*
power class Thread class
*/
class PowerClass implements Runnable
{
JFrame jf;
JPanel p3;
JLabel ball,paddle,gamepower;
Label brick,gameover;
Thread t;
int brickx,bricky,powerx,powery,px,py,powernumber,bombflag=0,padx,pady;
ImageIcon img;
int x1,y1,flag=0;

PowerClass(JFrame jf,JPanel p3,Label brick,JLabel paddle,JLabel ball,int x1,int y1)
{
t=new Thread(this);
this.jf=jf;
this.p3=p3;
this.brick=brick;
this.paddle=paddle;
this.ball=ball;
this.x1=x1;
this.y1=y1;

brickx=brick.getX();
bricky=brick.getY();

powerx=brickx+20;
powery=bricky+15;

t.start();
}

	/// Starting of Power Thread

public void run()
{

powernumber=(int)(Math.random()*5);


switch(powernumber)
{
	case 0: img=new ImageIcon("Picture1.png");
			gamepower=new JLabel(img,JLabel.CENTER);		///  Big Puddle Power
			gamepower.setBounds(powerx,powery,60,60);
			break;
			
	case 1: img=new ImageIcon("Picture2.png");
			gamepower=new JLabel(img,JLabel.CENTER);		/// Small Puddle Power
			gamepower.setBounds(powerx,powery,60,60);
			break;
			
	case 2: img=new ImageIcon("Picture3.png");
			gamepower=new JLabel(img,JLabel.CENTER);		/// MegaBall Power
			gamepower.setBounds(powerx,powery,40,35);
			break;
			
	case 3: img=new ImageIcon("Picture4.png");
			gamepower=new JLabel(img,JLabel.CENTER);		/// Bomb Power 
			gamepower.setBounds(powerx,powery,60,60);
			break;
			
	case 4: img=new ImageIcon("Picture5.png");
			gamepower=new JLabel(img,JLabel.CENTER);		/// Gun Power
			gamepower.setBounds(powerx,powery,60,60);
			break;
	}
p3.add(gamepower);
gamepower.setVisible(true);

try
{
		while(true)
		{
			if(bombflag==1)
			{
				startagain();		/// When Bomb Touch Puddle Gmane start again
				return;
			}
			
			if(flag==1)
			return;
			ballposition();
			Thread.sleep(5);
		}

}
catch(Exception e)
{}	
}


void ballposition()
{
Dimension d=p3.getSize();
int p3x=d.width;			/// P3 panel dimension	
int p3y=d.height;

d=paddle.getSize();
int paddlex=d.width;		/// paddle dimension
int paddley=d.height;

px=paddle.getX();			/// X of paddle 
py=paddle.getY();			/// Y of paddle

powerx=gamepower.getX();	/// X of power 
powery=gamepower.getY();	/// Y of power

if(powery>p3y)			
{
flag=1;
return;
}


		///  When Power touch puddle

if((powerx+25)>px && powerx<(px+paddlex) && (powery+25)>py)
{
gamepower.setVisible(false);
flag=1;
	switch(powernumber)
	{
	case 0: ball.setIcon(new ImageIcon("megaball.png"));
			paddle.setIcon(new ImageIcon("largestricker.png"));
			paddle.setBounds(px-32,py,110,30);
			break;
		
	case 1: ball.setIcon(new ImageIcon("megaball.png"));
			paddle.setIcon(new ImageIcon("smallstricker.png"));
			paddle.setBounds(px+16,py,40,30);
			break;
		
	case 2: paddle.setIcon(new ImageIcon("s1.png"));
			paddle.setBounds(px,py,65,30);
			ball.setIcon(new ImageIcon("Picture3.png"));
			ball.setBounds(px,py,40,35);
			break;
			
	case 3: p3.removeAll();
			p3.validate();
			p3.repaint();
			Font f1=new Font("Arial",Font.BOLD,18);
			gameover=new Label("GAME OVER",Label.CENTER);
			gameover.setFont(f1);
			gameover.setBounds(x1/2-80,y1/2-30,200,30);
			gameover.setForeground(Color.yellow);
			p3.add(gameover);
			gameover.setVisible(true);
			bombflag=1;
			break;
	case 4: ball.setIcon(new ImageIcon("megaball.png"));
			paddle.setIcon(new ImageIcon("gunstricker.png"));
			break;
	
	}
return;
}
powery=powery+1;
gamepower.setBounds(powerx,powery,30,30);
}


void startagain()
{
if(bombflag==1)
{
bombflag=0;
	try
	{
	Thread.sleep(1000);
	}
	catch(Exception e)
	{}
jf.dispose();
StartWindow w=new StartWindow("Ball Braker By Vatsal Sevak",3);
w.setVisible(true);
return;
}
}

}

	
	//// Main Class

public class GameLoftBallBraker
{
public static void main(String[] arg)
{
StartWindow w=new StartWindow("Ball Braker By Vatsal Sevak",3);
w.setVisible(true);
}
}