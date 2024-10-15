package org.mvc.itvdnstudyspringmvc2.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mvc.itvdnstudyspringmvc2.validation.BookCreate;
import org.mvc.itvdnstudyspringmvc2.validation.BookNameUnique;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;

    @NotEmpty(message = "The book title cannot be empty")
    @BookNameUnique(groups = BookCreate.class)
    private String name;

    @NotEmpty(message = "The author cannot be empty")
    private String author;

    @NotEmpty(message = "The description cannot be empty")
    private String description;

    @DecimalMin(value = "20.0", message = "The price cannot be lower than 20.00")
    @NotNull(message = "The price cannot be empty")
    private Double price;

}
