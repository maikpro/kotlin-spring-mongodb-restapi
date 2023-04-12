package rest.kotlin.restapi.entities

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Item (
    @Id
    var id: ObjectId? = null,
    var name: String,
    var price: Double
)