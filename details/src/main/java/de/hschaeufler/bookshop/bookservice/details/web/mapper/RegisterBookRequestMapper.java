package de.hschaeufler.bookshop.bookservice.details.web.mapper;

import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookRequestDTO;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.RegisterBookRequestModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterBookRequestMapper {

    public RegisterBookRequestModel toRequestModel(RegisterBookRequestDTO registerBookRequestDTO){
        return new RegisterBookRequestModel(
                registerBookRequestDTO.getTitle(),
                registerBookRequestDTO.getAuthor(),
                registerBookRequestDTO.getIsbn()
        );
    }
}
