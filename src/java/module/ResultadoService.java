package module;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import module.ResultadoAluno;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

public class ResultadoService {

    // Método para carregar os resultados do arquivo JSON
    public List<ResultadoAluno> carregarResultados() {
        List<ResultadoAluno> resultados = new ArrayList<>();
        File file = new File("data/resultados.json");
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Gson gson = new Gson();
                resultados = gson.fromJson(reader, new TypeToken<List<ResultadoAluno>>(){}.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultados;
    }

    // Método para salvar o resultado de um aluno em um arquivo JSON
    public void salvarResultado(ResultadoAluno resultadoAluno) {
        List<ResultadoAluno> resultados = carregarResultados();
        resultados.add(resultadoAluno);
        salvarResultados(resultados);
    }
    
     private ServletContext context;

    public void setContext(ServletContext context) {
        this.context = context;
    }
    
    // Método para salvar os resultados em um arquivo JSON
    private void salvarResultados(List<ResultadoAluno> resultados) {
        String path = "C:/Users/Diego/OneDrive/Documentos/NetBeansProjects/tabuada/data/resultados.json"; // Modifique este caminho para refletir o caminho absoluto para a pasta 'data' em seu sistema
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new Gson();
            gson.toJson(resultados, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para salvar os resultados em um arquivo JSON
//    private void salvarResultados(List<ResultadoAluno> resultados) {
//        File file = new File("/WEB-INF/data/resultados.json");
//        try (Writer writer = new FileWriter(file)) {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            Gson gson = new Gson();
//            gson.toJson(resultados, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
