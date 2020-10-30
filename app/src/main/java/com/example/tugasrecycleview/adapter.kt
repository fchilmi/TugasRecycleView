package com.example.tugasrecycleview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list.view.*

class HeroAdapter(private val heroes: List<Hero>,
                  private val adapterOnClick: (Hero) -> Unit) : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.list, viewGroup, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bindHero(heroes[position])
    }

    inner class HeroHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindHero(hero: Hero) {
            itemView.apply {
                lbList.text = hero.name
                Picasso.get().load(hero.image).into(imageHero)

                setOnClickListener {
                    adapterOnClick(hero)
                }
            }
        }
    }
}