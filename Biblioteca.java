// Biblioteca.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> acervo;

    public Biblioteca() {
        acervo = new ArrayList<>(); // Inicialização da lista acervo
    }

    public List<Livro> getAcervo(){
        return acervo;
    }

    public void adicionarLivro(Livro livro) throws Exception {
        if (livro == null) {
            throw new Exception("Objeto não pode ser nulo");
        }
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("O título é um campo obrigatório");
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new Exception("O autor é um campo obrigatório");
        }
        acervo.add(livro);
    }

    public void cadastrar(Scanner scan) {
        System.out.println("Digite o título:");
        String titulo = scan.nextLine();
        System.out.println("Digite o nome do Autor:");
        String autor = scan.nextLine();

        int ano = 0;
        boolean anoValido = false;
        while (!anoValido) {
            System.out.println("Digite o ano de publicação:");
            if (scan.hasNextInt()) {
                ano = scan.nextInt();
                anoValido = true;
            } else {
                System.out.println("Ano inválido. Por favor, insira um número inteiro.");
                scan.next(); 
            }
        }
        scan.nextLine(); 
        int paginas = 0;
        boolean paginasValidas = false;
        while (!paginasValidas) {
            System.out.println("Digite o número de páginas:");
            if (scan.hasNextInt()) {
                paginas = scan.nextInt();
                paginasValidas = true; 
            } else {
                System.out.println("Número de páginas inválido. Por favor, insira um número inteiro.");
                scan.next(); 
            }
        }
        scan.nextLine(); 

        Livro novoLivro = new Livro();
        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setAnoPublicacao(ano);
        novoLivro.setNumeroPaginas(paginas);
        
        try {
            adicionarLivro(novoLivro);
            System.out.println(titulo + " cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimeListaLivros(){
        List<Livro> livros = getAcervo(); 
        System.out.println("Livros do Acervo");
        for (Livro livro : livros) {
            System.out.println(" - Título: " + livro.getTitulo());
            System.out.println(" - Autor: " + livro.getAutor());
            System.out.println(" - Ano de publicação: " + livro.getAnoPublicacao());
            System.out.println(" - Número de Páginas: " + livro.getNumeroPaginas());
        }
    }
    public void pesquisarLivro(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosEncontrados.add(livro);
            }
        }
        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse título: " + titulo);
        } else {
            System.out.println("Livros encontrados:");
            for (Livro livro : livrosEncontrados) {
                System.out.println(" - Título: " + livro.getTitulo());
                System.out.println(" - Autor: " + livro.getAutor());
                System.out.println(" - Ano de publicação: " + livro.getAnoPublicacao());
                System.out.println(" - Número de Páginas: " + livro.getNumeroPaginas());
            }
        }
    }
    

    public void excluirLivro(String titulo){
        boolean livroRemovido = false;
        for (int i = 0; i < acervo.size(); i++){
            if(acervo.get(i).getTitulo().equalsIgnoreCase(titulo)){
                acervo.remove(i);
                livroRemovido = true;
                break;
            }
        }
        if (livroRemovido){
            System.out.println("Livro removido com sucesso.");
        }else {
            System.out.println("Nenhum livro encontrado com esse título:");
        }
    }
    



}