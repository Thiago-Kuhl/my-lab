package com.tk.bankaccount

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("accounts")
class AccountController(val repository: AccountRepository) {

    @PostMapping
    fun createCustomer(@RequestBody account: Account) = ResponseEntity.ok(repository.save(account))

    @GetMapping
    fun getCustomer() = ResponseEntity.ok(repository.findAll())

    @PutMapping("{document}")
    fun updateCustomer(@PathVariable document: String, @RequestBody account: Account): ResponseEntity<Account> {
        val accountDBOptional = repository.findByDocument(document)
        val toSave = accountDBOptional
            .orElseThrow { RuntimeException("Account Document: $document not found!") }
            .copy(name = account.name, balance = account.balance)

        return ResponseEntity.ok(repository.save(toSave))
    }

    @DeleteMapping("{document}")
    fun deleteCustomer(@PathVariable document: String) = repository
        .findByDocument(document)
        .ifPresent { repository.delete(it) }
}