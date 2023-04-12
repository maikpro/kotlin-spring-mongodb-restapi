package rest.kotlin.restapi.controllers

import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rest.kotlin.restapi.entities.Item
import rest.kotlin.restapi.services.ItemService

@RestController
@RequestMapping("/item")
class ItemController(
    private val itemService: ItemService
) {
    @GetMapping
    fun findAll(): List<Item> {
        return this.itemService.findAll()
    }

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: ObjectId): Item {
        return this.itemService.findById(id)
    }

    @PostMapping
    fun create(@RequestBody item: Item): Item {
        return this.itemService.create(item)
    }
}