package com.afrinaldi.myfirstlazy.data

import com.afrinaldi.myfirstlazy.model.Hero
import com.afrinaldi.myfirstlazy.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero>{
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}