import com.example.chatgpt.data.auth.RetrofitClient
import com.example.chatgpt.data.auth.api.AuthApi
import com.example.chatgpt.data.auth.repositoryImpl.AuthRepositoryImpl
import com.example.chatgpt.domain.repository.AuthRepository
import com.example.chatgpt.domain.usecase.LoginUseCase
import com.example.chatgpt.presentation.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AuthApi> { RetrofitClient.authApi }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single { LoginUseCase(get()) }
    viewModel { AuthViewModel(get()) }
}