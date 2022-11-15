package de.hschaeufler.bookshop.bookservice.details.web.mapper;

import de.hschaeufler.bookshop.bookservice.details.web.model.GetBooksResponseDTO;
import de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase.GetBooksResponseModel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetBooksResponseMapper {
    public GetBooksResponseDTO toResponseDTO(GetBooksResponseModel getBooksResponseModel) {
        return new GetBooksResponseDTO(
                getBooksResponseModel.getTitle(),
                getBooksResponseModel.getAuthor(),
                getBooksResponseModel.getIsbn(),
                getBooksResponseModel.getBookNumber()
        );
    }

    public List<GetBooksResponseDTO> toResponseDTOs(List<GetBooksResponseModel> getBooksResponseModels) {
        return getBooksResponseModels.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
