1. Run the whole application as a springboot app.
2: Store all the images & PDFs which you want to convert into text in project\imagetoword\src\main\resources\images
3: In the console it will ask for what would you like to convert in the folder like ecard.pdf etc.  
question will be asked: enter file name with extension
then enter the file name with extension which you would like to convert.
4: If you have entered image the it will convert image in text likewise for PDFs also. 
5: But if it fails to return any text if the PDF file is entered that means the text length is 0, it will try to convert the PDF into image with extention .png & it will try to extract the text from that converted image.
6: If the PDF has multiple pages, it will convert each page as a single image & extract the text of first page which is converted as image.
7: If you would like to take the text of any other page apart from first page then you may need to specify it in the code.
8: Attaching some SS of the output for the reference.


 