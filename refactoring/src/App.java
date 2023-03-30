import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer a conexão HTTP e buscar as melhores séries de TV
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        ContentExtractor extractor = new ImdbContentExtractor();
        
        ClienteHTTP http = new ClienteHTTP();
        String json = http.buscaDados(url);

       


        //exibir e manipular dados
        StickerFactory stickerGenerator = new StickerFactory();
        List<Conteudo> contents = extractor.extractContents(json);

        
        for (int i=0; i < contents.size(); i++) {
            Conteudo content = contents.get(i);

            InputStream urlImage =  new URL(content.getUrlImagem()).openStream();

            stickerGenerator.create(urlImage, content.getTitulo(), content.getTitulo());

            System.out.println("\u001b[1mTítulo: \u001b[m" + content.getTitulo());
            System.out.println("");
        }
    }
}
