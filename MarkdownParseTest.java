import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
// two lines above are to import JUnit

public class MarkdownParseTest {
    
    @Test // declares that this method is a test
    public void addition() {
        assertEquals(2, 1+1); 
        // checks that the arguments are equal
    }

    @Test
    public void getLinksTest() throws IOException {
        Path fileName = Path.of("test1.md");
        String content = Files.readString(fileName);
        MarkdownParse test = new MarkdownParse();
        List expected = List.of("https://something.com", "some-thing.html");
        assertEquals(test.getLinks(content), expected);
    }

    @Test
    public void getLinksTest2() throws IOException {
        Path fileName = Path.of("test2.md");
        String content = Files.readString(fileName);
        MarkdownParse test = new MarkdownParse();
        List expected = List.of();
        assertEquals(test.getLinks(content), expected);
    }

    @Test
    public void getLinksTest3() throws IOException {
        Path fileName = Path.of("test3.md");
        String content = Files.readString(fileName);
        MarkdownParse test = new MarkdownParse();
        List expected = List.of();
        assertEquals(test.getLinks(content), expected);
    }

    // @Test
    // public void getLinksFail() throws IOException {
    //     Path fileName = Path.of("test-file9.md");
    //     String content = Files.readString(fileName);
    //     MarkdownParse test = new MarkdownParse();
    //     List expected = List.of("(link.com)");
    //     assertEquals(expected, test.getLinks(content));
    // }



    @Test
    public void snippet1() throws IOException {
    Path fileName = Path.of("test-snippet-1.md");
    String content = Files.readString(fileName);
    MarkdownParse test = new MarkdownParse();
    List expected = List.of("`google.com");
    assertEquals(expected, test.getLinks(content));
    }

    @Test
    public void snippet2() throws IOException {
    Path fileName = Path.of("test-snippet-2.md");
    String content = Files.readString(fileName);
    MarkdownParse test = new MarkdownParse();
    List expected = List.of("a.com, a.com(())", "example.com");
    assertEquals(expected, test.getLinks(content));
    }

    @Test
    public void snippet3() throws IOException {
    Path fileName = Path.of("test-snippet-3.md");
    String content = Files.readString(fileName);
    MarkdownParse test = new MarkdownParse();
    List expected = List.of("https://www.twitter.com", 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
        "https://cse.ucsd.edu/");
    assertEquals(expected, test.getLinks(content));
    }



}
