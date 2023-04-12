package rest.kotlin.restapi.services

import org.bson.types.ObjectId
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import rest.kotlin.restapi.entities.Item
import rest.kotlin.restapi.repositories.ItemRepository

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {
    fun findAll(): List<Item> {
        return this.itemRepository.findAll()
    }

    fun findById(id: ObjectId): Item {
        return itemRepository.findById(id)
            .orElseThrow { NotFoundException() }
    }

    fun create(item: Item): Item {
        return this.itemRepository.save(item)
    }
}
