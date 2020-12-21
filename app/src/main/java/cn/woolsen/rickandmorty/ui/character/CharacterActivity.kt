package cn.woolsen.rickandmorty.ui.character

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import cn.woolsen.architechture.BaseActivity
import cn.woolsen.rickandmorty.R
import cn.woolsen.rickandmorty.databinding.ActivityCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterActivity : BaseActivity() {

    private val viewModel by viewModels<CharacterViewModel>()
    private val pagingAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCharacterBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_character)

        binding.list.adapter = pagingAdapter

        lifecycleScope.launch {
            viewModel.characters.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }
}