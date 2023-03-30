import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor{
    public List<Conteudo> extractContents(String json) {

        JsonParser parser = new JsonParser();
        List<Map<String, String>> atributesList = parser.parse(json);
        List<Conteudo> contents = new ArrayList<>();

        for (Map<String, String> atributes : atributesList) {
            String title = atributes.get("title");
            String imageUrl = atributes.get("url");
            Conteudo content = new Conteudo(title, imageUrl);
            contents.add(content);
        }

        return contents;

    }
}
