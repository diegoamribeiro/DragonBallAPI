package com.dmribeiro87.dragonballapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dmribeiro87.dragonballapi.R
import com.dmribeiro87.dragonballapi.data.remote.CharactersApiService
import com.dmribeiro87.dragonballapi.data.remote.NetworkConfig
import com.dmribeiro87.dragonballapi.databinding.FragmentFirstBinding
import com.dmribeiro87.dragonballapi.repository.CharactersRepository
import com.dmribeiro87.dragonballapi.ui.viewmodel.CharacterViewModel
import com.dmribeiro87.dragonballapi.ui.viewmodel.CharacterViewModelFactory

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMain: CharacterAdapter

    private val characterViewModel: CharacterViewModel by viewModels {
        CharacterViewModelFactory(
            CharactersRepository(
                NetworkConfig.getInstance().create(CharactersApiService::class.java)
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observers()
        setListener()
    }

    private fun setupRecyclerView() {
        binding.rvCharacters.apply {
            adapterMain = CharacterAdapter(requireContext())
            adapter = adapterMain
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun setListener() {
        adapterMain.setAction { character ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(character)
            NavHostFragment.findNavController(this).navigate(action)
        }

    }

    private fun observers() {
        characterViewModel.characters.observe(viewLifecycleOwner) { list ->
            adapterMain.updateCharacters(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}