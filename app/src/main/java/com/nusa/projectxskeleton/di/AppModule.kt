package com.nusa.projectxskeleton.di

import com.nusa.projectxskeleton.domain.usecase.CommentInteractor
import com.nusa.projectxskeleton.domain.usecase.CommentUseCase
import com.nusa.projectxskeleton.presentation.comment.CommentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModul = module {
    factory<CommentUseCase> {
        CommentInteractor(
            get()
        )
    }
}

val viewModelModule = module {
    viewModel {
        CommentViewModel(get())
    }

}