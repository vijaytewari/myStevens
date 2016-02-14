/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gedcomreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Zack Ankuda
 */
public class GedcomReader {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner fileReader = new Scanner(new File("C:\\Users\\Zack\\Desktop\\SSW555\\Week 2\\P01_zmankuda.ged"));
        
        String[] tags = {"INDI", "NAME","SEX","BIRT","DEAT","FAMC","FAMS","FAM","MARR","HUSB","WIFE","CHIL","DIV","DATE","HEAD","TRLR","NOTE"};
        String level;
        String tag;
        Boolean validTag;
        String line;
        String value;
        String nextValue;
        StringBuilder builder = new StringBuilder();
        while(fileReader.hasNext()){
            //Read in level
            level = fileReader.next();
            
            //Read tag
            tag = fileReader.next();
            
            //Read in the rest of the line
            value = fileReader.nextLine();

            //Print out the information
            System.out.println(level+" "+tag+" "+value);
            System.out.println("Level: " + level);

            //Check for invalid tag
            validTag = false;
            for(int i=0;i<tags.length;i++){
                if(tag.equals(tags[i])){
                    validTag = true;
                }
            }
            if(!validTag){
                tag = "Invalid tag";
            }
            System.out.println("Tag: " + tag);
        }
    }
    
}
