import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.io.*;
import javax.swing.border.*;
import javax.swing.BorderFactory.*;
import java.util.*;

class Help extends JFrame implements ActionListener 
{
JLabel l1,l3;
JPanel p1;
TextArea ta1;
JButton b1;
Font f;
int userid,hmenu;

Help(int x,int y)
{
setLayout(null);
setTitle("User Help");
//setBounds(250,120,650,500);
this.userid=userid;
f=new Font("Arial",Font.BOLD,25);
l1=new JLabel("OVERVIEW OF BALL BRAKER");
this.hmenu=hmenu;
String s="*** Ball Braker is a single person game developed in java."+
"\n\n*** Ball Braker is very easy and fun loving game."+
"\n\n*** In this Game there are 4 stages."+
"\n\n*** As Player Proceed to next Stage Speed of Ball will Increase."+
"\n\n*** There are 3 lives to complete game."+
"\n\n*** The simple rull of this game is that Player has to stop the ball to touch to the floor and break all bricks."+
"\n\n*** Player can stop ball reaching to Floor bye moving puddle."+
"\n\n*** To Move puddle to Right side press Right Arrow Key. \n"+
"\n\n*** To Move puddle to Left side press Left Arrow Key. "+
"\n\n*** If Ball touch the Floor Player loses life.";
ta1=new TextArea(s,30,50,1);

l3=new JLabel("VATSAL SEVAK");
p1=new JPanel();
b1=new JButton("Next");
p1.setLayout(null);
p1.setBackground(Color.white);
String s1=("Created By");
p1.setBorder(new TitledBorder(new LineBorder(Color.black,2),""+s1));
p1.setVisible(true);
ta1.setEditable(false);
ta1.setBackground(Color.white);
ta1.setForeground(Color.black);

p1.setBounds(460,70,180,200);
l1.setBounds(10,5,400,50);
ta1.setBounds(10,70,450,390);
l3.setBounds(35,85,150,20);
b1.setBounds(510,400,80,30);

l1.setFont(f);

f=new Font("Arial",Font.BOLD,15);
ta1.setFont(f);l3.setFont(f);
add(l1);add(ta1);
add(p1);add(b1);p1.add(l3);

b1.addActionListener(this);
}
void budget_details()
{
ta1.setText("");
l1.setText("OVERVIEW OF BALL BRAKER");
String st="# To survive from the all stage Player has Power."+
"\n\n *** There are Four Powers which will help the player to get through the stages and lead the Player to completion of game."+
"\n\n *** There is One Power which results in the termination of Game."+
"\n\n 	1. BIG PUDDLE   --  Which Increase size of Puddle."+
"\n\n     	 2. SMALL PUDDLE --  Which Decrease size of Puddle."+
"\n\n 	3. MEGA BALL    --  Which Directly get through the all brick which are come across its way."+
"\n\n 	4. GUN POWER    --  Which fire bullet and bullet break the brick"+
"\n\n *** There is BOMB POWER which causes the termination of game."+
"\n\n *** Score increment by 25 each time ball touch the brick and by 20 when bullet touch the birck."+
"\n\n *** So The Objective of Player is simply break the all damn Bricks.";


ta1.setText(st);

}
public void actionPerformed(ActionEvent ae)
{
String ss=ae.getActionCommand();

 if(ss.equals("Next"))
{
budget_details();
b1.setText("Close");
}

if(ss.equals("Close"))
{
setVisible(false);
}

}
}

