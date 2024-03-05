package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pupu {
    private int x;
    private int y;
    private ImageIcon img;
    private int snake_size;

    public Pupu(){
        //img = new ImageIcon("pupu.jpg");
        img = new ImageIcon(getClass().getResource("pupu.jpg"));
        this.x = (int)(Math.floor(Math.random()*Main.column) * Main.CELL_SIZE);
        this.x = (int)(Math.floor(Math.random()*Main.column) * Main.CELL_SIZE);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return  this.y;
    }

    public void drawFruit(Graphics g){
//        g.setColor(Color.green);
//        g.fillOval(this.x,this.y,Main.CELL_SIZE,Main.CELL_SIZE);
        img.paintIcon(null,g , this.x,this.y);
    }

    public void setNewLocation(Snake s){
        int new_x;
        int new_y;
        boolean overlapping;
        do{
            new_x = (int)(Math.floor(Math.random()*Main.column) * Main.CELL_SIZE);
            new_y = (int)(Math.floor(Math.random()*Main.column) * Main.CELL_SIZE);
            overlapping = check_overlap(new_x,new_y,s);
        }while(overlapping);

        this.x = new_x;
        this.y = new_y;
    }
    private boolean check_overlap(int x, int y, Snake s){
        ArrayList<Node> snake_body = s.getSnakeBody();
        for(int j =0;j < s.getSnakeBody().size(); j++){
            if(x == s.getSnakeBody().get(j).x && y == s.getSnakeBody().get(j).y){
                return true;
            }
        }
        return false;
    }
}
