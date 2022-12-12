package app.prog.controller.mapper;

import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthor;
import app.prog.controller.response.UpdateAuthor;
import app.prog.model.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponse toRest(AuthorEntity domain){
        return AuthorResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .particularity(domain.getParticularity())
                .hasParticularity(domain.hasParticularity())
                .build();
    }

    public AuthorEntity toDomainCreate(CreateAuthor rest){
        return AuthorEntity.builder()
                .name(rest.getName())
                .particularity(rest.getParticularity())
                .build();
    }

    public AuthorEntity toDomainUpdate(UpdateAuthor rest){
        return AuthorEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .particularity(rest.getParticularity())
                .build();
    }
}
