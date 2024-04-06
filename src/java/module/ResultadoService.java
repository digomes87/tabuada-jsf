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
    
    String filepath = "data/resultado.json";
    
 

//    // Método para carregar os resultados do arquivo JSON
    public List<ResultadoAluno> carregarResultados() {
        List<ResultadoAluno> resultados = new ArrayList<>();
        File file = new File(filepath);
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
    
    private void salvarResultados(List<ResultadoAluno> resultados) {
    String path = "C:/Users/Diego/OneDrive/Documentos/NetBeansProjects/tabuada/data/resultados.json";
    try (FileWriter fileWriter = new FileWriter(path, true)) { // Abre o arquivo no modo de adição
        Gson gson = new Gson();
        for (ResultadoAluno resultado : resultados) {
            String json = gson.toJson(resultado);
            
            // Adiciona uma vírgula antes do novo objeto JSON, se o arquivo já contiver dados
            File file = new File(path);
            if (file.exists() && file.length() > 0) {
                fileWriter.write(", ");
            }
            
            fileWriter.write(json); // Escreve o JSON do resultado atual
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
//    // Método para salvar os resultados em um arquivo JSON
//    private void salvarResultados(List<ResultadoAluno> resultados) {
//    String path = "C:/Users/Diego/OneDrive/Documentos/NetBeansProjects/tabuada/data/resultados.json";
//        try (FileWriter fileWriter = new FileWriter(path, true)) { // Abre o arquivo no modo de adição
//            Gson gson = new Gson();
//            String json = gson.toJson(resultados);
//
//            // Adiciona uma vírgula antes do novo array JSON, se o arquivo já contiver dados
//            File file = new File(path);
//            if (file.exists() && file.length() > 0) {
//                fileWriter.write(", ");
//            }
//
//            fileWriter.write(json); // Escreve o JSON completo de uma vez
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
