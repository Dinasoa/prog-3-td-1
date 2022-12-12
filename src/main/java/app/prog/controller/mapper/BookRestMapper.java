package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.awt.print.Book;
import java.util.Optional;

@Component
@AllArgsConstructor

public class BookRestMapper {

    private AuthorService service;

    public BookResponse toRest(BookEntity domain) {
        Optional<AuthorEntity> author = Optional.ofNullable(domain.getAuthor());
        if(author.isPresent()) {
            return BookResponse.builder()
                    .id(domain.getId())
                    .title(domain.getTitle())
                    .author(domain.getAuthor().getName())
                    .hasAuthor(domain.hasAuthor())
                    .build();
        }
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(null)
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        Optional<AuthorEntity> author = service.searchByName(rest.getAuthor()) ;
        if(author.isPresent()){
        return BookEntity.builder()
                .author(author.get())
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
        }
        return  BookEntity.builder()
                .title(rest.getTitle())
                .author(null)
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        Optional<AuthorEntity> author = service.searchByName(rest.getAuthor()) ;
        if(author.isPresent()) {
            return BookEntity.builder()
                    .id(rest.getId())
                    .author(author.get())
                    .title(rest.getTitle())
                    .pageNumber(0) //Constraint not null in database, default value is 0
                    .build();
        }
        return BookEntity.builder()
                .id(rest.getId())
                .author(null)
                .title(rest.getTitle())
                .pageNumber(0)
                .build();
    }
}
