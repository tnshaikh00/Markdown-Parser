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
}