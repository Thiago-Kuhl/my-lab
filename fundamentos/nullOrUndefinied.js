const a = { name: "Teste" };

const b = a //atribuicao por referencia (copia a referencia da memória) (tipos ñ primitivos)

let c = 3

let d = c //copia por valor(quando trabalhamos com tipos primitivos!)

d++

let valor // ñ inicilizada
console.log(valor) //undefined (nunca recebeu atribuição)

valor = null //não tem valor / não tem nenhum local de memória apontado
console.log(valor)
console.log(valor != null ? valor.toString() : 'null') 

const produto = {}

console.log(produto)

produto.preco = '10'

console.log(produto)

produto.preco = undefined 

console.log(!!produto.preco)
console.log(produto)

produto.preco = null

console.log(produto)
delete produto.preco

console.log(produto)

//null limpa as atribuições de memória
//undefinied é usado quando algo não foi definido