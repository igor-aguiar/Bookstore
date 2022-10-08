package igoraguiar.com.github.Bookstore.dto;

import igoraguiar.com.github.Bookstore.model.Author;

public class AuthorDTO {
    private String authorName;

    public AuthorDTO(String nameAuthor) {
        this.authorName = nameAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public AuthorDTO() {
    }

    public Author toAuthor(){
        return new Author(this.authorName);
    }
}
