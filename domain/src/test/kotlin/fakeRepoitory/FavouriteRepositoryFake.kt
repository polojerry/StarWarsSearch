package fakeRepoitory

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FavouriteRepositoryFake : FavouriteRepository {
    private val db  = HashMap<String, CharacterModel>()

    override suspend fun insertFavourite(characterModel: CharacterModel) {
        db[characterModel.url] = characterModel
    }

    override suspend fun getFavourites(): Flow<List<CharacterModel>> {
        return flowOf(db.values.toList())
    }
}