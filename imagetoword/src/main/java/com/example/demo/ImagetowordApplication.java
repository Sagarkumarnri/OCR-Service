package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.bytedeco.javacpp.*;
import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.texts.PdfTextExtractOptions;
import com.spire.pdf.texts.PdfTextExtractor;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@SpringBootApplication
public class ImagetowordApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImagetowordApplication.class, args);
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nenter file name with extension----------------------------->::::::->");
		String content = sc.next();
		String extension = content.split("[.]")[1];
		String name = content.split("[.]")[0];
		System.out.println(extension + ".......");
		if (extension.equals("pdf")) {
			GetTextFromPdf api1 = new GetTextFromPdf();

			String contentFromPdf = api1.getTextFromPdf("src/main/resources/images/" + content);
			System.out.println(contentFromPdf + "............");
			if (true) {
				PdfToImage ptom = new PdfToImage();
				ptom.convertPdfToImage("src/main/resources/images/" + content, "src/main/resources/images/", name);
				GetTextFromImage api = new GetTextFromImage();
				String text=api.getTextFromImage("src/main/resources/images/" + name + "0.png");
				System.out.println("image OCR......... "+text);

			} else {
				System.out.println(contentFromPdf);
			}

		} else if (extension.equals("tif") || extension.equals("jpg") || extension.equals("png")) {
			GetTextFromImage api = new GetTextFromImage();
			String text=api.getTextFromImage("src/main/resources/images/" + content);
			System.out.println("image OCR......... "+text);
			
		}
		}

	}

}
