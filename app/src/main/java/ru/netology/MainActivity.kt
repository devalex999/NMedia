package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils.formatNumber
import androidx.activity.viewModels
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.view.*
import ru.netology.databinding.ActivityMainBinding
import ru.netology.util.Util
import ru.netology.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()

        viewModel.data.observe(this) { post ->
            with(binding) {
                txtAuthor.text = post.author
                txtPublished.text = post.published
                txtContent.text = post.content
                imgLike.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_like
                )
                txtLike.text = post.countLike.toString()
                txtShare.text = post.countShare.toString()
                txtShare.text = Util.count(post.countShare)
                txtVisibility.text = post.countVisibility.toString()
                txtVisibility.text = Util.count(post.countVisibility)
            }
        }

        binding.imgLike.setOnClickListener {
            viewModel.like()
        }
        binding.imgShare.setOnClickListener {
            viewModel.share()
        }
        binding.imgVisibility.setOnClickListener {
            viewModel.visibility()
        }
    }
}