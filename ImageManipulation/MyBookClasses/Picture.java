
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.awt.Color;  
import java.awt.GradientPaint;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import java.lang.Object;
import java.awt.MultipleGradientPaint;
import java.awt.LinearGradientPaint;
/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param width the width of the desired picture
     * @param height the height of the desired picture
     */
    public Picture(int width, int height) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;

    }


            
   
    ////Teodora Kis//////
    ////1804944//////
    
    //2 (a) WORKS
    public void cycleColours(){
       System.out.println("Please choose the beach picture");
        String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method
        
        Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture
        
        Pixel sourcePixel = null; //declare a source pixel variable
        Pixel targetPixel = null; //declare a target pixel variable
        
        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) { //loop through colums 
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){ // loop through rows
        
            
            sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
            targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
            
            
            targetPixel.setRed(sourcePixel.getBlue()); //set final colour for Red value for each pixel
            targetPixel.setGreen(sourcePixel.getRed());  //set final colour for Green value of each pixel
            targetPixel.setBlue(sourcePixel.getGreen());  //set final colour for Blue value for each pixel
         
            } 
        }    
    } //end of cycleColours         
           
    //2 (b) 
      //(i) WORKS
    public void randomizeColour1(){
       System.out.println("Please choose the beach picture");
        String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method

        Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture

        Pixel sourcePixel = null; //declare a source pixel variable
        Pixel targetPixel = null; //declare a target pixel variable

        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) { //loop through colums 
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){ // loop through rows


            sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
            targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations



            int offset = (int)(Math.random()*(100-1+1)+1); //declare offset between 0 and 100



          //Red
            int valueRed = (sourcePixel.getRed()+offset); //declare valueRed plus offset variable
          
            if (valueRed >255)                          //make sure RGB red value doesn't go over the 255 value
            valueRed = (valueRed -256);
            else
            valueRed = valueRed;

            targetPixel.setRed(valueRed);               //set target pixel colour for Red value

          //Green                                     // same as for the Red value but for the Green of RGB of each pixel
            int valueGreen = (sourcePixel.getGreen()+offset); 

            if (valueGreen >255) 
            valueGreen = (valueGreen-256);
            else
            valueGreen = valueGreen;

            targetPixel.setGreen(valueGreen);

          //Blue                                            // same as for the Red value but for the Blue of RGB of each pixel
            int valueBlue = (sourcePixel.getBlue()+offset); 

            if (valueBlue >255) 
            valueBlue = (valueBlue -256);
            else
            valueBlue = valueBlue;

            targetPixel.setBlue(valueBlue);
                }
            }
    }//end of randomizeColour1
            
    //(ii) WORKS
    public void randomizeColour2(){
       System.out.println("Please choose the beach picture");
        String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method

        Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture

        Pixel sourcePixel = null; //declare a source pixel variable
        Pixel targetPixel = null; //declare a target pixel variable

        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) { //loop through colums 
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){ // loop through rows


            sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
            targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations


            int offset = (int)(Math.random()*(100-1+1)+1); //declare offset between 0 and 100
                
            //same code as for posterize1, except the offset is substracted from the RGB value and this value is then subtracted from the maximum value of 255
            int valueRed = (sourcePixel.getRed()-offset); 
            //Red
            if (valueRed <=0) 
            valueRed = (255-valueRed );
            else
            valueRed = valueRed;

            targetPixel.setRed(valueRed);

            //Green
            int valueGreen = (sourcePixel.getGreen()-offset); 

            if (valueGreen <=0) 
            valueGreen = (255-valueGreen);
            else
            valueGreen = valueGreen;

            targetPixel.setGreen(valueGreen);
            //Blue
            int valueBlue = (sourcePixel.getBlue()-offset); 

            if (valueBlue <=0) 
            valueBlue = (255-valueBlue );
            else
            valueBlue = valueBlue;

            targetPixel.setBlue(valueBlue);
            }
        }
    } //end of randomizeColour2
         
    //2 (c)
    //(i) WORKS
    
    public void posterize1(){
       System.out.println("Please choose the beach picture");
        String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method

        Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture

        Pixel sourcePixel = null; //declare a source pixel variable
        Pixel targetPixel = null; //declare a target pixel variable

        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) { //loop through colums 
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){ // loop through rows


            sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
            targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations

        
        //Red - set RGB value for Red value of each pixel
            int valueRed = (sourcePixel.getRed()); 
        
            if (valueRed <64){ 
            valueRed = 31; 
            }  else if (64 < valueRed && valueRed <= 127) {
            valueRed = 95; 
            } else if (128 <  valueRed && valueRed <= 191){ 
            valueRed = 159; 
            }else
            valueRed = 223;
        
            targetPixel.setRed(valueRed);
            
            
        //Green - set RGB value for Green value of each pixel
            int valueGreen = sourcePixel.getGreen(); 
        
            if (valueGreen <64){ 
            valueGreen = 31; 
            }  else if (64 < valueGreen && valueGreen < 127) {
            valueGreen = 95; 
            } else if (128 <  valueGreen && valueGreen <= 191){ 
            valueGreen = 159; 
            }else
            valueGreen = 223;
        
            targetPixel.setGreen(valueGreen);
            
            
        //Blue - set RGB value for Blue value of each pixel
            int valueBlue = (sourcePixel.getBlue()); 
        
            if (valueBlue <64){ 
            valueBlue = 31; 
            }  else if (64 < valueBlue && valueBlue <= 127) {
            valueBlue = 95; 
            } else if (128 <  valueBlue && valueBlue <= 191){ 
            valueBlue = 159; 
            }else
            valueBlue = 223;
        
            targetPixel.setBlue(valueBlue);
           
            }
         } //end of colurs loop
        
         //negate left half of the picture
         //loop through left half of picture
         for (int sourceX = 0, targetX = 0; sourceX*2 < sourcePicture.getWidth(); sourceX++, targetX++) {
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){
            
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
        
        //Red -set value
            int valueRed = (sourcePixel.getRed()); 
        
            if (valueRed <64){ 
            valueRed = 31; 
            }  else if (64 < valueRed && valueRed <= 127) {
            valueRed = 95; 
            } else if (128 <  valueRed && valueRed <= 191){ 
            valueRed = 159; 
            }else
            valueRed = 223;
        
            targetPixel.setRed(255-valueRed); // subtract red value from the maximum value
            
            
        //Green 
            int valueGreen = sourcePixel.getGreen(); 
        
            if (valueGreen <64){ 
            valueGreen = 31; 
            }  else if (64 < valueGreen && valueGreen < 127) {
            valueGreen = 95; 
            } else if (128 <  valueGreen && valueGreen <= 191){ 
            valueGreen = 159; 
            }else
            valueGreen = 223;
        
            targetPixel.setGreen(255-valueGreen); // subtract green value from the maximum value
            
            
        //Blue 
            int valueBlue = (sourcePixel.getBlue()); 
        
            if (valueBlue <64){ 
            valueBlue = 31; 
            }  else if (64 < valueBlue && valueBlue <= 127) {
            valueBlue = 95; 
            } else if (128 <  valueBlue && valueBlue <= 191){ 
            valueBlue = 159; 
            }else
            valueBlue = 223;
        
            targetPixel.setBlue(255-valueBlue); // subtract blue value from the maximum value
        
      
            }
         }
            
    } //end of posterize1
            
            
            
            
    //(ii) WORKS
    public void posterize2(){
       System.out.println("Please choose the beach picture");
        String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method

        Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture

        Pixel sourcePixel = null; //declare a source pixel variable
        Pixel targetPixel = null; //declare a target pixel variable

        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) { //loop through colums 
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){ // loop through rows


            sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
            targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
        
        //Red 
            int valueRed = (sourcePixel.getRed()); 
        
            if (valueRed <64){ 
            valueRed = 31; 
            }  else if (64 < valueRed && valueRed <= 127) {
            valueRed = 95; 
            } else if (128 <  valueRed && valueRed <= 191){ 
            valueRed = 159; 
            }else
            valueRed = 223;
        
            targetPixel.setRed(valueRed);
            
            
        //Green 
            int valueGreen = sourcePixel.getGreen(); 
        
            if (valueGreen <64){ 
            valueGreen = 31; 
            }  else if (64 < valueGreen && valueGreen < 127) {
            valueGreen = 95; 
            } else if (128 <  valueGreen && valueGreen <= 191){ 
            valueGreen = 159; 
            }else
            valueGreen = 223;
        
            targetPixel.setGreen(valueGreen);
            
            
        //Blue 
            int valueBlue = (sourcePixel.getBlue()); 
        
            if (valueBlue <64){ 
            valueBlue = 31; 
            }  else if (64 < valueBlue && valueBlue <= 127) {
            valueBlue = 95; 
            } else if (128 <  valueBlue && valueBlue <= 191){ 
            valueBlue = 159; 
            }else
            valueBlue = 223;
        
            targetPixel.setBlue(valueBlue);
           
            }
            }
        
         //negate upper right quadrant WORKS
         for (int sourceX =  sourcePicture.getWidth()/2, targetX = this.getWidth()/2;  sourceX < sourcePicture.getWidth() ; sourceX++, targetX++) {
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight()/2; sourceY++, targetY++){
            
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
        
        //Red 
            int valueRed = (sourcePixel.getRed()); 
        
            if (valueRed <64){ 
            valueRed = 31; 
            }  else if (64 < valueRed && valueRed <= 127) {
            valueRed = 95; 
            } else if (128 <  valueRed && valueRed <= 191){ 
            valueRed = 159; 
            }else
            valueRed = 223;
        
            targetPixel.setRed(255-valueRed);
            
            
        //Green 
            int valueGreen = sourcePixel.getGreen(); 
        
            if (valueGreen <64){ 
            valueGreen = 31; 
            }  else if (64 < valueGreen && valueGreen < 127) {
            valueGreen = 95; 
            } else if (128 <  valueGreen && valueGreen <= 191){ 
            valueGreen = 159; 
            }else
            valueGreen = 223;
        
            targetPixel.setGreen(255-valueGreen);
            
            
        //Blue 
            int valueBlue = (sourcePixel.getBlue()); 
        
            if (valueBlue <64){ 
            valueBlue = 31; 
            }  else if (64 < valueBlue && valueBlue <= 127) {
            valueBlue = 95; 
            } else if (128 <  valueBlue && valueBlue <= 191){ 
            valueBlue = 159; 
            }else
            valueBlue = 223;
        
            targetPixel.setBlue(255-valueBlue);
        
      
            }
         }
         
          //negate lower left quadrant WORKS
         for (int sourceX =  0, targetX = 0;  sourceX < sourcePicture.getWidth()/2 ; sourceX++, targetX++) {
            for (int sourceY = sourcePicture.getHeight()/2, targetY = this.getHeight()/2; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){
            
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
        
        //Red 
            int valueRed = (sourcePixel.getRed()); 
        
            if (valueRed <64){ 
            valueRed = 31; 
            }  else if (64 < valueRed && valueRed <= 127) {
            valueRed = 95; 
            } else if (128 <  valueRed && valueRed <= 191){ 
            valueRed = 159; 
            }else
            valueRed = 223;
        
            targetPixel.setRed(255-valueRed);
            
            
        //Green 
            int valueGreen = sourcePixel.getGreen(); 
        
            if (valueGreen <64){ 
            valueGreen = 31; 
            }  else if (64 < valueGreen && valueGreen < 127) {
            valueGreen = 95; 
            } else if (128 <  valueGreen && valueGreen <= 191){ 
            valueGreen = 159; 
            }else
            valueGreen = 223;
        
            targetPixel.setGreen(255-valueGreen);
            
            
        //Blue 
            int valueBlue = (sourcePixel.getBlue()); 
        
            if (valueBlue <64){ 
            valueBlue = 31; 
            }  else if (64 < valueBlue && valueBlue <= 127) {
            valueBlue = 95; 
            } else if (128 <  valueBlue && valueBlue <= 191){ 
            valueBlue = 159; 
            }else
            valueBlue = 223;
        
            targetPixel.setBlue(255-valueBlue);
            
            }
         }
    }//end of posterize2
     
    //2 (d) DOESN'T FULLY WORK, creates overall and NOT gradual shadow :(
    public void makeShadow() {
       System.out.println("Please choose the beach picture");
        String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method

        Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture

        Pixel sourcePixel = null; //declare a source pixel variable
        Pixel targetPixel = null; //declare a target pixel variable

        for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++) { //loop through colums 
            for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){ // loop through rows


            sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
            targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
            
            //int shadow = 1-sourcePicture.getHeight();
            
            targetPixel.setRed(sourcePixel.getRed()-100); //darken value
            targetPixel.setGreen(sourcePixel.getGreen()-100);  //darken value
            targetPixel.setBlue(sourcePixel.getBlue()-100);  //darken value
         
            } 
        }    
    } // end of makeShadow      
            
    //2 (e) DOESN'T FULLY WORK, copies the two images over each other and NOT gradually :(
    public void blend() {
        System.out.println("Please choose the blank picture"); //select a base picture to use for the method
        System.out.println("Please choose the greece picture"); //select a picture to use for the method
        System.out.println("Please choose the beach picture"); //select a picture to use for the method
        
           Picture greecePicture = new Picture(FileChooser.pickAFile()); //source picture is the chosen picture
           Picture beachPicture = new Picture(FileChooser.pickAFile()); //source picture is the chosen picture
           
           Pixel greecePixel = null; //declare a source pixel variable
           Pixel beachPixel = null; //declare a source pixel variable
           Pixel targetPixel = null; //declare a source pixel variable
           
           //int width = ((greecePicture.getWidth()/this.getWidth())); // failed (?) attempt at making variable for gradual transition
           
           for (int sourceX = 0, targetX = 0; sourceX < greecePicture.getWidth(); sourceX++, targetX++){ //loop through colums 
               for (int sourceY = 0, targetY = 0; sourceY < greecePicture.getHeight(); sourceY++, targetY++){ // loop through rows
           
                    greecePixel = greecePicture.getPixel(sourceX, sourceY);  //declare source pixel locations
                    beachPixel = beachPicture.getPixel(sourceX, sourceY); //declare source pixel locations
                    targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
                   
                    //blend the pixel of the two pics together
                    Color averageColor = new Color(
                                    (int)(greecePixel.getRed()*0.5 + beachPixel.getRed()*0.5),
                                    (int)(greecePixel.getGreen()*0.5 + beachPixel.getGreen()*0.5),
                                    (int)(greecePixel.getBlue()*0.5 + beachPixel.getBlue()*0.5)
                    );
                    targetPixel.setColor(averageColor); // set target pixel colours              
               }
           }  
    } //end of blend method
            
           
    //2 (f) WORKS
    public void warholize() {
           System.out.println("Please choose the beach picture");
            String sourceFile = FileChooser.pickAFile(); //select a picture to use for the method

            Picture sourcePicture = new Picture(sourceFile); //source picture is the chosen picture

            Pixel sourcePixel = null; //declare a source pixel variable
            Pixel targetPixel = null; //declare a target pixel variable
                
                
          //upper left quadrant
          //loop through colums and rows and copy upper left quadrant of source picture into this quadrant
            for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth()/2; sourceX++, targetX++) {
                for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight()/2; sourceY++, targetY++){


                sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
                targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
                
                
                //set RGB values
              //Red 
                int valueRed = (sourcePixel.getRed()); 

                if (valueRed < 150){ 
                valueRed = 20; 

                }else
                valueRed = valueRed;

                targetPixel.setRed(255-valueRed);


              //Green 
                int valueGreen = (sourcePixel.getGreen()); 

                if (valueGreen >100){ 
                valueGreen = 255; 

                }else
                valueGreen = valueGreen-50;

                targetPixel.setGreen(valueGreen);

              //Blue 
                int valueBlue = (sourcePixel.getBlue()); 

                if (valueBlue >10){ 
                valueBlue = 200; 

                }else
                valueBlue = 255;

                targetPixel.setBlue(valueBlue);
                } 
            } //end of quadrant
                    
            //upper right quadrant
            //loop through colums and rows and copy upper left quadrant of source picture into this quadrant
            for (int sourceX = 0, targetX = this.getWidth()/2;  sourceX < sourcePicture.getWidth()/2 ; sourceX++, targetX++) {
                for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight()/2; sourceY++, targetY++){

                sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
                targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations

                int valueBlue = (sourcePixel.getBlue()); 

                if (valueBlue <100){ 
                valueBlue = 20; 
                }  else if (100 < valueBlue && valueBlue <= 150) {
                valueBlue = 60; 
                } else if (150 <  valueBlue && valueBlue <= 220){ 
                valueBlue = 100; 
                }else
                valueBlue = valueBlue;



                //set RGB values
                targetPixel.setRed(255-sourcePixel.getRed(0));
                targetPixel.setGreen(255-sourcePixel.getGreen());
                targetPixel.setBlue(valueBlue-100);
                } 
            } //end of quadrant
                     
        
            //lower left quadrant
            //loop through colums and rows and copy upper left quadrant of source picture into this quadrant
            for (int sourceX =  0, targetX = 0;  sourceX < sourcePicture.getWidth()/2 ; sourceX++, targetX++) {
                for (int sourceY = 0, targetY = this.getHeight()/2; sourceY < sourcePicture.getHeight()/2; sourceY++, targetY++){

                sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
                targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
                
                //set RGB values
                targetPixel.setRed(sourcePixel.getBlue()*2);
                targetPixel.setGreen(sourcePixel.getRed()-100);
                targetPixel.setBlue(255-sourcePixel.getGreen());
                } 
            }//end of quadrant
  
            
            //lower right quadrant
            //loop through colums and rows and copy upper left quadrant of source picture into this quadrant
            for (int sourceX = 0, targetX = this.getWidth()/2; sourceX < sourcePicture.getWidth()/2; sourceX++, targetX++) {
                for (int sourceY = 0, targetY = this.getHeight()/2; sourceY < sourcePicture.getHeight()/2; sourceY++, targetY++){


                sourcePixel = sourcePicture.getPixel(sourceX, sourceY); //declare source pixel locations
                targetPixel = this.getPixel(targetX, targetY); //declare target pixel locations
                
                //set RGB values
              //Red 
                int valueRed = (sourcePixel.getRed()); 

                if (valueRed < 150){ 
                valueRed = 20; 

                }else
                valueRed = valueRed;

                targetPixel.setRed(255-(valueRed+100));


               //Green 
                int valueGreen = (sourcePixel.getGreen()); 

                if (valueGreen >100){ 
                valueGreen = 255; 

                }else
                valueGreen = valueGreen-50;

                targetPixel.setGreen(255-(valueGreen+100));

               //Blue 
                int valueBlue = (sourcePixel.getBlue()); 

                if (valueBlue >10){ 
                valueBlue = 200; 

                }else
                valueBlue = 255;

                targetPixel.setBlue(255-(valueBlue+100));
                }
            } //end of quadrant  
    } //end of warholize  
 
} // this } is the end of class Picture, put all new methods before this
 