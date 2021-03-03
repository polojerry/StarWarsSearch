package fakeRepoitory

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import fakeData.DataFake
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SearchCharacterRepositoryFake : SearchCharacterRepository {
    override suspend fun searchCharacter(characterName: String): Flow<List<CharacterModel>> {
        val characterListFake = listOf(
            DataFake.characters.character,
            DataFake.characters.character1,
        )

        return flowOf(characterListFake)
    }
}