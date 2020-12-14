package com.example.movietvcatalogue.ui.tvshow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietvcatalogue.databinding.FragmentTvShowsBinding
import com.example.movietvcatalogue.viewmodel.ViewModelFactory

class TvShowsFragment : Fragment() {

    companion object{
        private const val TAG = "TvShowsFragment"
    }

    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)
            val tvShows = viewModel.getDataTvShows()

            Log.d(TAG, tvShows.toString())

            val tvShowsAdapter = TvMoviesAdapter()
            tvShowsAdapter.setMovies(tvShows)
            with(fragmentTvShowsBinding.rvTvShow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }
}