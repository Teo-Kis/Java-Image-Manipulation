/**
 * Auto Generated Java Class.
 */




   ////Teodora Kis//////
    ////1804944//////

/**
 * Statement of Compliance
 * Questions 2 (a) to (c) working just fine. 
 * Questions 2 (d) and (e) the transition is not gradual. 
 * Even tough you kindly explained to me the variable I need, 
 * I don't seem to be able to implement it in the right way.
 * Question 2 (f) is working just fine.
 */

public class TestPicture {
   
   
   public static void main(String[] args) { 
	   //Just once to set the media path to the folder
	   //FileChooser.setMediaPath(FileChooser.pickADirectory() );
	   //Navigate to the MediaSources folder and select it

	   //Select picture
	   Picture pict = new Picture(FileChooser.pickAFile());
	   pict.explore();
           
           //pict.cycleColours();
           //pict.randomizeColour1();
           //pict.randomizeColour2();
           //pict.posterize1();
           //pict.posterize2();
           //pict.makeShadow();
           //pict.blend();
           pict.warholize();
    
           pict.explore();

     
   }
   
}
