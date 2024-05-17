import com.jotrorox.jtoml.JTomlParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JTomlParserTest {
    @Test
    public void testParse() {
        JTomlParser parser = new JTomlParser("key = \"value\"");
        Map<String, Object> test = parser.parse();
        assert test.size() == 1;
        assert test.get("key").equals("value");
        assert test.get("key").getClass().equals(String.class);
    }

    @Test
    public void testParseTable() {
        JTomlParser parser = new JTomlParser("[table]\nkey = \"value\"");
        Map<String, Object> test = parser.parse();
        assert test.size() == 1;
        assert test.get("table") instanceof Map;
        assert ((Map)test.get("table")).get("key").equals("value");
    }

    @Test
    public void testParseMultiple() {
        JTomlParser parser = new JTomlParser
                ("key1 = \"value1\"\nkey2 = 2\nkey3 = true");
        Map<String, Object> test = parser.parse();
        assert test.size() == 3;
        assert test.get("key1").equals("value1");
        assert test.get("key1").getClass().equals(String.class);
        assert test.get("key2").equals(2);
        assert test.get("key2").getClass().equals(Integer.class);
        assert test.get("key3").equals(true);
        assert test.get("key3").getClass().equals(Boolean.class);
    }

    @Test
    public void testParseComment() {
        JTomlParser parser = new JTomlParser
                ("key = \"value\" # Comment");
        Map<String, Object> test = parser.parse();
        assert test.size() == 1;
        assert test.get("key").equals("value");
        assert test.get("key").getClass().equals(String.class);
    }

    @Test
    public void testParseWhitespace() {
        JTomlParser parser = new JTomlParser
                ("  key  =  \"value\"  ");
        Map<String, Object> test = parser.parse();
        assert test.size() == 1;
        assert test.get("key").equals("value");
        assert test.get("key").getClass().equals(String.class);
    }

    @Test
    public void testParseMultipleWhitespace() {
        JTomlParser parser = new JTomlParser
                ("  key1  =  \"value1\"  \n  key2  =  2  \n  key3  =  true  ");
        Map<String, Object> test = parser.parse();
        assert test.size() == 3;
        assert test.get("key1").equals("value1");
        assert test.get("key1").getClass().equals(String.class);
        assert test.get("key2").equals(2);
        assert test.get("key2").getClass().equals(Integer.class);
        assert test.get("key3").equals(true);
        assert test.get("key3").getClass().equals(Boolean.class);
    }
}
