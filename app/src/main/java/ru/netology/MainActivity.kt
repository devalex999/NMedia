package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.databinding.ActivityMainBinding
import ru.netology.dto.Post
import ru.netology.util.Util
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем понявились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остается с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен. https://netology.ru/",
            published = "21 мая в 18:36",
            likedByMe = false,
            countLike = 999,
            countShare = 998,
            countVisibility = 998
        )

        with(binding) {
            txtAuthor.text = post.author
            txtPublished.text = post.published
            txtContent.text = post.content

            if (post.likedByMe) {
                imgLike.setImageResource(R.drawable.ic_liked)
            }
            txtLike.text = post.countLike.toString()
            imgLike.setOnClickListener {
                if (!post.likedByMe) post.countLike++ else post.countLike--
                txtLike.text = Util.count(post.countLike)
                post.likedByMe = !post.likedByMe
                imgLike.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_like
                )
            }
            txtShare.text = post.countShare.toString()
            imgShare.setOnClickListener {
                post.countShare++
                txtShare.text = Util.count(post.countShare)
            }
            txtVisibility.text = post.countVisibility.toString()
            imgVisibility.setOnClickListener {
                post.countVisibility++
                txtVisibility.text = Util.count(post.countVisibility)
            }
        }
    }
}