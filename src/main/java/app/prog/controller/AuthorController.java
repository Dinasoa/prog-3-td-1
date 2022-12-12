package app.prog.controller;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthor;
import app.prog.controller.response.UpdateAuthor;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class AuthorController {
    private final AuthorService service;
    private final AuthorMapper mapper;

    @GetMapping("/authors")
    public List<AuthorResponse> getAllAuthors(){
        return service.getAuthors().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/authors")
    public List<AuthorResponse> createAuthors(@RequestBody List<CreateAuthor> author){
        List<AuthorEntity> domain = author.stream()
                .map(mapper::toDomainCreate)
                .toList();
        return service.postAuthors(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateAuthors(@RequestBody List<UpdateAuthor> author){
        List<AuthorEntity> domain = author.stream()
                .map(mapper::toDomainUpdate)
                .toList();
        return service.updateAuthors(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/author/{id_author}")
    public AuthorEntity deleteAuthor(@PathVariable int authorId){
        return service.deleteAuthors(authorId);
    }

}
