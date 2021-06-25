//Object.preventExtensions

const produto = Object.preventExtensions({
    nome: 'Qualquer', preco: 1.99, tag: 'promoção'
})

console.log('Extensivo: ', Object.isExtensible(produto))

produto.nome = 'Borracha'
produto.descricao = 'Borracha escolar branca'
delete produto.tag

console.log(produto)

//Object.seal
const pessoa  = {nome: 'Juliana', idade: 32}
Object.seal(pessoa)

console.log('Selado: ', Object.isSealed(pessoa))
pessoa.sobrenome = 'Silva'
delete pessoa.idade
pessoa.idade = 35
console.log(pessoa)

//Object.freeze -- selados + constantes

