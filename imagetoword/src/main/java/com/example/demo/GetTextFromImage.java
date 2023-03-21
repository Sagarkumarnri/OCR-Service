package com.example.demo;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.springframework.stereotype.Service;
@Service
public class GetTextFromImage {
	
	public String getTextFromImage(String path)
	{
	 BytePointer outText;

     TessBaseAPI api = new TessBaseAPI();
     // Initialize tesseract-ocr with English, without specifying tessdata path
     if (api.Init(null, "eng") != 0) {
         System.err.println("Could not initialize tesseract.");
         System.exit(1);
     }

     // Open input image with leptonica library
     PIX image = pixRead(path);
     api.SetImage(image);
     // Get OCR result
     outText = api.GetUTF8Text();
   

     // Destroy used object and release memory
     
     outText.deallocate();
     pixDestroy(image);
     return outText.getString();
	}
//	
}
