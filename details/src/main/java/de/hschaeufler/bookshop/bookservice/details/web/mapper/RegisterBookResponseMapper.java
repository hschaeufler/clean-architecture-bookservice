package de.hschaeufler.bookshop.bookservice.details.web.mapper;

import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookResponseDTO;
import de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase.RegisterBookResponseModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterBookResponseMapper {
    public RegisterBookResponseDTO toResponseDTO(RegisterBookResponseModel registerBookResponseModel){
        return new RegisterBookResponseDTO(
                registerBookResponseModel.getTitle(),
                registerBookResponseModel.getAuthor(),
                registerBookResponseModel.getIsbn()
        );
    }
}
