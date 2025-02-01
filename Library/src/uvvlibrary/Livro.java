package uvvlibrary;

public class Livro {
    int idLivro;
    String titulo, autor, editora, ISBN;
    float preco;
    
    public Livro(int idLivro, String titulo, String autor, String editora, String ISBN, float preco){
        this.idLivro = idLivro;
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.ISBN = ISBN;
        this.preco = preco;
    }
}
