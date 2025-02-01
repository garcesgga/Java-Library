package uvvlibrary;
//import das bibliotecas utilizadas no codigo
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//classe geren, nela vamos instaciar as duas classe e vamos atribuir novas funções
public class Geren {
    // Associação da classe aluno com a geren.
    private static List<Aluno> membros = new ArrayList<>();
    //função cadastro aluno criada a parti da classe aluno
    public void cadastroAluno(){
       InOut.MsgDeInformacao("Cadastro", "Cadastrar aluno");
       int idAluno = InOut.leInt("Escreva o seu numero de matricula.");
       if(alunoRep(idAluno)){
            InOut.MsgDeAviso("Aviso","Matricula já existente, favor adicionar outro.");
            return;
       }
       String nome = InOut.leString( "Escreva seu nome.");
       String curso = InOut.leString("Escreva seu curso.");
       
      //instanciando a classe ALUNO ou seja criando um objeto
       Aluno aluno = new Aluno(idAluno, nome, curso);
       membros.add(aluno);
       InOut.MsgDeAviso("Fim", "Conclução do Cadastro.");
    }
     //associação da classe livro com a geren
    private static List<Livro> livros = new ArrayList<>();
   //função cadatrolivro criada aparti da classe aluno
    public void cadastroLivro(){
        InOut.MsgDeInformacao("Cadastro", "Cadastrar livro");
        int idLivro = InOut.leInt("Escreva o codigo de cadastro do livro.");
        if(livroRep(idLivro)){
            InOut.MsgDeAviso("Aviso","Codigo já existente, favor adicionar outro.");
            return;
        }
        String titulo = InOut.leString("Escreva o titulo do livro.");
        String autor = InOut.leString("Escreva o autor.");
        String editora = InOut.leString("Escreva a editora.");
        String ISBN = InOut.leString("Escreva o ISBN.");
        float preco = InOut.leFloat("Escreva o valor do livro.");
        
        //instanciando a classe livro == Criar um novo obj
        Livro livro = new Livro(idLivro, titulo, autor, editora, ISBN, preco);
        livros.add(livro);
        InOut.MsgDeAviso("Fim", "Conclusão do Cadastro.");
    }
    //associando a classe emprestimo com a geren
    private static List<Emprestimo> saida = new ArrayList<>();
    
    //fução criada aparti da classe Emprestimo
    public void cadastroEmpres(){
        InOut.MsgDeInformacao("Emprestimo", "Novo Emprestimo.");
        int aluno = InOut.leInt("Escreva sua matricula.");
        if (alunoExist(aluno)){
            InOut.MsgDeAviso("Aviso","A matricula não existe.");
            return;
        }
        int livro = InOut.leInt("Escrevra o codigo do livro.");
        if (livroExist(livro)){
            InOut.MsgDeAviso("Aviso","O codigo não existe.");
            return;
        }
        else if (livroSaida(livro)){
            InOut.MsgDeAviso("Aviso","O livro já foi pego.");
            return;
        }
        String dataSaid = InOut.leString("Escreva a data de retirada o livro em (dd/MM/yyyy)");
        String dataRetorno = InOut.leString("Escreva a data para a entrega do livro em (dd/MM/yyyy)");
        float valorMulta = InOut.leFloat("Escreva o valor da multa por dia.");
        int r = new Random().nextInt(10000);
        int idEmpres = r;
        if (empresRep(idEmpres)){
            idEmpres = new Random().nextInt(10000);
        }
        InOut.MsgSemIcone("Cadastro", "O codigo do imprestimo é: " + idEmpres);
        Emprestimo empres = new Emprestimo(idEmpres,dataSaid,dataRetorno,valorMulta,livro,aluno);
        saida.add(empres);
        InOut.MsgDeAviso("Fim", "Conclusão do Emprestimo.");
    }
    // funcao criada caso a lista de alunos estiver vazia
    public void listAlunos(){
        if(membros.isEmpty()){
            InOut.MsgDeErro("ERRO", "Nenhum Cadastro de Aluno Encontrado.");
            return;
        }
        for(Aluno aluno : membros){
            InOut.MsgDeInformacao("Lista de Cadastros", "Matricula: " + aluno.idAluno + "\n Nome: " + aluno.nome + "\n Curso: " + aluno.curso);
        }
    } 
     // funcao criada caso a lista de livros estiver vazia
    public void listLivro(){
        if(livros.isEmpty()){
            InOut.MsgDeErro("ERRO", "Nenhum Livro Encontrado.");
            return;
        }
        for(Livro livro : livros){
            InOut.MsgDeInformacao("Lista de Livros", "Codigo : " + livro.idLivro + "\n Titulo: " + livro.titulo + "\n Autor: " + livro.autor + "\n Editora:" + livro.editora + "\n ISBN:" + livro.ISBN +"\n Preço:" + livro.preco);
        }
    }
     // funcao criada caso a lista de emprestimo estiver vazia
    public void listEmpres(){
        if(saida.isEmpty()){
            InOut.MsgDeErro("ERRO", "Nenhum Emprestimo Encontrado.");
            return;
        }
        for(Emprestimo empres : saida){
           InOut.MsgDeInformacao("Lista de Emprestimos", "Codigo: " + empres.idEmpres + "\n Matricula do aluno: " + empres.idAluno + "\n Codigo do livro: " + empres.idLivro + "\n Data de retirada: " + empres.dataSaid + "\n Data de entrega: " + empres.dataRetorno);
        }
    }
    
