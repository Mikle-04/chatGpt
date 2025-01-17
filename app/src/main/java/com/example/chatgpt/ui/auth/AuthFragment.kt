package com.example.chatgpt.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.chatgpt.R
import com.example.chatgpt.databinding.FragmentAuthBinding
import com.example.chatgpt.presentation.auth.AuthViewModel
import com.example.chatgpt.presentation.auth.LoginState
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthFragment : Fragment(R.layout.fragment_auth) {

    private lateinit var binding : FragmentAuthBinding

    private val authViewModel: AuthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthBinding.bind(view)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
            } else {
                authViewModel.login(email, password)
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        authViewModel.loginState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is LoginState.Loading -> showLoading()
                is LoginState.Success -> navigateToHome()
                is LoginState.Error -> showError(state.message)
            }
        })
    }

    private fun showLoading() {
        Toast.makeText(requireContext(), "Авторизация...", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToHome() {
        Toast.makeText(requireContext(), "Вход успешен!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_authFragment_to_homeFragment)
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), "Ошибка входа: $message", Toast.LENGTH_SHORT).show()
    }

}
