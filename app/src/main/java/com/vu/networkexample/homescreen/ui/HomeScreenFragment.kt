package com.vu.networkexample.homescreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vu.networkexample.R
import kotlinx.coroutines.launch

class HomeScreenFragment : Fragment() {

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllObjects()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.objectsState.collect { itemsInApiResponse ->
                    if (itemsInApiResponse.isNotEmpty()) {
                        var textValue = ""
                        itemsInApiResponse.map { item ->
                            textValue = textValue + item + "\n\n"
                        }
                        view.findViewById<TextView>(R.id.text).text = textValue
                    }
                }
            }
        }
    }
}