package rest.kotlin.restapi.repositories

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import rest.kotlin.restapi.entities.Item

@Repository
interface ItemRepository : MongoRepository<Item, ObjectId> {
}