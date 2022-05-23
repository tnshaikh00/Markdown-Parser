//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
 /**
  * 
  *
  *This is a reviewed Markdown Parser from https://github.com/Pgerardocastaneda/markdown-parser/blob/main/MarkdownParse.java
  *
  *
  */


public class OtherMarkdown {
 
   public static ArrayList<String> getLinks(String markdown) {
       ArrayList<String> toReturn = new ArrayList<>();
       int currentIndex = 0;
       while(currentIndex < markdown.length()) {
           int openBracket = markdown.indexOf("[", currentIndex);
           int closeBracket = markdown.indexOf("]", openBracket);
           int openParen = markdown.indexOf("(", closeBracket);
           int closeParen = markdown.indexOf(")", openParen); 
 
 
          
 
           if (markdown.indexOf("!", currentIndex) != -1){
               int exclamationMark = markdown.indexOf("!", currentIndex);
               if((exclamationMark + 1) == openBracket){
                   currentIndex = markdown.indexOf(")", currentIndex) + 1;
                   continue;
               }
           }   
 
           if(openBracket == -1){
               break;
           } else if(closeBracket == -1){
               break;
           } else if(openParen == -1){
               break;
           } else if(closeParen == -1){
               break;
           }
 
           currentIndex = closeParen + 1;
           String urlString = markdown.substring(openParen + 1, closeParen);
           if (urlString.indexOf(" ") != -1){
               continue;
           }
           toReturn.add(urlString);
          
       }
 
       return toReturn;
   }
 
   public static void main(String[] args) throws IOException {
       Path fileName = Path.of(args[0]);
       String content = Files.readString(fileName);
       ArrayList<String> links = getLinks(content);
       System.out.println(links);
   }
}