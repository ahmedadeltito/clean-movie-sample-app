package com.ahmedadel.domain;

import com.ahmedadel.domain.repository.MovieRepository;
import com.ahmedadel.domain.repository.PersonRepository;
import com.ahmedadel.domain.repository.TVRepository;
import com.ahmedadel.domain.usecase.movie.GetMovieUseCase;
import com.ahmedadel.domain.usecase.movie.GetMoviesUseCase;
import com.ahmedadel.domain.usecase.person.GetPersonUseCase;
import com.ahmedadel.domain.usecase.person.GetPersonsUseCase;
import com.ahmedadel.domain.usecase.tv.GetTVUseCase;
import com.ahmedadel.domain.usecase.tv.GetTVsUseCase;

public class DomainInjection {

    public static GetMoviesUseCase provideMoviesUseCase(MovieRepository movieRepository) {
        return new GetMoviesUseCase(movieRepository);
    }

    public static GetMovieUseCase provideMovieUseCase(MovieRepository movieRepository) {
        return new GetMovieUseCase(movieRepository);
    }

    public static GetPersonsUseCase providePersonsUseCase(PersonRepository personRepository) {
        return new GetPersonsUseCase(personRepository);
    }

    public static GetPersonUseCase providePersonUseCase(PersonRepository personRepository) {
        return new GetPersonUseCase(personRepository);
    }

    public static GetTVsUseCase provideTVsUseCase(TVRepository tvRepository) {
        return new GetTVsUseCase(tvRepository);
    }

    public static GetTVUseCase provideTvUseCase(TVRepository tvRepository) {
        return new GetTVUseCase(tvRepository);
    }

}