    // função criada para a devolução do livro emprestado
    //calcula a multa caso atraso, varias funções importantes para o processo.
    public void entregaLivro() throws ParseException{
        int empres = InOut.leInt("Escreva o codigo do emprestimo.");
        
        Emprestimo emprest = obterEmpres(empres);
        if(emprest == null){
            InOut.MsgDeErro("ERRO", "Codigo inexistente.");
            return;
        }
        String dataEntre = InOut.leString("Escreva a data que o livro foi devolvido. dd/MM/yyyy");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data1 = formatoData.parse(emprest.dataRetorno);
        Date data2 = formatoData.parse(dataEntre);
        long atraso = (data2.getTime() - data1.getTime()) / (24 * 60 * 60 * 1000);
        if(atraso > 0){
            float multa = atraso * emprest.valorMulta;
            InOut.MsgDeAviso("Multa", "O valor da multa a ser pago é: " + multa + "R$");
        }
        saida.remove(emprest);
        InOut.MsgDeAviso("Concluido", "A entrega do livro foi feita.");

        
    }
    //função para pegar livro
    public void perdaLivro(){
       int empres = InOut.leInt("Escreva o codigo do emprestimo.");
       
        Emprestimo emprest = obterEmpres(empres);
        if(emprest == null){
            InOut.MsgDeErro("ERRO", "Codigo inexistente.");
            return;
        }
       int livro = InOut.leInt("Escreva o codigo do livro.");
        Livro livr = testLivro(livro);
        if(livr == null){
            InOut.MsgDeErro("ERRO", "Codigo inexistente.");
            return;
        }
        if (livr.idLivro == emprest.idLivro){
            InOut.MsgDeAviso("Multa", "O valor da multa a ser pago é: " + livr.preco + "R$");
            livros.remove(livro);
            saida.remove(emprest);
            InOut.MsgDeAviso("Concluido", "A multa da perda foi paga.");
        }
        else{
            InOut.MsgDeErro("ERRO", "Livro não faz parte do emprestimo.");
        }
    }
    //função para exibir o livro
    public void exibirLivro(){
        int livro = InOut.leInt("Escreva o codigo do livro.");

        Livro livr = testLivro(livro);
        if (livr == null){
            InOut.MsgDeErro("ERRO", "Codigo inexistente, favor inserir um existente.");
        }
        else{
            InOut.MsgDeInformacao("Livro", "Codigo : " + livr.idLivro + "\n Titulo: " + livr.titulo + "\n Autor: " + livr.autor + "\n Editora:" + livr.editora + "\n ISBN:" + livr.ISBN +"\n Preço:" + livr.preco);
 
        }
        Emprestimo livr1 = obterLivro(livro);
        if (livr1 == null){
            InOut.MsgDeInformacao("Livro", "Livro na Biblioteca");
        }
        else{
            InOut.MsgDeInformacao("Livro", "Livro no Emprestimo");
        }
    }
    // função exibi emprestimo
    public void exibirEmpres(){
        int empres = InOut.leInt("Escreva o codigo do emprestimo.");
        
        Emprestimo emprest = obterEmpres(empres);
        if(emprest == null){
            InOut.MsgDeErro("ERRO", "Codigo inexistente.");
            return;
        }
        else{
            InOut.MsgDeInformacao("Emprestimo", "Codigo: " + emprest.idEmpres + "\n Matricula do aluno: " + emprest.idAluno + "\n Codigo do livro: " + emprest.idLivro + "\n Data de retirada: " + emprest.dataSaid + "\n Data de entrega: " + emprest.dataRetorno);

        }
    }
    //funçao para exibir o cadastro de um aluno
    public void exibirAluno(){
        int aluno = InOut.leInt("Escreva sua matricula.");

        Aluno alun1 = testAlun(aluno);
        if(alun1 == null){
            InOut.MsgDeErro("Erro", "Matricula inexistente.");
        }
        else{       
            InOut.MsgDeInformacao("Aluno", "Matricula: " + alun1.idAluno + "\n Nome: " + alun1.nome + "\n Curso: " + alun1.curso);
        }
        Emprestimo alun = obterAluno(aluno);
        if (alun == null){
            InOut.MsgDeInformacao("Aluno", "Sem Nenhum Emprestimo");
        }
        else{
            InOut.MsgDeInformacao("Aluno", "Com Emprestimo");
        }
    }
    //função para altera o preço de um livro já cadastrado
    public void alteraPreco(){
        int livro = InOut.leInt("Escreva o codigo do livro.");
        
        Livro livr = testLivro(livro);
        if (livr == null){
            InOut.MsgDeErro("ERRO", "Codigo inexistente, favor inserir um existente.");
        }
        else{
            float novoPreco = InOut.leFloat("Escreva o novo valor para o preço.");
            livr.preco = novoPreco;
            InOut.MsgDeAviso("Alteração", "O item foi alterado");
        }
    }
        //função para altera o curso de um aluno(a) já cadastrado(a).
    public void alteraCurso(){
        int aluno = InOut.leInt("Escreva a sua matricula.");
        
        Aluno alun = testAlun(aluno);
        if(alun == null){
            InOut.MsgDeErro("Erro", "Matricula inexistente.");
        }
        else{
            String novoCurso = InOut.leString("Escreva o novo curso.");
            alun.curso = novoCurso;
            InOut.MsgDeAviso("Alteração", "O item foi alterado");
        }
    }
    //função para altera o data de um empre.livro já cadastrado

