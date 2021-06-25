Array.prototype.map2 = function(callback){
    const newArray = []

    for(let i = 0; i < this.length; i++){
        newArray.push(callback(this[i], i, this))
    }
    return newArray
}

const carrinho = [
    '{"nome": "Borracha", "preco": 3.45}',
    '{"nome": "Caderno", "preco": 13.90}',
    '{"nome": "Kit Lápis", "preco": 41.22}',
    '{"nome": "Caneta", "preco": 7.50}',
]

let precos = carrinho.map2(item =>JSON.parse(item).preco)
console.log(precos)
