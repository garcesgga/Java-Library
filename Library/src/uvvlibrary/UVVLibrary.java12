
package uvvlibrary;

import java.text.ParseException;


public class UVVLibrary {

// aqui chamamos as funçoes e metodos feitos pela classe geren
// main é o ponto de partida da execução do programa.
//A exceção ParseException é frequentemente associada ao tratamento de datas e horas em Java.
//Quando ocorre um erro ao analisar uma data ou hora, essa exceção pode ser lançada.
    public static void main(String[] args) throws ParseException {
        InOut.MsgDeInformacao("     Menu    ", " Bem Vindo A UVVLibary ");
        while(true){
            Geren ob1 = new Geren();
            int opcao = menuP();
        //cada case é uma opção a ser feita no codgo
        //lembrando que temos varios menus e varias opções 
        // e cada uma dessas opções tem outras.
            switch (opcao) {
                case 1:
                    int opcao1 = menu1();
                    switch (opcao1){
                        case 1:
                            ob1.cadastroAluno();
                            continue;
                        case 2:
                            ob1.cadastroLivro();
                            continue;    
                        case 3:
                            ob1.cadastroEmpres();
                            continue;
                        case 4:
                            InOut.MsgDeInformacao("Fim", "Voltando ao menu principal");;
                            continue;
                        default:
                        InOut.MsgDeInformacao("Erro", "Opção Invalida"); 
                    }
                    continue;
                case 2:
                    int opcao2 = menu2();
                    switch (opcao2){
                        case 1:
                            ob1.alteraCurso();
                            continue;
                        case 2:
                            ob1.alteraPreco();
                            continue;    
                        case 3:
                            ob1.alteraData();
                            continue;
                        case 4:
                            InOut.MsgDeInformacao("Fim", "Voltando ao menu principal");;
                            continue;
                        default:
                        InOut.MsgDeInformacao("Erro", "Opção invalida"); 
                    }
                    continue;            
                case 3:
                    int opcao3 = menu3();
                    switch (opcao3){
                        case 1:
                            ob1.entregaLivro();
                            continue;
                        case 2:
                            ob1.perdaLivro();
                            continue;
                        case 3:
                            InOut.MsgDeInformacao("Fim", "Voltando ao menu principal");;
                            continue;
                        default:
                        InOut.MsgDeInformacao("Erro", "Opção invalida"); 
                    }
                    continue;    
                case 4:
                    int opcao4 = menu4();
                    switch (opcao4){
                        case 1:
                            ob1.excluiAluno();
                            continue;
                        case 2:
                            ob1.excluiLivro();
                            continue;    
                        case 3:
                            InOut.MsgDeInformacao("Fim", "Voltando ao menu principal");;
                            continue;
                        default:
                        InOut.MsgDeInformacao("Erro", "Opção invalida"); 
                    }   
                    continue;
                case 5:
                    int opcao5 = menu5(); 
                    switch (opcao5){
                        case 1:
                            ob1.exibirAluno();
                            continue;
                        case 2:
                            ob1.exibirLivro();
                            continue;    
                        case 3:
                            ob1.exibirEmpres();
                            continue;
                        case 4:
                            ob1.listAlunos();
                            continue;
                        case 5:
                            ob1.listLivro();
                            continue;
                        case 6: 
                            ob1.listEmpres();
                            continue;
                        case 7:
                            InOut.MsgDeInformacao("Fim", "Voltando ao menu principal");;
                            continue;
                        default:
                        InOut.MsgDeInformacao("Erro", "Opção invalida"); 
                    }
                    continue;
            
                case 6:
                    InOut.MsgDeInformacao("Fim", "Saindo do Programa");;
                    System.exit(0);
                    break;
                default:
                    InOut.MsgDeInformacao("Erro", "Opção invalida");
                }  
        }
    }
    //menu inicial
    private static int menuP(){
        int opcao = InOut.leInt("Selecione umas das opções abaixo:\n" +"1. Cadastrar\n" +
                                                   " 2. Alterar     \n" +
                                                   " 3. Entregar\n" +
                                                    "4. Excluir \n" +
                                                   " 5. Exibir \n" +
                                                  " 6. Sair");
        return opcao;
    }
    //menu do case1
    private static int menu1(){
        InOut.MsgDeInformacao("     Cadastro   ", " Bem Vindo a Área de Cadastro ");
        int opcao1 = InOut.leInt("Selecione umas das opções abaixo: \n"+
                                                "1. Cadastrar Aluno\n"
+                                                    "2. Cadastrar Livro \n"    
+                                                   "3. Cadastrar Emprestimo \n"
+                                                  " 4. Voltar");
        return opcao1;
        
        
    }
    //menu do case2
    private static int menu2(){
        InOut.MsgDeInformacao("     Alterar   ", " Bem Vindo a Área de Alteração");
        int opcao2 = InOut.leInt("Selecione umas das opções abaixo: \n" +
                                                   "1. Alterar Curso do Aluno \n" +
                                                    "2. Alterar Preço do Livro \n" +     
                                                   " 3. Alterar Data de Entrega \n" +
                                                   " 4. Voltar");
        return opcao2;
    }
    //menu do case 3
    private static int menu3(){
        InOut.MsgDeInformacao("     Entrega   ", " Bem Vindo a Área de Entrega");
        int opcao3 = InOut.leInt("Selecione umas das opções abaixo: \n" +
                                                   "1. Entregrar Livro \n" +
                                                    "2. Perda de Livro \n"+
                                                    "3. Voltar");
        return opcao3;
    }
    //menu do case 4
    private static int menu4(){
        InOut.MsgDeInformacao("     Excluir   ", " Bem Vindo a Área de Exclução");
        int opcao4 = InOut.leInt("Selecione umas das opções abaixo: \n" +
                                                   "1. Excluir Matricula de Aluno\n" +
                                                    "2. Excluir Livro\n" +
                                                    "3. Voltar");
        return opcao4;
    }
    ////menu do case 5
    private static int menu5(){
        InOut.MsgDeInformacao("     Exibir    ", " Bem Vindo a Área de Exibição");
        int opcao5 = InOut.leInt("Selecione umas das opções abaixo: \n" +
                                                   "1. Exibir Conta de Aluno\n" +
                                                    "2. Exibir Cadastro do Livro\n" +     
                                                    "3. Exibir Cadastro do Emprestimo\n" +
                                                    "4. Exibir todos os Alunos\n" +
                                                   " 5. Exibir todos os Livros\n" +
                                                    "6. Exibir todos os Emprestimos\n" +
                                                   " 7. Voltar"); 
        return opcao5;
    }
}