    public void alteraData(){
        int empres = InOut.leInt("Escreva o codigo do emprestimo.");
        
        Emprestimo empres1 = obterEmpres(empres);
        if(empres1 == null){
            InOut.MsgDeErro("Erro", "Coidgo inexistente.");
        }
        else{
            String novaData = InOut.leString("Escreva a nova data de entrega.");
            empres1.dataRetorno = novaData;
            InOut.MsgDeAviso("Alteração", "O item foi alterado");
        }
        
    }
   //função para exclui o aluno
    public void excluiAluno(){
        int aluno = InOut.leInt("Escreva sua matricula.");
        
        Aluno aluno1 = testAlun(aluno);
        if(aluno1 == null){
            InOut.MsgDeErro("Erro", "Matricula inexistente.");
            return;
        }
        
        membros.remove(aluno1);
        InOut.MsgDeAviso("Exclução", "A matricula foi excluida.");
    }
    //Função para excluir o livro
    public void excluiLivro(){
        int livro = InOut.leInt("Escreva o codigo do livro.");
        
        Livro liv1 = testLivro(livro);
                if(liv1 == null){
            InOut.MsgDeErro("Erro", "Codigo inexistente.");
            return;
        }
        
        livros.remove(liv1);
        InOut.MsgDeAviso("Exclução", "O livro foi excluido.");
        
    }
    //caso voce digite a matricula que não existe: codigo é usado na linha 235
    private Aluno testAlun(int aluno){
        for(Aluno alun : membros){
            if(alun.idAluno == aluno){
                return alun;
            }
        }
        return null;
    }
    //COdigo usado para retorna se o livro(codigo) existe
    //codigo usado na linha 149,178,221 e 279
    private Livro testLivro(int livro){
        for(Livro livr : livros){
            if(livr.idLivro == livro){
                return livr;
            }
        }
        return null;
    }
    //o codigo é usado para dizer se o aluno tem emprestimo: codigo é usado na linha 209
    private Emprestimo obterAluno(int aluno){
        for(Emprestimo empre : saida){
            if(empre.idAluno == aluno){
                return empre;
            }
        }
        return null;
    }
    //COdigo usado para retorna que o codigo do emprestimo n existe: linha 188, 143, 189, 250
    private Emprestimo obterEmpres(int empres){
        for (Emprestimo emprest : saida){
            if(emprest.idEmpres == empres){
                return emprest;  
            }
        }
        return null;
    }
    //Codigo usado para retorna se o livro, está na biblioteca ou já foi emprestado existe:
    //usado em 176
    private Emprestimo obterLivro(int livro){
        for (Emprestimo empres : saida) {
            if (empres.idLivro == livro) {
                return empres;
            }
        }
        return null;
    }
    //Codigo usado para retorna ja foi pego:  usado em 67
    private boolean livroSaida(int livro){
        for (Emprestimo empres : saida) {
            if (empres.idLivro == livro) {
                return true;
            }
        }
        return false;
    }
 //para dizer que a matricula digitada nao existe: esse codigo é usado na linha 58
    private boolean alunoExist(int idAluno) {
        for (Aluno aluno : membros) {
            if (aluno.idAluno == idAluno) {
                return false;
            }
        }
        return true;
    }
  // caso voce digite o codigo de um livro que nao existe: codigo é usado na linha 63
    private boolean livroExist(int idLivro) {
        for (Livro livro : livros) {
            if (livro.idLivro == idLivro) {
                return false;
            }
        }
        return true;
    }
    // caso voce digite a de outro aluno esse codigo é usado na linha 18
    private boolean empresRep(int idEmpres){
        for (Emprestimo empres : saida) {
            if (empres.idEmpres == idEmpres) {
                return false;
            }
        }
        return true;
    }
    // caso voce digite a matricula de outro aluno esse codigo é usado na linha 18.
    private boolean alunoRep(int idAluno) {
        for (Aluno aluno : membros) {
            if (aluno.idAluno == idAluno) {
                return true;
            }
        }
        return false;
    }
    // caso voce digite o codigo de um livro que já existe: codigo é usado na linha 36
    private boolean livroRep(int idLivro) {
        for (Livro livro : livros) {
            if (livro.idLivro == idLivro) {
                return true;
            }
        }
        return false;
    }


}
