package rest.kotlin.restapi.controllers

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun findAll(): ResponseEntity<List<Item>> {
        val allItems = this.itemService.findAll()
        return ResponseEntity.ok(allItems)
    }

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: String): ResponseEntity<Item> {
        val itemById = this.itemService.findById(id)
        if(itemById.isEmpty) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(itemById.get())
    }

    @PostMapping
    fun create(@RequestBody item: Item): ResponseEntity<Item> {
        val createdItem = this.itemService.create(item)
        return ResponseEntity.ok(createdItem)
    }

    @PutMapping("{id}")
    fun update(@PathVariable("id") id: String, @RequestBody item: Item): ResponseEntity<Item> {
        if(id != item.id){
            return ResponseEntity(HttpStatusCode.valueOf(500))
        }
        val foundItem = this.itemService.findById(id)
        if(foundItem.isEmpty) {
            return ResponseEntity.notFound().build()
        }
        val updatedItem = this.itemService.update(item)
        return ResponseEntity.ok(updatedItem)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<Item> {
        val foundItem = this.itemService.findById(id)
        if(foundItem.isEmpty) {
            return ResponseEntity.notFound().build()
        }
        val deletedItem = this.itemService.delete(id)
        return ResponseEntity.ok(deletedItem)
    }
}