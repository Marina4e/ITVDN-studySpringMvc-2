package org.mvc.itvdnstudyspringmvc2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;
import org.mvc.itvdnstudyspringmvc2.model.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    Book toModel(BookDTO bookDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    BookDTO toDto(Book book);
}
