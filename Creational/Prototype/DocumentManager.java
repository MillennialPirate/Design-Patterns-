/*Problem: Imagine a document editor that allows the user to create and edit documents. Implement the Prototype design pattern where different types of documents (e.g., WordDocument, PDFDocument, TextDocument) can be duplicated (cloned) and then modified independently. Each document type should implement the clone() method.

Tasks:

Implement a Document interface with the clone() method.
Create concrete classes for WordDocument, PDFDocument, and TextDocument.
Create a DocumentManager class that can store and clone different types of documents.
Demonstrate how cloning works by duplicating documents and making changes to the clone.*/
import java.util.*;
import java.lang.*;
import java.io.*;
// JAI SHRI RAM 
interface Document
{
    void getDoc(); 
    Document clone(); 
}

class PdfDocument implements Document
{
    String content; 
    public PdfDocument(String content)
    {
        this.content = content; 
    }
    @Override
    public void getDoc()
    {
        System.out.println("PDF Document - " + content); 
    }
    
    @Override
    public Document clone()
    {
        return new PdfDocument(content);
    }
}

class WordDocument implements Document{
    String content; 
    public WordDocument(String content)
    {
        this.content = content; 
    }
    
    @Override 
    public void getDoc()
    {
        System.out.println("Word Document - " + content); 
    }
    @Override
    public Document clone()
    {
        return new WordDocument(content); 
    }
}

class TextDocument implements Document
{
    String content; 
    public TextDocument(String content)
    {
        this.content = content; 
    }
    
    @Override 
    public void getDoc()
    {
        System.out.println("Text Document - " + content); 
    }
    @Override
    public Document clone()
    {
        return new TextDocument(content); 
    }
}

class DocManager 
{
    String pdfContent, wordContent, textContent;
    Map<String, Document> mp = new HashMap<String, Document>(); 
    public DocManager(String pdfContent, String wordContent, String textContent)
    {
        this.pdfContent = pdfContent; 
        this.wordContent = wordContent; 
        this.textContent = textContent; 
        mp.put("pdf", new PdfDocument(pdfContent)); 
        mp.put("word", new WordDocument(wordContent)); 
        mp.put("text", new TextDocument(textContent));
    }
    
    public Document clone(String key)
    {
        try{
            if(mp.containsKey(key))
                return mp.get(key).clone();
            else    
                throw new Exception("Document type doesnt exist");
        } 
        catch(Exception ex)
        {
            return null;
        }
    }
}


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        DocManager docManager = new DocManager("PDF Content", "", ""); 
        Document clonedDoc = docManager.clone("pdf"); 
        clonedDoc.getDoc(); 
	}
}
