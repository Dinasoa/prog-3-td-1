package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AuthorService {
    private final AuthorRepository repository;

    public List<AuthorEntity> getAuthors (){
        return repository.findAll();
    }

    public List<AuthorEntity> createAuthors(List<AuthorEntity> authors){
        return repository.saveAll(authors);
    }

    public List<AuthorEntity> updateAuthors(List<AuthorEntity> authors){
        return repository.saveAll(authors);
    }

    public AuthorEntity deleteAuthor(int authorsId){
        Optional<AuthorEntity> optional = repository.findById(authorsId) ;
        if(optional.isPresent()){
            repository.delete(optional.get());
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, authorsId + " Not found");
        }
    }

    public Optional<AuthorEntity> searchByName (String authorName){
        return repository.findAuthorEntityByName(authorName);
    }

}
