package com.example.demo;

import java.io.IOException;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfImageType;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

 

public class PdfToImage {
	public void convertPdfToImage(String path1 ,String path,String name) throws IOException
	{
		 PdfDocument pdf = new PdfDocument();
		
		  
		
		         //Load a PDF sample document
		 
		         pdf.loadFromFile(path1);
		 
		  
		 
		         //Loop through every page
		 
		         for (int i = 0; i < pdf.getPages().getCount(); i++) {
		 
		             //Convert all pages to images and set the image Dpi
		 
		             BufferedImage image = pdf.saveAsImage(i, PdfImageType.Bitmap,500,500);
		 
		             //Save images to a specific folder as a .png files
		            
		             File file = new File(path + "/" + String.format((name+"%d.png"), i));
		             System.out.println("here"+file);
		             ImageIO.write(image, "PNG", file);
		 
		         }
		 

	}

}
