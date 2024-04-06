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
    
    String filepath = "C:/Users/Diego/OneDrive/Documentos/NetBeansProjects/tabuada/data/resultados.json";

    
    public List<ResultadoAluno> carregarResultados() {
        List<ResultadoAluno> resultados = new ArrayList<>();
        File file = new File(filepath);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Gson gson = new Gson();
                resultados = gson.fromJson(reader, new TypeToken<List<ResultadoAluno>>(){}.getType());
                System.out.println("Resultados carregados do arquivo JSON: " + resultados);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo JSON não existe.");
        }
        return resultados;
    }


    // Método para salvar o resultado de um aluno em um arquivo JSON
    public void salvarResultado(ResultadoAluno resultadoAluno) {
    List<ResultadoAluno> resultados = carregarResultados();
        if (resultados == null) {
            System.out.println("A lista de resultados é nula. Não foi possível carregar os resultados.");
            resultados = new ArrayList<>(); // Cria uma nova lista vazia
        }
        resultados.add(resultadoAluno);
        salvarResultados(resultados);
    }

    
     private ServletContext context;

    public void setContext(ServletContext context) {
        this.context = context;
    }
    
    private void salvarResultados(List<ResultadoAluno> resultados) {
        String path = "C:/Users/Diego/OneDrive/Documentos/NetBeansProjects/tabuada/data/resultados.json";
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new Gson();
            fileWriter.write("["); // Adiciona o início do array JSON
            for (int i = 0; i < resultados.size(); i++) {
                if (i > 0) {
                    fileWriter.write(", "); // Adiciona a vírgula entre os objetos JSON
                }
                ResultadoAluno resultado = resultados.get(i);
                String json = gson.toJson(resultado);
                fileWriter.write(json); // Escreve o JSON do resultado atual
            }
            fileWriter.write("]"); // Adiciona o final do array JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}