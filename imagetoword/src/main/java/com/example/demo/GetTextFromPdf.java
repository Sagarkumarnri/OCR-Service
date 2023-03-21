package com.example.demo;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
 
public class GetTextFromPdf {
	public String getTextFromPdf (String path) throws IOException
	{
		File f = new File(path);
		String parsedText="";
		PdfReader reader = new PdfReader(path);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
		    TextExtractionStrategy strategy =
		      parser.processContent(i, new SimpleTextExtractionStrategy());
		    parsedText = parsedText+ strategy.getResultantText();
		     
		}
		 
 
		return parsedText;
	}

}
