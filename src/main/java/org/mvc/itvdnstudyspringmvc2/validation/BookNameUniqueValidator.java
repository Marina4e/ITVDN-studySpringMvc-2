package org.mvc.itvdnstudyspringmvc2.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.mvc.itvdnstudyspringmvc2.repository.BookRepository;

@RequiredArgsConstructor
public class BookNameUniqueValidator implements ConstraintValidator
        <BookNameUnique, String> {

    private final BookRepository bookRepository;

    @Override
    public boolean isValid(String name,
                           ConstraintValidatorContext constraintValidatorContext) {
        return bookRepository.findByName(name).isEmpty();
    }
}
