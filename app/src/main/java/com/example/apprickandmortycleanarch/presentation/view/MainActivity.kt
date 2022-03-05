package com.example.apprickandmortycleanarch.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprickandmortycleanarch.R

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprickandmortycleanarch.databinding.ActivityMainBinding
import com.example.apprickandmortycleanarch.domain.model.CharactersResult
import com.example.apprickandmortycleanarch.presentation.viewModel.CharactersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharactersViewModel by viewModel()
    private val adapter by lazy {
        CharactersAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configRv()
        resultsObserver()
    }

    private fun resultsObserver() {
        viewModel.characters.observe(this, androidx.lifecycle.Observer {
            adapter.updateList(it.results as MutableList<CharactersResult>)
        })
    }

    private fun configRv(){
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = GridLayoutManager(this, 2)
        //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}