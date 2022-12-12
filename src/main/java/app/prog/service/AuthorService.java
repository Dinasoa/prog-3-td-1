package app.prog.service;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AuthorService {
    private final AuthorRepository repository;

    private final AuthorMapper mapper;

    public List<AuthorEntity> getAuthors (){
        return repository.findAll();
    }

    public List<AuthorEntity> postAuthors(List<AuthorEntity> authors){
        return repository.saveAll(authors);
    }

    public List<AuthorEntity> updateAuthors(List<AuthorEntity> authors){
        return repository.saveAll(authors);
    }

    public AuthorEntity deleteAuthors(int authorsId){
        Optional<AuthorEntity> optional = repository.findById(authorsId) ;
        if(optional.isPresent()){
            repository.delete(optional.get());
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, authorsId + " Not found");
        }
    }

}
