import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.*;


public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks(){

        try{        
            Path file = Path.of("test-markdown.md");
            String content = Files.readString(file);
            ArrayList<String> links = MarkdownParse.getLinks(content);

            String link = "https://something.com";
            String link2 = "some-page.html";

            assertEquals(List.of(link,link2), links);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void snippet1() throws IOException{
        Path file = Path.of("/Users/MasterKai/Documents/GitHub/Markdown-Parser/Snippet1.md");
        String content = Files.readString(file);
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();

        expected.add("url.com");
        expected.add("`google.com");
        expected.add("google.com"); 
        expected.add("ucsd.edu");
        
        for(int i = 0; i < 4; i++){
            assertEquals(expected.get(i),actual.get(i));
        }
    }
    
    @Test
    public void snippet2() throws IOException{
        Path file = Path.of("/Users/MasterKai/Documents/GitHub/Markdown-Parser/Snippet2.md");
        String content = Files.readString(file);
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();

        expected.add("a.com");
        expected.add("a.com(())");
        expected.add("example.com"); 
        
        for(int i = 0; i < 3; i++){
            assertEquals(expected.get(i),actual.get(i));
        }
    }

    @Test
    public void snippet3() throws IOException{
        Path file = Path.of("/Users/MasterKai/Documents/GitHub/Markdown-Parser/Snippet3.md");
        String content = Files.readString(file);
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();

        expected.add("https://www.twitter.com");
        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule)");
        expected.add("[this link doesn't have a closing parenthesis](github.com" + 
                "And there's still some more text after that."); 
        expected.add("https://cse.ucsd.edu/");
        
        for(int i = 0; i < 4; i++){
            assertEquals(expected.get(i),actual.get(i));
        }
    }
}