package com.example.movieapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.domain.model.MovieModel
import com.example.movieapp.adapters.MoviesAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.viewmodel.MoviesViewModel
import com.example.movieapp.handle_state.StateData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MoviesViewModel by viewModels()

    private val adapter by lazy{ MoviesAdapter(MoviesAdapter.OnItemClickListener {

    }) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeUI()
    }

    private fun setupRecyclerView(){
        binding.recyclerView.adapter=adapter
    }

    private fun observeUI(){
        viewModel.moviesLiveDate.observe(this) {
            it?.let {
                when (it.status) {
                    StateData.DataStatus.LOADING -> showProgress()
                    StateData.DataStatus.SUCCESS -> handleSuccessStatus(it)
                    StateData.DataStatus.ERROR -> handleErrorStatus(it.error)
                }
            }
        }
    }

    private fun showProgress() {
        binding.progressBar.isVisible = true
    }

    private fun hideProgress() {
        binding.progressBar.isVisible = false
    }

    private fun handleSuccessStatus(it: StateData<List<MovieModel>>) {
        hideProgress()
        adapter.submitList(it.data)
    }

    private fun handleErrorStatus(it:Throwable?) {
        hideProgress()
        Toast.makeText(this,it!!.message, Toast.LENGTH_LONG).show()
    }
}