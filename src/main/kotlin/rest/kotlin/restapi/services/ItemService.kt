package rest.kotlin.restapi.services

import org.bson.types.ObjectId
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import rest.kotlin.restapi.entities.Item
import rest.kotlin.restapi.repositories.ItemRepository
import java.util.*

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {
    fun findAll(): List<Item> {
        return this.itemRepository.findAll()
    }

    fun findById(id: String): Optional<Item> {
        return itemRepository.findById(ObjectId(id))
    }

    fun create(item: Item): Item {
        return this.itemRepository.insert(item)
    }

    fun update(item: Item): Item {
        val updatedItem = findById(item.id.toString())
        if(updatedItem.isEmpty){
            throw NotFoundException()
        }

        return this.itemRepository.save(
            updatedItem.get().apply {
                name = item.name
                price = item.price
            }
        )
    }

    fun delete(id: String): Item {
        val deletedItem = findById(id)
        if(deletedItem.isEmpty){
            throw NotFoundException()
        }
        this.itemRepository.delete(deletedItem.get())
        return deletedItem.get()
    }
}
