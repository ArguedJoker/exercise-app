package com.qa.exerciseapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The routine you are looking for does not exist")
public class RoutineNotFoundException extends EntityNotFoundException {
}
