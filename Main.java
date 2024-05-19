
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean funfando = true;

        while (funfando) {
            Livro.status();
            int opcao = 0;
            boolean entradaValida = false;
            
            while (!entradaValida) {
                try {
                    opcao = scan.nextInt();
                    cls();
                    entradaValida = true;
                } catch (Exception e) {
                    System.out.println("Opção inválida. Por favor insira um número.");
                    scan.next();
                    continuar(scan);
                    scan.next();
                    cls();
                }   
            }
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("1 - Cadastrar livro:");
                    biblioteca.cadastrar(scan);
                    continuar(scan);
                    cls();
                    break;

                case 2:
                    System.out.println("2 - Listar livros:");
                    biblioteca.imprimeListaLivros();
                    continuar(scan);
                    cls();
                    break;

                case 3:
                    System.out.println("3 - Pesquisar livro:");
                    System.err.println("Digite o título do livro:");
                    String titulo = scan.nextLine();
                    biblioteca.pesquisarLivro(titulo);
                    continuar(scan);
                    cls();
                    break;

                case 4:
                    System.out.println("4 - Excluir livro");
                    System.out.println("Digite o título do livro:");
                    String titulo2 = scan.nextLine();
                    biblioteca.excluirLivro(titulo2);
                    continuar(scan);
                    cls();
                    break;

                case 0:
                    System.out.println("0 - Sair");
                    funfando = false;
                    continuar(scan);
                    cls();
                    break;
    
                default:
                    System.out.println("Opção invalida, tente novamente");
                    continuar(scan);
                    cls();
                    break;     
            }
        }
        scan.close(); 
    }
    private static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {

        } catch (IOException e) {
            System.out.println("Erro ao limpar a tela: " + e.getMessage());
        }
    }
    
    
    private static void continuar(Scanner scan) {
        System.out.println("Pressione ENTER para continuar.");
        scan.nextLine();
    }
    
    }



